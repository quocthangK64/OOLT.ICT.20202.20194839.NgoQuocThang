import javax.swing.JOptionPane;
public class problem5 {	
		public static void main(String[] args) {
			
			String strnum1 = JOptionPane.showInputDialog("Enter the first number: ");
			String strnum2 = JOptionPane.showInputDialog("Enter the second number: ");
			double num1 = Double.parseDouble(strnum1);
			double num2 = Double.parseDouble(strnum2);
			JOptionPane.showMessageDialog(null,"Sum of them is: "+ (num1+num2));
			JOptionPane.showMessageDialog(null,"Difference of them is: "+ (num1-num2));
			JOptionPane.showMessageDialog(null,"Product of them is: "+ (num1*num2));
			if (num2!=0) JOptionPane.showMessageDialog(null,"Quotient of them is: "+ (num1/num2));
			else JOptionPane.showMessageDialog(null,"The second number is 0, so we can't have quotient.");
		    System.exit(0);
		}
		
	}

