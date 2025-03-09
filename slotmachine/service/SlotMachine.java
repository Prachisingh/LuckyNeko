package slotmachine.service;

import slotmachine.config.GameConfiguration;
import slotmachine.config.SlotSymbolWaysPayConfig;
import slotmachine.dto.WeightedPrizeData;
import slotmachine.dto.WinData;
import slotmachine.util.GameUtility;

import java.math.BigDecimal;
import java.util.*;

//import static slotmachine.util.GameUtility.//printSlotFace;


/**
 * Main class of the game that starts the base game, so the spinning and performs cascading. It also triggers the free games.
 */
public class SlotMachine {

    public static void main(String[] args) {
        Random rng = new Random(); // TODO change it to static;
        int stake = 1;
        GameConfiguration configuration = new GameConfiguration();
        play(stake, rng, configuration);

    }

    // pass game configuration
    public static void play(int stake, Random rng, GameConfiguration gameConfiguration) {
        List<String[]> bgReelSet = gameConfiguration.createReelSets().getFirst();
        Spin baseGameResponse = playBaseGame(stake, rng, false, bgReelSet, gameConfiguration);
        if (baseGameResponse.isFsTriggered) {
            FreeSpins.playFreeSpins(rng, baseGameResponse.getFsAwarded(), gameConfiguration);
        }
    }

    public static Spin playBaseGame(int stake, Random rng, boolean isFreeGame, List<String[]> bgReelsA, GameConfiguration gameConfiguration) {
        Spin spin = new Spin();
        List<Integer> stopPosition = new ArrayList<>();

        BigDecimal totalWin = BigDecimal.ZERO;


        List<String[]> slotFace = new ArrayList<>();

        createGrid(rng, isFreeGame, bgReelsA, stopPosition, slotFace, gameConfiguration, spin);

        List<List<WinData>> cascadeList = new ArrayList<>();
        int scatterCount;
        totalWin = cascade(stake, slotFace, totalWin, stopPosition, cascadeList, spin, isFreeGame, gameConfiguration, rng);
        scatterCount = checkForScatterSym(slotFace, gameConfiguration);
        if (scatterCount >= 4) {

            int fsAwarded = 10 + ((scatterCount - 4) * 2);
            spin.setFsAwarded(fsAwarded);
            spin.setFsTriggered(true);
            spin.setScatterCount(scatterCount);
        }
        spin.setTotalWin(totalWin);

        return spin;
    }

    public static void createGrid(Random rng,
                                  boolean isFreeGame,
                                  List<String[]> bgReelsA,
                                  List<Integer> stopPosition,
                                  List<String[]> slotFace,
                                  GameConfiguration gameConfiguration,
                                  Spin spin) {
        int stopPos;
        int reelIdx = 1;
        for (String[] reel : bgReelsA) {
            stopPos = rng.nextInt(reel.length); //

            if (isFreeGame) {
                selectGridHeight(rng, reelIdx, gameConfiguration, spin, gameConfiguration.symHeightInFs);
            } else {
                selectGridHeight(rng, reelIdx, gameConfiguration, spin, gameConfiguration.symHeightInBaseGame);
            }
            if (gameConfiguration.getBoardHeight() > 5) {
                throw new RuntimeException("Board height can not be greater than 5");
            }

            String[] slotFaceReel = selectReels(gameConfiguration.getBoardHeight(), reel, stopPos, spin);
            stopPosition.add(stopPos);
            slotFace.add(slotFaceReel);
            reelIdx++;
        }
        String[] topReel = getTopReel(rng, stopPosition, isFreeGame, gameConfiguration);
        slotFace.add(topReel);
        fillTopReel(slotFace, topReel);
        markSymAsSilver(spin, rng, isFreeGame, gameConfiguration);
    }

