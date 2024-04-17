  class Solution {
    fun canJump(nums: IntArray): Boolean {

      val visited = MutableList(nums.size) { false }

      val deque = ArrayDeque<Int>()
      deque.addFirst(0)
      visited[0] = true

      while (deque.isNotEmpty()) {
        val curIdx = deque.removeLast()
        if (curIdx == nums.size - 1) return true

        val moveSteps = nums[curIdx]
        for (i in 0..moveSteps) {
          if (i + curIdx < nums.size && !visited[i + curIdx]) {
//            println("move $curIdx --> ${i + curIdx}")
            visited[i + curIdx] = true
            deque.addFirst(i + curIdx)
          }
        }
      }
      return false
    }
  }