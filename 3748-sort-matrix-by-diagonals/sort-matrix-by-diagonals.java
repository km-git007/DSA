class Solution {
    private void sortAndPopulate(int startRow, int startCol, int[][] mat, Comparator<int[]> comparator)
    {
        int i = startRow, j = startCol;
        int n = mat.length, m = mat[0].length;
        List<int[]> list = new ArrayList<>();
        while (i < n && j < m) {
            list.add(new int[]{mat[i][j], i, j});
            i++; j++;
        }

        // sort the list as per the comparator
        list.sort(comparator);

        // populate the matrix
        i = startRow;
        j = startCol;
        for(var cell : list) {
            mat[i][j] = cell[0];
            i++;
            j++;
        }
    }

    public int[][] sortMatrix(int[][] mat) {
        Comparator<int[]> comparator = (a, b) -> b[0] - a[0];
        int n = mat.length, m = mat[0].length;
        int row = n - 1;
        while (row >= 0) {
            sortAndPopulate(row, 0, mat, comparator);
            row--;
        }

        comparator = (a, b) -> a[0] - b[0];
        int col = 1;
        while (col < m) {
            sortAndPopulate(0, col, mat, comparator);
            col++;
        }
        return mat;
    }
}