  class Solution {
    fun searchRange(nums: IntArray, target: Int): IntArray {
      if (nums.isEmpty()) return intArrayOf(-1, -1)

      var firstIdx: Int = -1
      var lastIdx: Int = -1

      nums.forEachIndexed { index, i ->
        if (firstIdx == -1 && i == target) {
          firstIdx = index
        }
        if (i == target) {
          lastIdx = index
        }
      }
      return intArrayOf(firstIdx, lastIdx)
    }
  }