
import java.util.Scanner;
public class Pro2_2_6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//The first-degree equation (linear equation) with one variable
	    System.out.println("Linear Equation with One Variable ( ax + b = 0 )");
        double a,b;
        
	    System.out.print("Enter the value of a: ");
        a = sc.nextDouble();
	    System.out.print("Enter the value of b: ");
	    b = sc.nextDouble();
	    if (a!=0) {
	    	 System.out.println("The solution of function " + a + "x + " + b + " = 0"+" is: x = " + (b/a) );
	    }else {
             if (b!=0)
	    	 System.out.println("There is no solution for the function: "+ b + " = 0 ");
             else 
             System.out.println("You can see it's always true that "+ (int)b + " = 0 ");
	    }
	    
	    //The system of first-degree equations (linear system) with two variables
	    System.out.println();
	    System.out.println("Linear System with Two Variale {a11x1 + a12x2 = b1 & a21x1 + a22x2 = b2}");
	    double a11,a12,a21,a22,b1,b2,D1,D2,D;
	    
	    System.out.print("Enter the value of a11: ");
	    a11 = sc.nextDouble();
	    System.out.print("Enter the value of a12: ");
	    a12 = sc.nextDouble();
	    System.out.print("Enter the value of b1: ");
	    b1 = sc.nextDouble();
	    
	    System.out.print("Enter the value of a21: ");
	    a21 = sc.nextDouble();
	    System.out.print("Enter the value of a22: ");
	    a22 = sc.nextDouble();
	    System.out.print("Enter the value of b2: ");
	    b2 = sc.nextDouble();
	    
	    D  = a11 * a22 - a12 * a21;
	    D1 = b1  * a22 - b2  * a12;
	    D2 = a11 * b2  - a21 * b1;
	    if (D!=0) {
	    	System.out.println("System has one and only one solution which is: (x1;x2) = (" 
	                   + D1/D + ";" + D2/D +").");
	    }else {
	    	if(D1==0 && D2==0) {
	    		System.out.println("The values of the coefficients produce infinitely many solutions.");
	    	}else System.out.println("The values of the coefficients produce no solution.");
	    }
	    
	    //The second-degree equation with one variable
	    System.out.println();
	    System.out.println("A second-degree equation with one variable (ax^2 + bx + c = 0) ");
	    double c,delta;
	    System.out.print("Enter the value of a: ");
	    a = sc.nextDouble();
	    System.out.print("Enter the value of b: ");
	    b = sc.nextDouble();
	    System.out.print("Enter the value of c: ");
	    c = sc.nextDouble();
	    delta = b*b - 4*a*c;
	    if (a!=0) {
	    	if(delta < 0) System.out.println("There is no real soltion for this equation");
	    	else
	    	    if(delta == 0) System.out.println("There is a double root which is: x1 = x2 = " + (-b/(2*a)));
	    	else 
	    	    if(delta > 0) System.out.println("There are two roots which are x1 = " + (-b + Math.sqrt(delta))/(2*a) 
	    	    		+ " and x2 = " + (-b - Math.sqrt(delta))/(2*a));
	    }else {
	    	System.out.println("The equation becomes linear equation with one variable: " + b + "x + " + c + " = 0.");
	    	System.out.println("You should enter another value for a (a must be different from 0)");
	    }
	}

}