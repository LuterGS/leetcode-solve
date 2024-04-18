  class Solution {

    fun isValidSudoku(board: Array<CharArray>): Boolean {
      val isNotCorrectSquare = listOf(
        0 to 0, 0 to 3, 0 to 6,
        3 to 0, 3 to 3, 3 to 6,
        6 to 0, 6 to 3, 6 to 6
      ).any {
        val checkMap = mutableMapOf<Char, Int>()
        for (i in 0..2) {
          for (j in 0..2) {
            checkMap.compute(board[it.first + i][it.second + j]) { _, ctr ->
              if (ctr == null) 1
              else ctr + 1
            }
          }
        }
        checkMap.remove('.')
        checkMap.values.any { ctr -> ctr > 1 }
      }

      if (isNotCorrectSquare) return false

      val checkX = mutableMapOf<Char, Int>()
      val checkY = mutableMapOf<Char, Int>()
      for (i in 0..8) {
        for (j in 0..8) {
          checkX.compute(board[i][j]) { _, ctr -> if (ctr == null) 1 else ctr + 1 }
          checkY.compute(board[j][i]) { _, ctr -> if (ctr == null) 1 else ctr + 1 }
        }
        checkX.remove('.')
        checkY.remove('.')
        if (checkX.values.any { ctr -> ctr > 1 }) return false
        if (checkY.values.any { ctr -> ctr > 1 }) return false
        checkX.clear()
        checkY.clear()
      }
      return true
    }
  }