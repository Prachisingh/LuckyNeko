package slotmachine.config;

import slotmachine.dto.WeightedMultiplePrizeConfig;
import slotmachine.dto.WeightedPrizeData;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Map.entry;

public class GameConfiguration {
    public int boardHeight = 6;
    public final int boardWidth = 6;
    public final String AA = "AA";
    public final String BB = "BB";
    public final String CC = "CC";
    public final String DD = "DD";
    public final String EE = "EE";
    public final String FF = "FF";
    public final String GG = "GG";
    public final String HH = "HH";
    public final String JJ = "JJ";
    public final String KK = "KK";

    public final String LL = "LL";
    public final String SC = "SC";
    public final String WC = "WC";
    public final String SCATTER = "SC";
    public final String MS = "MS";

    public final String MYSTERY = "MS";
    public final Map<Integer, String> symbolMap = getSymbolMap();


    public int getBoardHeight() {
        return boardHeight;
    }

    public void setBoardHeight(int boardHeight) {
        this.boardHeight = boardHeight;
    }

    public Map<String, SlotSymbolWaysPayConfig> payout = createPayout();

    public List<List<String[]>> reelSets = createReelSets();
    public WeightedPrizeData symHeightInBaseGame = getSymHeightInBaseGame();

    public WeightedPrizeData silverSymReplacementInBaseGame = getSilverReplacement();

    public WeightedPrizeData mysteryReplacementInBaseGame = getMysteryReplacementInBaseGame();

    public WeightedPrizeData symHeightInFs = getSymHeightInFreeSpins();

    public WeightedPrizeData silverSymReplacementInFs = getSilverReplacementInFreeSpins();

    public WeightedPrizeData mysteryReplacementInFs = getMysteryReplacementInFreeSpins();


    public Map createPayout() {

        return Map.ofEntries(
                entry(AA, new SlotSymbolWaysPayConfig(3, List.of(BigDecimal.valueOf(1.5), BigDecimal.valueOf(2), BigDecimal.valueOf(2.5), BigDecimal.valueOf(4))).addWild(WC)),
                entry(BB, new SlotSymbolWaysPayConfig(3, List.of(BigDecimal.valueOf(1), BigDecimal.valueOf(1.25), BigDecimal.valueOf(1.5), BigDecimal.valueOf(2.5))).addWild(WC)),
                entry(CC, new SlotSymbolWaysPayConfig(3, List.of(BigDecimal.valueOf(0.5), BigDecimal.valueOf(1.25), BigDecimal.valueOf(1.5), BigDecimal.valueOf(2))).addWild(WC)),

                entry(DD, new SlotSymbolWaysPayConfig(3, List.of(BigDecimal.valueOf(0.4), BigDecimal.valueOf(0.75), BigDecimal.valueOf(1), BigDecimal.valueOf(1.5))).addWild(WC)),

                entry(EE, new SlotSymbolWaysPayConfig(3, List.of(BigDecimal.valueOf(0.3), BigDecimal.valueOf(0.5), BigDecimal.valueOf(0.6), BigDecimal.valueOf(0.75))).addWild(WC)),
                entry(FF, new SlotSymbolWaysPayConfig(3, List.of(BigDecimal.valueOf(0.3), BigDecimal.valueOf(0.5), BigDecimal.valueOf(0.6), BigDecimal.valueOf(0.75))).addWild(WC)),

                entry(GG, new SlotSymbolWaysPayConfig(3, List.of(BigDecimal.valueOf(0.2), BigDecimal.valueOf(0.3), BigDecimal.valueOf(0.4), BigDecimal.valueOf(0.5))).addWild(WC)),
                entry(HH, new SlotSymbolWaysPayConfig(3, List.of(BigDecimal.valueOf(0.2), BigDecimal.valueOf(0.3), BigDecimal.valueOf(0.4), BigDecimal.valueOf(0.5))).addWild(WC)),

                entry(JJ, new SlotSymbolWaysPayConfig(3, List.of(BigDecimal.valueOf(0.05), BigDecimal.valueOf(0.1), BigDecimal.valueOf(0.15), BigDecimal.valueOf(0.20))).addWild(WC)),
                entry(KK, new SlotSymbolWaysPayConfig(3, List.of(BigDecimal.valueOf(0.05), BigDecimal.valueOf(0.1), BigDecimal.valueOf(0.15), BigDecimal.valueOf(0.20))).addWild(WC)),
                entry(LL, new SlotSymbolWaysPayConfig(3, List.of(BigDecimal.valueOf(0.05), BigDecimal.valueOf(0.1), BigDecimal.valueOf(0.15), BigDecimal.valueOf(0.20))).addWild(WC))

        );
    }

