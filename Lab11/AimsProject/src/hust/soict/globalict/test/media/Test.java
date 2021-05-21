package hust.soict.globalict.test.media;

import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;
import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		List<Media> mediae = new ArrayList<Media>();
		DigitalVideoDisc dvd = new DigitalVideoDisc("The Lion King",
					"Animation","Roger Allers", 87, 19.95f);
		CompactDisc cd = new CompactDisc("Bandcamp","Jacam Manricks Music",2.05f);
		Book book = new Book("Harry Potter", "Magic", 2.05f, "I can can the can, but the can cannot can me");
		mediae.add(cd);
		mediae.add(book);
		mediae.add(dvd);
		for (Media m : mediae)
			System.out.println(m.toString());
	}
}