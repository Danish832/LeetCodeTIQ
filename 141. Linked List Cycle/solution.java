public class Solution {
    public boolean hasCycle(ListNode head) {

        if(head==null || head.next==null)
        return false;

        ListNode slow = head, fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast) 
                return true;
        }
        
        return false;

    }
}

// Intuition of above approach = If two men a running in a circular track and one man is running faster than the other 
// then they are surely going meet each other after a certain time 

// Another approach  - Use HashSet