    public List<List<String[]>> createReelSets() {
        List<List<String[]>> gameReels = new ArrayList<>();
        List<String[]> bgReels = new ArrayList<>(5);

        bgReels.add(new String[]{
                MS, KK, MS, LL, MS, LL, JJ, DD, SC, HH, KK, LL, HH, LL, KK, GG, EE, CC, LL, HH, LL, EE, CC, JJ, EE, GG, KK, HH, FF, LL, LL, HH, EE, CC, CC, CC, JJ, EE, FF, LL, CC, HH, GG, LL, BB, FF, EE, LL, GG, KK, LL, GG, FF, EE, CC, KK, JJ, EE, LL, HH, LL, KK, EE, FF, LL, CC, DD, CC, HH, KK, GG, MS, DD, GG, FF, CC, JJ, MS, MS, MS, JJ, FF, EE, KK, GG, EE, JJ, JJ, JJ, BB, KK, LL, LL, EE, FF, LL, DD, FF, DD, HH, GG, KK, MS, MS, HH, KK, EE, GG, HH, KK, JJ, LL, FF, FF, EE, JJ, DD, GG, JJ, KK, BB, GG, KK, JJ, SC, LL, LL, MS, KK, HH, LL, LL, LL, GG, MS, FF, BB, KK, BB, HH, LL, FF, LL, JJ, DD, CC, LL, JJ, KK, LL, HH, HH, SC, JJ, FF, HH, CC, KK, HH, FF, KK, AA, JJ, KK, BB, JJ, JJ, JJ, FF, CC, EE, EE, SC, GG, GG, LL, LL, GG, HH, LL, JJ, BB, HH, LL, DD, DD, JJ, GG, KK, HH, FF, EE, MS, MS, KK, GG, LL, DD, HH, GG, AA, JJ, HH, KK, LL, JJ, HH, KK, FF, HH, DD, JJ, EE, BB, KK, LL, EE, EE, SC, JJ, JJ, KK, KK, HH, EE, MS, FF, FF, MS, EE, GG, HH, KK, DD, LL, LL, SC, JJ, JJ, EE, EE, GG, JJ, FF, HH, DD, JJ, LL, GG, GG, GG, KK, KK, DD, HH, HH, KK, KK, CC, GG, EE, HH, HH, FF, MS, LL, LL, JJ, GG, LL, FF, GG, GG, KK, KK, SC, LL, DD, JJ, KK, FF, HH, LL, LL, KK, KK, LL, FF, GG, LL, LL, JJ, KK, KK, FF, LL, KK, DD, HH, GG, JJ, CC, CC, CC, KK, KK, LL, SC, LL, GG, KK, EE, KK, KK, GG, GG, JJ, FF, DD, KK, LL, FF, EE, GG, CC, CC, EE, EE, JJ, JJ, KK, FF, LL, CC, FF, SC, FF, LL, MS, KK, MS, HH, JJ, BB, GG, EE, EE, EE, KK, FF, GG, JJ, DD, KK, KK, FF, FF, JJ, EE, HH, KK, JJ, BB, GG, DD, DD, KK, SC, MS, MS, LL, LL, DD, FF, HH, MS, HH, HH, GG, KK, MS, JJ, LL, LL, HH, FF, GG, CC, CC, EE, EE, HH, GG, KK, LL, AA, FF, HH, HH, GG, GG, CC, HH, SC, JJ, JJ, GG, HH, LL, JJ, HH, LL, FF, FF, GG, JJ, KK, KK, HH, GG, JJ, FF, BB, GG, BB, BB, JJ, MS, KK, SC, LL, GG, GG, MS, MS, LL, FF, KK, KK, EE, HH, LL, LL, GG, FF, KK, KK, EE, EE, JJ, LL, HH, DD, FF, MS, JJ, JJ, GG, HH, EE, JJ, JJ, DD, DD, BB, GG, KK, LL, JJ, EE, SC, HH, JJ, EE, FF, EE, EE, LL, LL, KK, GG, EE, LL, FF, MS, MS, KK, GG, GG, GG, EE, FF, JJ, HH, KK, BB, EE, HH, SC, MS, JJ, JJ, KK, JJ, KK, FF, FF, LL, JJ, KK, BB, BB, JJ, KK, DD, GG, HH, JJ, DD, DD, SC, FF, EE, KK, KK, LL, LL, JJ, DD, EE,
        });
        bgReels.add(new String[]{
                JJ, JJ, LL, KK, KK, HH, HH, CC, GG, GG, HH, GG, GG, SC, EE, HH, FF, DD, GG, JJ, MS, LL, KK, KK, FF, MS, MS, LL, EE, HH, SC, EE, JJ, LL, LL, JJ, KK, FF, LL, JJ, DD, GG, LL, GG, KK, MS, FF, GG, JJ, JJ, MS, LL, EE, FF, FF, HH, KK, FF, FF, BB, KK, JJ, FF, EE, EE, MS, DD, DD, GG, JJ, HH, KK, CC, LL, GG, DD, LL, JJ, GG, LL, KK, EE, EE, FF, HH, FF, KK, LL, WC, LL, JJ, HH, GG, FF, EE, KK, MS, CC, CC, SC, HH, JJ, MS, EE, LL, GG, FF, HH, HH, JJ, LL, HH, MS, LL, LL, MS, LL, LL, KK, JJ, EE, HH, JJ, KK, KK, FF, EE, EE, JJ, GG, EE, HH, SC, BB, KK, EE, KK, HH, LL, GG, JJ, EE, GG, GG, CC, DD, MS, KK, JJ, LL, GG, LL, HH, HH, EE, LL, LL, LL, GG, EE, BB, BB, GG, JJ, SC, KK, KK, EE, GG, DD, HH, HH, KK, GG, LL, HH, LL, HH, GG, JJ, JJ, AA, GG, HH, CC, CC, SC, HH, JJ, GG, GG, FF, FF, EE, JJ, HH, EE, CC, GG, GG, BB, KK, LL, SC, GG, KK, HH, JJ, EE, GG, CC, FF, FF, EE, JJ, HH, LL, LL, FF, FF, JJ, JJ, LL, GG, KK, HH, EE, EE, KK, FF, HH, GG, FF, MS, LL, LL, FF, KK, KK, JJ, FF, HH, EE, EE, GG, CC, KK, JJ, FF, LL, SC, HH, HH, GG, GG, EE, JJ, JJ, DD, DD, FF, SC, GG, MS, KK, HH, BB, KK, LL, GG, GG, KK, AA, LL, JJ, JJ, HH, CC, LL, LL, EE, BB, BB, HH, HH, FF, MS, EE, WC, FF, FF, KK, JJ, JJ, EE, GG, JJ, CC, GG, GG, KK, DD, DD, EE, FF, LL, GG, GG, JJ, HH, FF, MS, LL, SC, JJ, KK, KK, EE, CC, CC, GG, EE, FF, HH, LL, DD, MS, DD, DD, KK, JJ, EE, GG, DD, KK, GG, GG, EE, EE, JJ, EE, WC, KK, LL, HH, MS, FF, FF, SC, GG, HH, KK, CC, GG, JJ, EE, MS, MS, FF, GG, DD, KK, LL, HH, HH, FF, CC, CC, KK, GG, JJ, JJ, CC, EE, EE, GG, GG, FF, KK, LL, LL, JJ, KK, KK, EE, EE, MS, DD, DD, FF, JJ, GG, HH, LL, BB, BB, EE, GG, HH, HH, JJ, DD, GG, LL, LL, HH, HH, GG, MS, LL, LL, EE, EE, LL, HH, KK, DD, DD, GG, MS, MS, DD, DD, HH, LL, HH, KK, GG, JJ, MS, MS, HH, HH, FF, GG, GG, EE, WC, JJ, FF, GG, JJ, CC, CC, EE, JJ, FF, JJ, FF, SC, HH, GG, FF, EE, KK, KK, KK, HH, FF, FF, KK, LL, SC, CC, KK, HH, JJ, MS, KK, MS, HH, HH, KK, FF, EE, MS, LL, EE, MS, JJ, HH, FF, GG, EE, CC, CC, JJ, HH, HH, GG, FF, LL, MS, GG, JJ, AA, FF, FF, KK, EE, LL, LL, HH, KK, JJ, LL, EE, HH, KK, KK, LL, HH, KK, LL, CC, HH, GG, KK, SC, CC, LL, FF, FF, EE, JJ, JJ, GG, LL, CC, FF,});
        bgReels.add(new String[]{
                LL, LL, HH, HH, CC, JJ, GG, EE, EE, FF, KK, MS, KK, DD, HH, FF, CC, EE, MS, HH, LL, GG, GG, LL, CC, JJ, HH, KK, EE, JJ, GG, KK, KK, EE, EE, JJ, GG, CC, FF, WC, EE, KK, JJ, KK, BB, EE, CC, KK, HH, FF, KK, GG, DD, EE, EE, HH, GG, CC, CC, BB, GG, HH, LL, LL, JJ, SC, EE, EE, HH, HH, JJ, GG, LL, JJ, KK, EE, EE, HH, KK, GG, GG, EE, CC, HH, JJ, CC, GG, MS, MS, SC, HH, JJ, LL, CC, DD, GG, LL, HH, FF, JJ, JJ, HH, GG, WC, KK, LL, CC, JJ, KK, FF, JJ, MS, FF, FF, KK, GG, FF, JJ, JJ, HH, BB, JJ, HH, GG, CC, CC, SC, EE, HH, KK, DD, JJ, CC, AA, GG, LL, KK, BB, BB, MS, LL, EE, EE, GG, FF, MS, JJ, GG, HH, EE, LL, KK, JJ, LL, EE, EE, LL, SC, KK, DD, LL, AA, GG, MS, MS, LL, GG, EE, KK, EE, JJ, CC, CC, LL, LL, SC, JJ, JJ, KK, HH, GG, BB, KK, JJ, FF, FF, GG, EE, HH, HH, DD, KK, KK, GG, HH, JJ, FF, FF, KK, JJ, AA, GG, KK, KK, KK, JJ, JJ, HH, DD, KK, FF, GG, MS, BB, HH, JJ, JJ, WC, CC, CC, GG, DD, DD, KK, CC, LL, SC, EE, EE, CC, JJ, KK, HH, FF, LL, LL, FF, GG, GG, CC, CC, JJ, GG, DD, KK, FF, GG, HH, CC, LL, KK, LL, JJ, FF, MS, MS, HH, HH, EE, JJ, CC, KK, LL, LL, GG, JJ, AA, GG, JJ, FF, FF, BB, HH, HH, LL, EE, JJ, HH, GG, HH, DD, KK, KK, JJ, JJ, SC, GG, DD, JJ, DD, DD, GG, FF, MS, EE, KK, HH, LL, KK, MS, MS, EE, EE, LL, HH, DD, KK, KK, HH, JJ, SC, LL, LL, HH, HH, JJ, GG, EE, FF, LL, KK, DD, CC, CC, LL, LL, SC, EE, MS, GG, HH, DD, KK, EE, GG, MS, LL, KK, KK, DD, DD, LL, EE, BB, JJ, SC, CC, CC, HH, DD, JJ, GG, LL, LL, LL, DD, DD, CC, CC, KK, HH, LL, BB, JJ, KK, FF, LL, FF, GG, KK, KK, LL, FF, DD, KK, KK, MS, MS, SC, JJ, GG, LL, LL, GG, KK, DD, JJ, LL, EE, EE, HH, KK, JJ, KK, AA, MS, DD, KK, JJ, SC, HH, EE, EE, GG, GG, HH, LL, KK, CC, GG, DD, WC, LL, DD, JJ, GG, HH, HH, KK, JJ, MS, DD, EE, JJ, BB, BB, LL, KK, HH, MS, JJ, SC, LL, CC, KK, KK, DD, HH, CC, CC, KK, HH, LL, JJ, DD, KK, HH, HH, LL, MS, MS, KK, FF, DD, GG, GG, GG, JJ, JJ, CC, GG, SC, FF, FF, BB, JJ, HH, KK, GG, CC, KK, KK, GG, BB, MS, LL, LL, DD, DD, HH, JJ, CC, KK, DD, DD, FF, HH, MS, MS, KK, CC, DD, SC, GG, HH, BB, CC, KK, LL, LL, GG, GG, JJ, MS, MS, DD, DD, JJ, GG, HH, BB, BB, GG, FF, FF, JJ, KK, GG, WC, MS, LL, LL, HH, SC, MS, MS, LL, MS, FF, CC,});
        bgReels.add(new String[]{
                LL, EE, LL, EE, GG, GG, JJ, KK, HH, HH, FF, FF, MS, CC, KK, GG, DD, HH, LL, EE, MS, JJ, JJ, HH, DD, GG, EE, LL, HH, GG, JJ, FF, MS, HH, LL, GG, GG, MS, CC, EE, HH, FF, GG, GG, BB, CC, DD, LL, EE, EE, GG, MS, HH, DD, HH, EE, EE, DD, DD, KK, JJ, JJ, DD, LL, GG, GG, LL, HH, FF, EE, GG, JJ, KK, GG, FF, FF, JJ, EE, FF, BB, JJ, CC, DD, EE, GG, DD, HH, JJ, CC, BB, EE, GG, FF, DD, CC, JJ, KK, KK, KK, FF, GG, EE, HH, HH, FF, FF, DD, GG, SC, EE, JJ, JJ, CC, CC, MS, JJ, KK, GG, JJ, HH, BB, GG, GG, JJ, DD, DD, CC, JJ, EE, FF, CC, WC, DD, BB, JJ, MS, MS, BB, BB, FF, EE, CC, FF, JJ, MS, HH, GG, JJ, EE, MS, FF, SC, GG, EE, CC, LL, MS, LL, FF, CC, KK, AA, EE, EE, BB, JJ, JJ, CC, FF, HH, GG, DD, DD, MS, HH, LL, GG, GG, FF, EE, SC, BB, MS, KK, KK, KK, JJ, LL, LL, FF, CC, DD, DD, MS, EE, GG, CC, FF, FF, LL, GG, MS, MS, WC, FF, JJ, GG, GG, CC, FF, KK, JJ, DD, BB, EE, LL, SC, LL, DD, MS, MS, EE, CC, FF, DD, JJ, CC, CC, JJ, DD, GG, FF, EE, EE, JJ, JJ, JJ, HH, HH, EE, DD, GG, SC, CC, FF, KK, JJ, EE, DD, LL, MS, GG, GG, WC, FF, JJ, EE, EE, HH, SC, DD, FF, FF, CC, JJ, GG, AA, GG, GG, FF, CC, BB, LL, LL, EE, EE, HH, KK, JJ, EE, CC, FF, MS, GG, GG, EE, JJ, CC, GG, LL, LL, JJ, EE, EE, CC, MS, EE, KK, FF, GG, LL, HH, HH, MS, EE, CC, FF, HH, HH, GG, DD, HH, LL, EE, EE, GG, JJ, CC, KK, MS, FF, CC, HH, LL, HH, HH, HH, WC, LL, LL, LL, CC, FF, HH, JJ, LL, LL, FF, HH, CC, SC, FF, JJ, BB, GG, DD, DD, DD, EE, JJ, GG, LL, KK, FF, EE, CC, CC, JJ, DD, FF, EE, HH, BB, GG, LL, SC, KK, KK, JJ, FF, GG, EE, KK, CC, LL, FF, FF, MS, MS, EE, LL, JJ, JJ, HH, FF, CC, GG, HH, HH, DD, WC, FF, GG, AA, KK, LL, CC, FF, GG, GG, FF, SC, HH, JJ, JJ, EE, GG, FF, DD, GG, CC, CC, HH, LL, HH, JJ, EE, CC, FF, LL, LL, LL, GG, GG, BB, BB, JJ, MS, EE, GG, MS, LL, GG, DD, FF, SC, CC, EE, DD, DD, MS, EE, MS, GG, CC, MS, MS, EE, EE, JJ, LL, LL, KK, CC, JJ, SC, LL, GG, FF, DD, DD, LL, KK, MS, MS, GG, EE, FF, JJ, DD, GG, FF, JJ, JJ, MS, MS, LL, CC, CC, EE, GG, DD, FF, CC, JJ, KK, EE, LL, SC, GG, DD, CC, MS, MS, EE, BB, DD, FF, LL, LL, JJ, JJ, GG, GG, MS, CC, CC, WC, JJ, EE, BB, BB, EE, EE, MS, GG, FF, LL, LL, SC, BB, MS, MS, EE, EE, LL, FF, JJ, KK, LL,});
        bgReels.add(new String[]{
                GG, LL, LL, GG, FF, EE, MS, CC, JJ, LL, LL, JJ, JJ, MS, GG, SC, FF, DD, JJ, GG, LL, LL, HH, HH, MS, MS, GG, JJ, EE, KK, JJ, JJ, GG, DD, DD, KK, MS, FF, EE, GG, DD, LL, KK, KK, AA, BB, FF, JJ, GG, GG, KK, HH, EE, JJ, DD, GG, HH, MS, MS, BB, HH, GG, FF, HH, MS, DD, AA, AA, LL, GG, KK, HH, MS, LL, JJ, DD, GG, GG, JJ, DD, MS, EE, FF, MS, KK, FF, HH, HH, KK, BB, GG, KK, JJ, KK, EE, HH, CC, CC, LL, EE, KK, GG, HH, EE, JJ, JJ, MS, KK, JJ, GG, HH, KK, KK, LL, JJ, HH, CC, SC, HH, GG, HH, KK, MS, MS, FF, FF, EE, HH, GG, LL, EE, KK, FF, BB, HH, KK, MS, KK, AA, JJ, GG, EE, EE, HH, CC, DD, HH, KK, GG, DD, JJ, JJ, KK, GG, EE, EE, DD, GG, JJ, EE, BB, BB, HH, LL, LL, SC, HH, MS, LL, DD, HH, FF, HH, LL, LL, MS, KK, KK, JJ, GG, HH, AA, CC, KK, CC, CC, HH, MS, GG, JJ, MS, FF, SC, KK, GG, KK, LL, CC, JJ, LL, BB, HH, MS, JJ, JJ, HH, KK, KK, EE, JJ, CC, HH, FF, HH, MS, MS, LL, LL, AA, FF, HH, LL, EE, JJ, MS, HH, EE, EE, HH, FF, KK, JJ, LL, CC, LL, HH, LL, HH, WC, GG, FF, KK, KK, EE, JJ, CC, HH, KK, MS, MS, LL, HH, KK, CC, MS, FF, LL, LL, DD, KK, KK, JJ, JJ, EE, LL, KK, BB, HH, KK, JJ, EE, SC, LL, LL, GG, GG, KK, CC, LL, AA, EE, LL, KK, KK, SC, HH, HH, EE, KK, FF, EE, LL, GG, GG, JJ, JJ, GG, CC, JJ, KK, HH, DD, DD, MS, GG, MS, JJ, JJ, GG, WC, LL, GG, GG, KK, KK, SC, LL, LL, CC, GG, JJ, JJ, FF, KK, DD, DD, MS, MS, LL, HH, GG, HH, LL, DD, HH, MS, JJ, LL, JJ, GG, EE, JJ, HH, EE, KK, FF, FF, LL, EE, EE, KK, HH, CC, JJ, GG, EE, SC, HH, FF, JJ, GG, JJ, BB, KK, CC, CC, CC, WC, HH, JJ, KK, GG, CC, EE, LL, LL, LL, FF, KK, FF, HH, HH, KK, LL, JJ, EE, KK, SC, DD, DD, GG, JJ, LL, LL, BB, BB, EE, JJ, KK, LL, LL, DD, MS, MS, HH, GG, KK, MS, FF, HH, EE, EE, MS, LL, KK, HH, GG, EE, EE, SC, HH, EE, DD, KK, LL, AA, HH, JJ, GG, KK, KK, KK, SC, MS, MS, LL, LL, GG, FF, FF, JJ, GG, CC, KK, EE, GG, GG, GG, SC, CC, KK, JJ, CC, EE, HH, HH, HH, KK, JJ, FF, FF, CC, CC, CC, LL, KK, GG, GG, HH, FF, KK, JJ, HH, DD, DD, EE, KK, EE, EE, GG, KK, JJ, JJ, EE, HH, WC, GG, MS, MS, JJ, FF, HH, HH, JJ, GG, AA, FF, FF, SC, HH, HH, HH, KK, HH, KK, EE, EE, KK, HH, GG, KK, AA, HH, GG, CC, KK, LL, LL, SC, CC, HH, FF, FF, GG, GG, GG, JJ, HH, CC, FF,});
        bgReels.add(new String[]{
                FF, FF, LL, LL, KK, JJ, HH, EE, DD, EE, KK, JJ, SC, CC, JJ, MS, MS, DD, KK, FF, HH, DD, HH, LL, EE, JJ, FF, KK, CC, JJ, HH, KK, KK, DD, DD, EE, HH, LL, CC, JJ, DD, KK, HH, JJ, BB, CC, GG, KK, MS, MS, JJ, HH, CC, GG, DD, KK, HH, KK, LL, AA, HH, BB, KK, CC, JJ, MS, DD, DD, KK, LL, DD, EE, EE, JJ, LL, DD, HH, MS, KK, BB, HH, CC, LL, MS, JJ, GG, HH, LL, CC, AA, FF, JJ, MS, LL, CC, HH, LL, SC, KK, KK, JJ, CC, HH, CC, KK, KK, DD, JJ, LL, FF, HH, JJ, CC, CC, LL, HH, LL, JJ, MS, SC, BB, JJ, FF, BB, KK, EE, CC, MS, FF, KK, KK, JJ, LL, LL, HH, CC, BB, KK, BB, MS, FF, CC, KK, LL, EE, DD, EE, HH, FF, LL, KK, KK, JJ, LL, CC, KK, DD, FF, KK, CC, LL, AA, DD, FF, BB, HH, HH, SC, KK, DD, JJ, MS, HH, LL, LL, JJ, JJ, MS, LL, HH, DD, DD, LL, JJ, EE, EE, LL, JJ, FF, KK, CC, LL, SC, KK, LL, JJ, CC, EE, KK, LL, LL, HH, KK, KK, LL, LL, AA, AA, CC, LL, EE, HH, GG, BB, FF, JJ, SC, GG, GG, FF, LL, FF, CC, KK, LL, HH, CC, CC, WC, GG, JJ, KK, KK, EE, HH, HH, LL, HH, LL, FF, GG, JJ, HH, CC, MS, EE, HH, FF, GG, FF, JJ, JJ, HH, LL, MS, HH, FF, FF, DD, JJ, GG, BB, KK, CC, LL, LL, AA, KK, JJ, KK, CC, BB, FF, MS, BB, MS, JJ, EE, HH, BB, LL, LL, MS, JJ, JJ, FF, HH, CC, DD, GG, CC, BB, FF, FF, CC, KK, FF, EE, KK, JJ, HH, DD, DD, JJ, FF, CC, KK, HH, FF, BB, GG, LL, SC, FF, FF, JJ, HH, LL, LL, FF, FF, CC, GG, JJ, DD, DD, KK, DD, KK, LL, FF, CC, LL, DD, HH, MS, KK, KK, MS, FF, CC, KK, KK, BB, LL, SC, GG, GG, FF, CC, JJ, HH, WC, KK, MS, CC, CC, LL, SC, KK, FF, HH, BB, JJ, LL, LL, EE, AA, HH, KK, MS, FF, EE, CC, MS, KK, KK, GG, GG, FF, HH, SC, HH, HH, KK, CC, JJ, DD, DD, GG, SC, FF, LL, LL, KK, AA, CC, LL, JJ, JJ, MS, DD, KK, HH, HH, EE, JJ, KK, LL, HH, CC, CC, MS, MS, JJ, HH, FF, CC, KK, JJ, HH, CC, DD, JJ, BB, BB, HH, KK, FF, LL, LL, JJ, JJ, GG, KK, DD, CC, FF, GG, GG, KK, FF, EE, JJ, CC, MS, MS, FF, FF, HH, JJ, KK, EE, CC, HH, HH, LL, JJ, KK, SC, LL, LL, EE, EE, WC, JJ, MS, MS, HH, GG, JJ, KK, HH, BB, LL, LL, SC, CC, CC, FF, JJ, GG, KK, CC, JJ, EE, LL, JJ, JJ, KK, GG, CC, HH, KK, FF, BB, GG, KK, HH, HH, LL, SC, JJ, HH, FF, CC, CC, JJ, HH, FF, BB, BB, HH, FF, MS, JJ, KK, HH, LL, EE, BB, SC, GG, FF, MS, MS, LL, LL, EE, GG,});

        List<String[]> topReel = new ArrayList<>(5);
        topReel.add(new String[]{
                KK, CC, GG, GG, GG, GG, DD, HH, FF, LL, LL, LL, LL, KK, SC, JJ, CC, CC, KK, JJ, HH, LL, DD, KK, GG, EE, JJ, JJ, JJ, JJ, LL, LL, SC, BB, GG, JJ, MS, MS, HH, LL, KK, GG, FF, KK, HH, EE, DD, GG, LL, LL, KK, FF, LL, LL, KK, JJ, EE, AA, LL, JJ, JJ, JJ, JJ, GG, LL, JJ, CC, HH, KK, GG, JJ, DD, DD, HH, LL, LL, AA, HH, MS, MS, MS, MS, KK, GG, EE, JJ, KK, KK, KK, KK, GG, HH, EE, HH, JJ, DD, DD, DD, DD, FF, LL, WC, KK, GG, GG, DD, JJ, KK, LL, LL, GG, BB, KK, SC, JJ, KK, HH, JJ, FF, EE, WC, KK, JJ, KK, KK, JJ, BB, BB, BB, BB, GG, EE, LL, JJ, JJ, FF, FF, FF, FF, GG, HH, CC, CC, CC, CC, FF, EE, KK, KK, LL, LL, FF, KK, AA, EE, EE, EE, EE, JJ, DD, MS, JJ, FF, FF, HH, HH, FF, MS, MS, GG, EE, JJ, JJ, BB, BB, BB, BB, LL, CC, JJ, SC, KK, GG, FF, FF, HH, GG, WC, JJ, FF, KK, KK, HH, EE, GG, FF, KK, KK, KK, KK, JJ, MS, MS, HH, KK, GG, SC, FF, HH, DD, JJ, MS, BB, KK, GG, FF, LL, GG, EE, HH, KK, FF, HH, EE, JJ, WC, LL, KK, EE, DD, DD, DD, DD, FF, FF, HH, SC, HH, KK, EE, LL, LL, FF, HH, HH, BB, MS, MS, MS, MS, GG, LL, JJ, HH, JJ, SC, KK, CC, GG, EE, HH, HH, EE, KK, AA, JJ, JJ, JJ, JJ, FF, BB, EE, KK, EE, KK, GG, LL, LL, GG, CC, HH, JJ, SC, GG, KK, JJ, FF, GG, EE, KK, KK, JJ, JJ, FF, MS, KK, DD, HH, HH, CC, KK, CC, GG, KK, MS, HH, FF, MS, GG, EE, HH, MS, KK, LL, LL, JJ, SC, BB, KK, HH, LL, LL, LL, LL, MS, CC, LL, HH, WC, KK, FF, HH, CC, JJ, HH, JJ, SC, CC, MS, LL, LL, JJ, BB, GG, FF, AA, EE, KK, FF, GG, DD, DD, HH, KK, CC, FF, JJ, EE, BB, KK, JJ, BB, BB, BB, BB, KK, CC, JJ, HH, AA, KK, LL, LL, HH, JJ, HH, EE, JJ, KK, SC, JJ, EE, JJ, EE, EE, GG, CC, CC, EE, KK, HH, LL, LL, AA, FF, FF, HH, CC, CC, CC, CC, KK, JJ, JJ, SC, GG, HH, LL, MS, EE, CC, GG, MS, GG, JJ, KK, HH, HH, GG, JJ, FF, CC, CC, CC, CC, JJ, LL, KK, GG, MS, MS, MS, EE, HH, JJ, SC, KK, DD, EE, HH, MS, DD, MS, FF, EE, EE, EE, EE, JJ, AA, HH, DD, WC, JJ, LL, HH, KK, KK, EE, JJ, CC, SC, DD, BB, GG, GG, GG, GG, EE, LL, LL, JJ, BB, FF, FF, FF, FF, JJ, KK, GG, EE, SC, FF, JJ, DD, KK, EE, JJ, HH, LL, LL, JJ, HH, FF, BB, HH, HH, HH, HH, JJ, JJ, HH, JJ, SC, LL, FF, GG, CC, KK, FF, DD, JJ, KK, KK, KK, KK, JJ, AA, LL, LL, LL, LL, JJ, JJ, KK, HH, JJ, HH, EE, EE,});


        List<String[]> fgReels = new ArrayList<>(5);

        fgReels.add(new String[]{
                MS, KK, MS, LL, MS, GG, JJ, DD, KK, HH, SC, LL, HH, LL, KK, GG, EE, CC, LL, LL, LL, EE, CC, JJ, EE, GG, KK, HH, FF, LL, LL, HH, EE, CC, CC, CC, JJ, EE, FF, LL, CC, HH, GG, LL, BB, FF, EE, LL, GG, KK, LL, GG, FF, EE, CC, KK, JJ, EE, LL, AA, LL, KK, EE, FF, GG, CC, DD, CC, HH, KK, GG, MS, DD, GG, SC, CC, JJ, MS, MS, MS, JJ, FF, EE, KK, GG, EE, JJ, JJ, JJ, AA, KK, LL, LL, EE, FF, LL, DD, FF, DD, HH, GG, KK, MS, MS, HH, HH, EE, GG, HH, KK, JJ, LL, FF, FF, EE, JJ, DD, GG, JJ, KK, BB, GG, KK, JJ, LL, LL, LL, MS, KK, HH, LL, LL, LL, AA, MS, FF, BB, KK, BB, HH, LL, FF, LL, JJ, SC, CC, GG, JJ, KK, LL, HH, HH, HH, JJ, FF, HH, CC, KK, HH, FF, KK, AA, JJ, KK, BB, JJ, JJ, JJ, FF, CC, EE, EE, EE, GG, GG, LL, LL, GG, HH, LL, JJ, BB, HH, GG, DD, DD, JJ, GG, KK, HH, FF, EE, MS, MS, KK, GG, LL, DD, HH, GG, AA, JJ, HH, KK, LL, JJ, GG, SC, FF, HH, DD, JJ, EE, BB, KK, GG, EE, EE, EE, JJ, JJ, KK, KK, HH, EE, MS, FF, FF, MS, EE, GG, HH, KK, DD, LL, LL, LL, JJ, JJ, EE, EE, GG, JJ, FF, HH, DD, JJ, LL, GG, GG, GG, KK, KK, DD, HH, HH, KK, KK, CC, GG, EE, HH, HH, FF, MS, LL, AA, JJ, GG, LL, FF, GG, GG, KK, KK, KK, LL, DD, JJ, MS, FF, HH, LL, LL, KK, KK, LL, FF, GG, LL, LL, JJ, KK, KK, FF, LL, KK, DD, HH, GG, JJ, CC, CC, CC, KK, SC, LL, JJ, LL, GG, MS, EE, KK, KK, GG, GG, JJ, FF, DD, KK, LL, FF, EE, GG, CC, CC, EE, SC, JJ, JJ, KK, FF, LL, CC, FF, FF, FF, LL, MS, KK, MS, HH, JJ, BB, GG, EE, EE, EE, KK, FF, GG, JJ, DD, KK, KK, FF, FF, JJ, EE, HH, KK, JJ, BB, GG, DD, DD, KK, KK, MS, MS, LL, LL, DD, FF, HH, MS, HH, SC, GG, KK, MS, JJ, AA, LL, HH, FF, GG, CC, CC, EE, EE, HH, GG, KK, LL, AA, FF, HH, HH, GG, GG, CC, HH, JJ, JJ, JJ, GG, SC, LL, JJ, HH, LL, FF, FF, GG, JJ, KK, KK, HH, GG, JJ, FF, BB, GG, BB, BB, JJ, MS, KK, KK, LL, GG, GG, MS, MS, SC, FF, KK, KK, EE, HH, LL, LL, GG, FF, KK, KK, EE, EE, JJ, LL, HH, DD, FF, MS, JJ, JJ, GG, HH, EE, JJ, SC, DD, DD, BB, GG, KK, LL, JJ, EE, EE, HH, JJ, EE, FF, EE, EE, LL, LL, KK, GG, EE, LL, FF, MS, MS, KK, GG, GG, GG, EE, FF, JJ, HH, KK, BB, EE, HH, HH, MS, JJ, JJ, KK, JJ, KK, FF, FF, LL, JJ, SC, BB, BB, JJ, KK, DD, GG, HH, JJ, DD, DD, DD, FF, EE, KK, KK, LL, LL, JJ, DD, EE,        });

        fgReels.add(new String[]{
                JJ, JJ, LL, KK, KK, HH, HH, CC, GG, GG, HH, GG, GG, EE, EE, HH, SC, DD, GG, JJ, MS, LL, KK, KK, FF, MS, MS, LL, EE, HH, KK, EE, JJ, LL, LL, JJ, KK, FF, LL, JJ, DD, GG, LL, GG, KK, MS, FF, GG, JJ, JJ, MS, LL, EE, FF, FF, JJ, KK, FF, FF, BB, KK, JJ, FF, EE, EE, MS, DD, DD, GG, JJ, HH, KK, CC, LL, GG, DD, LL, JJ, GG, AA, KK, EE, EE, FF, HH, FF, KK, LL, WC, LL, JJ, HH, GG, FF, EE, KK, MS, CC, CC, LL, HH, JJ, MS, EE, LL, GG, FF, HH, HH, JJ, LL, HH, MS, LL, LL, MS, LL, LL, KK, JJ, EE, HH, JJ, KK, KK, FF, EE, EE, JJ, GG, EE, HH, FF, BB, KK, EE, KK, AA, LL, GG, JJ, EE, GG, GG, CC, DD, MS, KK, JJ, LL, GG, LL, HH, SC, EE, LL, LL, LL, GG, EE, BB, BB, GG, JJ, AA, KK, KK, EE, GG, DD, HH, HH, KK, GG, LL, HH, LL, HH, GG, JJ, JJ, AA, GG, HH, CC, CC, EE, HH, JJ, GG, GG, FF, FF, EE, JJ, HH, EE, CC, GG, GG, BB, KK, LL, SC, GG, KK, HH, JJ, EE, GG, CC, FF, FF, EE, JJ, HH, LL, LL, FF, FF, JJ, JJ, LL, GG, KK, LL, EE, EE, KK, FF, HH, GG, FF, MS, LL, LL, FF, KK, KK, JJ, FF, HH, EE, EE, GG, CC, KK, JJ, FF, LL, LL, HH, HH, GG, GG, EE, JJ, JJ, DD, DD, FF, GG, GG, MS, KK, HH, BB, KK, LL, GG, GG, KK, AA, LL, JJ, JJ, HH, CC, LL, LL, EE, BB, BB, HH, HH, FF, MS, EE, WC, FF, FF, KK, JJ, JJ, EE, GG, JJ, CC, GG, GG, KK, SC, DD, EE, FF, LL, GG, GG, JJ, HH, FF, MS, LL, JJ, JJ, KK, KK, EE, CC, CC, GG, EE, SC, HH, LL, DD, MS, DD, DD, KK, JJ, EE, GG, DD, KK, GG, GG, EE, EE, JJ, EE, WC, KK, LL, HH, MS, FF, FF, JJ, GG, HH, KK, CC, GG, JJ, EE, MS, MS, FF, GG, DD, KK, LL, HH, HH, FF, CC, CC, KK, GG, JJ, JJ, CC, EE, EE, SC, GG, FF, KK, LL, LL, JJ, KK, KK, EE, EE, MS, DD, DD, FF, JJ, GG, HH, LL, BB, BB, EE, GG, HH, HH, JJ, DD, GG, LL, LL, HH, HH, GG, MS, LL, LL, EE, EE, LL, HH, SC, DD, DD, GG, MS, MS, DD, DD, HH, LL, AA, KK, GG, JJ, MS, MS, HH, SC, FF, GG, GG, EE, WC, JJ, FF, GG, JJ, CC, CC, EE, JJ, FF, JJ, FF, KK, HH, GG, FF, EE, KK, KK, KK, HH, FF, SC, KK, LL, CC, CC, KK, HH, JJ, MS, KK, MS, HH, HH, KK, FF, EE, MS, LL, EE, MS, JJ, HH, FF, GG, EE, CC, CC, JJ, HH, HH, GG, FF, LL, MS, GG, JJ, AA, FF, FF, KK, EE, LL, LL, HH, KK, JJ, LL, EE, HH, KK, KK, LL, HH, KK, LL, CC, SC, GG, KK, CC, CC, LL, FF, FF, EE, JJ, JJ, GG, LL, CC, FF,        });

        fgReels.add(new String[]{
                LL, LL, HH, HH, CC, JJ, GG, SC, EE, KK, KK, MS, KK, DD, HH, FF, CC, EE, MS, HH, LL, GG, GG, LL, CC, JJ, HH, KK, EE, JJ, GG, KK, KK, EE, EE, JJ, GG, CC, FF, WC, EE, KK, JJ, JJ, BB, EE, CC, KK, HH, FF, KK, GG, DD, EE, EE, HH, GG, CC, CC, AA, GG, HH, LL, LL, JJ, MS, EE, EE, SC, HH, JJ, GG, LL, JJ, KK, EE, EE, HH, KK, GG, GG, EE, CC, HH, JJ, CC, GG, MS, MS, AA, HH, JJ, LL, CC, DD, GG, LL, FF, FF, JJ, JJ, HH, GG, WC, KK, LL, CC, JJ, KK, FF, JJ, MS, FF, FF, KK, GG, FF, JJ, JJ, HH, BB, JJ, HH, GG, CC, CC, DD, EE, HH, KK, DD, JJ, CC, AA, GG, LL, KK, BB, BB, MS, LL, EE, EE, GG, FF, MS, SC, GG, HH, EE, LL, KK, JJ, LL, EE, EE, LL, LL, KK, DD, LL, AA, GG, MS, MS, LL, GG, EE, KK, EE, JJ, CC, CC, LL, LL, LL, JJ, JJ, KK, HH, GG, BB, KK, JJ, FF, FF, GG, EE, HH, HH, DD, KK, KK, KK, HH, JJ, FF, FF, KK, JJ, AA, GG, KK, KK, KK, JJ, JJ, SC, DD, KK, FF, GG, MS, BB, HH, JJ, JJ, WC, CC, CC, GG, DD, DD, KK, CC, LL, LL, EE, EE, CC, JJ, KK, HH, FF, LL, LL, FF, GG, GG, CC, CC, JJ, GG, DD, KK, FF, GG, HH, CC, LL, LL, LL, JJ, FF, MS, MS, HH, HH, EE, JJ, CC, KK, LL, LL, GG, JJ, AA, GG, JJ, FF, FF, BB, HH, HH, LL, EE, JJ, HH, GG, HH, DD, KK, KK, JJ, JJ, HH, GG, DD, JJ, DD, DD, GG, FF, MS, EE, KK, HH, LL, KK, MS, MS, EE, EE, LL, HH, DD, KK, SC, HH, JJ, CC, LL, LL, HH, HH, JJ, GG, EE, FF, LL, KK, DD, CC, CC, LL, SC, EE, EE, MS, GG, HH, DD, KK, EE, GG, MS, LL, KK, KK, DD, DD, LL, EE, BB, JJ, CC, CC, CC, HH, DD, JJ, GG, LL, LL, LL, DD, DD, CC, CC, KK, HH, LL, BB, JJ, KK, FF, LL, FF, GG, KK, KK, LL, FF, DD, KK, KK, MS, MS, JJ, JJ, GG, SC, LL, GG, KK, DD, JJ, LL, EE, EE, HH, KK, JJ, KK, AA, MS, DD, KK, JJ, JJ, HH, EE, EE, GG, GG, HH, SC, KK, CC, GG, DD, WC, LL, DD, JJ, GG, HH, HH, KK, JJ, MS, DD, EE, JJ, BB, BB, LL, KK, HH, MS, JJ, JJ, LL, CC, KK, KK, DD, HH, CC, SC, KK, HH, LL, JJ, DD, KK, HH, HH, LL, MS, MS, KK, FF, DD, GG, GG, GG, JJ, JJ, CC, GG, FF, FF, SC, BB, JJ, HH, KK, GG, CC, KK, KK, GG, BB, MS, LL, LL, DD, DD, HH, JJ, CC, KK, DD, DD, FF, HH, MS, MS, KK, CC, DD, GG, GG, HH, BB, CC, KK, LL, LL, GG, GG, JJ, MS, MS, DD, DD, JJ, GG, SC, BB, BB, GG, FF, FF, JJ, KK, GG, WC, MS, LL, LL, HH, HH, MS, MS, LL, MS, FF, CC,        });

        fgReels.add(new String[]{
                LL, EE, LL, EE, GG, GG, JJ, KK, HH, HH, FF, FF, MS, CC, KK, GG, DD, SC, LL, EE, MS, JJ, JJ, HH, DD, GG, EE, LL, HH, GG, JJ, FF, MS, HH, LL, GG, GG, MS, CC, EE, HH, FF, GG, GG, BB, CC, DD, LL, EE, EE, GG, MS, HH, DD, HH, EE, EE, DD, DD, AA, JJ, JJ, DD, LL, GG, GG, LL, HH, FF, EE, GG, JJ, KK, GG, SC, FF, JJ, EE, FF, BB, JJ, CC, DD, EE, GG, DD, HH, JJ, CC, AA, EE, GG, FF, DD, CC, JJ, KK, KK, KK, FF, GG, EE, HH, HH, FF, FF, DD, GG, FF, EE, JJ, JJ, CC, CC, MS, JJ, KK, GG, JJ, HH, BB, GG, GG, JJ, DD, DD, CC, JJ, EE, FF, CC, WC, DD, AA, JJ, MS, MS, BB, BB, FF, SC, CC, FF, JJ, MS, HH, GG, JJ, EE, MS, FF, FF, GG, EE, CC, LL, MS, LL, FF, CC, KK, AA, EE, EE, BB, JJ, JJ, CC, FF, HH, GG, DD, DD, MS, HH, LL, GG, GG, FF, EE, JJ, BB, MS, KK, KK, KK, JJ, LL, LL, FF, CC, DD, DD, MS, EE, GG, CC, FF, FF, LL, AA, MS, MS, WC, FF, JJ, GG, GG, CC, FF, KK, JJ, DD, BB, EE, LL, LL, SC, DD, MS, MS, EE, CC, FF, DD, JJ, CC, CC, JJ, DD, GG, FF, EE, EE, JJ, JJ, JJ, HH, HH, EE, DD, GG, JJ, CC, FF, KK, JJ, EE, DD, LL, MS, GG, GG, WC, FF, JJ, EE, EE, HH, GG, DD, FF, FF, CC, JJ, GG, AA, GG, GG, FF, CC, BB, LL, LL, EE, EE, HH, KK, JJ, EE, CC, FF, MS, GG, GG, EE, JJ, CC, GG, LL, LL, JJ, EE, EE, CC, MS, EE, KK, FF, GG, LL, HH, HH, MS, EE, CC, FF, SC, HH, GG, DD, LL, LL, EE, EE, GG, JJ, CC, KK, MS, FF, CC, HH, LL, SC, HH, HH, WC, LL, LL, LL, CC, FF, HH, JJ, LL, LL, FF, HH, CC, CC, FF, JJ, BB, GG, DD, DD, DD, EE, JJ, GG, LL, KK, FF, EE, CC, CC, JJ, DD, FF, EE, HH, BB, GG, LL, LL, KK, KK, JJ, FF, GG, EE, KK, CC, LL, FF, FF, MS, MS, EE, LL, SC, JJ, HH, FF, CC, GG, HH, HH, DD, WC, FF, GG, AA, KK, LL, CC, FF, GG, GG, FF, HH, HH, JJ, JJ, EE, GG, FF, DD, GG, CC, CC, HH, LL, SC, JJ, EE, CC, FF, LL, LL, LL, GG, GG, BB, BB, JJ, MS, EE, GG, MS, LL, GG, DD, SC, FF, CC, EE, DD, DD, MS, EE, MS, GG, CC, MS, MS, EE, EE, JJ, LL, LL, KK, CC, JJ, JJ, LL, GG, FF, DD, DD, SC, KK, MS, MS, GG, EE, FF, JJ, DD, GG, FF, JJ, JJ, MS, MS, LL, CC, CC, EE, GG, DD, FF, CC, JJ, KK, EE, LL, GG, GG, DD, CC, MS, MS, EE, BB, DD, FF, LL, LL, JJ, JJ, GG, GG, MS, CC, CC, WC, JJ, EE, BB, BB, EE, EE, MS, GG, FF, LL, LL, LL, BB, MS, MS, SC, EE, LL, FF, JJ, KK, LL,        });

        fgReels.add(new String[]{
                GG, LL, LL, GG, FF, EE, MS, CC, JJ, LL, SC, JJ, JJ, MS, GG, FF, FF, DD, JJ, GG, LL, LL, HH, HH, MS, MS, GG, JJ, EE, KK, JJ, JJ, GG, DD, DD, KK, MS, FF, EE, GG, DD, LL, KK, KK, AA, BB, FF, JJ, GG, GG, KK, HH, EE, JJ, DD, GG, HH, MS, MS, BB, HH, GG, FF, EE, MS, DD, DD, DD, LL, GG, KK, HH, MS, LL, JJ, DD, GG, GG, SC, DD, MS, EE, FF, MS, KK, FF, HH, HH, KK, BB, GG, KK, JJ, FF, EE, HH, CC, CC, LL, EE, KK, GG, HH, EE, JJ, JJ, MS, KK, JJ, GG, HH, KK, KK, LL, JJ, HH, CC, KK, HH, GG, HH, KK, MS, MS, FF, FF, EE, HH, GG, LL, EE, KK, FF, BB, HH, KK, MS, KK, AA, JJ, GG, EE, EE, HH, CC, DD, KK, KK, GG, WC, JJ, JJ, KK, GG, EE, SC, DD, GG, JJ, EE, BB, BB, HH, LL, LL, HH, HH, MS, LL, DD, HH, FF, HH, LL, LL, MS, KK, KK, JJ, GG, HH, AA, CC, KK, CC, CC, HH, MS, GG, JJ, MS, FF, FF, KK, GG, KK, LL, CC, JJ, LL, BB, HH, MS, JJ, JJ, HH, SC, KK, EE, JJ, CC, HH, FF, HH, MS, MS, LL, LL, FF, FF, KK, LL, EE, JJ, MS, HH, EE, EE, HH, FF, KK, JJ, LL, CC, LL, HH, LL, HH, WC, GG, FF, KK, KK, EE, JJ, CC, HH, KK, MS, MS, LL, KK, KK, CC, MS, FF, LL, LL, DD, KK, KK, JJ, JJ, EE, LL, KK, BB, HH, KK, JJ, EE, EE, LL, LL, GG, GG, KK, CC, LL, GG, EE, LL, KK, KK, KK, HH, HH, EE, KK, FF, EE, LL, GG, GG, JJ, JJ, GG, CC, JJ, KK, SC, DD, DD, MS, GG, MS, JJ, JJ, GG, WC, LL, GG, GG, KK, KK, KK, LL, LL, CC, GG, JJ, JJ, FF, KK, DD, DD, MS, MS, LL, HH, GG, HH, LL, DD, HH, MS, JJ, LL, JJ, GG, EE, JJ, HH, EE, KK, FF, FF, LL, EE, EE, KK, HH, CC, JJ, GG, EE, EE, HH, FF, JJ, GG, JJ, AA, KK, CC, CC, CC, WC, HH, JJ, KK, GG, CC, EE, LL, LL, LL, FF, KK, FF, SC, HH, KK, LL, JJ, EE, KK, DD, DD, DD, GG, JJ, LL, LL, BB, BB, EE, JJ, KK, LL, LL, DD, MS, MS, HH, GG, KK, MS, FF, HH, EE, EE, MS, LL, KK, HH, GG, EE, EE, KK, HH, EE, DD, KK, LL, AA, HH, JJ, GG, KK, KK, KK, KK, MS, MS, LL, LL, GG, FF, FF, SC, GG, CC, KK, EE, GG, GG, GG, GG, CC, KK, JJ, CC, EE, HH, HH, HH, KK, JJ, SC, FF, CC, CC, CC, LL, KK, GG, GG, HH, FF, KK, JJ, HH, DD, DD, EE, KK, EE, EE, GG, KK, JJ, JJ, EE, HH, WC, GG, MS, MS, JJ, FF, HH, HH, JJ, GG, AA, FF, FF, HH, HH, HH, HH, KK, HH, KK, EE, EE, KK, HH, GG, KK, AA, HH, GG, CC, KK, SC, LL, LL, CC, HH, FF, FF, GG, GG, GG, JJ, HH, CC, FF,        });

        fgReels.add(new String[]{
                FF, FF, LL, LL, KK, JJ, HH, EE, LL, LL, KK, JJ, KK, CC, JJ, MS, MS, DD, KK, SC, HH, LL, HH, LL, EE, JJ, FF, KK, CC, JJ, HH, KK, KK, DD, DD, JJ, HH, LL, CC, JJ, DD, KK, JJ, JJ, BB, CC, GG, KK, MS, MS, JJ, HH, CC, GG, DD, LL, HH, KK, LL, AA, HH, WC, KK, CC, JJ, MS, DD, DD, KK, LL, DD, SC, EE, JJ, LL, DD, HH, MS, KK, BB, HH, CC, LL, MS, JJ, GG, HH, LL, CC, AA, FF, JJ, MS, LL, CC, HH, LL, KK, KK, KK, JJ, CC, HH, CC, KK, KK, LL, JJ, LL, FF, HH, JJ, CC, CC, LL, HH, LL, JJ, MS, FF, BB, JJ, FF, BB, KK, LL, CC, MS, FF, KK, KK, JJ, LL, LL, HH, CC, BB, KK, BB, MS, FF, CC, KK, LL, EE, DD, SC, HH, FF, LL, KK, KK, JJ, LL, CC, KK, DD, FF, KK, CC, LL, AA, WC, FF, BB, HH, HH, CC, KK, DD, JJ, MS, HH, LL, LL, JJ, JJ, MS, LL, HH, LL, LL, LL, JJ, EE, EE, LL, JJ, FF, KK, CC, LL, LL, KK, LL, JJ, CC, EE, KK, LL, LL, HH, KK, KK, LL, LL, JJ, JJ, CC, LL, EE, HH, GG, BB, FF, JJ, SC, GG, GG, FF, LL, FF, CC, KK, LL, HH, CC, CC, WC, GG, JJ, KK, KK, EE, HH, HH, LL, HH, LL, FF, GG, JJ, HH, CC, MS, EE, HH, FF, GG, FF, JJ, JJ, JJ, LL, MS, HH, FF, FF, DD, JJ, GG, KK, KK, CC, LL, LL, AA, KK, JJ, KK, CC, BB, FF, MS, BB, MS, JJ, EE, HH, LL, LL, LL, MS, JJ, JJ, FF, HH, CC, WC, GG, CC, HH, FF, FF, CC, KK, FF, EE, KK, JJ, HH, DD, DD, JJ, FF, CC, KK, HH, FF, JJ, GG, LL, LL, SC, FF, JJ, HH, LL, LL, FF, FF, CC, GG, JJ, DD, DD, KK, DD, SC, LL, FF, CC, LL, DD, HH, MS, KK, KK, MS, FF, CC, KK, KK, BB, LL, GG, GG, GG, FF, CC, JJ, HH, WC, KK, MS, CC, CC, LL, LL, KK, FF, HH, BB, JJ, LL, LL, EE, EE, HH, KK, MS, FF, EE, CC, MS, KK, KK, GG, GG, FF, HH, HH, HH, HH, KK, CC, SC, DD, DD, GG, FF, FF, LL, LL, KK, AA, CC, LL, JJ, JJ, MS, DD, KK, HH, HH, EE, JJ, KK, LL, HH, CC, CC, MS, MS, JJ, HH, FF, CC, KK, SC, HH, CC, DD, JJ, BB, BB, HH, KK, FF, LL, LL, JJ, JJ, GG, SC, DD, CC, FF, GG, GG, KK, FF, EE, JJ, CC, MS, MS, FF, FF, HH, JJ, KK, EE, CC, HH, HH, LL, JJ, KK, LL, LL, LL, EE, EE, WC, JJ, MS, MS, HH, SC, JJ, KK, HH, BB, LL, LL, CC, CC, CC, FF, JJ, GG, KK, CC, JJ, EE, LL, JJ, JJ, KK, GG, CC, HH, KK, FF, BB, GG, KK, HH, HH, LL, LL, JJ, HH, FF, CC, CC, SC, HH, FF, BB, BB, HH, FF, MS, JJ, KK, HH, LL, EE, BB, CC, GG, FF, MS, MS, LL, LL, EE, GG,        });

        List<String[]> fgTopReel = new ArrayList<>(5);
        fgTopReel.add(new String[]{
                KK, CC, FF, GG, GG, JJ, DD, HH, FF, LL, LL, EE, BB, KK, FF, SC, CC, CC, KK, JJ, HH, KK, DD, KK, GG, EE, HH, HH, GG, JJ, LL, LL, LL, BB, GG, JJ, MS, MS, SC, LL, KK, GG, FF, KK, HH, EE, DD, GG, LL, LL, KK, FF, CC, CC, KK, JJ, EE, EE, AA, JJ, KK, EE, FF, GG, CC, JJ, CC, HH, KK, SC, JJ, DD, DD, HH, LL, LL, AA, HH, MS, MS, MS, MS, KK, GG, EE, JJ, SC, FF, LL, KK, GG, HH, EE, HH, JJ, DD, DD, FF, HH, FF, LL, WC, KK, GG, GG, DD, MS, MS, SC, LL, GG, AA, KK, HH, JJ, KK, GG, JJ, FF, EE, WC, KK, JJ, KK, KK, JJ, JJ, SC, HH, BB, GG, EE, LL, JJ, JJ, FF, FF, GG, EE, GG, HH, MS, MS, JJ, CC, FF, EE, KK, KK, LL, LL, FF, KK, FF, EE, EE, MS, MS, JJ, DD, MS, JJ, FF, FF, HH, HH, FF, MS, MS, SC, EE, JJ, JJ, CC, CC, GG, GG, FF, CC, JJ, BB, KK, GG, FF, FF, HH, GG, WC, JJ, FF, KK, KK, HH, EE, GG, FF, LL, LL, EE, AA, JJ, MS, MS, HH, KK, GG, CC, FF, HH, DD, JJ, MS, BB, KK, MS, MS, LL, GG, EE, HH, KK, FF, HH, EE, JJ, WC, CC, KK, EE, GG, HH, KK, DD, FF, SC, HH, JJ, HH, KK, EE, LL, LL, FF, HH, HH, BB, MS, MS, MS, MS, GG, AA, JJ, HH, JJ, KK, KK, CC, GG, EE, HH, SC, EE, KK, FF, JJ, JJ, GG, HH, FF, BB, EE, KK, EE, KK, GG, LL, LL, GG, CC, HH, JJ, JJ, GG, KK, JJ, FF, GG, EE, KK, KK, JJ, JJ, FF, MS, KK, DD, HH, HH, CC, KK, CC, GG, KK, MS, HH, FF, SC, GG, EE, HH, MS, KK, LL, LL, JJ, FF, BB, KK, HH, FF, EE, GG, AA, MS, CC, LL, HH, WC, KK, FF, HH, CC, JJ, HH, SC, HH, MS, MS, LL, LL, JJ, BB, GG, FF, GG, EE, KK, FF, GG, DD, DD, HH, KK, CC, FF, JJ, EE, BB, KK, JJ, BB, GG, HH, JJ, SC, CC, JJ, HH, GG, KK, AA, FF, HH, JJ, HH, EE, GG, KK, KK, JJ, EE, JJ, SC, EE, GG, CC, CC, EE, KK, HH, LL, LL, AA, FF, FF, HH, GG, HH, KK, CC, KK, JJ, JJ, BB, GG, HH, SC, MS, EE, MS, GG, MS, GG, JJ, KK, HH, HH, GG, JJ, FF, CC, GG, KK, JJ, JJ, EE, KK, GG, MS, MS, MS, EE, HH, JJ, FF, KK, DD, EE, HH, MS, DD, MS, FF, JJ, FF, HH, KK, JJ, GG, HH, DD, WC, JJ, FF, HH, KK, KK, EE, JJ, CC, DD, DD, BB, GG, MS, HH, SC, EE, LL, LL, JJ, BB, FF, GG, FF, JJ, JJ, KK, GG, EE, EE, FF, JJ, DD, KK, EE, GG, HH, EE, FF, JJ, HH, FF, BB, KK, HH, JJ, KK, GG, JJ, HH, JJ, LL, LL, FF, GG, CC, MS, MS, DD, JJ, KK, FF, GG, HH, JJ, AA, LL, LL, LL, EE, JJ, SC, KK, HH, JJ, HH, EE, EE,        });
        gameReels.add(bgReels);
        gameReels.add(topReel);
        gameReels.add(fgReels);
        gameReels.add(fgTopReel);

        return gameReels;
    }



