  class Solution {
    fun generateParenthesis(n: Int): List<String> {
      val arr = MutableList(n + 1) { mutableSetOf<String>() }
      arr[1].add("()")

      fun plusTwo(x: Int, y: Int): MutableSet<String> {
        val res = mutableSetOf<String>()
        arr[x].forEach { ax ->
          arr[y].forEach { ay ->
            res.add("$ax$ay")
          }
        }
        return res
      }

      if (n == 1) return arr[1].toList()

      for (i in 2..n) {
        // get all elements
        var (divX, divY) = 1 to i - 1
        while (divY >= 1) {
          arr[i].addAll(plusTwo(divX, divY))
          divX += 1
          divY -= 1
        }
        arr[i - 1].forEach {
          arr[i].add("($it)")
        }

      }

      return arr[n].toList()
    }
  }