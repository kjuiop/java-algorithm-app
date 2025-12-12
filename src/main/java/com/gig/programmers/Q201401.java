package com.gig.programmers;

import java.util.*;

/**
 * @author : JAKE
 * @date : 25. 12. 12.
 */
public class Q201401 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(
                new String[]{"I", "I", "O", "I", "O", "O"},
                new String[]{"jerry", "tom", "-", "yasu", "-", "-"}
        )));

        System.out.println(Arrays.toString(solution(
                new String[]{"I", "I", "I", "I", "O", "O", "O"},
                new String[]{"one", "two", "three", "four"}
        )));
    }

    public static String[] solution(String[] queries, String[] names) {
        Queue<String> queue = new LinkedList<>();
        Stack<String> answer = new Stack<>();

        for (int i=0; i<queries.length; i++) {
            if (queries[i].equals("I")) {
                queue.add(names[i]);
            } else {
                // 가장 처음의 문자열을 제거하고, 그 문자열의 길이를 조건으로 answer 에 넣는다.
                String temp = queue.poll();
                if (temp.length() % 2 == 0) {
                    answer.push(temp);
                }
            }
        }
        return answer.toArray(new String[answer.size()]);
    }

    // Queue - 선입선출
    // 자료 입력하기, 가장 먼저 입력된 자료 처리하기
    public static String[] solution1(String[] queries, String[] names) {
        List<String> list = new ArrayList<>();
        Queue<String> queue = new ArrayDeque<>();
        for (int i=0; i<names.length; i++) {
            if (queries[i].equals("I")) {
                queue.add(names[i]);
            } else {
                String removed = queue.remove();
                if (removed.length() % 2 == 0) {
                    list.add(removed);
                }
            }
        }
        return list.toArray(new String[0]);
    }
}
