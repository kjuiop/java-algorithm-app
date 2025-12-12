package com.gig.programmers;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author : JAKE
 * @date : 25. 12. 12.
 */
public class Q201398 {

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"2","3","5","*","+"}));
        System.out.println(solution(new String[]{"2","3","+","5","*"}));
    }

    public static int solution(String[] expression) {
        Stack<Integer> stack = new Stack<>();
        for (String s : expression) {
            if (s.equals("+") || s.equals("-") || s.equals("*")) {
                int a = stack.pop();
                int b = stack.pop();
                int result = calculate(s, b, a);
                stack.push(result);
                continue;
            }
            stack.push(Integer.valueOf(s));
        }
        return stack.get(0);
    }

    // 후위 표기식 연산식
    // 2, 3, 5 가 있으면 뒤에서 꺼내서 연산을 한다.
    public static int solution1(String[] expression) {
        Stack<Integer> stack = new Stack<>();
        for (String s : expression) {
            try {
                int i = Integer.parseInt(s);
                stack.push(i);
            } catch (NumberFormatException e) {
                int a = stack.pop();
                int b = stack.pop();
                int result = calculate(s, b, a);
                stack.push(result);
            }
        }
        return stack.get(0);
    }

    public static int calculate(String h, int a, int b) {
        if (h.equals("*")) {
            return a * b;
        } else if (h.equals("+")) {
            return a + b;
        } else if (h.equals("-")) {
            return b - a;
        } else {
            return 0;
        }
    }
}
