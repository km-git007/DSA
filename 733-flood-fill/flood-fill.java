class Solution {
    private int newColor, color, n, m;
    private final int [][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    private void dfs(int row,int col, int[][] image)
    {
        if( row < 0 || row >=n || col <0 || col>=m || image[row][col]!=color )
        return;

        image[row][col]=newColor;

        for(int[] direction : directions)
        dfs(row+direction[0],col+direction[1],image);
        
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        if (image[sr][sc] == newColor)     
        return image;
        
        // color which will get applied.
        this.newColor = newColor;
        // original color of the grid.
        this.color = image[sr][sc];
        n = image.length;
        m = image[0].length;

        dfs(sr, sc, image);

        return image;
    }
}