package hust.soict.globalict.aims.store;
import java.util.ArrayList;

import hust.soict.globalict.aims.exception.PlayerException;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;
public class Store {
	public ArrayList<Media> itemsInStore = new ArrayList<Media>();
	public void addMedia(Media m) {
		this.itemsInStore.add(m);
		System.out.println(m.getTitle() + " has been added to store.");
	}
	public void removeMedia(Media m) {
		if(m!=null) {
		int count = 0;
		for(Media item : itemsInStore) {
			if(item.equals(m)) {
			this.itemsInStore.remove(m);
			System.out.println(item.getTitle()+ " has been removed from store.");
			count--;
			break;
			}else count++;
		}
		if(count == this.itemsInStore.size()) {
			System.out.println("There are no disks titled " + m.getTitle() + " in the store to remove.");
		}
		}else {
			System.out.println("This media has not been in the store.");
		}
	}
	public void printID() {
		System.out.println("List of available items in store: ");
		for (Media item : itemsInStore) {
			System.out.print(item.getId()+"   ");
		}
		System.out.println();
	}
	
	public void SearchID(int id) {
		int count = 0;
		for(Media item : itemsInStore) {
			if(item.getId()==id) {
				item.getDetail();
				count--;
				break;
			}else count++;
		}
		if(count == itemsInStore.size()) {
			System.out.println("ID is invalid. That media may not be in the store.");
		}
	}
	
	public Media disc(int id) {
		for(Media item : itemsInStore) {
			if(item.getId()==id) {
				return item;
			}
		}
		return null;
	}
	
	public void play(int id) throws PlayerException {
		int count = 0;
		for(Media item : itemsInStore) {
			if(item.getId()==id) {
				if(item.getClass().getSimpleName().equals("Book")) {
					System.out.println("You had already chosen a book which cannot be played.");
				}else {
					if(item.getClass().getSimpleName().equals("DigitalVideoDisc")) {
						DigitalVideoDisc dvd = (DigitalVideoDisc) item;
						dvd.play();
					}else {
						if(item.getClass().getSimpleName().equals("CompactDisc")) {
							CompactDisc  cd = (CompactDisc) item;
							cd.play();
						}
					}
				}
				count--;
				break;
			}else count++;
		}
		if(count == itemsInStore.size()) {
			System.out.println("ID is invalid. That media may not be in the store.");
		}
	}
	
	public ArrayList<Media> getItemsInStore() {
		return itemsInStore;
	}
	
}
