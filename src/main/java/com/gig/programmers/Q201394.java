package com.gig.programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * @author : JAKE
 * @date : 25. 12. 9.
 */
public class Q201394 {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(solution(new int[][]{{1, 80}, {3820, 20}, {110, 60}, {1, 90}, {110, 80}})));
    }

    public static int[][] solution(int[][] classNScore) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int[] ints : classNScore) {
            int cl = ints[0];
            int sc = ints[1];
            if (map.containsKey(cl)) {
                map.put(cl, map.get(cl) + sc);
            } else {
                map.put(cl, sc);
            }
        }

        // treemap 은 key 의 오름차순으로 정렬하여 값을 갖고 있다.
        int[][] answer = new int[map.size()][2];
        int index = 0;
        for (int key : map.keySet()) {
            answer[index] = new int[]{key, map.get(key)};
            index++;
        }

        return answer;
    }

    // 각 학생들이 소속된 반과 성적만이 주어질 때
    // 학급별 점수의 합을 구해야 함
    public static int[][] solution1(int[][] classNScore) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int[] classScore : classNScore) {
            int classNum = classScore[0];
            int score = classScore[1];

            if (map.containsKey(classNum)) {
                map.replace(classNum, map.get(classNum) + score);
            } else {
                map.put(classNum, score);
            }
        }

        int[][] answer = new int[map.size()][2];
        int index = 0;
        for (int key : map.keySet()) {
            answer[index][0] = key;
            answer[index][1] = map.get(key);
            index++;
        }

        Arrays.sort(answer, (l1, l2) -> {
            return l1[0] - l2[0];
        });
        return answer;
    }
}
