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

        ListNode newList = new ListNode() ;
        ListNode dummy = newList ;
        ListNode temp1 = list1 ;
        ListNode temp2 = list2 ;

        while(temp1!=null && temp2!=null){
            if(temp1.val > temp2.val){
                dummy.next = temp2 ;
                temp2 = temp2.next ;
            }

            else {
                dummy.next = temp1 ;
                temp1 = temp1.next ;
            }

            dummy = dummy.next ;
        }

        while(temp1!=null){
            
            dummy.next = temp1 ;
            dummy = dummy.next ;
            temp1 = temp1.next ;
        }

        while(temp2!=null){
            
            dummy.next = temp2 ;
            dummy = dummy.next ;
            temp2 = temp2.next ;
        }

        return newList.next ;
    }
}