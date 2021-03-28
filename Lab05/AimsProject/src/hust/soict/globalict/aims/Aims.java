package hust.soict.globalict.aims;
import java.util.Scanner;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.disc.DigitalVideoDisc;
import hust.soict.globalict.aims.store.Store;

public class Aims {
    public static void showMenu() {
    		System.out.println("AIMS: ");
    		System.out.println("--------------------------------"); 
    		System.out.println("1. View store"); 
    		System.out.println("2. Update store"); 
    		System.out.println("3. See current cart"); 
    		System.out.println("0. Exit"); 
    		System.out.println("--------------------------------"); 
    		System.out.println("Please choose a number: 0-1-2-3");
    }
    public static void storeMenu() { 
    		System.out.println("Options: ");
    		System.out.println("--------------------------------"); 
    		System.out.println("1. See a DVD’s details"); 
    		System.out.println("2. Add a DVD to cart"); 
    		System.out.println("3. See current cart"); 
    		System.out.println("0. Exit"); 
    		System.out.println("--------------------------------"); 
    		System.out.println("Please choose a number: 0-1-2-3");
    }
    public static void cartMenu() { 
    		System.out.println("Options: ");
    		System.out.println("--------------------------------"); 
    		System.out.println("1. Filter DVDs in cart"); 
    		System.out.println("2. Sort DVDs in cart"); 
    		System.out.println("3. Remove DVD from cart"); 
    		System.out.println("4. Place order"); 
    		System.out.println("0. Exit"); 
    		System.out.println("--------------------------------");
    		System.out.println("Please choose a number: 0-1-2-3-4");
    }
	public static void main(String[] args) {
		Store store = new Store();
		Cart anOrder = new Cart();

		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
				"Animation","Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Stars Wars",
		    	"Science Fiction","George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
				"Animation", 18.99f);
	    DigitalVideoDisc dvd4 = new DigitalVideoDisc("the lion king",
	    		"Animation", 18f);
	    DigitalVideoDisc dvd5 = new DigitalVideoDisc("Aladin",
	    		"Animation", 19.95f);
		anOrder.addDigitalVideoDisc(dvd1);
		anOrder.addDigitalVideoDisc(dvd4);
		anOrder.addDigitalVideoDisc(dvd2);
		anOrder.addDigitalVideoDisc(dvd3);
		anOrder.addDigitalVideoDisc(dvd5);
	    // section 6 Lab05
	    int main_choice;
	    int store_choice;
	    int cart_choice;
	    int update_choice;
	    int filter_choice;
	    int sort_choice;
	    // add some dvds to store first
	    store.addDVD(dvd1);
	    store.addDVD(dvd4);
	    
	    do {
	    	Aims.showMenu();
	    	Scanner sc = new Scanner(System.in);
	    	main_choice = sc.nextInt();
	    	switch(main_choice) {
	    		case 1:
	    			do {
	    	        store.printID();
	    	        Aims.storeMenu();
	    	        store_choice =  sc.nextInt();
	    	        switch(store_choice) {
	    	        	case 1:
	    	        		System.out.println("Please enter the id of DVD you wanted to see deatils: ");
	    	        		String id;
	    	        		id = sc.next();
	    	        		store.SearchID(id);
	    	        		System.out.println("Do you want to add this to your cart (Y or N)?");
	    	        		String yes_no;
	    	        		yes_no = sc.next();
	    	        		if(yes_no.equals("Y")) anOrder.addDigitalVideoDisc(store.disc(id));
	    	        		break;
	    	        	case 2:
	    	        		System.out.println("Enter ID of DVD that you want to add to your cart:");
	    	        		String Id;
	    	        		Id = sc.next();
	    	        		anOrder.addDigitalVideoDisc(store.disc(Id));
	    	        		break;
	    	        	case 3:
	    	        		anOrder.Printlist();
	    	        		break;
	    	        	case 0:
	    	        		break;
	    	        	default:
	    	        		System.out.println("Wrong input. Pls enter again.");
	    	        }
	    			}while (store_choice!=0);
	    			break;
	    		case 2:
	    			do {
	    			System.out.println("You want to: ");
	    			System.out.println("1. Add DVD");
	    			System.out.println("2. Remove DVD");
	    			System.out.println("0. Exit");
	    			System.out.println("--------------------------------");
	        		System.out.println("Please choose a number: 0-1-2");
	    			update_choice = sc.nextInt();
	    			switch(update_choice) {
	    				case 1:
	    					store.addDVD(dvd2);
	    					break;
	    				case 2:
	    					store.removeDVD(dvd2);
	    					break;
	    				case 0:
	    					break;
	    				default:
	    	        		System.out.println("Wrong input. Pls enter again.");
	    			}
	    			}while(update_choice!=0);
	    			break;
	    		case 3:
	    			do {
	    			anOrder.Printlist();
	    			Aims.cartMenu();
	    			cart_choice = sc.nextInt();
	    			switch(cart_choice) {
	    				case 1:
	    					do {
	    					System.out.println("You want to filter DVDs by: ");
	    		    		System.out.println("1. ID"); 
	    		    		System.out.println("2. Title");  
	    		    		System.out.println("0. Exit");
	    		    		System.out.println("--------------------------------");
	    		    		System.out.println("Please choose a number: 0-1-2");
	    		    		filter_choice = sc.nextInt();
	    		    		switch(filter_choice) {
	    		    			case 1:
	    		    			    System.out.println("Enter the ID of DVD you want to filter:");
	    		    			    String ID;
	    		    			    ID = sc.next();
	    		    			    anOrder.SearchID(ID);
	    		    				break;
	    		    			case 2:
	    		    				System.out.println("Enter the title (or token of title) of DVD you want to filter:");
	    		    				Scanner scan = new Scanner(System.in);
	    		    			    String title ;
	    		    			    title = scan.nextLine();
	    		    			    anOrder.SearchTitle(title);
	    		    				break;
	    		    			case 0:
	    		    				break;
	    		    			default:
	    	    	        		System.out.println("Wrong input. Pls enter again.");
	    		    		}
	    					}while(filter_choice!=0);
	    					break;
	    				case 2:
	    					do {
	    					System.out.println("You want to sort DVDs by: ");
	    		    		System.out.println("1. Title"); 
	    		    		System.out.println("2. Cost");  
	    		    		System.out.println("0. Exit");
	    		    		System.out.println("--------------------------------");
	    		    		System.out.println("Please choose a number: 0-1-2");
	    		    		sort_choice = sc.nextInt();
	    		    		switch(sort_choice) {
	    		    			case 1:
	    		    			    anOrder.SortbyTitleandPrint();
	    		    				break;
	    		    			case 2:
	    		    			    anOrder.SortbyCostandPrint();
	    		    				break;
	    		    			case 0:
	    		    				break;
	    		    			default:
	    	    	        		System.out.println("Wrong input. Pls enter again.");
	    		    		}
	    					}while(sort_choice!=0);
	    					break;
	    				case 3:
	    					System.out.println("Enter ID of DVD that you want to remove from your cart:");
	    					String id;
	    					id = sc.next();
	    					anOrder.removeDigitalVideoDisc(id);
	    					break;
	    				case 4:
	    					anOrder.emptyCart();
	    					break;
	    				case 0:
	    					break;
	    				default:
	    	        		System.out.println("Wrong input. Pls enter again.");
	    			}
	    			}while(cart_choice!=0);
	    			break;
	    		case 0:
	    			System.out.println("Goodbye!!!");
	    	}
	    }while(main_choice!=0);
	}
}
