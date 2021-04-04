package hust.soict.globalict.test.store;

import hust.soict.globalict.aims.disc.DigitalVideoDisc;
import hust.soict.globalict.aims.store.Store;

public class StoreTest {

	public static void main(String[] args) {
		Store store = new Store();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
				"Animation","Roger Allers", 87, 19.95f);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Stars Wars",
				"Science Fiction","George Lucas", 87, 24.95f);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
				"Animation", 18.99f);
		
	    DigitalVideoDisc dvd4 = new DigitalVideoDisc("the lion king",
	    		"Animation", 18f);
	    
	    store.addDVD(dvd1);
	    store.addDVD(dvd2);
	    store.addDVD(dvd1);
	    store.addDVD(dvd3);
	    store.addDVD(dvd4);
	    store.removeDVD(dvd2);
	}

}
