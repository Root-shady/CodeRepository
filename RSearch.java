import java.util.Arrays;
public class RSearch{
	public static <E extends Comparable<E>> int 
			binarySearch(E[] array, E foundMe){
		int low = 0;
		int high = array.length-1;
		return search(array, low, high, foundMe);
	}
	private static <E extends Comparable<E>> int 
			search(E[] array, int low, int high, E foundMe){
		if(low > high)
			return -1;
		else{
			int middle = low + (high-low)/2;
			int compare = array[middle].compareTo(foundMe);
			if(compare == 0)
				return middle;
			else if(compare < 0)
				return search(array, middle+1, high, foundMe);
			else
				return search(array, low, middle-1, foundMe);
		}
	}
	public static void main(String... args){
		/*Integer[] arr = new Integer[10];
		for(int i=0; i<10; i++)
			arr[i] = i;
		for(int i=0; i<10; i++){
			int result = Test.binarySearch(arr, i);
			System.out.println("The target: "+ i+ "result: " + result);
		}
		*/
		String[] arr = {};
		Arrays.sort(arr);
		for(String e: arr){
			System.out.print(" " + e);
		}

		System.out.println();
		for(String e: arr){
			int result = Test.binarySearch(arr, e);
			System.out.println("The result :" + e +"is :" + result);
		}
	}
}
