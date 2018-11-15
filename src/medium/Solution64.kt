package medium

class Solution64 {
    fun minPathSum(grid: Array<IntArray>): Int {
        val dp = Array(grid.size) { IntArray(grid[0].size) }
        val numRow = dp.size
        val numCol = dp[0].size
        fun safeDp(row: Int, col: Int): Int {
            if (row > dp.size - 1 || col > dp[0].size - 1 || row < 0 || col < 0) {
                return Int.MAX_VALUE
            }
            return dp[row][col]
        }

        for (i in numRow - 1 downTo 0) {
            for (j in numCol - 1 downTo 0) {
                if (i == numRow - 1 && j == numCol - 1) {
                    dp[i][j] = grid[i][j]
                } else {
                    dp[i][j] = Math.min(safeDp(i + 1, j), safeDp(i, j + 1)) + grid[i][j]
                }
            }
        }
        return dp[0][0]
    }
}