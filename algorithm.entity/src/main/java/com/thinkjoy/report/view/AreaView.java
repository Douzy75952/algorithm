package com.thinkjoy.report.view;

import java.io.Serializable;

/**
 * Created by douzy on 17/3/17.
 */
public class AreaView implements Serializable {
    private String area;
    private Integer count;

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
