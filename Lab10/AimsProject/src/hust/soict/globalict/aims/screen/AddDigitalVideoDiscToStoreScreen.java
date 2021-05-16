package hust.soict.globalict.aims.screen;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.store.Store;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen{
	private JTextField tfDirector;
	private JTextField tfLength;
	public AddDigitalVideoDiscToStoreScreen(Store store, Cart cart) {
		super(store, cart);
		btnOK.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				float cost = Float.parseFloat(tfCost.getText());
				int length = Integer.parseInt(tfLength.getText());
				DigitalVideoDisc dvd = new DigitalVideoDisc(tfTitle.getText(),tfCategory.getText(),tfDirector.getText(),length,cost);
				store.addMedia(dvd);
				new StoreScreen(store, cart);
				setVisible(false);
			}
		});
		setTitle("Enter some info for the DVD");
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
		center.add(new JLabel("Director: "));
		tfDirector = new JTextField();
		center.add(tfDirector);
		center.add(new JLabel("Length: "));
		tfLength = new JTextField();
		center.add(tfLength);
		
		return center;
	}
}
