import java.util.NoSuchElementException;
public class ArrayStack implements Stack{
	private Object[] array;
	private  final int capacity;
	private int top = -1;
//Two constructor
	public ArrayStack(){
		this(10);
	}
	
	public ArrayStack(int size){
		array = new Object[size];
		capacity = size; 
	}
	public void push(Object item){
		if(capacity == top+1)
			throw new IllegalStateException("Cannot add to full stack");
		array[++top] = item;
	}

	public Object pop(){
		if(top == -1){
			throw new NoSuchElementException("Stack underflow");
		}
		else{
			Object temp = array[top];
			//将移除的元素置空nullify,使GC知道其可回收,
			//防止内存泄漏(memory leak)
			array[top--] = null;
			return temp;
		}
	}

	public Object peek(){
		if(top == -1){
			throw new NoSuchElementException("Stack underflow");
		}
		else{
			return array[top];
		}
	}
	public int size(){
		return top + 1;
	}
	public boolean isEmpty(){
		return top == -1;
	}
	@Override
	public String toString(){
		StringBuilder s = new StringBuilder();
		for(int i=top; i>=0; i--){
			s.append(array[i]+" ");
		}
		return s.toString();
	}
	public static void main(String... args){
		ArrayStack aStack = new ArrayStack(10);
		aStack.push("I");
		aStack.push("Me");
		aStack.push("Good");
		aStack.pop();
		aStack.pop();
		if(!aStack.isEmpty())
			System.out.println("The size of the stack: " + aStack.size());
		System.out.println(aStack);
	}
}