    public WeightedPrizeData getSymHeightInBaseGame() {
        return new WeightedPrizeData()
                .addWeightedConfigForMultiplePrize(new WeightedMultiplePrizeConfig(45, new int[]{1, 4}))
                .addWeightedConfigForMultiplePrize(new WeightedMultiplePrizeConfig(45, new int[]{4, 1}))
                .addWeightedConfigForMultiplePrize(new WeightedMultiplePrizeConfig(45, new int[]{2, 3}))
                .addWeightedConfigForMultiplePrize(new WeightedMultiplePrizeConfig(45, new int[]{3, 2}))
                .addWeightedConfigForMultiplePrize(new WeightedMultiplePrizeConfig(12, new int[]{1, 2, 2}))
                .addWeightedConfigForMultiplePrize(new WeightedMultiplePrizeConfig(12, new int[]{2, 1, 2}))
                .addWeightedConfigForMultiplePrize(new WeightedMultiplePrizeConfig(12, new int[]{2, 2, 1}))
                .addWeightedConfigForMultiplePrize(new WeightedMultiplePrizeConfig(12, new int[]{3, 1, 1}))
                .addWeightedConfigForMultiplePrize(new WeightedMultiplePrizeConfig(12, new int[]{1, 3, 1}))
                .addWeightedConfigForMultiplePrize(new WeightedMultiplePrizeConfig(12, new int[]{1, 1, 3}))
                .addWeightedConfigForMultiplePrize(new WeightedMultiplePrizeConfig(6, new int[]{1, 1, 1, 2}))
                .addWeightedConfigForMultiplePrize(new WeightedMultiplePrizeConfig(6, new int[]{1, 1, 2, 1}))
                .addWeightedConfigForMultiplePrize(new WeightedMultiplePrizeConfig(6, new int[]{1, 2, 1, 1}))
                .addWeightedConfigForMultiplePrize(new WeightedMultiplePrizeConfig(6, new int[]{2, 1, 1, 1}))
                .addWeightedConfigForMultiplePrize(new WeightedMultiplePrizeConfig(3, new int[]{1, 1, 1, 1, 1}));

    }

