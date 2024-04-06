class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        int len = getLen(head);
        ListNode dummy = new ListNode(-1, head);
        int interval = 1;
        while(interval < len){
            ListNode pre = dummy;
            ListNode cur = dummy.next;
            while(cur != null){
                ListNode h1 = cur;
                ListNode h2 = split(interval, h1);
                cur = split(interval, h2);
                pre = mergeNode(pre, h1, h2);
            }
            interval *= 2;
        }
        return dummy.next;
    }
    private ListNode split(int interval, ListNode head){
        if(head == null) return null;
        ListNode cur = head;
        while(interval > 1 && cur != null){
            cur = cur.next;
            interval--;
        }
        if(cur == null) return null;
        ListNode temp = cur.next;
        cur.next = null;
        return temp;
    }
    private int getLen(ListNode head){
        int length = 0;
        ListNode curr = head;
        while (curr != null) {
            length++;
            curr = curr.next;
        }
        return length;
    }
    private ListNode mergeNode(ListNode prev, ListNode l1, ListNode l2){
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        prev.next = l1 != null ? l1 : l2;

        while (prev.next != null) {
            prev = prev.next;
        }

        return prev;
    }
}
