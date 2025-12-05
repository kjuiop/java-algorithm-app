package com.gig.programmers;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author : JAKE
 * @date : 25. 12. 5.
 */
// 한 쪽에만 존재하는 문자 풀이
public class Q201378 {

    // https://school.programmers.co.kr/tryouts/201378/challenges?language=java
    public static void main(String[] args) {
        System.out.println(solution("aabcddd", "bbcdeee"));
        System.out.println(solution("aabbccdd", "ddccbbaa"));
    }

    public static int solution(String str1, String str2) {
        String[] str1Array = str1.split("");
        HashSet<String> set1 = new HashSet<>(Arrays.asList(str1Array));

        String[] str2Array = str2.split("");
        HashSet<String> set2 = new HashSet<>(Arrays.asList(str2Array));

        for (String s2 : str2Array) {
            set1.remove(s2);
        }
        for (String s1 : str1Array) {
            set2.remove(s1);
        }
        return set1.size() + set2.size();
    }
}