    private static void markSymAsSilver(Spin spin, Random rng, boolean isFreeGame, GameConfiguration gameConfiguration) {
        List<int[]> symbolSizes = spin.getGridContainingSymbolSizes();
        List<String[]> silverSymMarker = new ArrayList<>();


        int silverIndex = 0;
        int chance;
        for (int[] array : symbolSizes) {
            String[] marker = new String[6];
            Arrays.fill(marker, "normal");
            silverSymMarker.add(marker);
            for (int i = 0; i < array.length; i++) {


                if (array[i] >= 2) {
                    // check for silver probability, could be either 1 or 0
                    if(isFreeGame){
                        chance = WeightedPrizeService.getPrizes(rng, gameConfiguration.getSymbolSilverProbabilityInFs());
                    }
                    else {
                        chance = rng.nextInt(2);
                    }
                    if (chance == 1) {
                        // set as silver
                        silverSymMarker.get(silverIndex)[i] = "silver";
                    }

                }
            }
            silverIndex++;
        }
        spin.setSilverSymMarker(silverSymMarker);
    }

    public static BigDecimal cascade(int stake, List<String[]> slotFace,
                                     BigDecimal totalWin,
                                     List<Integer> stopPosition,
                                     List<List<WinData>> cascadeList,
                                     Spin spin,
                                     boolean isFreeGame,
                                     GameConfiguration gameConfiguration,
                                     Random rng) {
        List<WinData> winDataList;
        int cascadeCounter = 0;
        int replacedMysterySymbolIndex;
        if (isFreeGame) {
            replacedMysterySymbolIndex = WeightedPrizeService.getPrizes(rng, gameConfiguration.mysteryReplacementInFs);
        } else {
            replacedMysterySymbolIndex = WeightedPrizeService.getPrizes(rng, gameConfiguration.mysteryReplacementInBaseGame);
        }
        String replacedMysterySymbol = gameConfiguration.symbolMap.get(replacedMysterySymbolIndex);
        List<String> latestSymbolLanded = new ArrayList<>();
        int catSymNum = 0;

        do {
            int catMultiplier;
            replaceMysterySymbolInSlotFace(gameConfiguration, slotFace, replacedMysterySymbol);
            if (cascadeCounter == 0) {
                catSymNum = getNumberOfCatSymbolsPresent(slotFace, gameConfiguration);
            }

            if (isFreeGame) {
                int catMultiplierInFs = spin.getFreeSpinsMultiplier() + catSymNum * 2;
                winDataList = calculateWin(slotFace, stake, gameConfiguration);
                totalWin = getTotalWin(winDataList, totalWin, catMultiplierInFs);
                spin.setFreeSpinsMultiplier(catMultiplierInFs);
            } else { // when in base game
                catMultiplier = catSymNum > 0 ? catSymNum * 2 : 1;
                winDataList = calculateWin(slotFace, stake, gameConfiguration);
                totalWin = getTotalWin(winDataList, totalWin, catMultiplier);
            }

            if (!winDataList.isEmpty()) {

                cascadeCounter++;
                removeSymFromWinPos(winDataList, slotFace, gameConfiguration, spin, rng, isFreeGame);
                shiftSymbolsDownwards(slotFace);

                int numOfEmptySym = shiftTopReelLeftAndGetNumOfEmptySym(slotFace);
                if (numOfEmptySym > 0) {
                    fillTopReelEmptyPos(numOfEmptySym, slotFace, stopPosition, gameConfiguration, latestSymbolLanded);
                }

                fillEmptyPosition(slotFace, stopPosition, isFreeGame, gameConfiguration, latestSymbolLanded);
                catSymNum = countNewCatSymbolOnCascade(latestSymbolLanded);
                latestSymbolLanded.clear();
            } else {
//                System.out.println("No more wins");
            }
            cascadeList.add(winDataList);
            spin.setCascadeList(cascadeList);
        } while (!winDataList.isEmpty());
        return totalWin;
    }

    private static int countNewCatSymbolOnCascade(List<String> latestSymbolLanded) {
        return (int) latestSymbolLanded.stream().filter(x -> x.equals("AA")).count();
    }

    private static int getNumberOfCatSymbolsPresent(List<String[]> slotFace, GameConfiguration gameConfiguration) {

        int counter = 0;

        for (int col = 0; col < gameConfiguration.boardWidth; col++) {
            for (int row = 0; row < slotFace.get(col).length; row++) {
                String sym = slotFace.get(col)[row];
                if (sym.contains(gameConfiguration.AA)) {
                    counter++;
                }
            }
        }
        return counter;
    }

