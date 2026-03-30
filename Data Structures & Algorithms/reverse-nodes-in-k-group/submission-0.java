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
        ListNode dummy = new ListNode(0, head);
        ListNode groupPrev = dummy;

        while(true){
            ListNode Kth = getkth( groupPrev , k );
            if (Kth == null){
                break;
            }

            ListNode groupNext = Kth.next;

            ListNode prev = Kth.next;
            ListNode curr = groupPrev.next;

            while(curr != groupNext){
                ListNode tmp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = tmp;
            }

            ListNode temp = groupPrev.next;
            groupPrev.next = Kth;
            groupPrev = temp;
        }

        return dummy.next;
    }
    private ListNode getkth(ListNode h , int k){
        while(k > 0 && h != null){
            h= h.next;
            k--;
        }
        return h;
    }
}
