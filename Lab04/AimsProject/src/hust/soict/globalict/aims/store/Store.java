package hust.soict.globalict.aims.store;
import java.util.ArrayList;
import  hust.soict.globalict.aims.disc.*;
public class Store {
	public ArrayList<DigitalVideoDisc> itemsInStore = new ArrayList<DigitalVideoDisc>();
	public void addDVD(DigitalVideoDisc disc) {
		this.itemsInStore.add(disc);
		System.out.println(disc.getTitle() + " has been added to store.");
	}
	public void removeDVD(DigitalVideoDisc disc) {
		int count = 0;
		for(DigitalVideoDisc item : itemsInStore) {
			if(item.equals(disc)) {
			this.itemsInStore.remove(disc);
			System.out.println(item.getTitle()+ " has been removed from store.");
			count--;
			break;
			}else count++;
		}
		if(count == itemsInStore.size()) {
			System.out.println("There are no disks titled " + disc.getTitle() + " in the store to remove.");
		}
	}
	public void printID() {
		System.out.println("List of available items in store: ");
		for (DigitalVideoDisc item : itemsInStore) {
			System.out.print(item.getId()+"   ");
		}
		System.out.println();
	}
	
	public void SearchID(String id) {
		int count = 0;
		for(DigitalVideoDisc item : itemsInStore) {
			if(item.getId().equals(id)) {
				System.out.println(item.getDetail());
				count--;
				break;
			}else count++;
		}
		if(count == itemsInStore.size()) {
			System.out.println("ID is invalid. That DVD may not be in the cart.");
		}
	}
	
	public DigitalVideoDisc disc(String id) {
		for(DigitalVideoDisc item : itemsInStore) {
			if(item.getId().equals(id)) {
				return item;
			}
		}
		return null;
	}
}
