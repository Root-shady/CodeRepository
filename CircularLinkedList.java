import java.util.NoSuchElementException;
public class CircularLinkedList<E>{
	private static class Node<E>{
		private E element;
		private Node<E> next;
		public Node(E e, Node<E> n){
			element = e;
			next = n;
		}
		public E getElement(){
			return element;
		}
		public Node<E> getNext(){
			return next;
		}
		public void setNext(Node<E> n){
			next = n;
		}
	}
	private Node<E> tail;
	private int size;
	public CircularLinkedList(){
		tail = null;
		size = 0;
	}
	public int size(){
		return size;
	}
	public boolean isEmpty(){
		return size == 0;
	}
	public E first(){ //get the first element, don't remove
		if(tail == null)
			throw new NoSuchElementException();
		return tail.getNext().getElement();
	}
	public E last(){
		if(tail == null)
			throw new NoSuchElementException();
		return tail.getElement();
	}
	public void addFirst(E e){
		if(tail == null){
			Node<E> temp = new Node<>(e, null);
			tail = temp;
			tail.setNext(tail);
			size ++;
		}else{
			Node<E> temp = new Node<>(e,tail.getNext());
			tail.setNext(temp);
			size ++;
		}
	}
	public void addLast(E e){
		addFirst(e);
		tail = tail.getNext();
	}
	public void rotate(){
		if(tail != null)
			tail = tail.getNext();
	}
	public E removeFirst(){
		if(tail == null)
			throw new NoSuchElementException();
		Node<E> temp = tail.getNext();
		if(temp == tail)
			tail = null;
		else{
			tail.setNext(temp.getNext());
			temp.setNext(null);
		}
		size --;
		return temp.getElement();
	}
	@Override 
	public String toString(){
		StringBuilder s = new StringBuilder();
		if(tail == null)
			return "";
		else if(tail.getNext() == tail)
			return tail.getElement().toString();
		else{
			Node<E> temp = tail.getNext();
			while(temp != tail){
				s.append(temp.getElement()+ " ");
				temp = temp.getNext();
			}
			s.append(tail.getElement()+ " ");
		}
		return s.toString();
	}
/*	public static void main(String... args){
		CircularLinkedList<Integer> circle = new CircularLinkedList<>();
		circle.addFirst(9);
		circle.addFirst(4);
		circle.addFirst(6);
		circle.addFirst(1);
		circle.addFirst(8);
		circle.addLast(0);
		circle.addLast(5);
		if(!circle.isEmpty()){
			System.out.println("The size of circular: " + circle.size());
		}
		System.out.println(circle);
		circle.removeFirst();
		System.out.println(circle);
	}*/
	public static void main(String... args){
		//实现约瑟夫环
		CircularLinkedList<Integer> circle = new CircularLinkedList<>();
		for(int i=1; i<30; i++){
			circle.addLast(i);
		}
		System.out.println("The Initial Linked: " + circle);
		int i = 1;
		while(circle.size() != 1){
			circle.rotate();
			i++;
			if(i % 3 == 0){
				int num = circle.removeFirst();
				System.out.println("The one out: " + num);
				i = 1;
			}		
		}
		System.out.println("The winner is: " + circle);
	}
}
