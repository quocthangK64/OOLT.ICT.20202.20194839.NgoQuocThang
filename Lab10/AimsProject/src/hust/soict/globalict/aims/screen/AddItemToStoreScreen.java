package hust.soict.globalict.aims.screen;
import javax.swing.*;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.store.Store;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
public abstract class AddItemToStoreScreen extends JFrame{
	private Store store;
	private Cart cart;
	protected JTextField tfTitle;
	protected JTextField tfCategory;
	protected JTextField tfCost;
	protected JButton btnOK;
	public AddItemToStoreScreen(Store store, Cart cart) {
		this.store = store;
		this.cart = cart;
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		btnOK = new JButton("OK");
		cp.add(btnOK, BorderLayout.SOUTH);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 300);
		setVisible(true);
		setLocation(400,300);
	}
	
	JMenuBar createMenuBar() {
		
		JMenu menu = new JMenu("Options");
		
		JMenu smUpdateStore = new JMenu("Update Store");
		smUpdateStore.add(new JMenuItem("Add Book"));
		smUpdateStore.add(new JMenuItem("Add CD"));
		smUpdateStore.add(new JMenuItem("Add DVD"));
		
		menu.add(smUpdateStore);
		JMenuItem smViewStore = new JMenuItem("View store");
		menu.add(smViewStore);
		menu.add(new JMenuItem("View cart"));
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		
		smViewStore.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new StoreScreen(store, cart);
				setVisible(false);
			}
		});
		return menuBar;
	}
	
	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		return north;
	}
	
	JPanel createCenter() {
		JPanel center = new JPanel();
		return center;
	}
}
