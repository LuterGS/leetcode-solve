  class Solution {
    fun threeSumClosest(nums: IntArray, target: Int): Int {

      var diff = 9999999
      var answer = 10
      
      for (i in 0..nums.size - 3) {
        for (j in i + 1..nums.size - 2) {
          for (k in j + 1..nums.size - 1) {
            val ans = nums[i] + nums[j] + nums[k]
            val tempDiff = abs(target - ans)
            if (tempDiff < diff) {
              diff = tempDiff
              answer = ans
            }
            
          }
        }
      }
      
      return answer
    }
  }