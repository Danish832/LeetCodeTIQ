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
        ListNode list1 = new ListNode(1);
        list1.addLast(2,list1);
        list1.addLast(4,list1);

        ListNode list2 = new ListNode(1);
        list2.addLast(3,list2);
        list2.addLast(4,list2);

        printList(list1);
        printList(list2);

        Solution s = new Solution() ;
        ListNode newHead = s.mergeTwoLists(list1,list2);
        printList(newHead);


    }
}

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode curr1 = list1 ;
        ListNode curr2 = list2 ;


        ListNode newList = new ListNode() ;
        ListNode dummy = newList ;


        boolean end = true ;
        while(end){
            if(curr1.val <= curr2.val){
                dummy.next = curr1 ;
                dummy = dummy.next;
                if(curr1.next==null){
                    while(curr2!=null){
                        dummy.next = curr2 ;
                        dummy = dummy.next ;
                        curr2 = curr2.next ;

                    }
                    end = false ;
                }
                else
                    curr1 = curr1.next ;
            }

            else if(curr1.val >= curr2.val){
                dummy.next = curr2 ;
                dummy = dummy.next;
                if(curr2.next==null){
                    while(curr1!=null){
                        dummy.next = curr1 ;
                        dummy = dummy.next ;
                        curr1 = curr1.next ;

                    }
                    end = false ;
                }
                else
                    curr2 = curr2.next ;
            }

        }
        return newList.next ;
    }
}