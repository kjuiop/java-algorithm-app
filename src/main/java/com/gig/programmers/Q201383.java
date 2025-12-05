package com.gig.programmers;

import java.util.*;

/**
 * @author : JAKE
 * @date : 25. 12. 5.
 */
public class Q201383 {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(solution(new int[]{11, 15, 20, 24, 31})));
    }

    // 정수배열 arr
    // 각 자릿수의 합이 sum 인 수가 있으면, 그러한 수의 개수가 cnt일 때 [sum, cnt] 를 담고 있는 2차원 배열을 반환하는 suolution
    // 작은 것부터 오름차순
    public static int[][] solution(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // hashmap 에 데이터를 저장
        for (int a : arr) {
            int sum = digitSum(a);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        // sum 을 key 값으로 하는 값을 정렬해야하기 때문에 List 로 map 을 변환해야함
        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);

        // 2차원 배열에 값을 넣어주는 부분
        int[][] answer = new int[keys.size()][2];
        for (int i=0; i<keys.size(); i++) {
            int sum = keys.get(i);
            answer[i][0] = sum;
            answer[i][1] = map.get(sum);
        }

        return answer;
    }

    // 각 자릿수의 합
    private static int digitSum(int n) {
        int sum = 0;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
