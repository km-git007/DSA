class Solution {
    private int n, m, targetColor;
    private final int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private void fillColor(int row, int col, int color, int[][] image){
        if(row < 0 || col < 0 || row >= n || col >= m || image[row][col] != color){
            return;
        }

        image[row][col] = targetColor;

        for(int[] dir : directions) {
            int nextRow = row + dir[0];
            int nextCol = col + dir[1];
            fillColor(nextRow, nextCol, color, image);
        }

    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        targetColor = color;
        if(image[sr][sc] == color) {
            return image;
        }

        n = image.length;
        m = image[0].length;
        fillColor(sr, sc, image[sr][sc], image);
        return image;
    }
}