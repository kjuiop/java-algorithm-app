package com.gig.programmers;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author : JAKE
 * @date : 25. 12. 7.
 */
public class Q201392 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(
                new int[][]{{340, 1111, 62}, {777, 1111, 10}, {7672, 3000, 20}, {3019, 1234, 34}, {7672, 1000, 0}}, 1, 2, 1)
        ));

        System.out.println(Arrays.toString(solution(
                new int[][]{{10000, 10000, 0}, {0, 0, 10000}}, 0, 0, 1)
        ));
    }

    public static int[] solution(int[][] points, int a, int b, int c) {

        // 상을 받는 학생들의 정수번호
        int[] answer = new int[a+b+c];


        int index = 0;

        // point int 배열의 크기가 정해져있지 않아 정수 번호를 추가할 수 있음
        for (int i=0; i<points.length; i++) {
            points[i] = new int[]{points[i][0], points[i][1], points[i][2], i+1};
        }

        Arrays.sort(points, (l1, l2) -> {

            // a 점수가 높은 학생
            if (l2[0] != l1[0]) {
                return l2[0] - l1[0];
            }

            // a 점수가 같을 때 정수 번호가 낮은 학생
            return l1[3] - l2[3];
        });

        for (int i=0; i<a; i++) {
            answer[index] = points[i][3];
            index++;
            points[i] = new int[]{-1, -1, -1, -1};
        }

        Arrays.sort(points, (l1, l2) -> {

            // b 점수가 높은 학생
            if (l2[1] != l1[1]) {
                return l2[1] - l1[1];
            }

            // b 점수가 같을 때 정수 번호가 낮은 학생
            return l1[3] - l2[3];
        });

        for (int i=0; i<b; i++) {
            answer[index] = points[i][3];
            index++;
            points[i] = new int[]{-1, -1, -1, -1};
        }

        Arrays.sort(points, (l1, l2) -> {

            // c 점수가 높은 학생
            if (l2[2] != l1[2]) {
                return l2[2] - l1[2];
            }

            // b 점수가 같을 때 정수 번호가 낮은 학생
            return l1[3] - l2[3];
        });

        for (int i=0; i<c; i++) {
            answer[index] = points[i][3];
            index++;
            points[i] = new int[]{-1, -1, -1, -1};
        }

        Arrays.sort(answer);
        return answer;
    }

    // 학생 n명, 1번부터 n번 까지 번호 붙어있음
    // x의 점수가 가장 높은 사람
    // y의 점수가 높은 사람
    // z의 점수가 높은 사람
    // 번호가 작은 학생

    // a, b, c 는 상의 갯수
    public static int[] solution1(int[][] points, int a, int b, int c) {

        // 정수 번호 부여
        Integer[] index = new Integer[points.length];
        for (int i=0; i<index.length; i++) {
            index[i] = i;
        }

        AtomicInteger n1 = new AtomicInteger(a);
        AtomicInteger n2 = new AtomicInteger(b);
        AtomicInteger n3 = new AtomicInteger(b);
        Arrays.sort(index, (p1, p2) -> {

            int[] point1 = points[p1];
            int[] point2 = points[p2];

            int x1 = point1[0], x2 = point1[1], x3 = point1[2];
            int y1 = point2[0], y2 = point2[1], y3 = point2[2];

            if (n1.get() > 0) {
                n1.set(n1.get() - 1);
                return x1 - y1;
            }

            if (n2.get() > 0) {
                n2.set(n2.get() -1);
                return x2 - y2;
            }

            if (n3.get() > 0) {
                n3.set(n3.get() -1);
            }

            return x3 - y3;
        });

        return Arrays.stream(index).mapToInt(i -> i+1).toArray();
    }
}
