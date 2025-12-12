package com.gig.programmers;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : JAKE
 * @date : 25. 12. 12.
 */
public class Q201402 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 4, 5, 6}, new int[]{1, 2, 8, 9}, new int[]{7, 10}, new int[]{1, 2, 3, 4, 5}));
        System.out.println(solution(new int[]{3, 4, 5, 6}, new int[]{1, 2, 8, 9}, new int[]{7, 10}, new int[]{5, 6, 7}));
    }

    public static int solution(int[] first_belt, int[] second_belt, int[] third_belt, int[] example) {
        Queue<Integer> que1 = new LinkedList<>();
        Queue<Integer> que2 = new LinkedList<>();
        Queue<Integer> que3 = new LinkedList<>();
        for (int a : first_belt) {
            que1.add(a);
        }
        for (int a : second_belt) {
            que2.add(a);
        }
        for (int a : third_belt) {
            que3.add(a);
        }

        for (int e : example) {
            if (que1.peek() == e) {
                que1.poll();
            } else if (que2.peek() == e) {
                que2.poll();
            } else if (que3.peek() == e) {
                que3.poll();
            } else {
                return 0;
            }
        }
        return 1;
    }

    // 컨베이어 벨트 3개, 각 벨트마다 임의의 번호의 상자
    // 각 벨트의 끝에서만 상자를 가져올 수 있으며, 아래에서 위로 쌓아야하는 상자의 번호가 주어져 있음
    public static int solution1(int[] first_belt, int[] second_belt, int[] third_belt, int[] example) {
        Queue<Integer> queue = new LinkedList<>();
        for (int e : example) {
            queue.add(e);
        }

        int index1 = 0, index2 = 0, index3 = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (first_belt[index1] == current) {
                index1++;
            } else if (second_belt[index2] == current) {
                index2++;
            } else if (third_belt[index3] == current) {
                index3++;
            } else {
                return 0;
            }
        }

        return 1;
    }
}
