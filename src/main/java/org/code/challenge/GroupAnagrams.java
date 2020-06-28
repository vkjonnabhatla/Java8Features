package org.code.challenge;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Given an array of strings, group anagrams together.
 *
 * Example:
 *
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * Note:
 *
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 */
public class GroupAnagrams {

    public static void main(String[] args) {
        String[] strings = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strings));
        System.out.println(groupAnagramsWithCollectors(strings));
    }

    public static List<List<String>> groupAnagrams(String[] strs){
        //Base case
        if(strs == null && strs.length == 0){
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++){
            String str = sort(strs[i].toCharArray());
            List l = map.get(str);
            if(l == null){
                l = new ArrayList();
                map.put(str, l);
            }
            l.add(strs[i]);
        }
        return new ArrayList(map.values());
    }

    private static String sort(char[] toCharArray) {
        Arrays.sort(toCharArray);
        return new String(toCharArray);
    }

    // Implementation using Collectors groupBy methods
    public static List<List<String>> groupAnagramsWithCollectors(String[] strs){

        //Base case

        if(strs == null || strs.length == 0){
            return new ArrayList<>();
        }
        Map<String, List<String>> map = Stream.of(strs)
                .collect(Collectors.groupingBy(str -> sort(str.toCharArray())));

        System.out.println(map);
        System.out.println(map.values());
        return new ArrayList<>(map.values());

    }

}
