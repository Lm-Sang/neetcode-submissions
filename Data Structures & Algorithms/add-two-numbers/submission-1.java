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
        int temp = 0;
        while (l1 != null && l2 != null) {
            current.next = new ListNode((l1.val + l2.val) % 10 + temp);
            temp = (l1.val + l2.val) / 10;
            current = current.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        int temp1 = 0;
        while (l1 != null){
            current.next = new ListNode((l1.val + temp) % 10);
            temp1 = (l1.val + temp) / 10;
            current = current.next;
            l1 = l1.next;
        }
        while (l2 != null){
            current.next = new ListNode((l2.val + temp) % 10);
            temp1 = (l2.val + temp) / 10;
            current = current.next;
            l2 = l2.next;
        }
        if (temp != 0){
            current.next = new ListNode(temp);
        }
        if (temp1 != 0){
            current.next = new ListNode(temp1);
            current = current.next;
        }
        return dummy.next;
    }
}
