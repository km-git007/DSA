class Solution {
    private int n, m, targetColor;
    private final int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private void fillColor(int row, int col, int color, int[][] image) {
        if(row < 0 || col < 0 || row >= n || col >= m || image[row][col] != color) {
            return;
        }
        
        // fill color
        image[row][col] = targetColor;
        
        for(int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            fillColor(newRow, newCol, color, image);
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color) {
            return image;
        }

        n = image.length;
        m = image[0].length;
        targetColor = color;
        
        fillColor(sr, sc, image[sr][sc], image);
        return image;
    }
}