package com.gig.programmers;

import java.util.Stack;

/**
 * @author : JAKE
 * @date : 25. 12. 9.
 */
public class Q201397 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 4, 2, 5, 3}));
        System.out.println(solution(new int[]{100, 100, 100}));
    }

    public static int solution(int[] heights) {
        Stack<Integer> cameras = new Stack<>();
        cameras.push(0);
        for (int height : heights) {
            if (cameras.peek() < height) {
                cameras.push(height);
            }
        }
        return cameras.size() -1;
    }

    // 빌딩의 꼭대기에 감시카메라가 있음
    // 높은 빌딩이 있으면 그 뒤의 빌딩은 보이지 않음
    // 빌딩의 높이가 앞에서 뒤로 순서대로 저장된 배열 heights
    // 설치해야하는 감시카메라 최소 개수
    public static int solution1(int[] heights) {
        Stack<Integer> cameras = new Stack<>();
        int max = 0;
        for (int height : heights) {
            if (height > max) {
                max = height;
                cameras.push(height);
            }
        }
        return cameras.size();
    }
}
