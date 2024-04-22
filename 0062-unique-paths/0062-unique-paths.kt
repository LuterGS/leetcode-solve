  class Solution {
    fun uniquePaths(m: Int, n: Int): Int {
      val dp: MutableList<MutableList<Int>> = MutableList(m) { MutableList(n) { 0 } }
      dp[0][0] = 1
      for (i in 0..<m) {
        for (j in 0..<n) {
          when {
            i == 0 && j == 0 -> continue
            i != 0 && j == 0 -> dp[i][j] = dp[i - 1][j]
            i == 0 && j != 0 -> dp[i][j] = dp[i][j - 1]
            else -> dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
          }
        }
      }
      return dp[m - 1][n - 1]
    }
  }