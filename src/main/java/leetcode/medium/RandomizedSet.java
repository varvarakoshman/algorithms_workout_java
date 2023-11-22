package leetcode.medium;

import java.util.*;

public class RandomizedSet {

    private final Map<Integer, Integer> map;
    private final List<Integer> elements;

    private final Random random;

    public RandomizedSet() {
        this.map = new HashMap<>();
        this.elements = new ArrayList<>();
        this.random = new Random();
    }

    // O(1) time | O(1) space
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        } else {
          elements.add(val);
          map.put(val, elements.size() - 1);
          return true;
        }
    }

    // O(1) time | O(1) space
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        } else {
            int indexToReplace = map.get(val);
            int lastIndex = elements.size() - 1;
            int lastElement = elements.get(lastIndex);
            elements.set(indexToReplace, lastElement);
            map.put(lastElement, indexToReplace);
            elements.remove(lastIndex);
            map.remove(val);
            return true;
        }
    }

    // O(1) time | O(1) space
    public int getRandom() {
        return elements.get(random.nextInt(elements.size()));
    }
}
