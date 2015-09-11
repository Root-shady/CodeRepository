import java.util.NoSuchElementException;
public class DoubleList<E>{
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
	public void setPrev(Node<E> p){
		prev = p;
	}
	public void setNext(Node<E> n){
		next = n;
	}
	}

	private Node<E> header;
	private Node<E> tailer;
	private int size;
	//Constructor
	public DoubleList(){
		header = new Node<>(null,null, null);
		tailer = new Node<>(null, header,null);
		header.setNext(tailer);
		size = 0;
	}
	//methods
	public int size(){
		return size;
	}
	public boolean isEmpty(){
		return size == 0;
	}
	public E first(){
		if(size == 0)
			throw new NoSuchElementException();
		return header.getNext().getElement();
	}
	public E last(){
		if(size == 0)
			throw new NoSuchElementException();
		return tailer.getPrev().getElement();
	}
	private void addBetween(Node<E> node,E element){
		Node<E> temp = new Node<>(element, node, node.getNext());
		node.getNext().setPrev(temp);
		node.setNext(temp);
		size ++;
	}
	public void addFirst(E element){
		addBetween(header, element);
	}
	public void addLast(E element){
		addBetween(tailer.getPrev(), element);
	}
	private E remove(Node<E> node){
		if(size == 0)
			throw new NoSuchElementException();
		Node<E> temp = node.getNext();
		temp.getNext().setPrev(node);
		node.setNext(temp.getNext());
		temp.setPrev(null);
		temp.setNext(null);
		size --;
		return temp.getElement();
	}
	public E removeFirst(){
		if(size == 0)
			throw new NoSuchElementException();
		return remove(header);
	}
	public E removeLast(){
		return remove(tailer.getPrev().getPrev());
	}
	public String toString(){
		StringBuilder s = new StringBuilder();
		Node<E> temp = header.getNext();
		while(temp != tailer){
			s.append(temp.getElement() + " ");
			temp = temp.getNext();
		}
		return s.toString();
	}
	public static void main(String... args){
		DoubleList<String> Dlist = new DoubleList<>();
		Dlist.addFirst("You!");
		Dlist.addFirst(" Love ");
		Dlist.addLast("Break");
		Dlist.addLast("Even");
		System.out.println("The Double List: " + Dlist);
		for(int i=0; i<1; i++){
			Dlist.removeFirst();
		}
		System.out.println("The Double List: " + Dlist);
		if(!Dlist.isEmpty()){
			System.out.println("The size of the Double link: " + Dlist.size());
		}
		System.out.println("The Double List: " + Dlist);
		for(int i=0; i<1; i++){
			Dlist.removeLast();
		}
		System.out.println("The Double List: " + Dlist);

	}
}
