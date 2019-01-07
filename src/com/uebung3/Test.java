package com.uebung3;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<String>();
        list1.add("1");
        list1.add("2");
        ArrayList<String> list2 = list1;
        list1.add("3");
        System.out.println(list1);
        System.out.println(list2);
    }
}
