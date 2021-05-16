package hust.soict.globalict.aims.screen;

import javax.swing.*;
import java.awt.*;
import hust.soict.globalict.aims.store.Store;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Playable;
import hust.soict.globalict.aims.media.Track;
public class StoreScreen extends JFrame{
	private Store store;
	private Cart cart;
	public StoreScreen(Store store, Cart cart) {
		this.store = store;
		this.cart = cart;
		
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Store");
		setSize(1024, 768);
		setVisible(true);
	}
	
	JMenuBar createMenuBar() {
		
		JMenu menu = new JMenu("Options");
		
		JMenu smUpdateStore = new JMenu("Update Store");
		JMenuItem smAddBook = new JMenuItem("Add Book");
		JMenuItem smAddCD = new JMenuItem("Add CD");
		JMenuItem smAddDVD = new JMenuItem("Add DVD");
		smUpdateStore.add(smAddBook);
		smUpdateStore.add(smAddCD);
		smUpdateStore.add(smAddDVD);
		
		menu.add(smUpdateStore);
		menu.add(new JMenuItem("View store"));
		JMenuItem smViewCart = new JMenuItem("View cart");
		menu.add(smViewCart);
		
		smViewCart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new CartScreen(cart, store);
				setVisible(false);
			}
		});
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		
		smAddBook.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new AddBookToStoreScreen(store, cart);
				setVisible(false);
			}
		});
		
		smAddCD.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new AddCompactDiscToStoreScreen(store, cart);
				setVisible(false);
			}
		});
		
		smAddDVD.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new AddDigitalVideoDiscToStoreScreen(store, cart);
				setVisible(false);
			}
		});
		
		
		return menuBar;
	}
	
	JPanel createHeader() {
		
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		
		JLabel title = new JLabel("AIMS");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
		title.setForeground(Color.CYAN);
		
		JButton btnCart = new JButton("View cart");
		btnCart.setPreferredSize(new Dimension(100, 50));
		btnCart.setMaximumSize(new Dimension(100, 50));
		btnCart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new CartScreen(cart, store);
				setVisible(false);
			}
		});
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(btnCart);
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		
		return header;
	}
	
	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}
	
	JPanel createCenter() {
		
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(3, 3, 2, 2));
		
		ArrayList<Media> mediaInStore = store.getItemsInStore();
		for (int i = 0; i < mediaInStore.size(); i++) {
			MediaStore cell = new MediaStore(mediaInStore.get(i));
			center.add(cell);
		}
		
		return center;
	}
	
	public class MediaStore extends JPanel{
		private Media media;
		public MediaStore(Media media) {
			
			this.media = media;
			this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			
			JLabel title = new JLabel(media.getTitle());
			title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
			title.setAlignmentX(CENTER_ALIGNMENT);
			
			JLabel cost = new JLabel("" + media.getCost() + " $");
			cost.setAlignmentX(CENTER_ALIGNMENT);
			
			JPanel container = new JPanel();
			container.setLayout(new FlowLayout(FlowLayout.CENTER));
			
			JButton btnAddToCart = new JButton("Add to cart");
			container.add(btnAddToCart);
			btnAddToCart.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					cart.addMedia(media);
				}
			});
			
			JButton btnRemove = new JButton("Remove");
			container.add(btnRemove);
			btnRemove.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					store.removeMedia(media);
					setVisible(false);
				}
			});
			
			if(media instanceof Playable) {
				JButton btnPlay = new JButton("Play");
				container.add(btnPlay);
				
				btnPlay.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						new Dialog(media);
					}
				});
			}
			this.add(Box.createVerticalGlue());
			this.add(title);
			this.add(cost);
			this.add(Box.createVerticalGlue());
			this.add(container);
			
			this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		}
	}
	
	public static void main(String[] args) {
		Store s = new Store();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
				"Bnimation","Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Stars Wars",
		    	"Science Fiction","George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
				"Bnimation", 18.99f);
	    DigitalVideoDisc dvd4 = new DigitalVideoDisc("the lion king",
	    		"Animation", 18f);
	    DigitalVideoDisc dvd5 = new DigitalVideoDisc("Aladin",
	    		"Animation", 19.95f);
	    Book b1 = new Book("Harry Potter", "Magic", 2.05f, "I can can the can, but the can cannot can me");
	    Book b2 = new Book("Lich Su Dang", "History", 2.00f, new String[] {"Hoang Thi Lan", "Luong Thi Phuong Thao"}, "I can can the can, but the can cannot can me");
	    Book b3 = new Book("Harry Potter 2", "Magic", 2.05f, "I can can the can, but the can cannot can me");
	    //Book b4 = new Book("Harry Potter 3", "Magic", 2.05f, "I can can the can, but the can cannot can me");
	    CompactDisc cd1 = new CompactDisc("Bandcamp","Jacam Manricks Music",2.05f);
	    Track t1 =  new Track("HOW SHALLOW", 5);
	    Track t2 = new Track("SlIPPERY", 4);
	    Track t3 = new Track("INTERCEPT", 6);
	    cd1.addTrack(t1);
	    cd1.addTrack(t2);
	    cd1.addTrack(t3);
	    s.addMedia(dvd1);
	    s.addMedia(dvd2);
	    s.addMedia(dvd3);
	    s.addMedia(dvd4);
	    s.addMedia(dvd5);
	    s.addMedia(b1);
	    s.addMedia(b2);
	    s.addMedia(cd1);
	    s.addMedia(b3);
	    //s.addMedia(b4);
	    
	    // if you want to check cart works you can press button "Add to cart" twice for 1 items it will print on console 
	    // or print out something in addMedia method in Cart class
	    Cart c = new Cart();
	    new StoreScreen(s, c);
	}

}
