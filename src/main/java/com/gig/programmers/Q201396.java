package com.gig.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author : JAKE
 * @date : 25. 12. 9.
 */
public class Q201396 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"I", "I", "I", "O", "O", "O"}, new int[]{4, 44, 444, 44, 44, 44})));
    }

    public static Integer[] solution(String[] queries, int[] vals) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> answer = new Stack<>();
        for (int i=0; i<queries.length; i++) {
            String cmd = queries[i];
            if (cmd.equals("I")) {
                stack.push(vals[i]);
            } else {
                int tmp = stack.pop();
                if (tmp >= vals[i]) {
                    answer.push(tmp);
                }
            }
        }

        return answer.toArray(new Integer[answer.size()]);
    }

    // 스택, 후입선출 (Last In First Out)
    public static int[] solution1(String[] queries, int[] vals) {
        List<Integer> answerList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<queries.length; i++) {
            String cmd = queries[i];
            if (cmd.equals("I")) {
                list.add(vals[i]);
            } else {
                int o = list.remove(list.size()-1);
                if (o >= vals[i]) {
                    answerList.add(o);
                }
            }
        }

        int[] answer = new int[answerList.size()];
        for (int i=0; i<answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}
