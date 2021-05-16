package hust.soict.globalict.aims.screen;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.store.Store;


public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen{
	private JTextField tfDirector;
	public AddCompactDiscToStoreScreen(Store store, Cart cart) {
		super(store, cart);
		btnOK.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				float cost = Float.parseFloat(tfCost.getText());
				CompactDisc cd = new CompactDisc(tfTitle.getText(),tfCategory.getText(),tfDirector.getText(),cost);
				store.addMedia(cd);
				new StoreScreen(store, cart);
				setVisible(false);
			}
		});
		setTitle("Enter some info for the CD");
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
		
		return center;
	}
}
