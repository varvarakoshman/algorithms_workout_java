package leetcode.medium;

import java.util.*;

public class GroupAnagrams {

    private static final char ALPHABET_START = 'a';

//    public static List<List<String>> groupAnagrams(String[] strs) {
//        Map<String, List<String>> groupedAnagrams = new HashMap<>();
//        for (String word : strs) {
//            char[] letterFrequencies = new char[26];
//            for (char letter : word.toCharArray()) {
//                int index = letter - ALPHABET_START;
//                letterFrequencies[index] += 1;
//            }
//            String hash = String.valueOf(letterFrequencies);
//            if (!groupedAnagrams.containsKey(hash)) {
//                groupedAnagrams.put(hash, new ArrayList<>());
//            }
//            groupedAnagrams.get(hash).add(word);
//        }
//        return groupedAnagrams.values().stream()
//                .toList();
//    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        char START = 'a';
        Map<String, List<String>> map = new HashMap<>();
        for (String str: strs) {
            int[] frequencies = new int[26];
            for (char letter: str.toCharArray()) {
                frequencies[letter - START] += 1;
            }
            String key = String.valueOf(frequencies);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        return map.values().stream().toList();
    }

    public static void main(String[] args) {
        groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
    }
}
