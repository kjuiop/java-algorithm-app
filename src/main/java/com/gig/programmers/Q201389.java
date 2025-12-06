package com.gig.programmers;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author : JAKE
 * @date : 25. 12. 6.
 */
public class Q201389 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{5, 3, 19, 11, 4, 18})));
    }

    public static Integer[] solution(int[] arr) {
        // Arrays 를 사용하기 위해 먼저 int[] 를 Integer[] 로 변경한다.
        Integer[] index = new Integer[arr.length];
        // 반환하고자 하는 값은 인덱스이기 때문에 인덱스 값을 집어넣어준다.
        for (int i=0; i<index.length; i++) {
            index[i] = i;
        }

        // index 를 정렬하는데 index 가 아닌 arr 의 값을 기준으로 정렬한다.
        Arrays.sort(index, (l1, l2) -> {
            return arr[l1] - arr[l2];
        });

        return index;
    }

    // arr 배열을 오름차순으로 정렬할 때 정렬 전의 인덱스 값을 반환하라
    // 서로 다른 원소
    public static int[] solution1(int[] arr) {
        int[] answer = new int[arr.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<arr.length; i++) {
            map.put(arr[i], i);
        }

        Arrays.sort(arr);

        for (int i=0; i<arr.length; i++) {
            answer[i] = map.get(arr[i]);
        }

        return answer;
    }
}
