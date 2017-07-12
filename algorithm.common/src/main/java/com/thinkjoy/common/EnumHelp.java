package com.thinkjoy.common;

import java.util.Arrays;
import java.util.List;

/**
 * 通用枚举类
 * Created by douzy on 17/2/7.
 */
public class EnumHelp {

    /**
     * 通用批次枚举
     * @return
     */
    public static List<String> getBatch() {
        String[] arr = {"1", "11", "12", "2", "21", "22", "23", "4", "41", "42", "8", "81", "82", "83", "84"};
        List<String> list = Arrays.asList(arr);
        System.out.print(list.size());
        return list;
    }

    /**
     * 通用文理科枚举
     * @return
     */
    public static List<String> getMajorType() {
        String[] arr = {"1", "2"};
        List<String> list = Arrays.asList(arr);
        return list;
    }
}
