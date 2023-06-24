package CLL;

public class Circular_Linked_List {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CircularLinkedList cll = new CircularLinkedList();
	    cll.print();
	    cll.InsertAtHead(2);
	    cll.InsertAtHead(1);
	    cll.InsertAtTail(3);
	    cll.print();
	    System.out.println(cll.GetSize());
	    
	    cll.InsertAtIndex(4,0);
	    cll.InsertAtIndex(5,4);
	    cll.print();
	    
	    System.out.println("Reverse Order");
	    cll.Reverse();
	    cll.print();
	    
	    cll.DeleteHead();
	    cll.print();
	    
	    cll.DeleteByValue(4);
	    cll.print();
	    
	    cll.DeleteByIndex(2);
	    cll.print();
	    
	    cll.DeleteTail();
	    cll.print();
	}
}
class Node{
    int data;
    Node next;
    
    Node(int data){
        this.data = data;
        next = null;
    }
}
class CircularLinkedList{
    Node head;
    
    public void InsertAtHead(int data){
        Node newnode = new Node(data);
        if(head == null){
            head = newnode;
            newnode.next = head;
            return;
        }
        Node temp = head;
        while(temp.next != head){
            temp = temp.next;
        }
        newnode.next = temp.next;
        temp.next = newnode;
        head = newnode;
    }
    public void InsertAtTail(int data){
        Node newnode = new Node(data);
        if(head == null){
            head = newnode;
            newnode.next = head;
            return;
        }
        Node temp = head;
        while(temp.next != head){
            temp = temp.next;
        }
        newnode.next = temp.next;
        temp.next = newnode;
    }
    public void InsertAtIndex(int data, int index){
        int size = GetSize();
        if(index > size){
            System.out.println("Invalid Index");
            return;
        }
        if(index == 0){
            InsertAtHead(data);
            return;
        }
        Node newnode = new Node(data);
        Node temp = head;
        while(index > 1){
            temp = temp.next;
            index--;
        }
        newnode.next = temp.next;
        temp.next = newnode;
    }
    public void DeleteHead(){
        if(head == null){
            System.out.println("Nothing to Delete");
            return;
        }
        if(head.next == head){
            head.next = null;
            head = null;
            return;
        }
        Node temp = head;
        while(temp.next != head){
            temp = temp.next;
        }
        Node tmp = head;
        temp.next = head.next;
        head = head.next;
        tmp.next = null;
    }
    public void DeleteTail(){
        if(head == null){
            System.out.println("Nothing to Delete");
            return;
        }
        if(head.next == head){
            head.next = null;
            head = null;
            return;
        }
        Node temp = head;
        while(temp.next.next != head){
            temp = temp.next;
        }
        Node tmp = temp.next;
        temp.next = temp.next.next;
        tmp.next = null;
    }
    public void DeleteByValue(int val){
        Node temp = head;
        if(head.data == val){
            DeleteHead();
            return;
        }
        while(temp.next != head && temp.next.data != val){
            temp = temp.next;
        }
        if(temp.next != head){
            Node tmp = temp.next;
            temp.next = temp.next.next;
            tmp.next = null;
        }
        else{
            System.out.println("Value Not Found");
        }
    }
    public void DeleteByIndex(int index){
        int size = GetSize();
        if((index > size) && (index < 0)){
            System.out.println("Invalid Index");
            return;
        }
        if(index == 0){
            DeleteHead();
            return;
        }
        Node temp = head;
        for(int i=1; i<index; i++){
            temp = temp.next;
        }
        Node tmp = temp.next;
        temp.next = temp.next.next;
        tmp.next = null;
    }
/*    public void Reverse(){
    	Node curr = head;
    	Node next = null;
    	Node last = head;
    	while(last.next != head) {
    		last = last.next;
    	}
    	Node prev = last;
    	do {
    		next = curr.next;
    		curr.next = prev;
    		prev = curr;
    		curr = next;
    	}
    	while(curr != head);
    	head = prev;
    }*/
    // both way is correct giving correct answer. But the 2nd one is more reliable.
    public void Reverse(){
    	Node curr = head;
    	Node next = null;
    	Node prev = null;
    	do {
    		next = curr.next;
    		curr.next = prev;
    		prev = curr;
    		curr = next;
    	}
    	while(curr != head);
    	head.next = prev;
    	head = prev;
    }
    public int GetSize(){
        int size = 0;
        Node temp = head;
        do{
            size++;
            temp = temp.next;
        }
        while(temp != head);
        return size;
    }
    public void print(){
        if(head == null){
            System.out.println("List Underflow");
            return;
        }
        Node temp = head;
        do{
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        while(temp != head);
        System.out.println();
    }
}