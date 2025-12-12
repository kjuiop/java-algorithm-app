package com.gig.programmers;

import java.util.Stack;

/**
 * @author : JAKE
 * @date : 25. 12. 12.
 */
public class Q201400 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 2, 1, 5, 4}));
    }

    // 1부터 N까지 정수가 하나씩 들고있는 스택 1개, 비어있는 스택 2개
    // 연산 1 : 스택 1의 원소를 스택 3
    // 연산 2 : 스택 1의 원소를 스택 2
    // 연산 3 : 스택 2의 원소를 스택 3
    // 각각 스택이 비어있으면 안됨
    // 스택 3에 n부터 1까지 정수를 순서대로 넣기
    public static String solution(int[] first_stack) {
        StringBuilder answer = new StringBuilder();
        Stack<Integer> first = new Stack<>();
        Stack<Integer> second = new Stack<>();
        Stack<Integer> third = new Stack<>();

        for (int i : first_stack) {
            first.push(i);
        }

        // 1부터 N 까지의 정수이기 때문에 원소의 갯수가 최대값이다.
        int max = first.size();
        while (true) {
            if (!first.isEmpty() && first.peek() == max) {
                third.push(first.pop());
                answer.append("1");
                max -= 1;
            } else if (!second.isEmpty() && second.peek() == max) {
                third.push(second.pop());
                answer.append("3");
                max -= 1;
            } else {
                if (first.isEmpty()) {
                    break;
                }
                second.push(first.pop());
                answer.append("2");
            }
        }

        if (max > 0) {
            return "-1";
        }
        return answer.toString();
    }
}
