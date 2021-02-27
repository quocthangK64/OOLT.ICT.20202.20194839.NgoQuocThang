package problem6_6;

public class Add2Matrices {

	public static void main(String[] args) {
		int A[][] = {{1,2},{3,4}};
		int B[][] = {{5,6},{7,8}};
        int S[][] = new int [3][2];
        int i,j;
        System.out.println("The const matrix A is: ");
        for(i = 0; i < 2; i++) {
        	for(j = 0; j< 2;j++) {
        		System.out.print(A[i][j]+ " ");
        	}
        	System.out.println();
        }
        System.out.println("The const matrix B is: ");
        for(i = 0; i < 2; i++) {
        	for(j = 0; j< 2;j++) {
        		System.out.print(B[i][j]+ " ");
        	}
        	System.out.println();
        }
        System.out.println("The final matrix is: ");
        for(i = 0; i < 2; i++) {
        	for(j = 0; j< 2;j++) {
        		S[i][j] = A[i][j] + B[i][j];
        		System.out.print(S[i][j]+ " ");
        	}
        	System.out.println();
        }
	}

}
