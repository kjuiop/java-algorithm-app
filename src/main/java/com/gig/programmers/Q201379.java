package com.gig.programmers;

import java.util.HashSet;

/**
 * @author : JAKE
 * @date : 25. 12. 5.
 */
// MEX 구하기
public class Q201379 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{0,1,2,4,4,2}));
        System.out.println(solution(new int[]{1,1,2,3,4,5}));
    }

    public static int solution(int[] arr) {
        // 문제에서 주어진 arr 이 가질 수 있는 데이터의 범위
        int[] count = new int[1000001];
        for (int i : arr) {
            // 배열의 데이터를 index 로 생각해서 해당 원소에 대한 값을 1 증가시킴
            count[i] += 1;
        }

        for (int i=0; i<count.length; i++) {
            // 0부터 차례대로 인덱스를 세어볼 때 값이 0이면 가장 작은 값을 의미함
            if (count[i] == 0) {
                return i;
            }
        }
        return 0;
    }

    public static int solution1(int[] arr) {
        int max = 0;
        HashSet<Integer> set = new HashSet<>();

        for (int a : arr) {
            set.add(a);
            max = Math.max(max, a);
        }

        for (int i=0; i<=max; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        // 원소의 값이 모두 존재하면 mex 값은 max 의 그 다음 숫자가 된다.
        return max + 1;
    }
}
