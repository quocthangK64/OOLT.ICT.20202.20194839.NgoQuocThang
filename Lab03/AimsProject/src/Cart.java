import java.util.Comparator;
import java.util.Arrays;
public class Cart {
	
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemOrdered[] = 
			new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int QtyOrdered = 0;
	
	// getter to get the current disc in the cart
    public int getQtyOrdered() {
		return QtyOrdered;
	}
    
    // a function to use in method removeDigitalVideoDisc
	int searchDisc(DigitalVideoDisc disc) {
		for(int i = 0; i < QtyOrdered; i++) {
			if(itemOrdered[i].equals(disc)) 
				return i;
		}
		return -1;
	}
	
	// addDigitalVideoDisc method
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if(QtyOrdered < MAX_NUMBERS_ORDERED) {
			itemOrdered[QtyOrdered] = disc;
			QtyOrdered++;
			System.out.println("The disc titled " + disc.getTitle() + " has been added");
		}else {
			System.out.println("The cart is almost full");
		}
	}
	
	// overloading addDigitalVideoDisc method with 1 parameter LIST (-------LAB04--------)
	public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList) {
		for(int i = 0; i < dvdList.length; i++) {
			this.addDigitalVideoDisc(dvdList[i]);
		}
	}
	//overloading addDigitalVideoDisc method with 2 parameters (-------LAB04--------)
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		this.addDigitalVideoDisc(dvd1);
		this.addDigitalVideoDisc(dvd2);
	}
	
	// removeDigitalVideoDisc method
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		int pos = searchDisc(disc);
		if(QtyOrdered == 0) {
			System.out.println("There are no more disk to remove");
		}else {
			if(pos == -1) {
				System.out.println("There are no disks titled " + disc.getTitle() + " in the cart to remove");
			}else {
				if(QtyOrdered > 0) {
					for(int i = pos; i < QtyOrdered-1; i++) {
						itemOrdered[i] = itemOrdered[i+1];
					}
					QtyOrdered--;
					System.out.println("The disc titled " + disc.getTitle()+ " has been removed");
				}
			}
		}
	}
	
	// totalCost method
	public float totalCost() {
		float sum = 0;
		for (int i = 0; i < QtyOrdered; i++) {
			sum += itemOrdered[i].getCost();
		}
		return sum;
	}
	// 
	public void ShowDetail() {
		for(int i = 0; i < QtyOrdered; i++) {
			System.out.println(itemOrdered[i].getDetail());
		}
	}
	
	//Sort the DVDs in the cart by cost and print the result
	public void SortbyCostandPrint() {
		System.out.println("Show details of all sorted DVDs by cost in the cart");
		itemOrdered = DVDUtils.sortByCost(itemOrdered);
		System.out.println("ID   Title   Category   Director   Length   Cost   Date_added");
		for(int i = 0; i < QtyOrdered; i++) {
			System.out.println(itemOrdered[i].getDetail());
		}
	}
	
	public void SortbyTitleandPrint() {
		System.out.println("Show details of all sorted DVDs by title in the cart");
		itemOrdered = DVDUtils.sortByTitle(itemOrdered);
		System.out.println("ID   Title   Category   Director   Length   Cost   Date_added");
		for(int i = 0; i < QtyOrdered; i++) {
			System.out.println(itemOrdered[i].getDetail());
		}
	}
	
	public void SearchID(String id) {
		int count = 0;
		for(int i = 0; i < QtyOrdered; i++) {
			if(itemOrdered[i].getId().compareToIgnoreCase(id) == 0) {
				System.out.println(itemOrdered[i].getDetail());
			}else count++;
		}
		if (count == QtyOrdered) System.out.println("No match is found.");
	}
	public void Printlist() {
		Comparator<DigitalVideoDisc> DVDcheck = new Comparator<DigitalVideoDisc>() {
			@Override
			public int compare(DigitalVideoDisc disc1, DigitalVideoDisc disc2) {
				int compareByTitle = DVDUtils.compareByTitle(disc1, disc2);
				if(compareByTitle == 0) {
					int compareByCost = DVDUtils.compareByCost(disc1, disc2);
					if(compareByCost == 0) {
						return disc2.getLength() - disc1.getLength();
					}
					return -compareByCost;
				}
				return compareByTitle;
			}
		};
		int number = 0;
    	for (number = 0; itemOrdered[number] != null; number++);
//    	DigitalVideoDisc[] itemOrdered_new = new DigitalVideoDisc [number];
////    	for(int i =0; i<number;i++) {
////    		itemOrdered_new[i] = itemOrdered[i];
////    	}
//		Arrays.sort(itemOrdered_new,DVDcheck);
		Arrays.sort(itemOrdered, 0, number, DVDcheck);
		System.out.println("=============CART=============");
		System.out.println("Ordered items:");
		for(int i = 0; i < QtyOrdered; i++) {
			System.out.println(itemOrdered[i].getTitle() + " - " + itemOrdered[i].getCategory() + " - " + itemOrdered[i].getDirector() + " - " + itemOrdered[i].getLength() + " : " + itemOrdered[i].getCost() + "$");
		}
		System.out.println("Total Cost: " + this.totalCost());
	}
}
