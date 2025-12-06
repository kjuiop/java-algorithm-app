package com.gig.programmers;

import java.util.Arrays;

/**
 * @author : JAKE
 * @date : 25. 12. 6.
 */
public class Q201386 {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(solution(0, 0, new int[][]{{0, 2}, {-3, 4}, {-3, 0}})));
        System.out.println(Arrays.deepToString(solution(1, 3, new int[][]{{0, -1}, {2, 0}, {0, 6}, {1, 3}, {0, 0}})));
    }

    public static int[][] solution(int x0, int y0, int[][] points) {

        Arrays.sort(points, (p1, p2) -> {
            int distance1 = (x0 - p1[0]) * (x0 - p1[0]) + (y0 - p1[1]) * (y0 - p1[1]);
            int distance2 = (x0 - p2[0]) * (x0 - p2[0]) + (y0 - p2[1]) * (y0 - p2[1]);
            if (distance1 != distance2) {
                return distance1 - distance2;
            } else {
                if (p1[0] != p2[0]) {
                    return p1[0] - p2[0];
                } else {
                    return p1[1] - p2[1];
                }
            }
        });

        return points;
    }

    // 2차원 좌표계에서 점들을 특정 기준점에 가까운 순서대로 정렬하는 문제
    // 거리가 같으면 x 좌표가 더 작은 값이, x 좌표가 같으면 y좌표 더 작은 값이 먼저 오도록 정렬
    public static int[][] solution1(int x0, int y0, int[][] points) {

        // distance 기준으로 자료구조가 필요하지 않을까?
        // map 은 같은 거리일 때 데이터를 갱신함으로 X
        // 거리 순으로 정렬한 다음에, 거리가 같은 애들끼리 2차 정렬이 필요
        Arrays.sort(points, (p1, p2) -> {

            // 정렬을 하기 위해서는 두 수의 비교를 해야함
            // 여기서는 2차 배열이기 때문에 비교 대상은 각 배열 p1, p2
            long dx1 = p1[0] - x0;
            long dy1 = p1[1] - y0;
            long dx2 = p2[0] - x0;
            long dy2 = p2[1] - y0;

            // 기준점과 순서쌍의 거리를 구하는 공식을 사용
            // 이때 루트는 연산 비용만 들 뿐 값의 비교는 제곱으로 가능함으로 생략
            long dist1 = dx1 * dx1 + dy1 * dy1;
            long dist2 = dx2 * dx2 + dy2 * dy2;

            // 비교 대상의 순서쌍의 두 거리간의 비교
            if (dist1 != dist2) {
                return Long.compare(dist1, dist2);
            }

            // x 축의 비교
            if (p1[0] != p2[0]) {
                return Integer.compare(p1[0], p2[0]);
            }

            // y축의 비교
            return Integer.compare(p1[1], p2[1]);
        });

        return points;
    }
}
