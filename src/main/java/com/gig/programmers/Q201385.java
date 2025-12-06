package com.gig.programmers;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author : JAKE
 * @date : 25. 12. 6.
 */
public class Q201385 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{19, 6, 2, 18, 3}, new int[]{7, 10, 8, 2, 15})));
        System.out.println(Arrays.toString(solution(new int[]{40000}, new int[]{40000})));
    }

    public static int[] solution(int[] a, int[] b) {
        Arrays.sort(a);
        // b에 대한 내림차순
        Integer[] temp = new Integer[b.length];
        for (int i=0; i<b.length; i++) {
            temp[i] = b[i];
        }

        // b에 대한 내림차순
        Arrays.sort(temp, (l1, l2) -> {
            return l2-l1;
        });

        int[] answer = new int[a.length];
        for (int i=0; i<a.length; i++) {
            answer[i] = a[i] * temp[i];
        }

        return answer;
    }

    // a의 길이를 N 이라 한다.
    // 0 <= i <= N-1 / (a*b)[i] = (a에서 i+1번째로 작은 수 ) * (b 에서 i + 1번째로 큰수)
    public static int[] solution1(int[] a, int[] b) {
        Arrays.sort(a);
        // b에 대한 내림차순
        Integer[] temp = new Integer[b.length];
        for (int i=0; i<b.length; i++) {
            temp[i] = b[i];
        }
        Arrays.sort(temp, Collections.reverseOrder());

        int[] answer = new int[a.length];
        for (int i=0; i<a.length; i++) {
            answer[i] = a[i] * temp[i];
        }

        return answer;
    }
}
