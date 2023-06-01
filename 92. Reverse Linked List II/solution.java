 // Iteratiive approach
 class LL
{
	Node head;
	private int size;

	LL(){
		this.size=0;
	}

	class Node
	{
		int data;
		Node next;
		
		Node(int data){
			this.data = data;
			this.next = null;
			size++;
		}

	}

	public void addFirst(int data){
		Node newNode = new Node(data);
		if(head==null){
			head=newNode;
			return;
		}
		newNode.next = head;
		head = newNode;
	}

	public void addLast(int data){
		Node newNode = new Node(data);
		if(head==null){
			head=newNode;
			return;
		}
		else{
			Node currNode=head;
			while(currNode.next!=null){
				 currNode = currNode.next;
			}
			currNode.next = newNode;
			
		}
	}

	public void printList(){
		if(head==null){
			System.out.println("List is empty");
			return;
		}
		Node currNode = head;
		while(currNode!=null){
			System.out.print(currNode.data+" -> ");
			currNode = currNode.next;
		}
		System.out.println("NULL");
	}

	public void printList_Reverse_Recursive(Node head){
		if(head==null){
			System.out.print("null ");
			return ;
		}
		printList_Reverse_Recursive(head.next);
		System.out.print(head.data+" ");
	}

	
	public void deleteFirst(){
		if(head==null){
			System.out.println("List is empty");
			return;
		}
		size--;
		head = head.next;
	}

	public void deleteLast(){
		
		if(head==null){
			System.out.println("List is empty");
			return;
		}

		size--;

		if(head.next==null){
			head=null;
			return;
		}
		Node currNode = head;
		while(currNode.next.next !=null){
			currNode=currNode.next;
		}
		currNode.next=null;
	}

	public int getSize(){
		return size;
	}

    public void Reverse_iterate(){
        if(head == null || head.next == null){
            return ;
        }
        Node prevNode = head ;
        Node currNode = head.next ;
        while(currNode!=null){
            Node nextNode = currNode.next;
            currNode.next = prevNode;

            //update
            prevNode = currNode ;
            currNode = nextNode;
        }
        head.next = null ;
        head = prevNode;
    }

    public Node Reverse_recursive(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node newHead = Reverse_recursive(head.next);
        head.next.next = head ;
        head.next = null ;

        return newHead;
    }

    public Node reverseBetween(Node head, int left, int right) {
        if(head.next==null){
            return head ;
        }
        Node dummy = new Node(0) ;
        dummy.next= head;
        Node leftprev = dummy ;
        Node curr = head ;

        int i=0 ;
        while(i<left-1){
            leftprev = curr ;
            curr = curr.next ;
            i++ ; 
        }

        Node prev =null;
        int itr =  0 ;
            while(itr<right-left+1){
            Node tempNext = curr.next ;
            curr.next = prev ;
            prev = curr ;
            curr = tempNext ;  
            itr++;
        }

        leftprev.next.next = curr ;
        leftprev.next = prev ;


        return dummy.next ;

    }



	public static void main(String args[]){
		LL list =  new LL();
		list.addLast(1);
		list.addLast(2);
		list.addLast(3);
		list.addLast(4);
		list.addLast(5);
        list.printList();      
        list.head = list.reverseBetween(list.head,2,4);
        list.printList();      
		
	}

}





