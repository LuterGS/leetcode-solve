  class Solution {
    fun intToRoman(num: Int): String {
      val symbolValues = listOf(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1)
      val symbols = listOf("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I")

      val answer = StringBuilder()
      var n = num
      for (i in 0..symbols.size - 1) {
        println("num $n, $i")
        repeat(n / symbolValues[i]) {
          answer.append(symbols[i])
        }
        n %= symbolValues[i]
      }
      return answer.toString()
    }
  }