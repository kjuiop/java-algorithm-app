package com.gig.backjoon;

import java.util.Scanner;

/**
 * @author : JAKE
 * @date : 2022/09/17
 */
public class Q2884 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int m = sc.nextInt();

        m -= 45;

        if (m < 0) {
            m += 60;
            h -= 1;
        }

        if (h < 0) {
            h += 24;
        }

        System.out.printf("%d %d", h, m);
    }
}
