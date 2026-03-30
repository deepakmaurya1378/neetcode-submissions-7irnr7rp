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

    public static ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode next;
        ListNode prev=null;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;

        }
        return prev;
    }
    public void reorderList(ListNode head) {
       if (head == null || head.next == null) return;


        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode second = reverse(slow.next);
        slow.next = null;
        

        while(second != null){
            ListNode t1 =  head.next;
            ListNode t2 = second.next;

            head.next = second;
            head.next.next = t1;

            second = t2;
            head = head.next.next;
        }
        return;

    }
}
