package slotmachine.service;

import slotmachine.config.GameConfiguration;
import slotmachine.dto.WinData;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static slotmachine.service.SlotMachine.cascade;
import static slotmachine.service.SlotMachine.checkForScatterSym;

/**
 * Class handles free spins.
 */
public class FreeSpins {
    static Random rng = new Random();


    public static void main(String[] args) {
        GameConfiguration gameConfiguration = new GameConfiguration();
        playFreeSpins(rng, 50, gameConfiguration);
    }

    public static Spin playFreeSpins(Random rng, int fsAwarded, GameConfiguration gameConfiguration) {
        Spin freeSpin = new Spin();
        BigDecimal totalWin = BigDecimal.ZERO;
        List<List<WinData>> cascadeList = new ArrayList<>();
        freeSpin.setFreeSpinsMultiplier(2);
        for (int i = fsAwarded; i > 0; i--) {


            List<Integer> stopPosition = new ArrayList<>();
            List<String[]> slotFace = new ArrayList<>();
            List<String[]> freeSpinReels = gameConfiguration.reelSets.get(2);
            SlotMachine.createGrid(rng, true, freeSpinReels, stopPosition, slotFace, gameConfiguration, freeSpin);
            totalWin = cascade(1, slotFace, totalWin, stopPosition, cascadeList, freeSpin, true, gameConfiguration, rng); // TODO remove 1 as stake


            int scatterCount = checkForScatterSym(slotFace, gameConfiguration);
            if (scatterCount >= 4) {
                i = i + (10 + ((scatterCount - 4) * 2));;
            }
        }
        freeSpin.setTotalWin(totalWin);
        return freeSpin;
    }


    private static int getScatterCount(List<String[]> slotFace, GameConfiguration gameConfiguration) {
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
}
