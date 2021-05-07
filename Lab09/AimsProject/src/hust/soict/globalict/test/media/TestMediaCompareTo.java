package hust.soict.globalict.test.media;
import java.util.Collection;
import java.util.Collections;

import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;

import java.util.ArrayList;
public class TestMediaCompareTo {

	public static void main(String[] args) {
		Collection<Media> collection = new ArrayList<Media>();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
				"Animation","Roger Allers", 87, 19.95f);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Stars Wars",
				"Science Fiction","George Lucas", 124, 24.95f);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
				"Animation","George Lucas", 90, 18.99f);
		// same title different category
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("aladin",
				"BCD","George Lucas", 90, 18.99f);
		
		collection.add(dvd4);
		collection.add(dvd2);
		collection.add(dvd1);
		collection.add(dvd3);
		
		java.util.Iterator<Media> iterator = collection.iterator();
		
		System.out.println("-----------------------------------");
		System.out.println("The DVDs currently in the order are: ");
		
		while (iterator.hasNext()) {
			System.out.println((iterator.next()).getTitle());
		}
		
		Collections.sort((java.util.List<Media>) collection);
		
		iterator = collection.iterator();
		
		System.out.println("-----------------------------------");
		System.out.println("The DVDs in sorted order are: ");
		
		while (iterator.hasNext()) {
			System.out.println((iterator.next()).getTitle());
		}
		
		System.out.println("-----------------------------------");
	}

}
