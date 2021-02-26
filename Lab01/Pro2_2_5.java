import java.util.Scanner;
public class Pro2_2_5 {	

		public static void main(String[] args) {

			double first,second;
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter the first number: ");
			first = sc.nextDouble();
			System.out.print("Enter the second number: ");
			second = sc.nextDouble();

			System.out.println("Sum of them is: "+ (first+second));
			System.out.println("Difference of them is: "+ (first-second));
			System.out.println("Product of them is: "+ (first*second));
			if (second!=0) System.out.println("Quotient of them is: "+ (first/second));
			else System.out.println("The second number is 0, so we can't have quotient.");

		}
		
	}

