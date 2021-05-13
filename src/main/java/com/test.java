package com;

import java.util.StringJoiner;

public class test {
    public static void main(String[] args) {
        for (int i = 0; i < 10 ; i++) {
            StringJoiner sj = new StringJoiner("\t");
            sj.add("你好").add("1").add("号");
            System.out.println(sj);
        }

    }
}
