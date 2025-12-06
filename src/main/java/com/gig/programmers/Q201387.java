package com.gig.programmers;

import java.util.Arrays;

/**
 * @author : JAKE
 * @date : 25. 12. 6.
 */
public class Q201387 {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(solution(new int[][]{{1, 2}, {6, 9}, {14, 7}, {6, 10}})));
        System.out.println(Arrays.deepToString(solution(new int[][]{{10000000, 6000000}, {20, 12}, {5, 3}, {20, 12}})));
    }

    public static int[][] solution(int[][] rational) {

        Arrays.sort(rational, (l1, l2) -> {
            double a1 = l1[0], a2 = l1[1];
            double b1 = l2[0], b2 = l2[1];

            double a = a1 / a2;
            double b = b1 / b2;

            // 오름차순 정렬
            if (a - b > 0) {
                return 1;
            } else if (a - b < 0) {
                return -1;
            } else {
                // 분모 기준으로 정렬
                return (int)(a2 - b2);
            }
        });

        return rational;
    }

    // 0이상 10,000,000 이하의 두 정수의 비 a/b 로 표현된 유리수들이 담긴 이차원 정수 배열 rational
    // 이 수들을 증가하는 순서대로,
    // 수가 같다면 분모인 b가 증가하는 순서대로 정렬한 이차원 정수 배열을 return 하는 함수
    public static int[][] solution1(int[][] rational) {

        Arrays.sort(rational, (l1, l2) -> {
            // 소수점 값이 나올 수 있게 double 로 치환 후 계산한다
            double a1 = l1[0], a2 = l1[1];
            double b1 = l2[0], b2 = l2[1];

            double a = a1 / a2;
            double b = b1 / b2;

            if (a != b) {
                return Double.compare(a, b);
            }

            return l1[1] - l2[1];
        });

        return rational;
    }
}
