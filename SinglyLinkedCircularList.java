package SinglyLinkedCircularList;

public class SinglyLinkedCircularList {

	public static void main(String[] args) {
		
		SinglyLinkedList list = new SinglyLinkedList();
		list.add(4);
		list.add(3);
		list.add(6);
		list.add(2);
		list.add(8);
		list.add(14);

		list.print();
		list.size();
		System.out.println("");
		System.out.println("");

		list.delete(8);
		System.out.println("");
		System.out.println("");

		list.print();
		list.size();
	}
}


class SinglyLinkedList{
	
	Node tail;
	private int size = 0;
	
	
	public void add(int value) {
		if(tail == null) {
			Node nod = new Node(value);
			tail = nod;
			tail.head = nod;
			size++;
		}else {
			Node nod = new Node(value);
			tail.next = nod;
			nod.head = tail.head;
			tail.head = null;
			tail = nod;
			size++;
		}
	}
	
	public void delete(int value) {
		
		if(tail.head == tail) {
			tail = null;
			size--;
		}else if(tail.head.value == value) {
			Node nod = tail.head;
			tail.head = nod.next;
			nod = null;
			size--;
		}else if(tail.head.value != value && tail.value != value) {
			size--;
			Node nod = tail.head;
			Node n = new Node();
			
			while(nod.value != value) {
				n = nod;
				nod = nod.next;
			}
			n.next = nod.next;
			nod = null;
		}
	}
	
	public void print() {
		
		if(tail == null) {
			System.out.println("Список пуст");

		}else {
		
			Node nod = tail.head;
			while(nod.next != null) {
				System.out.println(nod.value);
				nod = nod.next;
			}
			System.out.println(nod.value);

		}
	}
    public void size() {
    	System.out.println("Длина списка: " + size);
    }
	
	 static class Node{
		private int value;
		private Node next;
		private Node head;
		
		public Node(int value) {
			this.value = value;
		}
		public Node() {}
	}
}