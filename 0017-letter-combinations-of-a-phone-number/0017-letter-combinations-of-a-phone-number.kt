  class Solution {
    fun letterCombinations(digits: String): List<String> {

      if (digits == "") {
        return listOf()
      }

      val strs: List<List<Char>> = listOf(
        listOf(),
        listOf(),
        listOf('a', 'b', 'c'),
        listOf('d', 'e', 'f'),
        listOf('g', 'h', 'i'),
        listOf('j', 'k', 'l'),
        listOf('m', 'n', 'o'),
        listOf('p', 'q', 'r', 's'),
        listOf('t', 'u', 'v'),
        listOf('w', 'x', 'y', 'z'),
      )

      val res = digits.map { strs[it.digitToInt()] }
      val pointer = MutableList(digits.length) { 0 }
      val answer = mutableListOf<String>()
//      println(res)

      while (true) {
//        println(pointer)

        val tempAns = StringBuilder()
        for (i in 0..res.size - 1) {
          tempAns.append(res[i][pointer[i]])
        }
        answer.add(tempAns.toString())

        var breakPoint = true
        for (i in 0..res.size - 1) {
          if (pointer[i] != res[i].size - 1) {
            breakPoint = false
            break
          }
        }
        if (breakPoint) {
//          println("break!")
          break
        }

        pointer[pointer.size - 1] += 1

        for (i in 0..res.size - 1) {
          val revIndex = res.size - 1 - i
          if (pointer[revIndex] == res[revIndex].size) {
            pointer[revIndex] = 0
            pointer[revIndex - 1] += 1
          }
        }
      }


      return answer
    }
  }