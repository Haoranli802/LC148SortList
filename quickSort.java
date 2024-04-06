class Solution {
     public ListNode sortList(ListNode head) {
        return quickSort(head, null);
    }

    private ListNode quickSort(ListNode head, ListNode tail) {
        if(head == null || head.next == null || head == tail) {
            return head;
        }
        boolean sorted = true;
        ListNode pivot = head;
        ListNode curr = pivot.next;
        ListNode prev = pivot;
        while(curr != null && curr != tail) {
            ListNode next = curr.next;
            if(curr.val < pivot.val) {
                sorted = false;
                prev.next = next;
                curr.next = head;
                head = curr;
            } else {
                if(curr.val < prev.val) {
                    sorted = false;
                }
                prev = curr;
            }
            curr = next;
        }
        if(sorted) {
            return head;
        }
        pivot.next = quickSort(pivot.next, tail);
        
        return quickSort(head, pivot);
    }
}
