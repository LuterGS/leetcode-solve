  class Solution {
    fun maxArea(height: IntArray): Int {

      fun getBoxSize(x: Int, y: Int): Int {
        return min(height[x], height[y]) * (y - x)
      }

      // two-pointer
      var (x, y) = 0 to height.size - 1
      val currentBoxSize = getBoxSize(x, y)
      var answer = currentBoxSize

      while (x < y) {
//        println("current x $x, y $y")

        if (height[x] <= height[y]) {
//          println("get height[x] <= height[y]")
          val tempX = x
          while (x < y) {
            if (height[x] > height[tempX]) {
              break
            }
            x += 1
          }
          val boxSize = getBoxSize(x, y)
          if (boxSize > answer) {
            answer = boxSize
          }
        }

        if (height[x] > height[y]) {
//          println("get height[x] > height[y]")
          val tempY = y
          while (x < y) {
            if (height[y] > height[tempY]) {
              break
            }
            y -= 1
          }
          val boxSize = getBoxSize(x, y)
          if (boxSize > answer) {
            answer = boxSize
          }
        }

      }

      return answer
    }
  }