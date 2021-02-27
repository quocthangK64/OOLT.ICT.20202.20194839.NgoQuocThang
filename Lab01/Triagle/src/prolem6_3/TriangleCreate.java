package prolem6_3;
import java.util.Scanner;
public class TriangleCreate {

	public static void main(String[] args) {
		int n,i,j;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the value of n: ");
		n = sc.nextInt();
		for (i = 0; i < n; i++ ){
            for (j = n-i; j >= 2; j-- ){
                System.out.print(" ");
            }
            for (j = 0; j <= 2*i; j++ ){
                System.out.print("*");
            }
            System.out.println();
        }
		
	}

}
