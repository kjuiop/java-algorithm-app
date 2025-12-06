package com.gig.programmers;

import java.util.Arrays;

/**
 * @author : JAKE
 * @date : 25. 12. 6.
 */
public class Q201384 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{5, 8, 17, 22}, new int[]{6, 7, 11, 15})));
        System.out.println(Arrays.toString(solution(new int[]{5, 5, 33}, new int[]{5, 5, 5})));
        System.out.println(Arrays.toString(solution(new int[]{497, 2039, 3885}, new int[]{26, 49})));
    }

    public static int[] solution(int[] arr1, int[] arr2) {
        int[] answer = new int[arr1.length + arr2.length];
        int index = 0;
        for (int i : arr1) {
            answer[index] = i;
            index++;
        }
        for (int i : arr2) {
            answer[index] = i;
            index++;
        }
        Arrays.sort(answer);
        return answer;
    }

    // 두 배열을 이어붙인 후 오름차순으로 정렬하는 함수
    public static int[] solution1(int[] arr1, int[] arr2) {
        int[] answer = new int[arr1.length + arr2.length];
        for (int i=0; i<arr1.length; i++) {
            answer[i] = arr1[i];
        }
        for (int i=arr1.length; i<answer.length; i++) {
            answer[i] = arr2[i-arr1.length];
        }
        Arrays.sort(answer);
        return answer;
    }
}