    public WeightedPrizeData getSymHeightInFreeSpins() {
        return new WeightedPrizeData()
                .addWeightedConfigForMultiplePrize(new WeightedMultiplePrizeConfig(30, new int[]{1, 4}))
                .addWeightedConfigForMultiplePrize(new WeightedMultiplePrizeConfig(30, new int[]{4, 1}))
                .addWeightedConfigForMultiplePrize(new WeightedMultiplePrizeConfig(30, new int[]{2, 3}))
                .addWeightedConfigForMultiplePrize(new WeightedMultiplePrizeConfig(30, new int[]{3, 2}))
                .addWeightedConfigForMultiplePrize(new WeightedMultiplePrizeConfig(12, new int[]{1, 2, 2}))
                .addWeightedConfigForMultiplePrize(new WeightedMultiplePrizeConfig(12, new int[]{2, 1, 2}))
                .addWeightedConfigForMultiplePrize(new WeightedMultiplePrizeConfig(12, new int[]{2, 2, 1}))
                .addWeightedConfigForMultiplePrize(new WeightedMultiplePrizeConfig(12, new int[]{3, 1, 1}))
                .addWeightedConfigForMultiplePrize(new WeightedMultiplePrizeConfig(12, new int[]{1, 3, 1}))
                .addWeightedConfigForMultiplePrize(new WeightedMultiplePrizeConfig(12, new int[]{1, 1, 3}))
                .addWeightedConfigForMultiplePrize(new WeightedMultiplePrizeConfig(10, new int[]{1, 1, 1, 2}))
                .addWeightedConfigForMultiplePrize(new WeightedMultiplePrizeConfig(10, new int[]{1, 1, 2, 1}))
                .addWeightedConfigForMultiplePrize(new WeightedMultiplePrizeConfig(10, new int[]{1, 2, 1, 1}))
                .addWeightedConfigForMultiplePrize(new WeightedMultiplePrizeConfig(10, new int[]{2, 1, 1, 1}))
                .addWeightedConfigForMultiplePrize(new WeightedMultiplePrizeConfig(18, new int[]{1, 1, 1, 1, 1}));

    }

