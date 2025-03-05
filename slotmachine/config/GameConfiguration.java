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
    public final Map<Integer, String> symbolMap = getSymbolMap();


    public int getBoardHeight() {
        return boardHeight;
    }

    public void setBoardHeight(int boardHeight) {
        this.boardHeight = boardHeight;
    }

    public Map<String, SlotSymbolWaysPayConfig> payout = createPayout();

    public List<List<String[]>> reelSets = createReelSets();
    public WeightedPrizeData symHeight = getSymHeight();

    public WeightedPrizeData silverSymReplacement = getSilverReplacement();


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
                GG, BB, FF, CC, JJ, EE, BB, DD, KK, HH, KK, FF, AA, KK, KK, JJ, JJ, CC, GG, HH, DD, EE, CC, AA, EE, GG, KK, HH, FF, CC, CC, BB, EE, CC, CC, CC, AA, EE, FF, DD, CC, HH, GG, EE, BB, FF, KK, GG, JJ, KK, HH, GG, FF, EE, CC, KK, JJ, EE, DD, HH, FF, KK, JJ, FF, GG, CC, DD, CC, HH, KK, GG, DD, DD, JJ, KK, CC, JJ, EE, HH, KK, JJ, FF, EE, CC, GG, EE, AA, DD, JJ, BB, KK, HH, HH, EE, FF, JJ, DD, FF, DD, KK, GG, KK, EE, FF, HH, KK, JJ, GG, HH, KK, JJ, JJ, FF, FF, EE, JJ, DD, GG, AA, KK, BB, GG, KK, DD, SC, EE, DD, JJ, KK, HH, HH, KK, KK, GG, HH, FF, BB, KK, AA, EE, DD, FF, SC, JJ, DD, CC, CC, JJ, KK, BB, BB, HH, CC, JJ, FF, HH, CC, KK, HH, FF, KK, AA, JJ, KK, BB, BB, JJ, JJ, FF, CC, EE, EE, KK, GG, GG, EE, FF, GG, HH, KK, JJ, BB, HH, GG, DD, DD, BB, GG, KK, HH, FF, EE, HH, JJ, KK, GG, GG, DD, HH, GG, AA, JJ, HH, KK, JJ, JJ, HH, KK, FF, HH, DD, JJ, EE, BB, KK, EE, JJ, EE, JJ, CC, JJ, KK, KK, HH, EE, AA, FF, FF, DD, EE, GG, HH, BB, DD, EE, FF, SC, JJ, JJ, EE, EE, GG, JJ, FF, HH, DD, JJ, JJ, GG, GG, GG, KK, CC, DD, HH, HH, DD, KK, CC, GG, JJ, HH, HH, FF, KK, KK, AA, DD, GG, JJ, FF, GG, GG, KK, BB, SC, EE, DD, JJ, KK, FF, HH, DD, DD, KK, KK, AA, FF, GG, CC, CC, DD, KK, CC, FF, EE, KK, DD, HH, GG, JJ, CC, CC, CC, KK, DD, EE, EE, FF, GG, KK, JJ, KK, AA, GG, GG, CC, FF, DD, KK, HH, FF, EE, GG, CC, CC, JJ, EE, DD, JJ, KK, FF, FF, CC, FF, KK, FF, HH, CC, KK, FF, HH, JJ, BB, GG, EE, EE, JJ, KK, FF, GG, JJ, DD, KK, BB, FF, FF, JJ, EE, HH, KK, JJ, BB, GG, DD, DD, KK, HH, JJ, JJ, KK, KK, DD, FF, HH, JJ, HH, HH, KK, KK, JJ, JJ, AA, HH, HH, FF, GG, CC, CC, JJ, EE, HH, GG, KK, EE, AA, FF, HH, HH, GG, GG, CC, HH, GG, BB, JJ, GG, HH, EE, JJ, HH, HH, FF, FF, GG, JJ, KK, EE, HH, GG, AA, FF, BB, GG, JJ, JJ, JJ, JJ, KK, SC, EE, GG, GG, JJ, JJ, FF, FF, AA, KK, EE, HH, HH, GG, GG, FF, KK, KK, EE, EE, BB, BB, HH, DD, FF, EE, JJ, JJ, GG, HH, EE, JJ, AA, DD, DD, BB, GG, KK, KK, JJ, EE, SC, HH, JJ, EE, FF, EE, EE, JJ, JJ, KK, GG, KK, FF, FF, DD, EE, KK, GG, GG, GG, EE, FF, JJ, HH, KK, BB, EE, HH, SC, JJ, JJ, DD, KK, JJ, KK, FF, FF, JJ, JJ, EE, BB, BB, JJ, EE, DD, GG, HH, BB, DD, DD, SC, FF, EE, KK, KK, GG, GG, JJ, DD, EE,
        });

        fgReels.add(new String[]{
                JJ, BB, BB, KK, KK, HH, HH, CC, HH, JJ, HH, GG, GG, FF, EE, HH, FF, DD, GG, CC, CC, HH, KK, KK, FF, DD, CC, EE, KK, HH, KK, EE, JJ, FF, FF, JJ, KK, FF, GG, JJ, DD, GG, GG, JJ, KK, JJ, FF, GG, AA, JJ, KK, HH, HH, FF, FF, HH, KK, FF, FF, BB, SC, JJ, FF, EE, EE, HH, DD, DD, GG, BB, HH, KK, CC, GG, GG, DD, DD, JJ, CC, AA, KK, KK, EE, SC, HH, FF, KK, CC, WC, EE, JJ, HH, GG, FF, EE, KK, JJ, CC, CC, KK, HH, BB, FF, JJ, FF, GG, FF, HH, AA, JJ, GG, HH, KK, EE, EE, JJ, DD, CC, KK, JJ, KK, HH, JJ, KK, AA, FF, EE, KK, JJ, DD, EE, HH, EE, BB, KK, EE, KK, AA, DD, GG, JJ, EE, BB, GG, CC, DD, FF, KK, AA, EE, GG, FF, HH, AA, EE, GG, GG, HH, HH, EE, BB, BB, JJ, AA, SC, KK, KK, EE, GG, DD, HH, AA, KK, CC, JJ, HH, JJ, HH, GG, BB, JJ, AA, GG, HH, CC, CC, SC, HH, JJ, GG, DD, FF, FF, EE, JJ, HH, KK, CC, GG, CC, BB, KK, KK, JJ, GG, KK, HH, AA, EE, GG, CC, FF, FF, EE, JJ, HH, GG, GG, FF, FF, JJ, AA, HH, JJ, KK, HH, EE, HH, KK, CC, HH, GG, FF, JJ, GG, GG, FF, AA, KK, BB, FF, HH, EE, EE, GG, CC, KK, JJ, FF, EE, KK, HH, HH, GG, GG, EE, JJ, AA, DD, DD, FF, KK, GG, FF, KK, HH, BB, KK, GG, DD, GG, KK, AA, JJ, BB, JJ, HH, CC, HH, HH, EE, JJ, BB, HH, HH, FF, JJ, EE, GG, FF, FF, KK, BB, JJ, EE, GG, JJ, CC, GG, GG, KK, DD, DD, EE, FF, KK, JJ, GG, KK, HH, FF, JJ, KK, SC, BB, KK, KK, EE, CC, CC, GG, EE, FF, HH, DD, DD, EE, DD, DD, KK, AA, EE, GG, DD, KK, GG, JJ, KK, EE, JJ, EE, KK, KK, EE, HH, JJ, FF, FF, GG, GG, HH, KK, CC, GG, AA, EE, FF, EE, FF, GG, DD, KK, FF, BB, HH, FF, CC, CC, KK, GG, JJ, SC, CC, EE, EE, GG, GG, FF, KK, KK, CC, JJ, KK, KK, EE, EE, JJ, DD, DD, FF, JJ, GG, HH, AA, JJ, BB, EE, CC, HH, AA, CC, DD, GG, BB, BB, HH, HH, DD, JJ, EE, FF, KK, EE, HH, HH, KK, DD, DD, GG, EE, FF, DD, DD, HH, GG, HH, KK, GG, JJ, AA, EE, HH, HH, FF, GG, JJ, EE, DD, JJ, FF, GG, JJ, CC, CC, EE, BB, FF, JJ, FF, GG, HH, GG, FF, EE, KK, KK, KK, HH, FF, FF, KK, DD, KK, CC, KK, HH, JJ, EE, KK, FF, HH, BB, KK, FF, EE, CC, FF, EE, HH, JJ, HH, FF, GG, EE, CC, CC, JJ, HH, BB, GG, FF, KK, KK, GG, JJ, AA, FF, FF, JJ, EE, EE, DD, HH, KK, JJ, GG, EE, HH, BB, KK, GG, BB, KK, GG, CC, HH, BB, KK, JJ, GG, KK, FF, FF, EE, JJ, AA, GG, KK, CC, FF,
        });

        fgReels.add(new String[]{
                AA, AA, HH, HH, CC, DD, JJ, JJ, EE, FF, JJ, FF, AA, DD, HH, FF, CC, EE, GG, HH, EE, KK, GG, CC, CC, JJ, HH, KK, EE, JJ, KK, KK, DD, EE, EE, BB, GG, CC, FF, DD, EE, KK, JJ, KK, CC, EE, CC, KK, HH, FF, AA, GG, DD, EE, EE, HH, GG, CC, CC, BB, KK, HH, DD, DD, JJ, AA, JJ, EE, HH, HH, CC, KK, JJ, JJ, KK, EE, EE, HH, BB, GG, GG, EE, CC, AA, JJ, CC, GG, EE, HH, EE, HH, BB, GG, CC, DD, GG, HH, HH, FF, AA, JJ, HH, KK, WC, KK, EE, CC, AA, KK, FF, JJ, EE, FF, FF, BB, GG, FF, JJ, AA, HH, BB, JJ, HH, GG, CC, CC, SC, EE, HH, KK, DD, JJ, CC, AA, GG, HH, KK, GG, GG, JJ, KK, EE, EE, GG, FF, CC, JJ, KK, HH, EE, KK, KK, AA, EE, EE, EE, FF, SC, BB, DD, DD, AA, GG, DD, EE, HH, GG, EE, KK, EE, JJ, CC, CC, KK, KK, JJ, BB, BB, KK, HH, GG, BB, KK, JJ, FF, FF, GG, JJ, HH, HH, DD, KK, BB, GG, HH, JJ, FF, FF, KK, JJ, AA, GG, KK, KK, BB, JJ, JJ, AA, DD, SC, FF, GG, JJ, JJ, HH, BB, BB, JJ, CC, CC, GG, DD, DD, AA, CC, FF, KK, JJ, EE, CC, JJ, KK, AA, FF, GG, GG, FF, KK, GG, CC, CC, JJ, GG, DD, BB, FF, GG, AA, CC, HH, KK, BB, BB, FF, AA, FF, HH, HH, EE, BB, CC, KK, KK, JJ, GG, JJ, AA, GG, AA, FF, FF, BB, HH, HH, EE, EE, JJ, HH, GG, HH, DD, KK, KK, BB, AA, SC, KK, DD, JJ, DD, DD, GG, FF, AA, BB, KK, HH, BB, BB, FF, GG, EE, EE, HH, HH, DD, BB, BB, HH, JJ, FF, DD, DD, HH, HH, AA, BB, EE, FF, FF, KK, DD, CC, CC, DD, DD, GG, EE, EE, GG, HH, DD, KK, EE, GG, AA, KK, BB, KK, DD, DD, EE, EE, KK, DD, GG, CC, CC, HH, DD, JJ, GG, GG, HH, HH, DD, DD, CC, CC, KK, HH, EE, BB, CC, AA, KK, FF, FF, GG, BB, KK, FF, FF, DD, BB, AA, GG, KK, HH, JJ, GG, FF, GG, GG, KK, DD, JJ, FF, EE, EE, HH, KK, JJ, KK, AA, JJ, DD, KK, JJ, EE, HH, BB, BB, GG, GG, HH, FF, KK, CC, AA, DD, EE, EE, DD, JJ, GG, HH, HH, KK, JJ, EE, DD, GG, JJ, FF, FF, KK, KK, HH, AA, JJ, DD, EE, CC, AA, AA, DD, HH, CC, CC, KK, HH, EE, JJ, DD, SC, HH, HH, BB, EE, FF, DD, FF, DD, GG, GG, GG, BB, JJ, CC, GG, SC, AA, AA, BB, JJ, HH, KK, AA, CC, BB, KK, GG, BB, JJ, CC, DD, DD, JJ, HH, AA, CC, KK, DD, DD, FF, HH, JJ, JJ, KK, CC, DD, EE, GG, HH, BB, CC, BB, FF, FF, GG, GG, JJ, KK, KK, DD, DD, JJ, GG, HH, BB, BB, GG, HH, FF, JJ, CC, GG, EE, JJ, EE, EE, HH, CC, FF, HH, FF, JJ, FF, CC,});

        fgReels.add(new String[]{
                AA, HH, HH, KK, GG, GG, AA, KK, HH, HH, JJ, KK, KK, CC, KK, GG, DD, HH, GG, EE, JJ, JJ, AA, GG, DD, GG, EE, HH, HH, KK, JJ, KK, KK, HH, FF, KK, KK, JJ, CC, EE, HH, HH, GG, GG, BB, KK, DD, KK, EE, EE, GG, DD, HH, DD, HH, EE, EE, DD, DD, KK, JJ, JJ, DD, KK, GG, KK, EE, HH, KK, KK, GG, JJ, KK, GG, HH, HH, KK, EE, FF, BB, JJ, CC, DD, EE, GG, DD, HH, JJ, CC, BB, KK, GG, FF, DD, CC, JJ, KK, KK, KK, FF, GG, EE, JJ, HH, FF, FF, DD, KK, HH, EE, JJ, JJ, CC, CC, AA, JJ, KK, GG, JJ, HH, BB, FF, GG, JJ, DD, DD, CC, JJ, EE, FF, CC, WC, DD, BB, JJ, KK, HH, BB, BB, KK, EE, CC, FF, JJ, FF, HH, GG, JJ, EE, KK, KK, FF, GG, EE, CC, EE, JJ, FF, FF, CC, KK, AA, EE, EE, BB, JJ, JJ, CC, FF, HH, GG, DD, DD, AA, HH, HH, KK, GG, FF, EE, JJ, BB, FF, KK, KK, KK, JJ, BB, BB, FF, CC, DD, DD, HH, EE, GG, CC, FF, FF, KK, GG, JJ, BB, DD, FF, JJ, GG, KK, CC, FF, KK, JJ, DD, BB, EE, FF, JJ, FF, DD, AA, JJ, EE, CC, FF, DD, JJ, CC, CC, JJ, DD, GG, FF, KK, KK, JJ, JJ, JJ, HH, HH, EE, DD, GG, DD, CC, FF, KK, JJ, EE, DD, JJ, JJ, KK, KK, WC, FF, JJ, EE, EE, HH, FF, DD, FF, FF, CC, JJ, GG, AA, KK, KK, FF, CC, BB, HH, HH, EE, EE, HH, KK, JJ, EE, CC, FF, JJ, KK, GG, EE, JJ, CC, GG, DD, DD, JJ, EE, EE, CC, JJ, KK, KK, FF, GG, CC, HH, HH, BB, EE, CC, FF, HH, HH, GG, DD, HH, HH, KK, KK, GG, JJ, CC, KK, JJ, FF, CC, EE, EE, HH, HH, HH, CC, DD, HH, CC, CC, FF, HH, JJ, KK, KK, FF, HH, CC, SC, FF, JJ, BB, GG, DD, DD, DD, EE, JJ, KK, EE, KK, FF, EE, CC, CC, JJ, DD, FF, JJ, HH, BB, GG, EE, JJ, KK, KK, JJ, FF, KK, EE, KK, CC, EE, FF, FF, BB, DD, EE, DD, JJ, JJ, HH, EE, CC, GG, HH, HH, DD, EE, FF, KK, AA, KK, FF, CC, FF, GG, GG, FF, SC, HH, JJ, JJ, EE, GG, FF, DD, GG, CC, CC, HH, AA, HH, JJ, EE, CC, FF, BB, BB, AA, GG, GG, BB, BB, JJ, JJ, EE, GG, AA, CC, GG, DD, FF, JJ, CC, EE, DD, DD, FF, EE, BB, GG, CC, JJ, JJ, HH, HH, JJ, EE, EE, KK, CC, JJ, KK, FF, GG, GG, DD, DD, EE, KK, HH, HH, GG, EE, GG, JJ, DD, GG, FF, JJ, JJ, KK, GG, FF, CC, CC, FF, GG, DD, FF, KK, JJ, KK, EE, KK, FF, GG, DD, CC, AA, FF, HH, BB, DD, KK, KK, KK, JJ, JJ, GG, GG, HH, CC, CC, KK, JJ, EE, BB, BB, EE, EE, JJ, GG, FF, HH, HH, KK, BB, JJ, GG, EE, EE, KK, FF, JJ, KK, DD,
        });

        fgReels.add(new String[]{
                GG, CC, CC, BB, FF, EE, BB, CC, JJ, DD, DD, BB, BB, KK, AA, KK, FF, DD, BB, GG, FF, FF, EE, HH, FF, BB, GG, JJ, EE, KK, JJ, AA, AA, DD, DD, KK, BB, FF, EE, GG, DD, FF, KK, AA, AA, BB, FF, JJ, BB, SC, KK, HH, EE, BB, DD, GG, HH, HH, AA, BB, HH, GG, FF, HH, JJ, DD, CC, DD, EE, DD, AA, HH, JJ, KK, JJ, DD, GG, GG, AA, DD, AA, BB, FF, DD, BB, FF, HH, HH, BB, BB, AA, EE, JJ, KK, EE, GG, CC, CC, FF, EE, KK, GG, HH, EE, BB, BB, FF, KK, JJ, CC, HH, DD, DD, FF, JJ, HH, CC, SC, DD, GG, EE, AA, GG, HH, FF, FF, EE, HH, GG, DD, EE, AA, FF, BB, HH, KK, DD, KK, AA, JJ, GG, EE, BB, GG, CC, DD, EE, KK, GG, DD, JJ, JJ, KK, GG, EE, AA, DD, GG, BB, EE, BB, BB, HH, EE, EE, SC, DD, JJ, FF, DD, EE, FF, EE, GG, GG, JJ, BB, BB, JJ, GG, HH, AA, CC, KK, CC, CC, HH, DD, GG, JJ, BB, FF, JJ, KK, GG, BB, DD, CC, JJ, EE, BB, HH, SC, CC, CC, HH, KK, KK, GG, JJ, CC, HH, FF, HH, CC, DD, BB, BB, FF, FF, HH, EE, EE, JJ, KK, JJ, AA, CC, HH, FF, BB, JJ, CC, CC, EE, DD, EE, HH, DD, GG, FF, KK, KK, EE, JJ, CC, SC, KK, CC, JJ, FF, HH, DD, CC, JJ, FF, AA, AA, DD, KK, KK, JJ, JJ, EE, BB, KK, BB, HH, KK, JJ, EE, DD, CC, CC, GG, GG, KK, CC, FF, GG, AA, FF, KK, KK, FF, HH, HH, EE, KK, FF, BB, CC, GG, GG, JJ, JJ, GG, CC, BB, KK, CC, DD, DD, JJ, GG, DD, BB, BB, GG, HH, EE, GG, GG, KK, KK, SC, DD, DD, CC, GG, JJ, JJ, FF, BB, DD, DD, CC, AA, FF, CC, JJ, HH, DD, DD, HH, GG, JJ, AA, BB, GG, EE, JJ, HH, BB, KK, FF, FF, AA, EE, CC, KK, HH, CC, BB, GG, EE, FF, HH, FF, JJ, GG, JJ, BB, BB, CC, CC, CC, WC, DD, BB, KK, GG, CC, EE, EE, BB, BB, FF, KK, FF, HH, HH, KK, CC, JJ, EE, KK, SC, DD, DD, GG, JJ, DD, DD, BB, BB, EE, BB, KK, EE, FF, DD, GG, CC, CC, GG, BB, FF, FF, HH, AA, EE, GG, CC, KK, HH, GG, EE, BB, KK, HH, EE, DD, CC, DD, AA, HH, JJ, GG, BB, KK, KK, JJ, JJ, KK, CC, EE, GG, FF, FF, JJ, GG, CC, BB, EE, AA, GG, CC, EE, CC, KK, JJ, CC, EE, DD, HH, HH, CC, JJ, FF, FF, CC, CC, CC, BB, KK, AA, GG, HH, FF, KK, JJ, HH, DD, DD, EE, BB, EE, BB, GG, DD, JJ, JJ, EE, CC, BB, GG, JJ, DD, JJ, FF, HH, HH, DD, GG, AA, FF, FF, EE, CC, HH, HH, GG, HH, CC, EE, EE, BB, HH, BB, KK, AA, HH, GG, CC, DD, AA, DD, EE, CC, DD, FF, FF, AA, GG, GG, JJ, HH, CC, FF,});

        fgReels.add(new String[]{
                FF, BB, FF, AA, KK, BB, HH, EE, FF, FF, BB, JJ, JJ, CC, AA, AA, EE, DD, KK, AA, HH, GG, HH, GG, EE, JJ, AA, KK, CC, JJ, HH, BB, BB, DD, DD, FF, HH, EE, CC, JJ, DD, KK, AA, EE, BB, CC, GG, KK, KK, HH, JJ, HH, CC, GG, DD, AA, HH, BB, FF, AA, HH, DD, KK, CC, FF, FF, DD, DD, KK, EE, DD, BB, EE, JJ, BB, DD, KK, JJ, AA, BB, HH, CC, AA, EE, EE, GG, HH, GG, CC, AA, FF, SC, JJ, GG, CC, HH, GG, CC, KK, KK, JJ, CC, HH, CC, BB, BB, EE, JJ, EE, AA, HH, JJ, CC, CC, FF, HH, BB, JJ, KK, KK, BB, EE, AA, BB, KK, GG, CC, GG, FF, KK, KK, AA, BB, EE, HH, CC, BB, KK, BB, GG, SC, CC, KK, FF, EE, DD, JJ, HH, BB, EE, KK, CC, JJ, GG, CC, SC, DD, FF, KK, CC, GG, AA, HH, FF, BB, BB, AA, GG, CC, DD, JJ, AA, HH, GG, GG, FF, FF, BB, EE, HH, DD, FF, FF, JJ, EE, EE, GG, DD, BB, KK, CC, GG, SC, KK, FF, AA, CC, EE, AA, EE, EE, HH, DD, BB, FF, FF, AA, DD, CC, EE, EE, DD, GG, BB, FF, DD, KK, GG, GG, FF, EE, DD, CC, KK, GG, HH, KK, CC, BB, GG, JJ, BB, KK, EE, AA, BB, EE, HH, EE, FF, GG, CC, HH, CC, FF, EE, HH, FF, GG, FF, EE, FF, BB, EE, FF, HH, AA, FF, DD, JJ, GG, BB, BB, CC, GG, GG, AA, AA, JJ, KK, CC, BB, FF, GG, BB, DD, JJ, EE, DD, GG, GG, DD, CC, BB, EE, FF, HH, CC, WC, GG, CC, HH, AA, FF, CC, BB, JJ, EE, SC, JJ, HH, DD, DD, JJ, AA, CC, KK, HH, FF, JJ, GG, CC, DD, BB, FF, JJ, HH, EE, EE, AA, FF, CC, GG, JJ, DD, DD, KK, DD, KK, FF, BB, CC, AA, DD, HH, JJ, KK, KK, FF, FF, CC, KK, KK, BB, GG, BB, GG, GG, FF, CC, AA, DD, FF, KK, EE, CC, CC, BB, SC, KK, FF, DD, BB, JJ, DD, GG, EE, EE, HH, KK, GG, DD, EE, CC, HH, KK, BB, GG, GG, KK, BB, KK, BB, HH, AA, CC, JJ, DD, DD, GG, BB, FF, DD, EE, KK, AA, CC, EE, JJ, JJ, EE, DD, KK, DD, HH, EE, JJ, KK, DD, HH, CC, CC, DD, FF, DD, HH, AA, CC, KK, JJ, HH, SC, DD, JJ, BB, BB, HH, BB, DD, DD, EE, CC, CC, GG, KK, DD, CC, AA, GG, GG, KK, DD, EE, JJ, CC, EE, FF, DD, AA, HH, JJ, DD, EE, CC, BB, DD, GG, AA, KK, EE, FF, FF, EE, EE, WC, JJ, DD, EE, HH, GG, JJ, KK, SC, BB, AA, EE, JJ, CC, CC, FF, AA, GG, KK, CC, JJ, EE, AA, JJ, JJ, KK, GG, CC, FF, BB, AA, BB, GG, KK, BB, DD, FF, BB, JJ, HH, FF, CC, CC, JJ, EE, AA, BB, BB, DD, FF, HH, JJ, KK, HH, GG, EE, BB, SC, GG, FF, KK, GG, GG, AA, EE, BB,});

        List<String[]> fgTopReel = new ArrayList<>(5);
        fgTopReel.add(new String[]{
                KK, KK, FF, BB, CC, AA, DD, JJ, FF, BB, HH, EE, HH, KK, CC, JJ, DD, HH, KK, JJ, KK, CC, CC, KK, DD, DD, JJ, JJ, KK, JJ, DD, CC, JJ, JJ, CC, BB, KK, EE, JJ, BB, KK, KK, FF, KK, HH, EE, DD, GG, BB, CC, KK, FF, CC, DD, KK, JJ, EE, FF, DD, JJ, KK, DD, FF, GG, CC, AA, CC, JJ, KK, BB, JJ, DD, BB, HH, DD, CC, AA, KK, HH, HH, CC, JJ, KK, GG, EE, JJ, JJ, DD, DD, KK, GG, HH, EE, BB, JJ, DD, DD, KK, HH, KK, CC, WC, KK, EE, EE, DD, JJ, KK, DD, DD, GG, BB, KK, AA, JJ, KK, CC, JJ, FF, EE, DD, KK, JJ, FF, KK, HH, HH, DD, HH, JJ, GG, EE, CC, JJ, BB, FF, JJ, GG, DD, GG, HH, JJ, GG, JJ, JJ, FF, EE, KK, BB, EE, JJ, JJ, KK, FF, EE, EE, JJ, CC, JJ, DD, JJ, BB, KK, KK, HH, JJ, FF, CC, AA, GG, EE, JJ, KK, JJ, JJ, DD, GG, DD, CC, JJ, EE, KK, GG, FF, FF, HH, GG, FF, AA, FF, EE, KK, BB, KK, GG, FF, BB, BB, EE, AA, HH, EE, FF, HH, KK, EE, EE, FF, BB, DD, AA, CC, JJ, KK, GG, FF, CC, GG, EE, HH, KK, FF, DD, DD, JJ, EE, CC, KK, EE, GG, HH, FF, DD, KK, EE, HH, FF, HH, KK, EE, GG, KK, FF, BB, HH, BB, CC, HH, HH, EE, GG, HH, JJ, HH, CC, JJ, KK, CC, AA, EE, JJ, JJ, EE, KK, FF, DD, AA, GG, HH, FF, JJ, AA, KK, EE, KK, GG, BB, BB, GG, CC, HH, BB, AA, GG, KK, JJ, FF, AA, EE, BB, KK, HH, CC, FF, CC, KK, DD, KK, FF, CC, KK, DD, GG, KK, BB, AA, AA, HH, EE, EE, HH, JJ, KK, FF, BB, AA, CC, BB, KK, HH, FF, DD, GG, AA, FF, CC, FF, HH, FF, KK, FF, DD, CC, HH, HH, EE, GG, CC, JJ, EE, FF, JJ, BB, GG, FF, GG, EE, KK, EE, GG, DD, DD, HH, KK, CC, FF, JJ, EE, BB, KK, HH, BB, GG, JJ, AA, KK, CC, JJ, HH, GG, KK, HH, FF, HH, JJ, HH, EE, GG, KK, AA, JJ, EE, BB, BB, EE, GG, CC, CC, EE, KK, HH, GG, CC, AA, GG, FF, HH, GG, HH, JJ, CC, KK, HH, KK, GG, GG, HH, EE, JJ, EE, CC, GG, AA, GG, JJ, KK, BB, JJ, GG, BB, FF, CC, GG, KK, JJ, JJ, EE, KK, GG, DD, CC, HH, EE, HH, JJ, HH, KK, DD, EE, HH, EE, DD, HH, FF, JJ, GG, HH, KK, JJ, GG, HH, DD, EE, JJ, FF, HH, BB, KK, EE, JJ, CC, KK, DD, BB, GG, GG, HH, GG, EE, HH, CC, JJ, BB, FF, GG, FF, JJ, HH, KK, GG, EE, DD, FF, JJ, DD, KK, EE, GG, HH, EE, FF, JJ, HH, FF, BB, KK, HH, JJ, KK, KK, JJ, HH, FF, EE, GG, FF, KK, CC, KK, FF, DD, JJ, KK, FF, HH, HH, JJ, AA, GG, BB, GG, EE, JJ, CC, KK, HH, JJ, DD, AA, EE,
        });
        gameReels.add(bgReels);
        gameReels.add(topReel);
        gameReels.add(fgReels);
        gameReels.add(fgTopReel);

        return gameReels;
    }

    public WeightedPrizeData createReel1And2Sym() {
        return new WeightedPrizeData()
                .addWeightedConfig(new WeightedPrizeConfig(27, 2))
                .addWeightedConfig(new WeightedPrizeConfig(27, 3))
                .addWeightedConfig(new WeightedPrizeConfig(28, 4))
                .addWeightedConfig(new WeightedPrizeConfig(11, 5))
                .addWeightedConfig(new WeightedPrizeConfig(4, 6))
                .addWeightedConfig(new WeightedPrizeConfig(3, 7));
    }

    public WeightedPrizeData createRee3And4Sym() {
        return new WeightedPrizeData()
                .addWeightedConfig(new WeightedPrizeConfig(26, 2))
                .addWeightedConfig(new WeightedPrizeConfig(24, 3))
                .addWeightedConfig(new WeightedPrizeConfig(19, 4))
                .addWeightedConfig(new WeightedPrizeConfig(15, 5))
                .addWeightedConfig(new WeightedPrizeConfig(10, 6))
                .addWeightedConfig(new WeightedPrizeConfig(6, 7));
    }

    public WeightedPrizeData createRee5And6Sym() {
        return new WeightedPrizeData()
                .addWeightedConfig(new WeightedPrizeConfig(28, 2))
                .addWeightedConfig(new WeightedPrizeConfig(24, 3))
                .addWeightedConfig(new WeightedPrizeConfig(19, 4))
                .addWeightedConfig(new WeightedPrizeConfig(13, 5))
                .addWeightedConfig(new WeightedPrizeConfig(10, 6))
                .addWeightedConfig(new WeightedPrizeConfig(6, 7));
    }

    public WeightedPrizeData createReel1Fg() {
        return new WeightedPrizeData()
                .addWeightedConfig(new WeightedPrizeConfig(35, 2))
                .addWeightedConfig(new WeightedPrizeConfig(27, 3))
                .addWeightedConfig(new WeightedPrizeConfig(15, 4))
                .addWeightedConfig(new WeightedPrizeConfig(13, 5))
                .addWeightedConfig(new WeightedPrizeConfig(7, 6))
                .addWeightedConfig(new WeightedPrizeConfig(3, 7));
    }

    public WeightedPrizeData createReelSym2Fg() {
        return new WeightedPrizeData()
                .addWeightedConfig(new WeightedPrizeConfig(35, 2))
                .addWeightedConfig(new WeightedPrizeConfig(28, 3))
                .addWeightedConfig(new WeightedPrizeConfig(14, 4))
                .addWeightedConfig(new WeightedPrizeConfig(12, 5))
                .addWeightedConfig(new WeightedPrizeConfig(7, 6))
                .addWeightedConfig(new WeightedPrizeConfig(4, 7));
    }

    public WeightedPrizeData createReelSym3Fg() {
        return new WeightedPrizeData()
                .addWeightedConfig(new WeightedPrizeConfig(35, 2))
                .addWeightedConfig(new WeightedPrizeConfig(29, 3))
                .addWeightedConfig(new WeightedPrizeConfig(15, 4))
                .addWeightedConfig(new WeightedPrizeConfig(10, 5))
                .addWeightedConfig(new WeightedPrizeConfig(8, 6))
                .addWeightedConfig(new WeightedPrizeConfig(3, 7));
    }

    public WeightedPrizeData createReelSym4Fg() {
        return new WeightedPrizeData()
                .addWeightedConfig(new WeightedPrizeConfig(35, 2))
                .addWeightedConfig(new WeightedPrizeConfig(27, 3))
                .addWeightedConfig(new WeightedPrizeConfig(17, 4))
                .addWeightedConfig(new WeightedPrizeConfig(11, 5))
                .addWeightedConfig(new WeightedPrizeConfig(6, 6))
                .addWeightedConfig(new WeightedPrizeConfig(4, 7));
    }

    public WeightedPrizeData createReelSym5Fg() {
        return new WeightedPrizeData()
                .addWeightedConfig(new WeightedPrizeConfig(31, 2))
                .addWeightedConfig(new WeightedPrizeConfig(25, 3))
                .addWeightedConfig(new WeightedPrizeConfig(20, 4))
                .addWeightedConfig(new WeightedPrizeConfig(13, 5))
                .addWeightedConfig(new WeightedPrizeConfig(7, 6))
                .addWeightedConfig(new WeightedPrizeConfig(4, 7));
    }

    public WeightedPrizeData createReelSym6Fg() {
        return new WeightedPrizeData()
                .addWeightedConfig(new WeightedPrizeConfig(27, 2))
                .addWeightedConfig(new WeightedPrizeConfig(25, 3))
                .addWeightedConfig(new WeightedPrizeConfig(19, 4))
                .addWeightedConfig(new WeightedPrizeConfig(14, 5))
                .addWeightedConfig(new WeightedPrizeConfig(9, 6))
                .addWeightedConfig(new WeightedPrizeConfig(6, 7));
    }

    public WeightedPrizeData getSymHeight() {
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
}
