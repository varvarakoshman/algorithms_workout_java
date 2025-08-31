package leetcode.medium;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        Queue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(intervals[0][1]);
        int roomsCount = 1;
//        Pair<Integer, Integer> pair = new Pair<>();
        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            if (minHeap.peek() > curr[0]) {
                roomsCount++;
            } else {
                minHeap.poll();
            }
            minHeap.add(curr[1]);
        }
        return roomsCount;
    }
}
