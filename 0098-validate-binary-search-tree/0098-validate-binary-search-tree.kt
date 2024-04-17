  class Solution {
    fun isValidBST(root: TreeNode?): Boolean {

      if (root?.left == null && root?.right == null) return true

      val orderedNumber = ArrayDeque<Int>()
      val searchQueue = ArrayDeque<TreeNode?>()
      val leftQueue = ArrayDeque<Int>()
      val rightQueue = ArrayDeque<Int>()

      orderedNumber.addFirst(root.`val`)
      searchQueue.addFirst(root)

      while (searchQueue.isNotEmpty()) {
        val curNode = searchQueue.removeLast()
        if (curNode?.left != null) {
          while (orderedNumber.first() != curNode.`val`) {
            orderedNumber.removeFirst().let { leftQueue.addFirst(it) }
          }
          orderedNumber.addFirst(curNode.left!!.`val`)
          while (leftQueue.isNotEmpty()) {
            leftQueue.removeFirst().let { orderedNumber.addFirst(it) }
          }

          searchQueue.addFirst(curNode.left)
        }
        if (curNode?.right != null) {
          while (orderedNumber.last() != curNode.`val`) {
            orderedNumber.removeLast().let { rightQueue.addFirst(it) }
          }
          orderedNumber.addLast(curNode.right!!.`val`)
          while (rightQueue.isNotEmpty()) {
            rightQueue.removeFirst().let { orderedNumber.addLast(it) }
          }
          
          searchQueue.addFirst(curNode.right)
        }
      }

      println(orderedNumber)

      for (i in 0..orderedNumber.size - 2) {
        if (orderedNumber[i] >= orderedNumber[i + 1]) return false
      }
      return true
    }
  }