package com.thinkjoy.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by douzy on 17/2/7.
 */
public class CalculationHelp {

    public static void getAllPath(String[]... args) {
        int itemNumber = args.length;
        int runCount = (int) Math.pow(2, itemNumber);
        for (int index = 0; index < runCount; index++) {
            String location = String.format("%0" + itemNumber + "d", Integer.valueOf(Integer.toBinaryString(index)));
            int item = 0;
            for (String[] tmp : args) {
                System.out.printf("%s ", tmp[location.charAt(item++) - '0']);
            }
            System.out.println();
        }
    }

    public static List<String> getList(Object[][] a) {
        Random r = new Random();
        List<String> strs = new ArrayList<String>();
        int n = 1;
        for (int i = 0; i < a.length; i++) {
            n *= a[i].length;
        }
        for (int i = 0; i < n; i++) {
            String c = "";
            for (int j = 0; j < a.length; j++) {
                int index = r.nextInt(a[j].length);
                c += a[j][index]+"|";
            }
            if (strs.contains(c)) {
                n++;
            } else {
                strs.add(c);
            }
        }
        Collections.sort(strs);
        return strs;
    }

    /**
     * List<String>转String[]
     * @param arr
     * @return
     */
    public static Object[] converListArr(List<String> arr) {
        Object[] objs = (Object[])arr.toArray();
        return objs;
    }
    public static void main(String[] arg) {
//        String[][] a = {{"110000", "120000","130000","140000","210000","220000","230000","310000"},
//                {"1", "11", "12", "2", "21", "22", "23", "4", "41", "42", "8", "81", "82", "83", "84"},
//                {"2012", "2013","2014","2015","2016"},
//                {"1", "2"}};
//        List<String> strs = getList(a);
//        for (String s : strs) {
//            System.out.println(s);
//        }
//        System.out.println(strs.size());

        List<String> slist=EnumHelp.getBatch();

        String[] objs = (String[])slist.toArray();
//                String[] strs = new String[slist.size()];
//         Object ss[]=(Object[]).toArray();
                System.out.print(objs.length);
        for (String s : objs) {
            System.out.println(s.toString());
        }

    }
}
