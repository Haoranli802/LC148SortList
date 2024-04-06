class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode temp = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(temp);
        ListNode dummy = new ListNode(-1);
        ListNode res = dummy;
        while(left != null && right != null){
            if(left.val > right.val){
                dummy.next = right;
                right = right.next;
            }
            else{
                dummy.next = left;
                left = left.next;
            }
            dummy = dummy.next;
        }
        dummy.next = left == null ? right : left;
        return res.next;
    }
}
/**
(NlogN), O(logN)
 */
