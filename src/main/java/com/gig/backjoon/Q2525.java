package com.gig.backjoon;

import java.security.InvalidParameterException;
import java.util.Scanner;

/**
 * @author : JAKE
 * @date : 2022/09/17
 */
public class Q2525 {

    static int h;
    static int m;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strArray = str.split(" ");

        if (strArray.length != 2) {
            throw new InvalidParameterException("ex) 2 3");
        }

        h = Integer.parseInt(strArray[0]);
        m = Integer.parseInt(strArray[1]);
        int needTime = Integer.parseInt(sc.nextLine());

        m += needTime;

        over60Minutes();

        over24Hour();

        System.out.printf("%d %d\n", h, m);
    }

    private static void over60Minutes() {
        if (m < 60) {
            return;
        }

        m -= 60;
        h += 1;

        if (m >= 60) {
            over60Minutes();
        }
    }

    private static void over24Hour() {
        if (h < 24) {
            return;
        }

        h -= 24;

        if (h >= 24) {
            over24Hour();
        }
    }
}
