package fun.codeschool;

public class LinkedList {
	
	private Node head;
	
	public LinkedList() {
		head = null;
	}
	
	public void insertAtBegining(int data) {
		Node node = new Node(data, null);
		if(head != null) {
			node.next = head;
			head = node;
		} else {
			head = node;
		}
	}
	
	public void reverseIterate() {
		if(head == null) {
			return;
		}
		Node curr = head;
		Node next = head.next;
		Node prev = null;
		while(curr != null) {
			curr.next = prev;
			prev = curr;
			if(next != null) {
				curr = next;
				next = curr.next;
			} else {
				head = curr;
				break;
			}
 		}
	}
	
	public void delete(int position) {
		if(head == null) {
			return;
		}
		Node curr = head;
		Node next = curr.next;
		if(position == 0 || position == 1) {
			if(curr.next != null) {
				curr.next = null;
				head = next;
			} else {
				head = null;
			}
			return;
		}
		if(position > capacity()) {
			System.out.println("Error: Invalid position to delete.");
			return;
		}
		Node prev = null;
		for(int i=0; i<position-1; i++) {
			prev = curr;
			curr = curr.next;
		}
		next = curr.next;
		prev.next = next;
		curr.next = null;
	}
	
	public void insertAtEnd(int data) {
		Node node = new Node(data, null);
		if(head == null) { //check if head is null, if yes then assign-
			head = node;   //-new node as head and return.
			return;
		}
		Node curr = head;
		while(curr.next != null) { //traverse to the end of the list.
			curr = curr.next;
		}
		if(curr.next == null) { //if null then we are at the end.
			curr.next = node; //assign new node at the end of the list.
		}
	}
	
	public void insert(int data, int position) {
		Node node = new Node(data, null);
		if(head == null) {
			head = node;
		}
		Node curr = head;
		if(position == 0 || position == 1) {
			node.next = curr;
			head = node;
			return;
		}
		for(int i=0; i<position-2; i++) {
			if(curr != null) {
				curr = curr.next;
			}
		}
		Node next = curr.next;
		curr.next = node;
		node.next = next;
	}
	
	public int capacity() {
		if(head == null) {
			return 0;
		}
		Node curr = head;
		int count = 0;
		while(curr != null) {
			count++;
			curr = curr.next;
		}
		return count;
	}
	
	private void printList(boolean forward) {
		if(head == null) {
			System.out.println("Empty LinkedList!!");
			return;
		}
		if(forward) {
			Node curr = head;
			while (curr != null) {
				System.out.print(curr.data);
				System.out.print(" --> ");
				curr = curr.next;
			}
		}
		System.out.print("null");
		System.out.println();
	}
	
	class Node {
		
		Node(int data, Node next) {
			super();
			this.data = data;
			this.next = next;
		}
		
		int data;
		Node next;
	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		Node node4 = ll.new Node(40, null);
		Node node3 = ll.new Node(30, node4);
		Node node2 = ll.new Node(20, node3);
		Node node1 = ll.new Node(10, node2);
		ll.head = node1;
//		System.out.println("Count: "+ll.capacity());
//		// Print all the elements.
		ll.printList(true);
//		
//		ll.insert(5, 2);
		ll.delete(6);
//		System.out.println("Count: "+ll.capacity());
		ll.printList(true);
//		ll.reverseIterate();
//		ll.printList(true);
	}
}
