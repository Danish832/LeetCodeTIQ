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

        

        ListNode Node1 = new ListNode(4);
        ListNode Node2 = new ListNode(1);
        ListNode Node3 = new ListNode(8);
        ListNode Node4 = new ListNode(4);
        ListNode Node5 = new ListNode(5);

        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(6);
        ListNode node3 = new ListNode(1);
        
        Node1.next  = Node2 ;
        Node2.next = Node3 ;
        Node3.next = Node4 ;
        Node4.next = Node5 ;
        Node5.next = null ;

        node1.next = node2;
        node2.next = node3;
        node3.next = Node3;

        ListNode headA = Node1 ;
        ListNode headB = node1 ;
        
        printList(headA);
        printList(headB);

        Solution s = new Solution() ;
        ListNode ans1 = s.IntersectionTwoLists1(headA,headB);
        ListNode ans2 = s.IntersectionTwoLists2(headA,headB);
        ListNode ans3 = s.IntersectionTwoLists3(headA,headB);
        ListNode ans4 = s.IntersectionTwoLists4(headA,headB);
        System.out.println(ans1.val);
        System.out.println(ans2.val);
        System.out.println(ans3.val);
        System.out.println(ans4.val);


    }
}

class Solution {
    public ListNode IntersectionTwoLists1(ListNode headA, ListNode headB) {
        ListNode temp1 = new ListNode() ;
        ListNode temp2 = new ListNode() ;
        temp1 = headA ;
        temp2 = headB ;
        //System.out.println(temp1==temp2);
        //System.out.println(temp1);
        while(temp1!=null){
            temp2 = headB;
            while(temp2!=null){
                if(temp1==temp2){
                    return temp1 ;
                }
                temp2 = temp2.next ;
            }
            temp1 = temp1.next ;
        }

    return null ;
    }

    public ListNode IntersectionTwoLists2(ListNode headA, ListNode headB) {
        HashMap<ListNode,Integer> map = new HashMap<>();
        ListNode temp1 = headA ;
        while(temp1!=null){
            map.put(temp1,temp1.val);
            temp1 = temp1.next ;
        }
        ListNode temp2 = headB ;
        while(temp2!=null){
            if(map.containsKey(temp2)){
                return temp2 ;
            }
            temp2 = temp2.next ;
        }

        return null ;
    }

    public ListNode IntersectionTwoLists3(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
    
    ListNode a = headA;
    ListNode b = headB;
    
    //if a & b have different len, then we will stop the loop after second iteration
    while( a != b){
    	//for the end of first iteration, we just reset the pointer to the head of another linkedlist
        a = a == null? headB : a.next;
        b = b == null? headA : b.next;    
    }
    
    return a;
    }

    public ListNode IntersectionTwoLists4(ListNode headA, ListNode headB) {
    //calculating the length of List A
        int lenA = 0;
        ListNode tempA = headA;
        while(tempA.next != null){
            lenA++;
            tempA = tempA.next;
        }
        
        //calculating the length of List B
        int lenB = 0;
        ListNode tempB = headB;
        while(tempB.next != null){
            lenB++;
            tempB = tempB.next;
        }
        //calculating the difference 
        int diff = Math.abs(lenA - lenB);

        //reinitializing 'head' for both the LinkedList
        tempA = headA ;
        tempB = headB;

        if(lenA > lenB){
            for(int i = 0 ; i < diff ; i++){
                tempA = tempA.next;
            }
        }else{
            for(int i = 0 ; i < diff ; i++){
                tempB = tempB.next;
            }
        } // till now both the tempA and tempB will be at same position from the intersection point of LL

        //now we will compare each element of both the linked list till common value is found
        while(tempA != tempB){
            tempA = tempA.next;
            tempB = tempB.next;
        }
        return tempA;
    }
        
}