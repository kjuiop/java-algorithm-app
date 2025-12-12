package com.gig.programmers;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author : JAKE
 * @date : 25. 12. 12.
 */
public class Q201399 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 3, 6, 8}, 2)));
        System.out.println(Arrays.toString(solution(new int[]{1, 3, 11}, 3)));
    }

    public static int[] solution(int[] arr, int k) {
        Stack<Integer> stack = new Stack<>();
        for (int a : arr) {
            // 최초 stack 이 비어있을 때 요소를 넣어준다.
            if (stack.isEmpty()) {
                stack.push(a);
                continue;
            }

            // 오름차순 정렬이기 때문에 stack 요소 중 제일 큰값을 뽑을 수 있다.
            // 가장 마지막 수와 k 를 더한 값이 다음 해당 요소보다 작을때까지 계속해서 stack 에 넣어준다.
            while (stack.peek() + k < a) {
                stack.push(stack.peek() + k);
            }
            // 마지막에 배열의 요소도 추가한다.
            stack.push(a);
        }

        int[] answer = new int[stack.size()];
        for (int i=0; i<stack.size(); i++) {
            answer[i] = stack.get(i);
        }

        return answer;
    }

    // 오름차순으로 정렬된 배열이 있음
    // 이웃한 두 수의 값의 차가 전부 k 보다 작거나 같도록 하기 위해 배열 사이에 수를 추가하고자 함
    // 완성된 배열의 원소의 갯수는 최소화하되, 원수들의 총합은 최대화
    public static int[] solution1(int[] arr, int k) {
        Stack<Integer> stack = new Stack<>();

        for (int i=0; i<arr.length; i++) {
            stack.push(arr[i]);
            if (i == 0) {
                continue;
            }

            if (arr[i] - arr[i-1] <= k) {
                continue;
            }

            int prev1 = stack.pop();
            int prev2 = stack.pop();
            int result = prev2 + k;
            stack.push(prev2);
            stack.push(result);
            stack.push(prev1);
        }

        int[] answer = new int[stack.size()];
        for (int i=0; i<stack.size(); i++) {
            answer[i] = stack.get(i);
        }
        return answer;
    }
}
