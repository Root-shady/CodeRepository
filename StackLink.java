
import java.util.LinkedList;
import java.util.Iterator;
public class StackLink<E> implements Stack<E>{
	private LinkedList<E> list = new LinkedList<E>();
	public void push(E item){ list.addFirst(item); }
	public E pop(){ return list.removeFirst(); }
	public E peek(){ return list.getFirst(); }
	public int size(){ return list.size(); }
	public boolean isEmpty(){ return list.isEmpty(); }
	@Override
	public String toString(){
		StringBuilder s = new StringBuilder();
		Iterator iterator = list.iterator();
		while(iterator.hasNext()){
			s.append(iterator.next()+" ");
		}
		return s.toString();
	}

	public static void main(String... args){
		StackLink<String> stack = new StackLink<>();
		stack.push("You!");
		stack.push(" Love ");
		stack.push("I");
		stack.pop();
		if(!stack.isEmpty()){
			System.out.println("The size of stack:" + stack.size());
		}
		System.out.println(stack);
	}
}
