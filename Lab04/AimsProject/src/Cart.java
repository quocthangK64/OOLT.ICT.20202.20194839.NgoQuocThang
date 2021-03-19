import javax.swing.JOptionPane;
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
			JOptionPane.showMessageDialog(null, "The disc titled " + disc.getTitle() + " has been added");
		}else {
			JOptionPane.showMessageDialog(null, "The cart is almost full");
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
			JOptionPane.showMessageDialog(null, "There are no more disk to remove");
		}else {
			if(pos == -1) {
				JOptionPane.showMessageDialog(null, "There are no disks titled " + disc.getTitle() + " in the cart to remove");
			}else {
				if(QtyOrdered > 0) {
					for(int i = pos; i < QtyOrdered-1; i++) {
						itemOrdered[i] = itemOrdered[i+1];
					}
					QtyOrdered--;
					JOptionPane.showMessageDialog(null, "The disc titled " + disc.getTitle()+ " has been removed");
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
}
