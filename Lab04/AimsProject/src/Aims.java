public class Aims {

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
		// check addDVD full. Set MAX_NUMBERS_ORDERED = 3 in Cart class
		System.out.println("Total Cost is: " + anOrder.totalCost());
		System.out.println();
		System.out.println("Local Date of dvd3 in the store is: " + dvd3.getDateAdded());
//		System.out.println("ID of dvd4 in the store is: " + dvd4.getId());
		System.out.println("# of dvds in the store is: " + DigitalVideoDisc.getNbDigitalVideoDiscs());
		System.out.println();
		anOrder.Printlist();
	}
}
