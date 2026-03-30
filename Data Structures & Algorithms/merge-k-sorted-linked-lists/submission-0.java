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
    private ListNode merge(ListNode l1, ListNode l2){
        if(l1 == null) return  l2;
        if(l2 == null) return l1;

        ListNode dummy = new ListNode();
        ListNode curr =  dummy;

        while( l1 != null && l2 != null){
            if(l1.val > l2.val){
                curr.next = l2;
                l2 = l2.next;
            }
            else{
                curr.next = l1;
                l1 = l1.next;
            }
            curr = curr.next;
        }

        if (l1 != null) curr.next = l1;
        if (l2 != null) curr.next = l2;

        return dummy.next;
            
    }
    public ListNode mergeKLists(ListNode[] lists) {
          int n = lists.length;
          ListNode dummy = new ListNode(0);
          ListNode curr = dummy;
          if (n == 0) return dummy.next;
          if(n < 2 ) return lists[0];

          for(int i = 0; i < n-1; i++){            
           lists[i+1] =  merge(lists[i] , lists[i+1]);
          }
          return lists[n-1];
    }
}
