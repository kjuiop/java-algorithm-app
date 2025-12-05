package com.gig.programmers;

import java.util.HashSet;

/**
 * @author : JAKE
 * @date : 25. 12. 5.
 */
public class Q201377 {

    // https://school.programmers.co.kr/tryouts/201377/challenges?language=java
    public static void main(String[] args) {
        System.out.println(solution(new int[]{0,5,17,5,1}));
        System.out.println(solution(new int[]{1,2,1,2}));
    }

    public static int solution(int[] queries) {
        HashSet<Integer> set = new HashSet<>();
        for (int query : queries) {
            if (set.contains(query)) {
                set.remove(query);
                continue;
            }
            set.add(query);
        }
        return set.size();
    }
}
