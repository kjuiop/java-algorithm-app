package com.gig.programmers;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : JAKE
 * @date : 25. 12. 13.
 */
public class Q201404 {

    public static void main(String[] args) {
        System.out.println(solution("abcacc", 3));
        System.out.println(solution("abcdabcd", 3));
    }

    public static int solution(String myStr, int k) {
        int answer = 0;
        // 윈도우 역할을 할 queue 생성
        Queue<Character> que = new LinkedList<>();
        // 윈도우 안의 문자열을 저장할 HashMap
        HashMap<Character, Integer> count = new HashMap<>();

        for (int i=0; i<myStr.length(); i++) {
            Character c = myStr.charAt(i);
            // 현재 count 안에 값이 있으면 그 값 만큼 answer 에 더함
            answer += count.getOrDefault(c, 0);
            // 윈도우의 크기가 k 보다 큰 경우
            if (que.size() >= k) {
                // 윈도우에서 가장 먼저 들어온 문자를 뺀다.
                Character item = que.poll();
                // 해당 문자의 카운트를 1 감소시킨다.
                count.put(item, count.get(item) - 1);
            }
            // 현재 문자를 윈도우에 넣는다.
            que.offer(c);
            // count 에 해당 문자의 갯수를 넣어준다.
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        return answer;
    }

    // 문자열의 인덱스 차이가 k 이하면서 같은 쌍의 갯수
    public static int solution1(String myStr, int k) {
        char[] arr = myStr.toCharArray();
        Queue<Character> que = new LinkedList<>();
        for (char c : arr) {
            que.offer(c);
        }

        int answer = 0;
        int index = 1;
        while(!que.isEmpty()) {
            char a = que.poll();
            int len = k + index;
            if (len > arr.length) {
                len = arr.length;
            }
            for (int i=index; i<len; i++) {
                if (a == arr[i]) {
                    answer++;
                }
            }
            index++;
        }

        return answer;
    }
}
