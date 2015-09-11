public class SLinkedList<T>{
	//inner class
	private class Node<T>{
		private T value;
		private Node<T> next;

		//Constructor
		public Node(T v, Node<T> n){
			value = v;
			next = n;
		}
		public Node(T v){
			this(v, null);
		}
		//accessor methods
		public T getValue(){
			return value;
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
	private Node<T> tail;
	private int size;
	//Constructor for a empty list
	public SLinkedList(){
		head = null;
		tail = null;
		size = 0;
	}
	//methods
	public int size(){
		return size;
	}
	//deterined whethere a element is contained.
	public boolean isContain(T target){
		if(find(target) != null)
			return true;
		return false;
	}
	private Node<T> find(T target){
		Node<T> temp = head;
		while(temp != null){
			if(temp.getValue().equals(target))
				return temp;
			temp = temp.getNext();
		}
		return temp;
	}
	public void traver(){
		Node<T> temp = head;
		while(temp != null){
			System.out.print(temp.getValue()+"-->");
			temp = temp.getNext();
		}
		System.out.println();
	}
	@Override
	public String toString(){
		return toString(head);
	}
	public String toString(Node<T> temp){
		if(temp == null)
			return "";
		else
			return temp.getValue() + "-->" + toString(temp.getNext()); 
	}
	//Add a node in the first place
	public void addFirst(T avalue){
		head = new Node<T>(avalue, head);
		if(size == 0) 
			tail = head;
		size ++;
	}
	//delete the first node in the list
	public T removeFirst(){
		if(head == null)//size == 0
			return null;
	 	T result = head.getValue() ;
		if(head.getNext() == null){ //size == 1
			head = null;
			tail = null;
		}
		else{
			head = head.getNext();
		}
		size --;
		return result;
	}
	//add a node at the last of the list
	public void addLast(T avalue){
		Node<T>temp = new Node<T>(avalue);
		if(head == null){ // size ==0;
			head = temp;
		}
		else{
			tail.setNext(temp);
		}
		tail = temp;
		size ++;
	}
	//remove the last node from the list implement 
	//a double linkedlist will be more efficient
	public T removeLast(){
		T result;
		if(head == null) //size == 0
			return null;
		else if(head.getNext() == null){ //size == 1
			result = head.getValue();
			head = null;
			tail = null;
		}else{
			Node<T> temp = head;
			while(temp.getNext().getNext() != null){
				temp = temp.getNext();
			}
			result = temp.getNext().getValue();
			temp.setNext(null);
		}
		size --;
		return result;
	}
	//find the specific element and insert
	public boolean findAndInsertAfter(T target, T avalue){
		Node<T> temp = head;
		if(temp == null)
			return false;
		while(temp != null){
			if(temp.getValue().equals(target)){
				Node<T> add = new Node<T>(avalue,temp.getNext());
				temp.setNext(add);
				if(add.getNext() == null)
					tail = add;
				size ++;
				return true;
			}
			temp = temp.getNext();
		}
		return false;
	}

	public T remove(int position) throws IllegalArgumentException{
		if(position < 1 || position > size){ //Handle the special situation
			throw new IllegalArgumentException("invalid position " +
					position + ", only 1.."+size+" availiable");
		}
		if(position == 1){
			removeFirst();
		}
		else{
			Node<T> node = head;
			for(int i=2; i<position; i++){
				node = node.getNext();
			}
			T result = node.getNext().getValue();
			node.setNext(node.getNext().getNext());
			if(node.getNext() == null)
				tail = node;
			size --;
			return result;
		}
		return null;
	}

	public static void main(String... args){
		SLinkedList<Integer> list = new SLinkedList<Integer>();
		list.addFirst(6);
		list.addFirst(5);
		list.addFirst(4);
		list.addLast(7);
		list.addLast(8);
		list.traver();
		System.out.println("The size of the list: " + list.size());
		list.removeFirst();
		System.out.println("The size of the list: " + list.size());
		list.traver();
		list.removeLast();
		System.out.println("The size of the list: " + list.size());
		list.traver();

		try{
			list.remove(5);
			System.out.println("The size of the list: " + list.size());
			list.traver();
			
		}catch(IllegalArgumentException e){
			System.out.println("Error: " + e);
		}
		list.findAndInsertAfter(7,8);
		System.out.println("The size of the list: " + list.size());
		list.traver();
		list.findAndInsertAfter(8,10);
		System.out.println("The size of the list: " + list.size());
		list.traver();
		list.findAndInsertAfter(8,9);
		System.out.println("The size of the list: " + list.size());
		list.traver();
	}
}
