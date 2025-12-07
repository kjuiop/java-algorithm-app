package com.gig.programmers;

import java.util.Arrays;

/**
 * @author : JAKE
 * @date : 25. 12. 7.
 */
public class Q201391 {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(solution(
                new int[][]{
                        {-23, 17}, {4, -11}, {22, 6}, {-1, -5}
                })));

        System.out.println(Arrays.deepToString(solution(
                new int[][]{
                        {-4, 7}, {-5, -22}, {-4, 12}, {-5, -22}, {-8, 13}, {-8, 1}
                })));
    }

    // coordinates 에 주어진 점들을 제 1,2,3,4 사분면 순
    // 같은 사분면의 점들은 x 좌표의 절대값이 작은 순
    // x 좌표의 절대값이 같다면 y 좌표의 절대값이 작은 순
    public static int[][] solution(int[][] coordinates) {

        Arrays.sort(coordinates, (p1, p2) -> {

            // 4사분면 순으로 정렬
            int a = getQuadrant(p1[0], p1[1]);
            int b = getQuadrant(p2[0], p2[1]);

            if (a != b) {
                return a - b;
            }

            // 절대값 구하는 함수
            int x1 = Math.abs(p1[0]), y1 = Math.abs(p1[1]);
            int x2 = Math.abs(p2[0]), y2 = Math.abs(p2[1]);

            if (x1 != x2) {
                return x1 - x2;
            }

            return y1 - y2;
        });

        return coordinates;
    }

    public static int getQuadrant(int x, int y) {
        if (x > 0 && y > 0) {
            return 1;
        }

        if (x < 0 && y > 0) {
            return 2;
        }

        if (x < 0 && y < 0) {
            return 3;
        }

        return 4;
    }
}
