import java.util.NoSuchElementException;
public class CircularDouble<E> implements Cloneable{
	private static class Node<E>{
		private E element;
		private Node<E> prev;
		private Node<E> next;

		public Node(E e, Node<E> p, Node<E> n){
			element = e;
			prev = p;
			next = n;
		}
		public E getElement(){
			return element;
		}
		public Node<E> getPrev(){
			return prev;
		}
		public Node<E> getNext(){
			return next;
		}
		public void setElement(E e){
			element = e;
		}
		public void setPrev(Node<E> p){
			prev = p;
		}
		public void setNext(Node<E> n){
			next = n;
		}
	}
	//make a deep equals
	@Override
	public boolean equals(Object o){
		if(o == null)
			return false;
		if(o.getClass() != getClass())
			return false;
		@SuppressWarnings("unchecked")
		CircularDouble<E> other = (CircularDouble<E>)o;
		if(other.size() != size)
			return false;
		//handle the empty list situation
		if(other.size() == 0 && size == 0)
			return true;
		Node<E> walkA = header.getNext();
		Node<E> walkB = other.header.getNext();
		while(walkA != header){
			//Walk through to compare the content of each node.
			if(!walkA.getElement().equals(walkB.getElement()))
				return false;
			walkA = walkA.getNext();
			walkB = walkB.getNext();
		}
		return true;
	}
	@Override
	public CircularDouble<E> clone() throws CloneNotSupportedException{
		//Since the super.clone()only make a shadow copy
		//therefore there is no need to use it.
		//Also remember to make it public
		CircularDouble<E> one = new CircularDouble<>();
		Node<E> temp = header.getNext();
		while(temp != header){
			one.addLast(temp.getElement());
			temp = temp.getNext();
		}
		return one;
	}
	//inplement a circular double linkedList
	private int size;
	private Node<E> header;
	//Only one sentinel
	public CircularDouble(){
		size = 0;
		header = new Node<E>(null,null, null);
		header.setPrev(header);
		header.setNext(header);
	}
	public int size(){
		return size;
	}
	public boolean isEmpty(){
		return size == 0;
	}

