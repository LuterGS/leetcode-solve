  class Solution {
    fun isValidBST(root: TreeNode?): Boolean {
      if (root?.left == null && root?.right == null) return true

      class LinkedNode (val value: Int?) {
        var next: LinkedNode? = null
        var before: LinkedNode? = null
      }

      val searchQueue = ArrayDeque<TreeNode?>()
      searchQueue.addFirst(root)
      val rootLink = LinkedNode(root.`val`)
      val start = LinkedNode(null)
      start.next = rootLink
      rootLink.before = start
      val end = LinkedNode(null)
      end.before = rootLink
      rootLink.next = end

      while (searchQueue.isNotEmpty()) {
        val curNode = searchQueue.removeLast()
        if (curNode?.left != null) {
          var index = start
          while (index.value != curNode.`val`) {
            index = index.next!!
          }
          val newNode = LinkedNode(curNode.left!!.`val`)
          val before = index.before
          before?.next = newNode
          index.before = newNode
          newNode.before = before
          newNode.next = index
          searchQueue.addFirst(curNode.left)
        }
        if (curNode?.right != null) {
          var index = end
          while (index.value != curNode.`val`) {
            index = index.before!!
          }
          val newNode = LinkedNode(curNode.right!!.`val`)
          val next = index.next
          index.next = newNode
          next?.before = newNode
          newNode.before = index
          newNode.next = next
          searchQueue.addFirst(curNode.right)
        }
      }

      var start1 = start.next
      var start2 = start.next?.next

      while (start2?.value != null) {
        if (start1!!.value!! >= start2.value!!) return false
        start1 = start1.next
        start2 = start2.next
      }


      return true
    }
  }