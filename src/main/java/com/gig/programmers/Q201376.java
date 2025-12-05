package com.gig.programmers;

/**
 * @author : JAKE
 * @date : 25. 12. 5.
 */
public class Q201376 {

    // https://school.programmers.co.kr/tryouts/201376/challenges

    public static void main(String[] args) {
        System.out.println(solution(30, 1000, "abcd"));
    }

    public static long solution(int x, int m, String myStr) {
        // 문제에서 int 자료형의 범위를 넘길 수 있는 변수의 값이 주어짐으로 자료형은 long 으로 변경
        long answer = 0;
        long sq = 1;
        for (int i = myStr.length() -1; i>=0; i--) {
            // ASCII 를 통해 현재 변수를 a는 1부터 26까지 변환한 값
            long a = myStr.charAt(i) - 'a' + 1;
            answer += a * sq % m;
            sq = sq * x % m;
        }
        answer %= m;
        return answer;
    }

    public static int solution2(int x, int m, String myStr) {
        // int 자료형이 표현할 수 있는 수는 2,147,483,648 임으로 이 값을 넘어가면 다시 작은 수로 돌아감
        // 반대로 int 자료형에서 가장 작은 수에서 적어지면 가장 큰 수인 2,147,483,648 로 돌아감
        // 문제에서 int 자료형의 범위를 넘길 수 있는 변수의 값이 주어짐으로 테스트는 실패하게 됨
        int answer = 0;
        int sq = 1;
        for (int i = myStr.length() -1; i>=0; i--) {
            // ASCII 를 통해 현재 변수를 a는 1부터 26까지 변환한 값
            int a = myStr.charAt(i) - 'a' + 1;
            answer += a * sq;
            sq *= x;
        }
        answer %= m;
        return answer;
    }

    public static int solution1(int x, int m, String myStr) {
        int answer = 0;
        for (int i = 0; i < myStr.length(); i++) {
            char ch = myStr.charAt(i);
            // a-> 1, b-> 2 로 값을 설정
            int val = (ch - 'a' + 1);
            // 다항식 (polynomial) 해시 공식 : a·x³ + b·x² + c·x¹ + d·x⁰
            // 호너방식 : ((ax+b)x+c)x+d
            // 1번 순회를 돌면서 이전 값에 연산을 하기 때문에 제곱 연산이 필요가 없어짐
            answer = (answer * x + val) % m;
        }
        return answer;
    }
}
