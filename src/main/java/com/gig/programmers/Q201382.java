package com.gig.programmers;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author : JAKE
 * @date : 25. 12. 5.
 */
public class Q201382 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(
                new String[][]{{"horror", "drama", "SF"}, {"horror", "detective", "suspense"}, {"SF", "fantasy", "-"}},
                new String[]{"SF", "drama", "fantasy", "romance"})));
    }

    // 각 장르 별 책이 몇 권씩 존재하는지 알고 싶음
    // 각 책은 최대 3개의 장르를 가질수 있음
    // 하나의 책의 장르가 3개 미만이라면 부족한 인덱스는 전부 - 로 대체
    // queries 는 어떤 자을에 몇 개의 책이 존재하는지 질문하는 문자 배열
    // 장르에 책이 없다면 0 리턴
    public static int[] solution(String[][] genres, String[] queries) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String[] genre : genres) {
            for (String book : genre) {
                map.put(book, map.getOrDefault(book, 0) + 1);
            }
        }

        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            answer[i] = map.getOrDefault(queries[i], 0);
        }

        return answer;
    }
}
