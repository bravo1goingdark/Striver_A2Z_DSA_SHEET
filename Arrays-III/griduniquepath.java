public class griduniquepath {
    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m + 1][n + 1];
        return mazedestcount(m, n, memo);
    }
    
    static int mazedestcount(int row, int col, int[][] memo) {
        if (row == 1 || col == 1) {
            return 1;
        }
    
        if (memo[row][col] != 0) {
            return memo[row][col];
        }
    
        int left = mazedestcount(row - 1, col, memo);
        int right = mazedestcount(row, col - 1, memo);
    
        memo[row][col] = left + right;
        return memo[row][col];
    }
}
