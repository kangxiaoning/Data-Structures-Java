/**
 * 因为在leetcode上，程序执行完后内存会销毁，不用太多顾及loitering objects的问题
 */
class Solution2 {
    public ListNode removeElements(ListNode head, int val) {

        // 删除链表最开始部分需要删除的元素
        while (head != null && head.val == val) {
            head = head.next;
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
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return head;
    }
}

