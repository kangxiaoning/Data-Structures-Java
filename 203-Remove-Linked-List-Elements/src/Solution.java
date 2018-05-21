
class Solution {
    public ListNode removeElements(ListNode head, int val) {

        // 删除链表最开始部分需要删除的元素
        while (head != null && head.val == val) {
            ListNode delNode = head;
            head = head.next;
            delNode.next = null;
        }

        // 删除完后为空
        if (head == null) {
            return null;
        }

        // 删除链表中间需要删除的元素
        ListNode prev = head;

        // 删除prev.next后，下一个可能依然需要删除，所以依然需要看是不是要删除
        while (prev.next != null) {
            if (prev.next.val == val) {
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            } else {
                prev = prev.next;
            }
        }
        return head;
    }
}

