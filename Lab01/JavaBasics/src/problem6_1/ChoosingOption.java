package JavaBasics.src.problem6_1;
import javax.swing.JOptionPane;
public class ChoosingOption {

	public static void main(String[] args) {
		
		int option = JOptionPane.showConfirmDialog(null, 
				"Do you want to change to the first class ticket");
		
		//if we choose Cancel --> option will become 2 different from "JOptionPane.YES_OPTION(0)" 
		//  --> so the answer will be NO
		JOptionPane.showMessageDialog(null, "You've chosen: "
				+(option==JOptionPane.YES_OPTION?"Yes":"No"));
		
		// only 2 options: YES and NO  (0) it's another method with 4 variables
		JOptionPane.showConfirmDialog(null,"Do you want to change to the first class ticket" , 
				"2 options YES and NO only (0) it's another method with 4 variables", 0);
		System.exit(0);
        
	}

}