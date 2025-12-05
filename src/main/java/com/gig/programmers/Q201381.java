package com.gig.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author : JAKE
 * @date : 25. 12. 5.
 */
public class Q201381 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"bfs", "sort", "bruteforce", "hash", "bfs", "dfs", "sort", "sort"})));
    }

    public static String[] solution(String[] folder_names) {
        String[] answer = new String[folder_names.length];
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < folder_names.length; i++) {
            if (map.containsKey(folder_names[i])) {
                answer[i] = folder_names[i] + "_" + map.get(folder_names[i]);
                map.replace(folder_names[i], map.get(folder_names[i]) + 1);
            } else {
                answer[i] = folder_names[i];
                map.put(folder_names[i], 1);
            }
        }

        return answer;
    }

    public static String[] solution1(String[] folder_names) {
        HashMap<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        for (String folder : folder_names) {
            if (map.containsKey(folder)) {
                map.put(folder, map.get(folder) + 1);
            } else {
                map.putIfAbsent(folder, 0);
            }

            if (map.get(folder) > 0) {
                list.add(folder + "_" + map.get(folder));
            } else {
                list.add(folder);
            }
        }
        return list.toArray(new String[0]);
    }
}
