import java.util.NoSuchElementException;
public class DoubleLink<E>{
	private Node head;
	private Node tail;
	private int size;

	public DoubleLink(){
		size = 0;
	}

	private class Node{
		E element;
		Node next;
		Node prev;
		public Node(E element, Node next, Node prev){
			this.element = element;
			this.prev = prev;
			this.next = next;
		}
		public Node(E element){
			this(element, null, null);
		}
	}
	public int size(){
		return size;
	}

	public boolean isEmpty(){
		return size == 0;
	}

	public void addFirst(E element){
		Node tmp = new Node(element, head, null);
		if(head != null){ head.prev = tmp; }
		head = tmp;
		if(tail == null) { tail = tmp; }
		size ++;
	}
	public void addLast(E element){
		Node tmp = new Node(element, null, tail);
		if(head == null)
			head = tmp;
		if(tail != null)
			tail.next = tmp;
		tail = tmp;
		size ++;
	}
	public String iterateForward(){
		Node temp = head;
		StringBuilder s = new StringBuilder();
		while(temp != null){
			s.append(temp.element + " ");
			temp = temp.next;
		}
		return s.toString();
	}
	public String iterateBackward(){
		Node temp = tail;
		StringBuilder s = new StringBuilder();
		while(temp != null){
			s.append(temp.element + " ");
			temp = temp.prev;
		}
		return s.toString();
	}
	public E removeFirst(){
		if(head == null)
			throw new NoSuchElementException();
		E element = head.element;
		head = head.next;
		if(head == null)
			tail = null;
		else
			head.prev = null;
		size --;
		return element;
	}
	public E removeLast(){
		if(tail == null)
			throw new NoSuchElementException();
		E element = tail.element;
		tail = tail.prev;
		if(tail == null)
			head = null;
		else
			tail.next = null;
		size --;
		return element;
	}
	public void add(int index, E element){
		//index can only be 0 ~ size()
		if(index < 0 || index > size)
			throw new IndexOutOfBoundsException();
		if(index == 0)
			addFirst(element);
		else if(index == size)
			addLast(element);
		else{
			Node temp = head;
			for(int i=0; i<index; i++){
				temp = temp.next;
			}
			Node insert = new Node(element, temp, temp.prev);
			temp.prev.next = insert;
			temp.prev = insert;
			size ++;
		}
	}
	public E remove(int index){
		E element = null;
		if(index < 0 || index >=size)
			throw new IndexOutOfBoundsException();
		if(index == 0)
			removeFirst();
		else if(index == size-1)
			removeLast();
		else{
			Node temp = head;
			for(int i=0; i<index; i++){
				temp = temp.next;
			}
			element = temp.element;
			temp.next.prev = temp.prev;
			temp.prev.next = temp.next;
			temp.next = null;
			temp.prev = null;
			size --;
		}
		return element;
	}
	public boolean contains(E element){
		return indexOf(element) != -1;
	}
	//return the index of the first occurence 
	public int indexOf(E element){
		Node temp = head;
		int index = -1;
		while(temp != null){
			index ++;
			if(temp.element.equals(element)){
				return index;
			}
			temp = temp.next;
		}
		return -1;
	}
	public void set(int index, E element){
		if(index<0 || index>=size)
			throw new IndexOutOfBoundsException();
		else{
			Node temp = head;
			for(int i=0; i<index; i++){
				temp = temp.next;
			}
			temp.element = element;
		}
	}
	public E get(int index){
		if(index<0 || index>=size)
			throw new IndexOutOfBoundsException();
		else{
			Node temp = head;
			for(int i=0; i<index; i++){
				temp = temp.next;
			}
			return temp.element;
		}
	}

	public void clear(){
		Node temp = head;
		while(head != null){
			temp = head.next;
			head.prev = head.next = null;
			head = temp;
		}
		temp = null;
		tail.prev = tail.next = null;
		size = 0;
	}
	public static void main(String[] args){
		DoubleLink<String> dlink = new DoubleLink<>();
		dlink.addFirst(" To ");
		dlink.addFirst("Welcome");
		dlink.addLast("Here");
		dlink.addLast("Shady");
		dlink.addLast("Eric");
		System.out.println(dlink.iterateForward());

		System.out.println(dlink.iterateBackward());
		if(!dlink.isEmpty())
			System.out.println("The size of the linked list: " + dlink.size());
		dlink.removeFirst();
		System.out.println(dlink.iterateForward());
		dlink.removeLast();
		System.out.println(dlink.iterateForward());
		dlink.add(0," Life ");
		System.out.println(dlink.iterateForward());
		System.out.println("The size of the doubleLink: " + dlink.size());
		System.out.println(dlink.iterateForward());
		dlink.add(4," kife ");
		System.out.println("The size of the doubleLink: " + dlink.size());
		System.out.println(dlink.iterateForward());
		dlink.set(4,"wife");
		System.out.println("The size of the doubleLink: " + dlink.size());
		System.out.println(dlink.iterateForward());
		System.out.println("The get:::::" + dlink.get(4));
		dlink.remove(4);
		System.out.println("The size of the doubleLink: " + dlink.size());
		System.out.println(dlink.iterateForward());
		System.out.println("The result: "+dlink.contains(" Shady"));
		dlink.clear();
	}
}
