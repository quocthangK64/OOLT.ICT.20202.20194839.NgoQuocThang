package hust.soict.globalict.aims.screen;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.store.Store;

public class AddBookToStoreScreen extends AddItemToStoreScreen{
	private JTextField tfAuthors;
	private JTextField tfContent;
	public AddBookToStoreScreen(Store store, Cart cart) {
		super(store, cart);
		btnOK.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				float cost = Float.parseFloat(tfCost.getText());
				String [] authors = tfAuthors.getText().split("[, ?.@]+");
				Book b = new Book(tfTitle.getText(),tfCategory.getText(),cost,authors,tfContent.getText());
				store.addMedia(b);
				new StoreScreen(store, cart);
				setVisible(false);
			}
		});
		setTitle("Enter some info for the Book");
	}
	
	JPanel createCenter() {
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(5, 1));
		
		center.add(new JLabel("Title: "));
		tfTitle = new JTextField();
		center.add(tfTitle);
		center.add(new JLabel("Category: "));
		tfCategory = new JTextField();
		center.add(tfCategory);
		tfCost = new JTextField();
		center.add(new JLabel("Cost: "));
		center.add(tfCost);
		center.add(new JLabel("List of authors (seperated by space): "));
		tfAuthors = new JTextField();
		center.add(tfAuthors);
		center.add(new JLabel("Content: "));
		tfContent = new JTextField();
		center.add(tfContent);
		
		return center;
	}

}
