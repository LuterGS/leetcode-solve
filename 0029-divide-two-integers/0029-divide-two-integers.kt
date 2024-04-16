  class Solution {
    fun divide(dividend: Int, divisor: Int): Int {
      if (dividend == Int.MIN_VALUE && divisor == -1) return Int.MAX_VALUE
      if (dividend == 0) return 0

      var modifiableDividend = dividend
      val positiveDivisor = abs(divisor)
      var answer = 0
      if (dividend > 0) {
        while (modifiableDividend > 0) {
          modifiableDividend -= positiveDivisor
          answer += 1
        }
        if (modifiableDividend < 0) answer -= 1
        
        return if (divisor > 0) answer
        else answer * -1
      } else {
        while (modifiableDividend < 0) {
          modifiableDividend += positiveDivisor
          answer += 1
        }
        if (modifiableDividend > 0) answer -= 1
        
        return if (divisor < 0) answer
        else answer * -1
      }
    }
  }