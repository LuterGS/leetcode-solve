  class Solution {
    fun reverse(x: Int): Int {
      if (x == 0) return 0

      val isPositive = x > 0

      val ansStr = abs(x).toString().reversed().trimStart { it == '0' }

      if (isPositive) {
        val intMaxStr = Int.MAX_VALUE.toString()
        if (ansStr.length < intMaxStr.length) {
          return ansStr.toInt()
        } else {
          var pointer = 0
          while (pointer < ansStr.length) {
            if (ansStr[pointer] > intMaxStr[pointer]) return 0
            if (ansStr[pointer] < intMaxStr[pointer]) break
            pointer += 1
          }
          return ansStr.toInt()
        }
      }else {
        val intMinStr = Int.MIN_VALUE.toString().removePrefix("-")
        if (ansStr.length < intMinStr.length) {
          return ansStr.toInt() * -1
        } else {
          var pointer = 0
          while (pointer < ansStr.length) {
            if (ansStr[pointer] > intMinStr[pointer]) return 0
            if (ansStr[pointer] < intMinStr[pointer]) break
            pointer += 1
          }
          return ansStr.toInt() * -1
        }
      }
    }
  }