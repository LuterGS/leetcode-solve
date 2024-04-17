  class Solution {
    fun numDecodings(s: String): Int {
      if (s.startsWith("0")) return 0
      if (s.endsWith("00")) return 0

      val lists = mutableListOf<String>()
      val strBuilder = StringBuilder()
      for (c in s) {
        strBuilder.append(c)
        if (c == '0') {
          lists.add(strBuilder.toString())
          strBuilder.clear()
        }
      }
      if (strBuilder.isNotEmpty()) {
        lists.add(strBuilder.toString())
      }

      val dp = mutableListOf<MutableList<Int>>()
      lists.forEach {
        dp.add( MutableList(it.length) { -1 } )
      }



      fun chunkRecursive(chunk: String, idx: Int): Int {
        if (chunk.length == 1) return 1
        if (chunk.length == 2) {
          return if (chunk.toInt() <= 26) {
            2
          } else {
            1
          }
        }

        dp[idx][0] = 1
        dp[idx][1] = if (chunk.substring(0, 2).toInt() <= 26) {
          2
        } else {
          1
        }

        for (i in 2..chunk.length - 1) {
          val sliced = chunk.substring(i - 1, i + 1)
          if (sliced.toInt() <= 26) {
            dp[idx][i] = dp[idx][i - 1] + dp[idx][i - 2]
          } else {
            dp[idx][i] = dp[idx][i - 1]
          }
        }

        return dp[idx][chunk.length - 1]
      }

      fun calculateChunk(chunk: String, idx: Int): Int {
        if (chunk.isEmpty() || chunk.isBlank()) return 0

        var answer = 0
        if (chunk.last() == '0') {
          if (chunk[chunk.length - 2].digitToInt() > 2) return 0
          val newChunk = chunk.substring(0, chunk.length - 2)
          answer += if (newChunk == "") {
            1
          } else {
            chunkRecursive(newChunk, idx)
          }
        } else {
          answer += chunkRecursive(chunk, idx)
        }
        return answer
      }

      return if (lists.contains("0")) 0
      else {
        lists
          .mapIndexed { index, str -> calculateChunk(str, index) }
          .reduce { a, b -> a * b }
      }
    }
  }