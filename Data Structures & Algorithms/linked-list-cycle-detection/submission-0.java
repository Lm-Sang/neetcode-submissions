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
    public boolean hasCycle(ListNode head) {
        HashSet<Integer> map = new HashSet<>();
        while (head != null){
            if (!map.contains(head.val)) {
                map.add(head.val);
                head = head.next;
                continue;
            }
            else{
                return true;
            }
        }
        return false;
    }
}
