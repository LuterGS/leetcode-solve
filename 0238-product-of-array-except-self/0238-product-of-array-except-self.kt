  class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
      if (nums.size == 2) {
        return intArrayOf(nums[1], nums[0])
      }

      val answer = MutableList(nums.size) { 0 }

      val leftCalculate: MutableList<Int?> = MutableList(nums.size) { null }
      leftCalculate[0] = nums[0]
      for (i in 1..nums.size - 1) {
        leftCalculate[i] = leftCalculate[i - 1]!! * nums[i]
      }

      val rightCalculate: MutableList<Int?> = MutableList(nums.size) { null }
      rightCalculate[nums.size - 1] = nums[nums.size - 1]
      for (i in 1..nums.size - 1) {
        val revIdx = nums.size - 1 - i
        rightCalculate[revIdx] = rightCalculate[revIdx + 1]!! * nums[revIdx]
      }

      for (i in 0..nums.size - 1) {
        answer[i] = when (i) {
          0 -> rightCalculate[1]!!
          nums.size - 1 -> leftCalculate[nums.size - 2]!!
          else -> leftCalculate[i - 1]!! * rightCalculate[i + 1]!!
        }
      }
//      println(leftCalculate)
//      println(rightCalculate)
//      println(answer)
      return answer.toIntArray()
    }
  }