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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode beforeGroup = dummyHead;
        ListNode curr = head;

        while (curr != null) {
            ListNode groupStart = curr;
            int i = 1;

            while (i < k && curr != null) {
                curr = curr.next;
                i++;
            }
            
            if (curr == null) {
                break;
            }
            ListNode nextGroup = curr.next;
            curr.next = null;
            ListNode reversedHead = reverseList(groupStart);
            beforeGroup.next = reversedHead;
            groupStart.next = nextGroup;
            beforeGroup = groupStart;
            curr = nextGroup;
        }

        return dummyHead.next;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}