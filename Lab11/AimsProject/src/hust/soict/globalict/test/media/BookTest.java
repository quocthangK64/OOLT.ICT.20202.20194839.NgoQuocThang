package hust.soict.globalict.test.media;

import hust.soict.globalict.aims.media.Book;

public class BookTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Book b1 = new Book("Harry Potter", "Magic", 2.05f, "I can can the can, but the can cannot can me");
		 Book b2 = new Book("Lich Su Dang", "History", 2.00f, new String[] {"Hoang Thi Lan", "Luong Thi Phuong Thao"}, 
				 "I can can the can, but the can cannot can me");
		 b1.getDetail();
		 System.out.println(b2.toString());
	}
}
