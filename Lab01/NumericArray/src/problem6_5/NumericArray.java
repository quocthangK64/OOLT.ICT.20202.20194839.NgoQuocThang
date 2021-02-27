package problem6_5;
import java.util.Arrays;
public class NumericArray {

	public static void main(String[] args) {
		
	    	int A[] = {1,5,20,6,12,2};
	    	System.out.println("The const array is: " + Arrays.toString(A));
	    	Arrays.sort(A);
	    	System.out.println("The sorted array is: " + Arrays.toString(A));
	    	int i;
	    	double sum=0;
	    	for(i = 0; i < A.length; i++) {
	    		sum += A[i];
	    	}
	    	System.out.println("The sum of all elements is: " + sum);
	    	double avg = sum/A.length;
	    	System.out.println("The average value of all elements is: "+ avg);
	    	
	}

}
