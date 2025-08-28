class Solution {
    private void sortAndPopulate(int startRow, int startCol, int[][] mat)
    {
        int i = startRow, j = startCol;
        int n = mat.length, m = mat[0].length;
        List<int[]> list = new ArrayList<>();
        while (i < n && j < m) {
            list.add(new int[]{mat[i][j], i, j});
            i++; j++;
        }
        // sort the list
        list.sort(Comparator.comparingInt(a -> a[0]));
        
        // populate the matrix
        i = startRow;
        j = startCol;
        for(var cell : list) {
            mat[i][j] = cell[0];
            i++;
            j++;
        }
    }
    
    public int[][] diagonalSort(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int row = n - 1;
        while (row >= 0) {
            sortAndPopulate(row, 0, mat);
            row--;
        }
        
        int col = 1;
        while (col < m) {
            sortAndPopulate(0, col, mat);
            col++;
        }
        return mat;
    }
}