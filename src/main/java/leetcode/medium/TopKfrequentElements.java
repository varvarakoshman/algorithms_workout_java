package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKfrequentElements {
    // O(n) time | O(n) space
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencies = new HashMap<>();
        int maxFreq = 0;
        for (int num : nums) {
            frequencies.put(num, frequencies.getOrDefault(num, 0) + 1);
            if (frequencies.get(num) > maxFreq) {
                maxFreq = frequencies.get(num);
            }
        }
        List<Integer>[] freqIndices = getFrequenciesIndices(frequencies, maxFreq);
        List<Integer> result = getTopK(freqIndices, k);
        return result.stream()
                .mapToInt(num -> num)
                .toArray();
    }

    private static List<Integer>[] getFrequenciesIndices(Map<Integer, Integer> frequencies, int maxFreq) {
        List<Integer>[] freqIndices = new List[maxFreq + 1];
        frequencies.forEach((num, freq) -> {
            if (freqIndices[freq] == null) {
                freqIndices[freq] = new ArrayList<>();
            }
            freqIndices[freq].add(num);
        });
        return freqIndices;
    }

    private static List<Integer> getTopK(List<Integer>[] freqIndices, int k) {
        List<Integer> result = new ArrayList<>();
        for (int i = freqIndices.length - 1; i > 0; i --) {
            if (freqIndices[i] != null) {
                List<Integer> elements = freqIndices[i];
                for (int elem: elements) {
                    result.add(elem);
                    if (result.size() == k) {
                        return result;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        topKFrequent(new int[]{1,1,1,2,2,3}, 2);
    }
}