    private static void replaceMysterySymbolInSlotFace(GameConfiguration gameConfiguration, List<String[]> slotFace, String replacedMysterySymbol) {
        for (int col = 0; col < gameConfiguration.boardWidth; col++) {
            for (int row = 0; row < slotFace.get(col).length; row++) {
                String sym = slotFace.get(col)[row];
                if (sym.contains(gameConfiguration.MYSTERY)) {
                    slotFace.get(col)[row] = replacedMysterySymbol;
                }
            }
        }

    }

    private static void selectGridHeight(Random rng, int reelIdx, GameConfiguration gameConfiguration, Spin spin, WeightedPrizeData symbolHeight) {
        int boardHeight;
        int[] slotFaceSymbolLength = new int[]{1, 1, 1, 1, 1, 1};
        if (reelIdx == 1 || reelIdx == 6) {
            spin.setSymSizes(slotFaceSymbolLength);
            boardHeight = 5;
        } else {
            int[] symSize = WeightedPrizeService.getMultiplePrizes(rng, symbolHeight);
            spin.setSymSizes(symSize);
            boardHeight = symSize.length;
        }
        gameConfiguration.setBoardHeight(boardHeight);
    }

    private static BigDecimal getTotalWin(List<WinData> winDataList, BigDecimal totalWin, int catMultiplier) {
        BigDecimal cascadeWinAmount = BigDecimal.ZERO;
        for (WinData win : winDataList) {
            if (win.getWinAmount() != null) {
                cascadeWinAmount = cascadeWinAmount.add(win.getWinAmount());
            }
        }
        totalWin = totalWin.add(cascadeWinAmount.multiply(BigDecimal.valueOf(catMultiplier)));
        return totalWin;
    }

    private static void fillTopReelEmptyPos(int numOfEmptySym, List<String[]> slotFace, List<Integer> stopPositions, GameConfiguration gameConfiguration, List<String> latestSymbolLanded) {
        String[] topReel = gameConfiguration.reelSets.get(1).getFirst();

        String[] topFaceReel = addElementsToTopReel(numOfEmptySym, topReel, stopPositions);

        int j = 0;
        for (int i = 1; i < 5; i++) {

            if (slotFace.get(i)[0].contains("-1")) {
                slotFace.get(i)[0] = topFaceReel[j];
                latestSymbolLanded.add(topFaceReel[j]);
                j++;
            }
        }
    }

    private static int shiftTopReelLeftAndGetNumOfEmptySym(List<String[]> slotFace) {
        List<String> topList = new ArrayList<>();
        for (int i = 1; i < 5; i++) {

            if (!slotFace.get(i)[0].contains("-1"))
                topList.add(slotFace.get(i)[0]);
        }

        for (int i = 0; i < topList.size(); i++) {
            slotFace.get(i + 1)[0] = topList.get(i);
        }
        int numOfEmptySym = 4 - topList.size();

        for (int i = numOfEmptySym; i > 0; i--) {
            slotFace.get(5 - i)[0] = "-1";
        }
        return numOfEmptySym;
    }


    private static void fillTopReel(List<String[]> slotFace, String[] topReel) {
        for (int i = 0; i < topReel.length; i++) {
            slotFace.get(i)[0] = topReel[i];
        }
    }

    private static String[] getTopReel(Random rng, List<Integer> stopPosition, boolean isFreeGame, GameConfiguration gameConfiguration) {
        int topReelStopPos;
        String[] topReel;
        if (isFreeGame) {
            topReel = gameConfiguration.reelSets.get(3).getFirst();
        } else {
            topReel = gameConfiguration.reelSets.get(1).getFirst();
        }

        topReelStopPos = rng.nextInt(topReel.length);

        String[] topFaceReel = selectTopReel(6, topReel, topReelStopPos);
        topReelStopPos += 3;
        topReelStopPos = topReelStopPos % topReel.length;
        stopPosition.add(topReelStopPos);
        return topFaceReel;
    }

