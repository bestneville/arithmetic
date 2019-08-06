package com.neville.moduletest.myapplication.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by niewei on 2019/3/19.
 */

public class MyUtils {
    public static void logIntArr(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + ",");
        }
    }

    public static <T> List newList(T... data) {
        List<T> list = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            list.add(data[i]);
        }
        return list;
    }

    public static void log(List list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + ",");
        }
        System.out.println();
    }

}
