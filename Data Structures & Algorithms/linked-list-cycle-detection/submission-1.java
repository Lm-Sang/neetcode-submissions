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
        HashSet<Integer, Boolean> map = new HashMap<>();
        while (head != null){
            if (!map.containsKey(head.val)) {
                map.put(head.val, false);
                head = head.next;
                continue;
            }
            else{
                if (map.get(head.val) == true) return true;
                map.get(head.val) = true;
            }
        }
        return false;
    }
}
