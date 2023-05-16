package leetcode.medium;

import java.util.*;

public class ValidateSudoku {

    public static boolean isValidSudoku(char[][] board) {
        List<Set<Character>> rows = getSudokuLines();
        List<Set<Character>> cloumns = getSudokuLines();
        List<List<Set<Character>>> squares = getSudokuSquares();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char currElem = board[i][j];
                if (!Objects.equals('.', currElem)) {
                    Set<Character> currRow = rows.get(i);
                    Set<Character> currColumn = cloumns.get(j);
                    Set<Character> currSquare = squares.get(i / 3).get(j / 3);
                    boolean isValid = isValidElement(currRow, currElem) && isValidElement(currColumn, currElem)
                            && isValidElement(currSquare, currElem);
                    if (!isValid) {
                        return false;
                    }
                }
            }
        }
        return true;
    }


    private static List<Set<Character>> getSudokuLines() {
        List<Set<Character>> line = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            line.add(new HashSet<>());
        }
        return line;
    }

    private static List<List<Set<Character>>> getSudokuSquares() {
        List<List<Set<Character>>> squares = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            List<Set<Character>> square = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                square.add(new HashSet<>());
            }
            squares.add(square);
        }
        return squares;
    }

    private static boolean isValidElement(Set<Character> existingElements, char newElem) {
        if (existingElements.contains(newElem)) {
            return false;
        }
        existingElements.add(newElem);
        return true;
    }

    public static void main(String[] args) {
        char[][] input = new char[][]{{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println(isValidSudoku(input));
    }
}
