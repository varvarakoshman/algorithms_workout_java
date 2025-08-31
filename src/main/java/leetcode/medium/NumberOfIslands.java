package leetcode.medium;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int count = 0;
        Set<Map.Entry<Integer, Integer>> visited = new HashSet<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                Map.Entry<Integer, Integer> point = Map.entry(i, j); //!!!
                if (!visited.contains(point)) {
                    dfs(grid, point, visited);
                    count += 1;
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, Map.Entry<Integer, Integer> point, Set<Map.Entry<Integer, Integer>> visited) {
        int row = point.getKey();
        int column = point.getValue();
        if (row < 0 || row >= grid.length || column < 0 || column >= grid[0].length || visited.contains(point)
                || grid[row][column] == '0') {
            return;
        }
        visited.add(point);
        dfs(grid, Map.entry(row + 1, column), visited);
        dfs(grid, Map.entry(row - 1, column), visited);
        dfs(grid, Map.entry(row, column + 1), visited);
        dfs(grid, Map.entry(row, column - 1), visited);
    }
}
