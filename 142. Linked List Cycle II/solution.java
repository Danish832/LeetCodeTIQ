public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null || head.next==null)
        return null;

        ListNode slow = head, fast = head;
        ListNode entry = head ;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast) {
                while(entry!=slow){
                  entry = entry.next;
                  slow = slow.next;
                }
                return entry;

            }
        }
        
        return null;
    }
}