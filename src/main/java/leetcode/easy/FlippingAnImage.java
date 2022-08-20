package leetcode.easy;

public class FlippingAnImage {
    public int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;
        boolean isOdd = n % 2 != 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n/2; j++) {
                int temp = Math.abs(image[i][j] - 1);
                image[i][j] = Math.abs(image[i][n-1-j] - 1);
                image[i][n-1-j] = temp;
            }
            if (isOdd){
                image[i][n/2] = Math.abs(image[i][n/2] - 1);
            }
        }
        return image;
    }
}
