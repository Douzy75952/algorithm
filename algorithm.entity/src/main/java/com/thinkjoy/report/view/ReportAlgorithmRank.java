package com.thinkjoy.report.view;

import java.io.Serializable;

/**
 * Created by douzy on 17/3/15.
 */
public class ReportAlgorithmRank implements Serializable {
    private int sumHigh=0;
    private int sumLow=0;
    private int sumAvgR=0;
    private int stdHigh=0;
    private int stdLow=0;
    private int stdAvgR=0;

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
