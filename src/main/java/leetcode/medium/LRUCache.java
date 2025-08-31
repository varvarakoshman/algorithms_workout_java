package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private final  Map<Integer, Node> cache;
    private final int capacity;
    private Node mostRecent;
    private Node leastRecent;
    private int nodeCount;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.nodeCount = 0;
        this.cache = new HashMap<>();
    }

    public int get(int key) {
        if (!this.cache.containsKey(key)) {
            return -1;
        }
        Node target = this.cache.get(key);
        Node beforeTarget = target.prev;
        Node afterTarget = target.next;
        if (beforeTarget != null) {
            beforeTarget.next = afterTarget;
        }
        if (afterTarget != null) {
            afterTarget.prev = beforeTarget;
        }
        if (target.next != null) {
            this.leastRecent = target.next;
        }
        if (target != this.mostRecent) {
            target.prev = this.mostRecent;
            target.next = null;
            this.mostRecent = target;
        }
        return target.value;
    }

    public void put(int key, int value) {
        if (this.cache.containsKey(key)) {
            Node target = this.cache.get(key);
            if (target == this.leastRecent) {
                this.leastRecent = target.next;
            }
            removeNode(target);
        } else if (this.nodeCount == this.capacity) {
            Node oldLeastRecent = this.leastRecent;
            this.leastRecent = this.leastRecent.next;
            removeNode(oldLeastRecent);
        }
        Node newNode = new Node(key, value, this.mostRecent, null);
        insertNew(newNode);
    }

    private void insertNew(Node newNode) {
        if (this.mostRecent != null) {
            this.mostRecent.next = newNode;
        }
        this.mostRecent = newNode;
        this.cache.put(newNode.key, newNode);
        if (this.nodeCount == 0) {
            this.leastRecent = newNode;
        }
        this.nodeCount++;
    }

    private void removeNode(Node toRemove) {
        toRemove.next = null;
        toRemove.prev = null;
        this.cache.remove(toRemove.key);
        this.nodeCount--;
    }

    private static class Node {
        Node prev;
        Node next;
        int key;
        int value;

        Node(int key, int value, Node prev, Node next) {
            this.key = key;
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(2, 1);
        lruCache.put(1, 1);
        lruCache.put(2, 3);
        lruCache.put(4, 1);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
    }
}
