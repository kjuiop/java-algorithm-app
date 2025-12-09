package com.gig.programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;

/**
 * @author : JAKE
 * @date : 25. 12. 9.
 */
public class Q201395 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"aabcd", "bcde", "aabbcc", "aaaa"}, new String[]{"abcd", "bcd", "aa"})));
    }

    public static int[] solution(String[] strs1, String[] strs2) {
        // 배열에는 contains 가 없기 때문에 HashSet 자체를 값으로 갖는다. (중복여부)
        HashSet<HashSet<Character>> set1 = new HashSet<>();

        for (String s : strs1) {
            HashSet<Character> hashSet = new HashSet<>();
            for (int j = 0; j < s.length(); j++) {
                hashSet.add(s.charAt(j));
            }
            // 이중 HashSet 으로 만듬
            set1.add(hashSet);
        }

        int[] answer = new int[strs2.length];
        for (int i=0; i<strs2.length; i++) {
            HashSet<Character> hashSet = new HashSet<>();
            for (int j=0; j<strs2[i].length(); j++) {
                hashSet.add(strs2[i].charAt(j));
            }
            // HashSet 은 요소 내용의 동등성을 기준으로 평가하기 때문에 contains 로 비교 가능
            if (set1.contains(hashSet)) {
                answer[i] = 1;
            }
        }

        return answer;
    }

    // 두 문자열에 등장한 알파벳 종류가 같다면 두 문자열의 구성이 같다.
    // strs2 에 대해 strs1 이 문자열의 구성이 같으면 1, 아나면 2
    public static int[] solution1(String[] strs1, String[] strs2) {
        int[] answer = new int[strs2.length];

        TreeMap<Integer, HashMap<Character, Integer>> map = new TreeMap<>();
        int index = 0;
        for (String str1 : strs1) {
            char[] array = str1.toCharArray();
            HashMap<Character, Integer> hashMap = new HashMap<>();
            for (char c : array) {
                hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
            }
            map.put(index, hashMap);
            index++;
        }

        for (int i=0; i<strs2.length; i++) {
            HashMap<Character, Integer> hashMap = map.get(i);
            char[] array = strs2[i].toCharArray();
            int count = 0;
            for (char c : array) {
                if (hashMap.containsKey(c)) {
                    count = 1;
                    continue;
                }
                count = 0;
            }
            answer[i] = count;
        }
        return answer;
    }
}