    public WeightedPrizeData getSilverReplacement() {
        return new WeightedPrizeData()
                .addWeightedConfig(new WeightedPrizeConfig(10, 2))
                .addWeightedConfig(new WeightedPrizeConfig(10, 3))
                .addWeightedConfig(new WeightedPrizeConfig(10, 4))
                .addWeightedConfig(new WeightedPrizeConfig(10, 5))
                .addWeightedConfig(new WeightedPrizeConfig(10, 6))
                .addWeightedConfig(new WeightedPrizeConfig(10, 7))
                .addWeightedConfig(new WeightedPrizeConfig(10, 8))
                .addWeightedConfig(new WeightedPrizeConfig(10, 9))
                .addWeightedConfig(new WeightedPrizeConfig(10, 10))
                .addWeightedConfig(new WeightedPrizeConfig(10, 11))
                .addWeightedConfig(new WeightedPrizeConfig(25, 12));
    }

    public WeightedPrizeData getSilverReplacementInFreeSpins() {
        return new WeightedPrizeData()
                .addWeightedConfig(new WeightedPrizeConfig(10, 2))
                .addWeightedConfig(new WeightedPrizeConfig(10, 3))
                .addWeightedConfig(new WeightedPrizeConfig(10, 4))
                .addWeightedConfig(new WeightedPrizeConfig(10, 5))
                .addWeightedConfig(new WeightedPrizeConfig(10, 6))
                .addWeightedConfig(new WeightedPrizeConfig(10, 7))
                .addWeightedConfig(new WeightedPrizeConfig(10, 8))
                .addWeightedConfig(new WeightedPrizeConfig(10, 9))
                .addWeightedConfig(new WeightedPrizeConfig(10, 10))
                .addWeightedConfig(new WeightedPrizeConfig(10, 11))
                .addWeightedConfig(new WeightedPrizeConfig(50, 12));
    }

