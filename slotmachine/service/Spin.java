package slotmachine.service;

import slotmachine.dto.WinData;
import slotmachine.test.WinBand;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Data transfer class that contains Spin data.
 */
public class Spin {

    public BigDecimal totalWin;
    public boolean isFsTriggered;
    public int scatterCount;
    List<List<WinData>> cascadeList;

    List<int[]> symSizeGrid = new ArrayList<>();
    List<String[]> silverSymMarker = new ArrayList<>();

    private List<WinBand> winSummaryBands = new ArrayList<>();

    public List<String[]> getSilverSymMarker() {
        return silverSymMarker;
    }

    public void setSilverSymMarker(List<String[]> silverSymMarker) {
        this.silverSymMarker = silverSymMarker;
    }

    public List<int[]> getSymSizeGrid() {
        return symSizeGrid;
    }

    public void setSymSizeGrid(List<int[]> symSizeGrid) {
        this.symSizeGrid = symSizeGrid;
    }

    public int getScatterCount() {
        return scatterCount;
    }

    public void setScatterCount(int scatterCount) {
        this.scatterCount = scatterCount;
    }

    int fsAwarded;

    public int[] getSymSizes() {
        return symSizes;
    }

    public void setSymSizes(int[] symSizes) {
        this.symSizes = symSizes;
    }

    int[] symSizes;


    public BigDecimal getTotalWin() {
        return totalWin;
    }

    public List<List<WinData>> getCascadeList() {
        return cascadeList;
    }

    public void setCascadeList(List<List<WinData>> cascadeList) {
        this.cascadeList = cascadeList;
    }

    public void setTotalWin(BigDecimal totalWin) {
        this.totalWin = totalWin;
    }

    public boolean isFsTriggered() {
        return isFsTriggered;
    }

    public void setFsTriggered(boolean fsTriggered) {
        isFsTriggered = fsTriggered;
    }

    public int getFsAwarded() {
        return fsAwarded;
    }

    public void setFsAwarded(int fsAwarded) {
        this.fsAwarded = fsAwarded;
    }

    public List<WinBand> getWinSummaryBands() {
        return winSummaryBands;
    }

    public void setWinSummaryBands(List<WinBand> winSummaryBands) {
        this.winSummaryBands = winSummaryBands;
    }
}

