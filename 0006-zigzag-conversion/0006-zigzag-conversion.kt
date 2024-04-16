class Solution {
  fun convert(s: String, numRows: Int): String {
    
    if (numRows == 1) {
      return s
    } else {

      // create list of lines
      val lines: List<MutableList<Char>> = List(numRows) { mutableListOf() }
      
      s.windowed(numRows * 2 - 2, numRows * 2 - 2, true) {
        var index = 0
//      println(it)
        while (index < it.length) {
          if (index / numRows == 0) {
//          println("${index} append in lines[${index}], value ${it[index]}")
            lines[index].add(it[index])
          }
          else {
            val curIdx = numRows - (index % numRows) - 2
//          println("${index} append in lines[${curIdx}], value ${it[index]}  ${index % numRows}")
            lines[curIdx].add(it[index])
          }
          index += 1
        }
      }

      return lines.joinToString(separator = "") { it.joinToString(separator = "") }
    }

    
  }
}