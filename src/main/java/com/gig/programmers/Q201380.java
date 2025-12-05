package com.gig.programmers;

import java.util.*;

/**
 * @author : JAKE
 * @date : 25. 12. 5.
 */
public class Q201380 {

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"abcd","acd","aaa","bbbbbb"}));
        System.out.println(solution(new String[]{"aaa","bbb","abbc"}));
    }

    public static String solution(String[] strs) {
        // HashMap 이 아니더라도 아스키코드를 기준으로 인덱스와 value 값으로 값을 저장할 수 있음
        // index : 알파벳 위치값, a~z : 0~25 , Value : 중복된 횟수
        int[] count = new int[26];
        for (String str : strs) {
            HashSet<Character> set = new HashSet<>();
            for (int i=0; i<str.length(); i++) {
                set.add(str.charAt(i));
            }

            // 문자 s를 'a' 기준으로 0~25 범위의 인덱스로 변환 (예: 'a'→0, 'b'→1, ...)
            for (char s : set) {
                count[s - 'a']++;
            }
        }

        // count 배열 속에 제일 많이 중복된 값 찾기
        int max = 0;
        for (int i : count) {
            max = Math.max(max, i);
        }

        // 제일 많이 중복된 값을 가지고 있는 문자열을 합한 후 값으로 리턴
        StringBuilder answer = new StringBuilder();
        for (int i=0; i<count.length; i++) {
            if (count[i] == max) {
                // 위에서 부여한 인덱스 + ASCII 가 원래 문자값이며, 이를 char 로 치환한 값
                answer.append((char) (i + 'a'));
            }
        }

        return answer.toString();
    }

    public static String solution1(String[] strs) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String str : strs) {
            HashSet<String> set = new HashSet<>(Arrays.asList(str.split("")));
            for(String s : set) {
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }

        // 제일 큰 값을 알아냄
        int maxCount = 0;
        for (int count : map.values()) {
            maxCount = Math.max(maxCount, count);
        }

        // 제일 큰 값을 가진 문자열을 알아내고 리스트에 등록함
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            if (e.getValue() == maxCount) {
                list.add(e.getKey());
            }
        }

        // 알파벳 내림차순으로 정렬
        Collections.sort(list);

        // 문자를 문자열로 합함
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s);
        }

        return sb.toString();
    }
}
