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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];

        while (lists.length > 1) {
            lists = mergeHalfList(lists);
        }

        return lists[0];
    }

    public ListNode[] mergeHalfList(ListNode[] lists){
        int i = 0, j = 0;

        ListNode[] temp = new ListNode[(lists.length + 1) / 2];
        while (true){
            if (i + 1 >= lists.length){
                if (i < lists.length) temp[j] = lists[i];
                return temp;
            }
            temp[j] = mergeTwoLists(lists[i], lists[i + 1]);
            j++;
            i += 2;
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        if (list1 != null) {
            tail.next = list1;
        } else {
            tail.next = list2;
        }
        return dummy.next;
    }
}