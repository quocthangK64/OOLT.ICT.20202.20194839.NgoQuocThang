package hust.soict.globalict.aims;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.disc.DigitalVideoDisc;

public class DiskTest {
	public static void main(String[] args) {
		
        Cart anOrder = new Cart();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
				"Animation","Roger Allers", 87, 19.95f);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Stars Wars",
				"Science Fiction","George Lucas", 87, 24.95f);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
				"Animation", 18.99f);
		// constructor without cost. So cost will be 0 
	    DigitalVideoDisc dvd4 = new DigitalVideoDisc("the lion king","Animation", 18f);
		// check totalCost and removeDVD
		anOrder.addDigitalVideoDisc(dvd1);
		anOrder.addDigitalVideoDisc(dvd2);
		anOrder.addDigitalVideoDisc(dvd3);
		anOrder.addDigitalVideoDisc(dvd4);
		if(dvd1.search("thang dhdk thes 1234 kin sdaasfasf")) {
			System.out.println("True");
		}else System.out.println("False");
		
		anOrder.SearchTitle("1234 ngay cos nhung noi nho th");
	}
}
