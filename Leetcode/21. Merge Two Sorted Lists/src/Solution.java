import java.util.ArrayList;
import java.util.Collections;

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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ArrayList<Integer> nums = new ArrayList<>();
        while (list1 != null) {
            nums.add(list1.val);
            list1 = list1.next;
        }
        while (list2 != null) {
            nums.add(list2.val);
            list2 = list2.next;
        }
        Collections.sort(nums);

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        for (int i = 0; i < nums.size(); i++) {
            curr.next = new ListNode(nums.get(i));
            curr = curr.next;
        }

        return dummy.next;
    }
}