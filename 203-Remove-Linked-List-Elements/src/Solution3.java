/**
 * 因为在leetcode上，程序执行完后内存会销毁，不用太多顾及loitering objects的问题
 */
class Solution3 {
    public ListNode removeElements(ListNode head, int val) {

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        // 删除链表中间需要删除的元素
        ListNode prev = dummyHead;

        // 删除prev.next后，下一个可能依然需要删除，所以依然需要看是不是要删除
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return dummyHead.next;
    }
}

