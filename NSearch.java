import java.util.Arrays;
public class NSearch{
	//This allows your binarySearch to work everything that can be compared 
	//with compareTo.
	public static <E extends Comparable<E>> int binarySearch(E[] array, E foundMe){
		int low = 0;
		int high = array.length -1;
		while(low <= high){
			int middle = low + ( high-low )/2;
			int compare = array[middle].compareTo(foundMe);
			if(compare == 0)
				return middle;
			else if(compare < 0)
				low = middle+1;
			else
				high = middle-1;
		}
		return -1;
	}
	public static void main(String... args){
		/*Integer[] arr = new Integer[10];
		for(int i=0; i<10; i++)
			arr[i] = i;
		for(int i=0; i<10; i++){
			int result = NSearch.binarySearch(arr, i+5);
			System.out.println("The target: "+ (i+5)+ "result: " + result);
		}*/
		String[] arr = {"Happy","life","greate","night","short","is","is"};
		Arrays.sort(arr);
		for(String e: arr){
			System.out.print(" " + e);
		}
		System.out.println();
		int result = NSearch.binarySearch(arr, "is");
		System.out.println("The result is :" + result);
	}
}