    private static void fillEmptyPosition(List<String[]> slotFace, List<Integer> stopPositions, boolean isFreeGame, GameConfiguration gameConfiguration, List<String> latestSymbolLanded) {
        List<String[]> reels;
        if (isFreeGame) {
            reels = gameConfiguration.reelSets.get(2);
        } else {
            reels = gameConfiguration.reelSets.getFirst();
        }

        List<Integer> reelLengths = GameUtility.getReelLength(reels);
        int reelIdx = 0;
        for (int col = 0; col < gameConfiguration.boardWidth; col++) {
            String[] reel = slotFace.get(col);
            for (int i = reel.length - 1; i > 0; i--) {
                if (reel[i].contains("-1") && i < 5) {
                    stopPositions.set(reelIdx, stopPositions.get(reelIdx) + reelLengths.get(reelIdx) - 1);
                    stopPositions.set(reelIdx, stopPositions.get(reelIdx) % reelLengths.get(reelIdx));

                    reel[i] = reels.get(reelIdx)[stopPositions.get(reelIdx)];
                    latestSymbolLanded.add(reel[i]);
                }
            }
            reelIdx++;
        }

    }


    private static void shiftSymbolsDownwards(List<String[]> slotFaceContainingRemovedSymbols) {
        boolean some;
        for (String[] reel : slotFaceContainingRemovedSymbols) {

            for (int i = reel.length - 1; i > 1; i--) {

                if (reel[i].contains("-1")) {
                    some = false;
                    for (int j = i; j > 1; j--) {
                        if (!reel[j - 1].contains("-1")) {
                            some = true;
                        }
                        reel[j] = reel[j - 1];

                    }
                    reel[1] = "-1";
                    if (some) {
                        i++;
                    }
                }
            }
        }
    }

    private static void removeSymFromWinPos(List<WinData> winDataList, List<String[]> slotFace, GameConfiguration gameConfiguration, Spin spin, Random rng, boolean isFreeGame) {
        List<String[]> silverMarker = spin.getSilverSymMarker();
        for (WinData win : winDataList) {
            for (Integer pos : win.getPosList()) {
                int row = pos / gameConfiguration.boardWidth;
                int reel = pos % gameConfiguration.boardWidth;
                // silver marked symbols are not removed rather they are converted to random symbols
                if (silverMarker.get(reel)[row].equals("silver")) {
                    // replace silver framed symbol with new symbol
                    int silverReplacement;
                    if (isFreeGame) {
                        silverReplacement = WeightedPrizeService.getPrizes(rng, gameConfiguration.silverSymReplacementInFs);
                    } else {
                        silverReplacement = WeightedPrizeService.getPrizes(rng, gameConfiguration.silverSymReplacementInBaseGame);
                    }
                    slotFace.get(reel)[row] = gameConfiguration.symbolMap.get(silverReplacement);
                    //Now mark same symbol as gold
                    silverMarker.get(reel)[row] = "gold";

                } else if (silverMarker.get(reel)[row].equals("gold")) {
                    // replace gold framed symbol with wild and make it normal symbol -  no more frames
                    slotFace.get(reel)[row] = "WC";
                    silverMarker.get(reel)[row] = "normal";
                } else {
                    slotFace.get(reel)[row] = "-1";
                }

            }

        }
    }

    private static String[] selectReels(int boardHeight, String[] reel, int position, Spin spin) {
        String[] boardReel = new String[boardHeight + 1];
        int[] symSizeOnReel = new int[boardHeight + 1];
        int counter = 0;
        for (int i = 1; i <= boardHeight; i++) {
            boardReel[i] = reel[(position + i - 1) % reel.length];
            // if symbol is scatter or wild, make its size as 1, so that it is not counted as silver symbol
            if (boardReel[i].equals("WC") || boardReel[i].equals("SC")) {
                symSizeOnReel[i] = 1;
            } else {
                symSizeOnReel[i] = spin.getSymSizes()[counter];
            }

            counter++;
        }
        spin.getGridContainingSymbolSizes().add(symSizeOnReel);
        return boardReel;
    }

    private static String[] addElementsToTopReel(int numSym, String[] reel, List<Integer> stopPositions) {
        String[] boardReel = new String[numSym];
        for (int i = 0; i < numSym; i++) {
            stopPositions.set(6, stopPositions.get(6) + reel.length + 1);
            stopPositions.set(6, stopPositions.get(6) % reel.length);
            boardReel[i] = reel[stopPositions.get(6)];
        }

        return boardReel;
    }

