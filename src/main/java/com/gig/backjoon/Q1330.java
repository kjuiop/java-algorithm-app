package com.gig.backjoon;

import java.security.InvalidParameterException;
import java.util.Scanner;

/**
 * @author : JAKE
 * @date : 2022/09/07
 */
public class Q1330 {

    /**
     * https://www.acmicpc.net/problem/1330
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strArray = str.split(" ");

        if (strArray.length != 2) {
            throw new InvalidParameterException("ex) 2 3");
        }

        int a = Integer.parseInt(strArray[0]);
        int b = Integer.parseInt(strArray[1]);

        if (a < b) {
            System.out.println("<");
        } else if (a > b) {
            System.out.println(">");
        } else {
            System.out.println("==");
        }
    }

}
