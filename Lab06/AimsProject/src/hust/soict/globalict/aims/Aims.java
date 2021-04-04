package hust.soict.globalict.aims;
import java.util.Scanner;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;
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
    		System.out.println("1. See a Media’s details"); 
    		System.out.println("2. Add a Media to cart"); 
    		System.out.println("3. See current cart"); 
    		System.out.println("0. Exit"); 
    		System.out.println("--------------------------------"); 
    		System.out.println("Please choose a number: 0-1-2-3");
    }
    public static void cartMenu() { 
    		System.out.println("Options: ");
    		System.out.println("--------------------------------"); 
    		System.out.println("1. Filter Medias in cart"); 
    		System.out.println("2. Sort Medias in cart"); 
    		System.out.println("3. Remove Media from cart"); 
    		System.out.println("4. Get a lucky item from cart");
    		System.out.println("5. Place order"); 
    		System.out.println("0. Exit"); 
    		System.out.println("--------------------------------");
    		System.out.println("Please choose a number: 0-1-2-3-4-5");
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
	    Book b1 = new Book("Harry Potter", "Magic", 2.05f, "I can can the can, but the can cannot can me");
	    Book b2 = new Book("Lich Su Dang", "History", 2.00f, new String[] {"Hoang Thi Lan", "Luong Thi Phuong Thao"}, "I can can the can, but the can cannot can me");
		anOrder.addMedia(dvd1);
		anOrder.addMedia(dvd4);
		anOrder.addMedia(dvd2);
		anOrder.addMedia(dvd3);
		anOrder.addMedia(dvd5);
		anOrder.addMedia(b1);
		anOrder.addMedia(b2);
	    // section 6 Lab05
	    int main_choice;
	    int store_choice;
	    int cart_choice;
	    int update_choice;
	    int filter_choice;
	    int sort_choice;
	    // add some dvds to store first
	    store.addMedia(dvd1);
	    store.addMedia(dvd2);
	    store.addMedia(dvd3);
	    store.addMedia(dvd4);
	    store.addMedia(dvd5);
	    store.addMedia(b1);
	    store.addMedia(b2);
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
	    	        		System.out.println("Please enter the id of Media you wanted to see details: ");
	    	        		int id;
	    	        		id = sc.nextInt();
	    	        		store.SearchID(id);
	    	        		System.out.println("Do you want to add this to your cart (Y or N)?");
	    	        		String yes_no;
	    	        		yes_no = sc.next();
	    	        		if(yes_no.equals("Y")) anOrder.addMedia(store.disc(id));
	    	        		break;
	    	        	case 2:
	    	        		System.out.println("Enter ID of Media that you want to add to your cart:");
	    	        		int Id;
	    	        		Id = sc.nextInt();
	    	        		anOrder.addMedia(store.disc(Id));
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
	    			store.printID();
	    			System.out.println("You want to: ");
	    			System.out.println("1. Add Media");
	    			System.out.println("2. Remove Media");
	    			System.out.println("0. Exit");
	    			System.out.println("--------------------------------");
	        		System.out.println("Please choose a number: 0-1-2");
	    			update_choice = sc.nextInt();
	    			switch(update_choice) {
	    				case 1:
	    					store.addMedia(dvd2);
	    					break;
	    				case 2:
	    					System.out.println("Enter id of media you want to remove: ");
	    					int id;
	    					id = sc.nextInt();
	    					store.removeMedia(store.disc(id));
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
	    					System.out.println("You want to filter Medias by: ");
	    		    		System.out.println("1. ID"); 
	    		    		System.out.println("2. Title");  
	    		    		System.out.println("0. Exit");
	    		    		System.out.println("--------------------------------");
	    		    		System.out.println("Please choose a number: 0-1-2");
	    		    		filter_choice = sc.nextInt();
	    		    		switch(filter_choice) {
	    		    			case 1:
	    		    			    System.out.println("Enter the ID of Media you want to filter:");
	    		    			    int ID;
	    		    			    ID = sc.nextInt();
	    		    			    anOrder.SearchID(ID);
	    		    				break;
	    		    			case 2:
	    		    				System.out.println("Enter the title (or token of title) of Media you want to filter:");
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
	    					System.out.println("You want to sort Medias by: ");
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
	    					System.out.println("Enter ID of Media that you want to remove from your cart:");
	    					int id;
	    					id = sc.nextInt();
	    					anOrder.removeMedia(id);
	    					break;
	    				case 4:
	    					Media lucky_item = anOrder.getALuckyItem();
	    					lucky_item.setFree();
	    					break;
	    				case 5:
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
