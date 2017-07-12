package com.thinkjoy.report.view;

import java.io.Serializable;

/**
 * Created by douzy on 17/3/17.
 */
public class StdView implements Serializable {
    private String searchKey;
    private int sumHigh;
    private int sumLow;
    private int sumAvgR;
    private int stdHigh;
    private int stdLow;
    private int stdAvgR;

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    public int getSumHigh() {
        return sumHigh;
    }

    public void setSumHigh(int sumHigh) {
        this.sumHigh = sumHigh;
    }

    public int getSumLow() {
        return sumLow;
    }

    public void setSumLow(int sumLow) {
        this.sumLow = sumLow;
    }

    public int getSumAvgR() {
        return sumAvgR;
    }

    public void setSumAvgR(int sumAvgR) {
        this.sumAvgR = sumAvgR;
    }

    public int getStdHigh() {
        return stdHigh;
    }

    public void setStdHigh(int stdHigh) {
        this.stdHigh = stdHigh;
    }

    public int getStdLow() {
        return stdLow;
    }

    public void setStdLow(int stdLow) {
        this.stdLow = stdLow;
    }

    public int getStdAvgR() {
        return stdAvgR;
    }

    public void setStdAvgR(int stdAvgR) {
        this.stdAvgR = stdAvgR;
    }
}
