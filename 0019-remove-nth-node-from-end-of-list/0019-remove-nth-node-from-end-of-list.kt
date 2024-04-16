  class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
      var previous: ListNode? = ListNode(-99).apply { this.next = head }
      var exact = head
      var next = head

      // length is 1
      if (exact?.next == null) return null

      // length is 2
      if (exact.next?.next == null) {
        return if (n == 2) {
          exact.next
        } else {
          head.apply { this?.next = null }
        }
      }

      repeat(n - 1) {
        next = next?.next
      }

      while (next?.next != null) {
        previous = previous?.next
        exact = exact?.next
        next = next?.next
      }

      return if (previous?.`val` == -99) {
        head?.next
      } else {
        previous?.next = exact?.next
        head
      }
    }
  }