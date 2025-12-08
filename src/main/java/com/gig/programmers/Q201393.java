package com.gig.programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

/**
 * @author : JAKE
 * @date : 25. 12. 8.
 */
public class Q201393 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{44, 12, 87, 44, 1}));
        System.out.println(solution(new int[]{373, 61, 373, 224, 8237, 224, 8237}));
        System.out.println(solution(new int[]{69789890, 2, 43810987, 7729, 193475}));
        System.out.println(solution(new int[]{93485, 93485, 93485}));
        System.out.println(solution(new int[]{23}));
    }

    public static int solution(int[] arr) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int j : arr) {
            if (count.containsKey(j)) {
                count.replace(j, count.get(j) + 1);
            } else {
                count.put(j, 1);
            }
        }

        int[][] countArr = new int[count.size()][2];
        int index = 0;
        for (Integer key : count.keySet()) {
            countArr[index][0] = count.get(key);
            countArr[index][1] = key;
            index++;
        }

        Arrays.sort(countArr, (l1, l2) -> {
            if (l2[0] != l1[0]) {
                return l2[0] - l1[0];
            } else {
                return l1[1] - l2[1];
            }
        });

        return countArr[0][1];
    }

    // arr 에서 가장 많이 등장하는 정수를, 그 중에서 가장 작은 정수를 return 하는 함수
    public static int solution1(int[] arr) {

        // 가장 많은 빈도를 구하기 위해 map 으로 중복을 제거하고, 카운팅을 한다.
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            if (map.containsKey(i)) {
                map.replace(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        // 정렬을 위해 index 배열을 만든다.
        Integer[] index = new Integer[arr.length];
        for (int i=0; i<index.length; i++) {
            index[i] = arr[i];
        }

        // 정렬 조건을 적용한다.
        // 1. 많은 빈도수
        // 2. 가장 작은 수
        Arrays.sort(index, (l1, l2) -> {

            if (!Objects.equals(map.get(l1), map.get(l2))) {
                return map.get(l2) - map.get(l1);
            }

            return l1 - l2;
        });

        return index[0];
    }
}
