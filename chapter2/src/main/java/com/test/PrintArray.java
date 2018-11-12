package com.test;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.List;
import java.util.function.Predicate;

public class PrintArray {

    public static void eval(List<Integer> list, Predicate<Integer> predicat) {
        for (Integer n : list) {
            if (predicat.test(n)) {
                System.out.print(n + " ");
            }
        }
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        String encoding = Base64.getEncoder().encodeToString("So".getBytes());
        System.out.println(encoding);

        byte[] decode = Base64.getDecoder().decode(encoding);
        System.out.println(new String(decode, "UTF-8"));
    }
}
