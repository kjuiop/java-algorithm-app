package com.gig.programmers;

import java.util.Arrays;

/**
 * @author : JAKE
 * @date : 25. 12. 6.
 */
public class Q201388 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"cAT", "TouCH", "mKDIR", "cd", "GrEp", "LS", "pWD", "fINd"})));
    }

    public static String[] solution(String[] words) {

        Arrays.sort(words, (l1, l2) -> {

            if (l1.length() != l2.length()) {
                return l1.length() - l2.length();
            }

            String lowerL1 = l1.toLowerCase();
            String lowerL2 = l2.toLowerCase();

            // 사전 순 정렬은 아래와 같이 할 수 있음 (String)
            return lowerL1.compareTo(lowerL2);
        });

        return words;
    }

    // 길이가 짧은 것부터
    // 길이가 같다면 문자열에 속한 문자를 전부 영소문자로 비교했을 때 기준 사전순으롲 정렬한 문자열 배열 반환
    public static String[] solution1(String[] words) {

        Arrays.sort(words, (l1, l2) -> {

            if (l1.length() != l2.length()) {
                return l1.length() - l2.length();
            }

            char[] arr1 = l1.toLowerCase().toCharArray();
            char[] arr2 = l2.toLowerCase().toCharArray();

            for (int i=0; i<arr1.length; i++) {
                if (arr1[i] != arr2[i]) {
                    return arr1[i] - arr2[i];
                }
            }

            // 아예 같은 경우는 주어지지 않는다고 함
            return 0;
        });

        return words;
    }
}
