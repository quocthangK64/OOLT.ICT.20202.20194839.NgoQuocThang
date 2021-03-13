import javax.swing.JOptionPane;

public class Aims {

	public static void main(String[] args) {
		
		Cart anOrder = new Cart();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
				"Animation","Roger Allers", 87, 19.95f);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Stars Wars",
				"Science Fiction","George Lucas", 87, 24.95f);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
				"Animation", 18.99f);
		// check totalCost and removeDVD
		anOrder.addDigitalVideoDisc(dvd1);
		anOrder.addDigitalVideoDisc(dvd2);
		anOrder.removeDigitalVideoDisc(dvd1);
		anOrder.removeDigitalVideoDisc(dvd2);
		anOrder.removeDigitalVideoDisc(dvd3);
		// check addDVD full. Set MAX_NUMBERS_ORDERED = 3 in Cart class
		JOptionPane.showMessageDialog(null, "Total Cost is: " + anOrder.totalCost());
		
	}
}
