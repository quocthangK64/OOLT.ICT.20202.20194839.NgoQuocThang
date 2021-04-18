package hust.soict.globalict.aims.cart;
import java.util.ArrayList;
import java.util.Collections;

import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.utils.MediaUtils;
public class Cart {
	
	public static final int MAX_NUMBERS_ORDERED = 20;
	// using array_list instead of array
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	
	// update addMedia and removeMedia
	public void addMedia(Media m) {
		if (m == null) System.out.println("This media is not in the store.");
		else {
		if(this.itemsOrdered.size()<20) {
			this.itemsOrdered.add(m);
		}else 
			System.out.println("The cart is almost full.");
		}
	}
	public void removeMedia(Media m) {
		if(this.itemsOrdered.size() > 0) {
			this.itemsOrdered.remove(m);
		}else
			System.out.println("The cart is empty. Nothing to remove.");
	}
	// totalCost method
	public float totalCost() {
		float sum = 0;
		for (int i = 0; i < this.itemsOrdered.size(); i++) {
			sum += this.itemsOrdered.get(i).getCost();
		}
		return sum;
	}
	// 
	public void ShowDetail() {
		for(int i = 0; i < itemsOrdered.size(); i++) {
			itemsOrdered.get(i).getDetail();
		}
	}
	
	//Sort the DVDs in the cart by cost and print the result
	public void SortbyCostandPrint() {
		System.out.println("Show details of all sorted medias by cost in the cart");
		itemsOrdered = MediaUtils.sortByCost(itemsOrdered);
		for(int i = 0; i < itemsOrdered.size(); i++) {
			itemsOrdered.get(i).getDetail();
		}
	}
	
	public void SortbyTitleandPrint() {
		System.out.println("Show details of all sorted medias by title in the cart");
		itemsOrdered = MediaUtils.sortByTitle(itemsOrdered);
		for(int i = 0; i < itemsOrdered.size(); i++) {
			itemsOrdered.get(i).getDetail();
		}
	}
	
	public void SearchID(int id) {
		int count = 0;
		for(int i = 0; i < itemsOrdered.size(); i++) {
			if(itemsOrdered.get(i).getId() == id) {
				itemsOrdered.get(i).getDetail();
			}else count++;
		}
		if (count == itemsOrdered.size()) System.out.println("No match is found.");
	}
	
	public void Printlist() {
//		Comparator<Media> DVDcheck = new Comparator<Media>() {
//			@Override
//			public int compare(Media disc1, Media disc2) {
//				int compareByTitle = MediaUtils.compareByTitle(disc1, disc2);
//				if(compareByTitle == 0) {
//					int compareByCost = MediaUtils.compareByCost(disc1, disc2);
//					if(compareByCost == 0) {
////						return disc2.getLength() - disc1.getLength();
//					}
//					return -compareByCost;
//				}
//				return compareByTitle;
//			}
//		};
		Collections.sort((java.util.List<Media>)itemsOrdered);
		System.out.println("===============================CART===============================");
		System.out.println("Ordered items:");
		if(itemsOrdered.size()==0) System.out.println("Empty."); 
		else {
		for(int i = 0; i < itemsOrdered.size(); i++) {
			itemsOrdered.get(i).getDetail();
		}
		System.out.println("Total Cost: " + this.totalCost());
		}
	}
	
	// ------------Lab05----------- //
	public void SearchTitle(String title) {
			int count = 0;
			for(int i = 0; i < itemsOrdered.size() ; i++) {
				if(itemsOrdered.get(i).search(title)) {
					itemsOrdered.get(i).getDetail();
				}else count++;
			}
			if (count == itemsOrdered.size()) System.out.println("No match is found.");
	}
	public void removeMedia(int id) {
		int count = 0;
    	if(itemsOrdered.size() == 0) {
    		System.out.println("There is nothing to remove.");
    	}else {
		for(int i = 0; i < itemsOrdered.size(); i++) {
			if(itemsOrdered.get(i).getId() == id) {
				this.removeMedia(itemsOrdered.get(i));
			}else count++;
		}
		if(count == itemsOrdered.size()) {
			System.out.println("ID is invalid. That DVD may not be in the cart.");
		}
    	}
	}
	public void addMedia(int id) {
		int count = 0;
		for(int i = 0; i < itemsOrdered.size(); i++) {
			if(itemsOrdered.get(i).getId() == id) {
				this.addMedia(itemsOrdered.get(i));
			}else count++;
		}
		if(count == itemsOrdered.size()) {
			System.out.println("ID is invalid. That DVD may not be in the cart.");
		}
	}
	public void emptyCart(){
	    itemsOrdered.clear();
	    System.out.println("Place order successfully. An order is created.");
	}
	// -----------Lab06----------------
	public Media getALuckyItem() {
		int max = Media.getNbMedia(), min = 1;
		while(true) {
			int lucky_id = (int)(Math.random() * (max - min + 1) + min);
			for(int i = 0; i < itemsOrdered.size(); i++) {
			if(itemsOrdered.get(i).getId() == lucky_id) {
				return itemsOrdered.get(i);
			}
			}
		}
	}
	// -----------Lab07--------------
	public void play(int id) {
		int count = 0;
		for(Media item : itemsOrdered) {
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
		if(count == itemsOrdered.size()) {
			System.out.println("ID is invalid. That media may not be in the cart.");
		}
	}
}
