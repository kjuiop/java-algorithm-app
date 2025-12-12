package com.gig.programmers;

import java.util.*;

/**
 * @author : JAKE
 * @date : 25. 12. 12.
 */
public class Q201403 {
    public static void main(String[] args) {

        System.out.println(solution(2, 2, new int[]{1, 2, 3, 4}));
        System.out.println(solution(3, 6, new int[]{3, 1, 2}));
        System.out.println(solution(3, 3, new int[]{100, 100, 200}));
    }

    public static int solution(int n, int k, int[] arr) {
        Queue<Integer> queue = new LinkedList<>();
        for (int a : arr) {
            queue.add(a);
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<k; j++) {
                queue.add(queue.poll());
            }
            int a = queue.poll();
            queue.add(a);
            queue.add(a);
        }

        int[] count = new int[1000001];
        int max = 0;
        int maxIndex = 0;

        while (!queue.isEmpty()) {
            count[queue.poll()] += 1;
        }

        for (int i=0; i<count.length; i++) {
            if (count[i] > max) {
                max = count[i];
                maxIndex = i;
            }
        }

        return maxIndex;
    }

    public static int solution1(int n, int k, int[] arr) {
        Queue<Integer> queue = new LinkedList<>();
        for (int a : arr) {
            queue.add(a);
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<k; j++) {
                queue.add(queue.poll());
            }
            int a = queue.poll();
            queue.add(a);
            queue.add(a);
        }

        // 빈도수를 구하기 위해 HashMap 을 사용한다.
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int q : queue) {
            map.put(q, map.getOrDefault(q, 0) + 1);
        }

        // 정렬을 사용하기 위해 map 의 key 로만 이루어진 배열을 만든다.
        Integer[] answer = new Integer[map.size()];
        int i = 0;
        for (int key : map.keySet()) {
            answer[i] = key;
            i++;
        }

        // answer 를 정렬하는데 있어, 1차로는 빈도수, 2차로는 오름차순으로 정렬한다.
        Arrays.sort(answer, (l1, l2) -> {
            if (map.get(l1) != map.get(l2)) {
                return map.get(l2) - map.get(l1);
            }
            return l1 - l2;
        });

        return answer[0];
    }
}