    private Map<Integer, String> getSymbolMap() {
        Map<Integer, String> symbolMap = new HashMap<>();

        symbolMap.put(0, WC);
        symbolMap.put(1, AA);
        symbolMap.put(2, BB);
        symbolMap.put(3, CC);
        symbolMap.put(4, DD);
        symbolMap.put(5, EE);
        symbolMap.put(6, FF);
        symbolMap.put(7, GG);
        symbolMap.put(8, HH);
        symbolMap.put(9, JJ);
        symbolMap.put(10, KK);
        symbolMap.put(11, LL);
        symbolMap.put(12, MS);
        symbolMap.put(13, SC);

        return symbolMap;
    }

    public WeightedPrizeData getMysteryReplacementInBaseGame() {
        return new WeightedPrizeData()
                .addWeightedConfig(new WeightedPrizeConfig(6, 2))
                .addWeightedConfig(new WeightedPrizeConfig(9, 3))
                .addWeightedConfig(new WeightedPrizeConfig(12, 4))
                .addWeightedConfig(new WeightedPrizeConfig(14, 5))
                .addWeightedConfig(new WeightedPrizeConfig(14, 6))
                .addWeightedConfig(new WeightedPrizeConfig(30, 7))
                .addWeightedConfig(new WeightedPrizeConfig(30, 8))
                .addWeightedConfig(new WeightedPrizeConfig(48, 9))
                .addWeightedConfig(new WeightedPrizeConfig(48, 10))
                .addWeightedConfig(new WeightedPrizeConfig(48, 11));
    }

    public WeightedPrizeData getMysteryReplacementInFreeSpins() {
        return new WeightedPrizeData()
                .addWeightedConfig(new WeightedPrizeConfig(6, 2))
                .addWeightedConfig(new WeightedPrizeConfig(9, 3))
                .addWeightedConfig(new WeightedPrizeConfig(12, 4))
                .addWeightedConfig(new WeightedPrizeConfig(14, 5))
                .addWeightedConfig(new WeightedPrizeConfig(14, 6))
                .addWeightedConfig(new WeightedPrizeConfig(30, 7))
                .addWeightedConfig(new WeightedPrizeConfig(30, 8))
                .addWeightedConfig(new WeightedPrizeConfig(40, 9))
                .addWeightedConfig(new WeightedPrizeConfig(40, 10))
                .addWeightedConfig(new WeightedPrizeConfig(40, 11));
    }
}
