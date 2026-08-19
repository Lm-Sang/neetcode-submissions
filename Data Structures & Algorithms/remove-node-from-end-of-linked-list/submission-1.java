/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head;
        ListNode prev = null;
        if (curr.next == null) return null;
        for (int i = 1; i <= n; i++){
            prev = curr;
            curr = curr.next;
        }
        if (curr == null) prev.next = null;
        prev.next = curr.next;

        return head;
    }
}
