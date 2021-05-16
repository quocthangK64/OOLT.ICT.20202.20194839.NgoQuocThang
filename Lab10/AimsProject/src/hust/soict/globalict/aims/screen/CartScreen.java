package hust.soict.globalict.aims.screen;

import java.io.IOException;

import javax.swing.JFrame;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Track;
import hust.soict.globalict.aims.store.Store;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class CartScreen extends JFrame{
	private Cart cart;
	private Store store;
	public CartScreen(Cart cart, Store store) {
		super();
		
		this.cart = cart;
		this.store = store;
		
		JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel);
		
		this.setTitle("Cart");
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1024, 768);
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {
					FXMLLoader loader = new FXMLLoader(getClass()
							.getResource("/hust/soict/globalict/aims/screen/cart.fxml"));
					CartScreenController controller =
							new CartScreenController(cart, store);
					loader.setController(controller);
					Parent root = loader.load();
					fxPanel.setScene(new Scene(root));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
	
		});
		
	}
	
	// BECAUSE I JUST ONLY ALLOW CARTSCREEN OPENS THROUGH STORESCREEN
	// MEANS USER ONLY OPENS CARTSCREEN THROUGH BUTTON VIEWCART ON STORESCREEN
	// IF YOU WANT TO TEST CARTSCREEN AND IT'S FUNCTION ONLY
	// YOU CAN UNCOMMENT ALL COMMENT LINES OF MAIN PROGRAM BELOW TO TEST
	// THANK YOU
	
//	public static void main(String[] args) {
//		Cart anOrder = new Cart();
//		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
//				"Bnimation","Roger Allers", 87, 19.95f);
//		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Stars Wars",
//		    	"Science Fiction","George Lucas", 87, 24.95f);
//		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
//				"Bnimation", 18.99f);
//	    DigitalVideoDisc dvd4 = new DigitalVideoDisc("the lion king",
//	    		"Animation", 18f);
//	    DigitalVideoDisc dvd5 = new DigitalVideoDisc("Aladin",
//	    		"Animation", 19.95f);
//	    Book b1 = new Book("Harry Potter", "Magic", 2.05f, "I can can the can, but the can cannot can me");
//	    Book b2 = new Book("Lich Su Dang", "History", 2.00f, new String[] {"Hoang Thi Lan", "Luong Thi Phuong Thao"}, "I can can the can, but the can cannot can me");
//	    Book b3 = new Book("Harry Potter 2", "Magic", 2.05f, "I can can the can, but the can cannot can me");
//	    // Lab07 create a CD and add to store
//	    CompactDisc cd1 = new CompactDisc("Bandcamp","Jacam Manricks Music",2.05f);
//	    Track t1 =  new Track("HOW SHALLOW", 5);
//	    Track t2 = new Track("SlIPPERY", 4);
//	    Track t3 = new Track("INTERCEPT", 6);
//	    cd1.addTrack(t1);
//	    cd1.addTrack(t2);
//	    cd1.addTrack(t3);
//		anOrder.addMedia(dvd1);
//		anOrder.addMedia(dvd4);
//		anOrder.addMedia(dvd2);
//		anOrder.addMedia(dvd3);
//		anOrder.addMedia(dvd5);
//		anOrder.addMedia(b1);
//		anOrder.addMedia(b2);
//		anOrder.addMedia(cd1);
//		
//		Store s = new Store();
//   		s.addMedia(dvd1);
//   		s.addMedia(dvd2);
//   		s.addMedia(dvd3);
//   		s.addMedia(dvd4);
//   		s.addMedia(dvd5);
//   		s.addMedia(b1);
//   		s.addMedia(b2);
//   		s.addMedia(cd1);
//   		s.addMedia(b3);
//		new CartScreen(anOrder, s);
//	}

}
