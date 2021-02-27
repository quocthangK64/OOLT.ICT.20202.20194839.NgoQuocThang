package problem6_4;

import java.util.Scanner;

public class DisplayDays {

	public static void main(String[] args) {
		do {
		String year, month;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a month: ");
		month = sc.nextLine();
		while(true) {
		try {
		System.out.print("Enter a year: ");
		year = sc.nextLine();
		int n = Integer.parseInt(year);
		break;
		} catch(Exception ex){
		  System.out.println("Year is not correct format ( must be int) or it's not a year. Please try again.");
		}
		}
		if(month.equals("1") || month.equals("3") || month.equals("5") || month.equals("7") || month.equals("8") || month.equals("10") || month.equals("12")
				|| month.equals("Jan") || month.equals("Mar") || month.equals("May") || month.equals("Jul") || month.equals("Aug") || month.equals("Oct") || month.equals("Dec") 
				|| month.equals("Jan.") || month.equals("Mar.") || month.equals("July")|| month.equals("Aug.") || month.equals("Oct.") || month.equals("Dec.")
				|| month.equals("January")|| month.equals("March")|| month.equals("August") || month.equals("October") || month.equals("December")) {
		System.out.print("Number of days is 31");
		break;
		}else
		if((month.equals("2") || month.equals("Feb") || month.equals("Feb.") || month.equals("February") && ((Integer.parseInt(year)%400==0) || (Integer.parseInt(year)%4==0 && Integer.parseInt(year)%100!=0)))){
					System.out.print("Number of days is 29");
					break;
	    }
		else if(month.equals("2") || month.equals("Feb") || month.equals("Feb.") || month.equals("February")){
					System.out.print("Number of days is 28");
					break;
		     }else
	    if(month.equals("4") || month.equals("6") || month.equals("9") || month.equals("11")
	       || month.equals("April") || month.equals("Apr.") || month.equals("Apr")
	       || month.equals("June") || month.equals("Jun")
	       || month.equals("September") || month.equals("Sept.") || month.equals("Sep")
	       || month.equals("November") || month.equals("Nov.") || month.equals("Nov")) {
				    	 System.out.println("Number of days is 30");
				    	 break;
	    }else System.out.println("Please enter month or year correctly again.");
		}while(true);
	}

}
