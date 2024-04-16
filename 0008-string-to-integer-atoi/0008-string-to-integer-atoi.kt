  class Solution {
    fun myAtoi(s: String): Int {

      if (s.isEmpty()) {
        return 0
      }

      var pointer = 0

      // 1. read in and ignore any leading whitespace
      while (pointer < s.length && s[pointer] == ' ') {
        pointer += 1
      }
      if (pointer == s.length) return 0

      // Check if the next character (if not already at the end of the string) is '-' or '+'.
      val isPositive = if (s[pointer] == '-') {
        pointer += 1
        false
      } else if (s[pointer] == '+') {
        pointer += 1
        true
      } else {
        true
      }

      val nums = listOf('1', '2', '3', '4', '5', '6', '7', '8', '9', '0')
      val strAnswerBuilder = StringBuilder()
      while (pointer < s.length && nums.contains(s[pointer])) {
        strAnswerBuilder.append(s[pointer])
        pointer += 1
      }

      val strAnswer = strAnswerBuilder.toString().trimStart { it == '0' }


      when {
        strAnswer.length > Int.MAX_VALUE.toString().length -> return if (isPositive) Int.MAX_VALUE else Int.MIN_VALUE
        strAnswer.length < Int.MAX_VALUE.toString().length ->  {
          return if (strAnswer.isEmpty()) {
            0
          } else {
            strAnswer.toInt() * (if (isPositive) 1 else -1)
          }
        }
        else -> {
          var idx = 0
          val intMax = if (isPositive) Int.MAX_VALUE else Int.MIN_VALUE
          val intMaxStr = if (isPositive) intMax.toString() else intMax.toString().trimStart { it == '-' }
//          println("str $strAnswer , max $intMaxStr")
          while (idx < strAnswer.length) {
//            println("${strAnswer[idx]} | ${intMaxStr[idx]} | $idx")
            if (strAnswer[idx] > intMaxStr[idx]) return intMax
            if (strAnswer[idx] < intMaxStr[idx]) return strAnswer.toInt() * (if (isPositive) 1 else -1)
            idx += 1
          }
          return intMax

//          return strAnswer.toInt() * (if (isPositive) 1 else -1)
        }
      }
    }
  }