    private static String[] selectTopReel(int boardHeight, String[] reel, int position) {
        String[] boardReel = new String[boardHeight];
        for (int i = 1; i < boardHeight - 1; i++) {
            boardReel[i] = reel[(position + i - 1) % reel.length];
        }
        //-10 is used as empty symbols as edge symbols on first row, so that it contains just 4 symbols
        boardReel[0] = "-10";
        boardReel[5] = "-10";
        return boardReel;
    }

    private static List<WinData> calculateWin(List<String[]> slotFace, int stake, GameConfiguration gameConfiguration) {
        BigDecimal totalWin = BigDecimal.ZERO;
        List<WinData> winDataList = new ArrayList<>();

        for (int row = 0; row < slotFace.getFirst().length; row++) {

            String symToCompare = slotFace.getFirst()[row]; // only first column elements need to be compared.
            boolean exists = winDataList.stream().anyMatch(sym -> sym.getSymbolName().equals(symToCompare)); // if the symbol is already compared
            if (!winDataList.isEmpty() && exists) {
                continue;
            }

            WinData winData = checkForWinCombination(symToCompare, slotFace, gameConfiguration);
            populateWin(winData, winDataList, stake, gameConfiguration);
            if (winData.getWinAmount() != null) {
                totalWin = totalWin.add(winData.getWinAmount());
            }
        }

        return winDataList;
    }

    public static int checkForScatterSym(List<String[]> slotFace, GameConfiguration gameConfiguration) {
        int counter = 0;

        for (int col = 0; col < gameConfiguration.boardWidth; col++) {
            for (int row = 0; row < slotFace.get(col).length; row++) {
                String sym = slotFace.get(col)[row];
                if (sym.contains(gameConfiguration.SCATTER)) {
                    counter++;
                }
            }
        }
        return counter;
    }

    private static void populateWin(WinData winData, List<WinData> winDataList, int stake, GameConfiguration gameConfiguration) {
        SlotSymbolWaysPayConfig payOut = gameConfiguration.payout.get(winData.getSymbolName());
        BigDecimal symbolWin;
        int ways;
        if (payOut != null && winData.getSymCountOnEachCol().size() >= payOut.getMinimumMatch()) {
            symbolWin = payOut.getWinAmount(winData.getSymCountOnEachCol().size());

            ways = 1;
            for (Map.Entry<Integer, Integer> entry : winData.getSymCountOnEachCol().entrySet()) {
                ways *= entry.getValue();
            }
            BigDecimal finalWin = symbolWin.multiply(BigDecimal.valueOf(ways));
            winData.setWinAmount(finalWin.multiply(BigDecimal.valueOf(stake))); // multiply with stake
            winData.setWays(ways);
            winData.setBasePayout(symbolWin);
            winDataList.add(winData);
        }
    }

    private static WinData checkForWinCombination(String symToCompare, List<String[]> slotFace, GameConfiguration gameConfiguration) {
        SlotSymbolWaysPayConfig payOut = gameConfiguration.payout.get(symToCompare);
        WinData winData = new WinData();
        List<Integer> posList = new ArrayList<>();
        Map<Integer, Integer> symCountPerColMap = new HashMap<>();
        int currentCol = 0;

        for (int col = 0; col < gameConfiguration.boardWidth; col++) {
            int symCountPerColumn = 0;
            int pos = col;
            if (col - currentCol > 1)
                break;
            for (int row = 0; row < slotFace.get(col).length; row++) {

                String currentSym = slotFace.get(col)[row];

                if (payOut != null && (symToCompare.equals(currentSym) || payOut.getWilds().contains(currentSym))) {

                    symCountPerColumn++;
                    symCountPerColMap.put(col, symCountPerColumn);

                    posList.add(pos);

                    currentCol = col;
                }
                pos += 6;
            }
        }
        winData.setPosList(posList);
        winData.setSymCountOnEachCol(symCountPerColMap);
        winData.setSymbolName(symToCompare);
        return winData;
    }
}
