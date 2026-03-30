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
          if (lists == null || lists.length == 0) {
            return null;
        }

        while (lists.length > 1) {
            List<ListNode> mergedLists = new ArrayList<>();
            for (int i = 0; i < lists.length; i += 2) {
                ListNode l1 = lists[i];
                ListNode l2 = (i + 1) < lists.length ? lists[i + 1] : null;
                mergedLists.add(merge(l1, l2));
            } // creating a mergedlist 
            lists = mergedLists.toArray(new ListNode[0]); // updating existing list with mergelist so that we again have to perform left operation that the previous or we try to reduce the time complextity of that
            
        }
        return lists[0];
    }
}
