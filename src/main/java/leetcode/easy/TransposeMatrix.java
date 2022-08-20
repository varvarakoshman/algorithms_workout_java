package leetcode.easy;

public class TransposeMatrix {
    public int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] matrixT = new int[n][m];
        for (int i=0; i < m; i++) {
            for (int j=0; j < n; j++) {
                matrixT[j][i] = matrix[i][j];
            }
        }
        return matrixT;
    }
}
