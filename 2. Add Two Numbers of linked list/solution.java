import java.util.* ;
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public void addLast(int data,ListNode head){
        ListNode newNode = new ListNode(data);
        ListNode currNode=head;
        while(currNode.next!=null){
            currNode = currNode.next;
        }
        currNode.next = newNode;


    }

    static public void printList(ListNode head){

        ListNode currNode = head;
        while(currNode!=null){
            System.out.print(currNode.val+" -> ");
            currNode = currNode.next;
        }
        System.out.println("NULL");
    }


    public static void main(String args[]){
        ListNode list1 = new ListNode(2);
        list1.addLast(4,list1);
        list1.addLast(3,list1);

        ListNode list2 = new ListNode(5);
        list2.addLast(6,list2);
        list2.addLast(4,list2);

        
        // printList(list1);
        // printList(list2);
        Solution s = new Solution() ;
        ListNode newHead = s.addnumbers(list1,list2);
        printList(newHead);


    }
}

class Solution {
    public ListNode addnumbers(ListNode l1, ListNode l2) {
        ListNode dummy  = new ListNode();
        ListNode temp = dummy ;
        int carry= 0 ;
        while(l1!=null || l2!=null || carry==1){
            int sum = 0 ;
            if(l1!=null){
                sum+=l1.val ;
                l1 = l1.next ;
            }

            if(l2!=null){
                sum+=l2.val ;
                l2 = l2.next ;
            }

            sum+=carry ;
            carry = sum/10 ;
            ListNode node = new ListNode(sum%10);
            temp.next = node ;
            temp = temp.next ;

        }

        return dummy.next ;
    }
}