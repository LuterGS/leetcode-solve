  class Solution {
    fun trap(height: IntArray): Int {
      val max = height.max()

      if (max == 0) return 0

      var answer = 0

      for (i in 1..max) {
        val left = height.indexOfFirst { it >= i }
        val right = height.indexOfLast { it >= i }
        val count = height.count { it >= i }
        if (left != -1 && right != -1 && left < right - 1) {
          answer += (right - left - 1) - (count - 2)
        }
      }

      return answer
    }
  }