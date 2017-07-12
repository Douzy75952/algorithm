package com.thinkjoy.report.entity;

import java.io.Serializable;

/**
 * Created by douzy on 17/3/15.
 */
public class ZgkUniversityAvgStd implements Serializable {
    private  Integer id;
    private Integer universityId;
    private Integer enrollArea;
    private Integer majorType;
    private  Integer yearCount;
    private Integer avgHighValue;
    private  Integer avgLowValue;
    private Integer avgAvgValue;
    private Integer stdHighDiff;
    private Integer stdLowDiff;
    private Integer stdAvgDiff;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUniversityId() {
        return universityId;
    }

    public void setUniversityId(Integer universityId) {
        this.universityId = universityId;
    }

    public Integer getEnrollArea() {
        return enrollArea;
    }

    public void setEnrollArea(Integer enrollArea) {
        this.enrollArea = enrollArea;
    }

    public Integer getMajorType() {
        return majorType;
    }

    public void setMajorType(Integer majorType) {
        this.majorType = majorType;
    }

    public Integer getYearCount() {
        return yearCount;
    }

    public void setYearCount(Integer yearCount) {
        this.yearCount = yearCount;
    }

    public Integer getAvgHighValue() {
        return avgHighValue;
    }

    public void setAvgHighValue(Integer avgHighValue) {
        this.avgHighValue = avgHighValue;
    }

    public Integer getAvgLowValue() {
        return avgLowValue;
    }

    public void setAvgLowValue(Integer avgLowValue) {
        this.avgLowValue = avgLowValue;
    }

    public Integer getAvgAvgValue() {
        return avgAvgValue;
    }

    public void setAvgAvgValue(Integer avgAvgValue) {
        this.avgAvgValue = avgAvgValue;
    }

    public Integer getStdHighDiff() {
        return stdHighDiff;
    }

    public void setStdHighDiff(Integer stdHighDiff) {
        this.stdHighDiff = stdHighDiff;
    }

    public Integer getStdLowDiff() {
        return stdLowDiff;
    }

    public void setStdLowDiff(Integer stdLowDiff) {
        this.stdLowDiff = stdLowDiff;
    }

    public Integer getStdAvgDiff() {
        return stdAvgDiff;
    }

    public void setStdAvgDiff(Integer stdAvgDiff) {
        this.stdAvgDiff = stdAvgDiff;
    }
}
