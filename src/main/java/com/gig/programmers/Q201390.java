package com.gig.programmers;

import java.util.Arrays;

/**
 * @author : JAKE
 * @date : 25. 12. 7.
 */
public class Q201390 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(
                new String[]{"squarearea", "countdown", "iceamericano", "twodimensioncoinflap", "subtraction"},
                new int[]{5, 3, 0, 3, 0},
                new int[]{55, 230, 11892, 230, 23950}))
        );
    }

    // 난이도의 값이 작은 문제부터
    // 완료한 사람의 수가 많은 문제부터
    // 사전 순으로
    public static int[] solution(String[] problem_names, int[] levels, int[] completions) {
        Integer[] index = new Integer[problem_names.length];
        for (int i=0; i<index.length; i++) {
            index[i] = i;
        }

        Arrays.sort(index, (l1, l2) -> {

            if (levels[l1] != levels[l2]) {
                return levels[l1] - levels[l2];
            }

            if (completions[l1] != completions[l2]) {
                return completions[l2] - completions[l1];
            }

            return problem_names[l1].compareTo(problem_names[l2]);
        });

        return Arrays.stream(index).mapToInt(i -> i).toArray();
    }
}
