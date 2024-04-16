  class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
      val counter: MutableMap<Int, Int> = mutableMapOf()
      nums.forEach {
        counter[it] = (counter[it] ?: 0) + 1
      }
//      println(counter)


      val answer: MutableSet<List<Int>> = mutableSetOf()
      val inherenceNums = counter.keys.toList()
      for (i in 0..inherenceNums.size - 2) {
        for (j in i + 1..inherenceNums.size - 1) {
          val desiredNum = -(inherenceNums[i] + inherenceNums[j])
          if (desiredNum != inherenceNums[i] && desiredNum != inherenceNums[j] && counter.containsKey(desiredNum)) {
            answer.add(listOf(inherenceNums[i],inherenceNums[j],desiredNum).sorted())
          }
        }
      }
      counter
        .filter { it.value >= 2 && it.key != 0 }
        .forEach {
          val desiredNum = -(2 * it.key)
          if (counter.containsKey(desiredNum)) {
            answer.add(listOf(it.key, it.key, desiredNum).sorted())
          }
        }

      if ((counter[0] ?: 0) >= 3) {
        answer.add(listOf(0, 0, 0))
      }

      return answer
        .toList()
    }
  }