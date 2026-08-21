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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode current = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val + l2.val > 9){
                current.next = new ListNode((l1.val + l2.val) % 10);
                current = current.next;
                current.next = new ListNode((l1.val + l2.val) / 10);
                current = current.next;
            }
            else {
                current.next = new ListNode(l1.val + l2.val);
                current = current.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return dummy.next;
    }
}