	public void addFirst(E element){
		Node<E> temp = new Node<E>(element, header, header.getNext());
		header.getNext().setPrev(temp);
		header.setNext(temp);
		size ++;
	}
	public void addLast(E element){
		Node<E> temp = new Node<E>(element, header.getPrev(), header);
		header.getPrev().setNext(temp);
		header.setPrev(temp);
		size ++;
	}
	public E removeFirst(){
		if(size == 0)
			throw new NoSuchElementException();
		E result = header.getNext().getElement();
		Node<E> temp = header.getNext();
		temp.getNext().setPrev(header);//what if it is head
		header.setNext(temp.getNext());
		size --;
		return result;
	}
	public E removeLast(){
		if(size == 0)
			throw new NoSuchElementException();
		E result = header.getPrev().getElement();
		Node<E> temp = header.getPrev();
		temp.getPrev().setNext(header);//if temp.getPrev() == header
		header.setPrev(temp.getPrev());
		size --;
		return result;
	}
	public void add(E element, int index){
		if(index<0 || index> size)
			throw new IndexOutOfBoundsException();
		Node<E> temp = header;
		for(int i=0; i<index; i++){
			temp = temp.getNext();
		}
		Node<E> node = new Node<E>(element, temp, temp.getNext());
		temp.getNext().setPrev(node);
		temp.setNext(node);
		size ++;
	}
	public E remove(int index){
		if(index<0 || index >= size)
			throw new IndexOutOfBoundsException();
		Node<E> temp = header;
		for(int i=0; i<index; i++){ //Notice that the temp.getNext()
			temp = temp.getNext();  //can never be header
		}
		//Remove the node next to the temp
		E result = temp.getNext().getElement();
		Node<E> node = temp.getNext();
		node.getNext().setPrev(temp);
		temp.setNext(node.getNext());
		node.setNext(null); //Detach the node from the double linkedList
		size --;
		return result;
	}
	//Return the first occurence of the element
	//if not found, return the -1, else return the index
	public int indexOf(E element){
		int index = -1;
		if(size == 0)
			return index;
		Node<E> temp = header.getNext();
		while(temp != header){
			index ++;
			if(temp.getElement().equals(element))
				return index;
			temp = temp.getNext();
		}
		return -1;
	}
	//The index of the last occurence of the element 
	public int lastIndexOf(E element){
		if(size == 0)
			return -1;
		int index = size;
		Node<E> temp = header.getPrev();
		while(temp != header){
			index -- ;
			if(temp.getElement().equals(element))
				return index;
			temp = temp.getPrev();
		}
		return -1;
	}
	public boolean contains(E element){
		return indexOf(element) != -1;
	}
	public void set(E element, int index){
		if(index<0 || index>=size)
			throw new IndexOutOfBoundsException();
		Node<E> temp = header;
		for(int i=0; i<=index; i++){
			temp = temp.getNext();
		}
		temp.setElement(element);
	}
	public E get(int index){
		if(index<0 || index>=size)
			throw new IndexOutOfBoundsException();
		Node<E> temp = header.getNext();
		for(int i=0; i<index; i++){
			temp = temp.getNext();
		}
		return temp.getElement();
	}
	public void clear(){
		Node<E> temp = header.getNext();
		while(temp != header){
			Node<E> node = temp.getNext();
			temp.setNext(null);
			temp = node;
		}
		header.setNext(header);
		header.setPrev(header);
		size = 0;
	}
	@Override
	public String toString(){
		if(size == 0)
			return "";
		StringBuilder s = new StringBuilder();
		Node<E> temp = header.getNext();
		while(temp != header){
			s.append(temp.getElement() + " ");
			temp = temp.getNext();
		}
		return s.toString();
	}
	public static void main(String... args){
		CircularDouble<String> list = new CircularDouble<>();
		list.addFirst("Short!");
		list.addFirst("is");
		list.addFirst("Life");
		list.addLast("What");
		list.addLast("It");
		list.addLast("Means?");
		
		System.out.println(list);
		if(list.contains("Life"))
			System.out.println("Contain(Yes) Index:" + list.indexOf("Life"));
		
		list.removeFirst();
		list.removeLast();
		list.add("Three", 3);
		list.set("Wow", 3);
		System.out.println(list);
		list.remove(1);
		if(!list.isEmpty())
			System.out.println("The size: " + list.size());
		System.out.println(list);

		System.out.println("The first occurence of the Wow: " + list.indexOf("Wow"));
		System.out.println("The first occurence of the Wow: " + list.lastIndexOf("Wow"));
		System.out.println("The element in the list: " + list.get(3));
		
		//list.clear();	
		//Test the equals method.
		CircularDouble<String> list1 = new CircularDouble<>();
		list1.addFirst("Night");
		list1.addLast("is");
//		list1.addLast("dark!");
		CircularDouble<String> list2 = new CircularDouble<>();
//		list2.addFirst("Night");
//		list2.addLast("is");
//		list2.addLast("dark!");
		System.out.println("The list1: " + list1);
		System.out.println("The list2: " + list2);
		if(list1.equals(list2))
			System.out.println("They are equals!");
		else
			System.out.println("They are Not equals!");
		//Test the clone method
		CircularDouble<String> list3 = null;
		try{
			list3 = list1.clone();
		}catch(CloneNotSupportedException e){
			e.printStackTrace();
		}
		System.out.println("The list3: " + list3);
		if(list1.equals(list3) && list3.equals(list1))
			System.out.println("They are equals!");
		else
			System.out.println("They are Not equals!");
		list1.set("Change", 0);
		//Notice that you change the content of the list1, which have not effect
		//on the list3, since it is a deep clone
		System.out.println("The list1: " + list1);
		System.out.println("The list3: " + list3);
	}
}
