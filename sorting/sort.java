import java.util.Random;
import java.util.Arrays;


public class Sort {
	private static Random rand = new Random();
	private static class Pair {   
        int min; 
        int max; 
    } 
	
	//----------------------------INSERTION SORT----------------------------------
	
	public static void insertionSort(int[] array) {
		int i, key, j, n;
		n = array.length;
		for(i=0; i<n; i++) {
			key = array[i];
			j = i-1;
			
			while (j >= 0 && array[j] > key) {
				array[j+1] = array[j];
				j = j-1;
			}
			
			array[j+1] = key;
		}
	}
	
	//-----------------------------QUICK SORT--------------------------------------
	
	public static int partition(int arr[], int low, int high) 
    { 
        int pivot = arr[high];  
        int i = (low-1); 
        for (int j=low; j<high; j++) 
        { 
            if (arr[j] < pivot) 
            { 
                i++; 
  
                int temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
            } 
        } 
   
        int temp = arr[i+1]; 
        arr[i+1] = arr[high]; 
        arr[high] = temp; 
  
        return i+1; 
    }
	
	 public static void sort(int arr[], int low, int high) 
	    { 
	        if (low < high) 
	        { 
	        	
	            int pi = partition(arr, low, high); 
	  
	            sort(arr, low, pi-1); 
	            sort(arr, pi+1, high); 
	        } 
	    } 
	public static void quickSort(int[] array) {
		int size = array.length;
		sort(array, 0, size-1);
	}
	
	//----------------------RADIX SORT HELPER---------------------
	
	public static Pair getMinMax(int[] array) { 
        Pair minmax = new  Pair(); 
        int i;
        int size = array.length;
  
        if (size == 1) { 
            minmax.max = array[0]; 
            minmax.min = array[0]; 
            return minmax; 
        } 
  
        if (array[0] > array[1]) { 
            minmax.max = array[0]; 
            minmax.min = array[1]; 
        } else { 
            minmax.max = array[1]; 
            minmax.min = array[0]; 
        } 
  
        for (i = 2; i < size; i++) { 
            if (array[i] > minmax.max) { 
                minmax.max = array[i]; 
            } else if (array[i] < minmax.min) { 
                minmax.min = array[i]; 
            } 
        } 
  
        return minmax; 
    } 
	
	//---------------------RADIX SORT-------------------------------
	
    static void countSort(int array[], int exp) 
    {
    	int size = array.length;
        int output[] = new int[size];
        int i; 
        int count[] = new int[10]; 
        Arrays.fill(count,0); 

        for (i = 0; i < size; i++) 
            count[ (array[i]/exp)%10 ]++; 

        for (i = 1; i < 10; i++) 
            count[i] += count[i - 1]; 

        for (i = size - 1; i >= 0; i--) 
        { 
            output[count[ (array[i]/exp)%10 ] - 1] = array[i]; 
            count[ (array[i]/exp)%10 ]--; 
        } 
 
        for (i = 0; i < size; i++) 
            array[i] = output[i]; 
    } 

    public static void radixSort(int[] array) 
    {
    	Pair minmax = getMinMax(array);
        int max = minmax.max; 
  
        for (int exp = 1; max/exp > 0; exp *= 10) 
            countSort(array, exp); 
    }

	//---------------------RANDOM INT ARRAY GENERATOR--------------------------
	
	public static int[] randomArrayGenerator(int size, int range) {
		if(size == 0) {
			size = rand.nextInt(10000);
		}
		else {
			size = rand.nextInt(10000);
		}
		int[] array = new int[size];
		for(int i = 0; i < size; i++) {
			if(range == 0) {
				array[i] = rand.nextInt(10000);
			}
			else {
				array[i] = rand.nextInt(range);
			}
		}
		return array;	
	}
	
	//-----------------------------TEST-----------------------------------------
	
	public static void main(String[] args) {
		int array[] = randomArrayGenerator(0, 0);
		int array2[] = array;
		int array3[] = array;
		System.out.println(Arrays.toString(array));
		long startTime = System.currentTimeMillis();
		insertionSort(array);
		long endTime = System.currentTimeMillis();
		long insertTime = endTime - startTime;
		long startTime2 = System.currentTimeMillis();
		radixSort(array2);
		long endTime2 = System.currentTimeMillis();
		long quickTime = endTime2 - startTime2;
		long startTime3 = System.currentTimeMillis();
		radixSort(array3);
		long endTime3 = System.currentTimeMillis();
		long radixTime = endTime3 - startTime3;
		System.out.print("\n");
		System.out.println(Arrays.toString(array2));
		System.out.print("\n");
		System.out.println("Array size: " + array.length);
		System.out.println("Insertion Sort Time: " + insertTime + "ms");
		System.out.println("Quick Sort Time: " + quickTime + "ms");
		System.out.println("Radix Sort Time: " + radixTime + "ms");
	    return;
	}

}
