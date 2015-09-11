import java.util.NoSuchElementException;
//Lastin-first-out(LIFO) stack of generic items.

public class LinkedStack<T> {
	//inner class for encapsulation
	class Node<T>{
		T item;
		Node<T> next;

		public Node(T item, Node<T> next){
			this.item = item;
			this.next = next;
		}
		//accessor methods
		public T getItem(){
			return item;
		}
		public Node<T> getNext(){
			return next;
		}
		//mutator
		public void setNext(Node<T> n){
			next = n;
		}
	}
	private Node<T> head;
	private int size;
	//constructor
	//construct a empty stack

	public LinkedStack(){
		head = null;
		size = 0;
		assert check();
	}
	//methods
	public boolean isEmpty(){
		return head == null;
	}
	public int size(){
		return size;
	}
	public void push(T item){
		head = new Node<T>(item, head);
		size ++;
		assert check();
	}
	public T pop(){
		if(head == null) 
			throw new NoSuchElementException("Stack underflow");
		T result = head.getItem();
		head = head.getNext();
		size --;
		assert check();
		return result;
	}
	//peek is an operation on certain abstract data type, specifically
	//sequential collections such as stacks and queues, which returns 
	//the value of the top of the collection without removing the value 
	//from the data.
	public T peek(){
		if(head == null)
			throw new NoSuchElementException("Stack underflow");
		return head.getItem();
	}
	@Override
	public String toString(){
		StringBuilder s = new StringBuilder();
		Node<T> temp = head;
		while(temp != null){
			s.append(temp.getItem() + " ");
			temp = temp.getNext();
		}
		return s.toString();
	}
	//check internal invariants
	private boolean check(){
		if(size == 0){
			return head == null;
		}
		//check internal consistency of instance variable size
		int numberOfNodes = 0;
		for(Node<T> temp = head; temp != null; temp = temp.getNext()){
			numberOfNodes ++;
		}
		if(numberOfNodes != size) return false;
		return true;
	}
	//Unit test
	public static void main(String... args){
		LinkedStack<String> stack = new LinkedStack<String>();
		stack.push("!");
		stack.push("you");
		stack.push(" love ");
		stack.push("I");
		System.out.println(stack);
		stack.pop();
		System.out.println(stack);
		stack.peek();
		System.out.println(stack);
		System.out.println("The size of the stack: " + stack.size());
	}
}
