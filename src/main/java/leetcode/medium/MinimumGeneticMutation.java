package leetcode.medium;

import java.util.*;

//
public class MinimumGeneticMutation {
    private static final char[] POSSIBLE_LETTERS = new char[]{'A', 'T', 'G', 'C'};

    public int minMutation(String startGene, String endGene, String[] bank) {
        Queue<String> queue = new ArrayDeque<>();
        queue.add(startGene);
        Set<String> seen = new HashSet<>();
        int stepsCount = 0;

        while (!queue.isEmpty()) {
            int nodesOnLevel = queue.size();
            for (int j=0; j < nodesOnLevel; j++) {
                String currMutation = queue.poll();
                if (Objects.equals(currMutation, endGene)) {
                    return stepsCount;
                }
                for (int i=0; i < currMutation.length(); i++) {
                    for (char letter: POSSIBLE_LETTERS) {
                        String newMutation = currMutation.substring(0, i) + letter + currMutation.substring(i + 1, currMutation.length());

                        if (!seen.contains(newMutation) && isContainedInBank(bank, newMutation)) {
                            seen.add(newMutation);
                            queue.add(newMutation);
                        }
                    }
                }
            }
            stepsCount++;
        }
        return -1;
    }

    private boolean isContainedInBank(String[] bank, String mutation) {
        for (String allowed: bank) {
            if (Objects.equals(mutation, allowed)) {
                return true;
            }
        }
        return false;
    }
}
