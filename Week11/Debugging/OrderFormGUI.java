package Week11.Debugging;
import javax.swing.*;

public class OrderFormGUI {
    public static void main(String[] args) {
        /** DO NOT CHANGE VALUES BELOW **/
        boolean hoodieInStock = true;
        boolean tshirtInStock = false;
        boolean longsleeveInStock = true;
        String item = "";
        int quantity = 0;
        String name = "";
        /** DO NOT CHANGE VALUES ABOVE **/
        int cont = 0;

        do {
        	do {
	        	String[] options = {"Hoodie", "T-shirt", "Long sleeve"};
	        	item = (String) JOptionPane.showInputDialog(null, "Select item style ", "Order Form",
	        			JOptionPane.PLAIN_MESSAGE, null, options, null);
	        	if (item.equals("Hoodie") && !hoodieInStock) {
	        		JOptionPane.showMessageDialog(null, "Item not in stock!", "Order Form",
	                        JOptionPane.ERROR_MESSAGE);
	        	} else if (item.equals("T-shirt") && !tshirtInStock) {
	        		JOptionPane.showMessageDialog(null, "Item not in stock!", "Order Form",
	                        JOptionPane.ERROR_MESSAGE);
	        	} else if (item.equals("Long sleeve") && !longsleeveInStock) {
	        		JOptionPane.showMessageDialog(null, "Item not in stock!", "Order Form",
	                        JOptionPane.ERROR_MESSAGE);
	        	} else {
	        		break;
	        	}
        	} while (true);
        	
	        do {
	        	try {
			        quantity = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter quantity", "Order Form",
			                JOptionPane.QUESTION_MESSAGE));
			        if (quantity < 1) {
			        	JOptionPane.showMessageDialog(null, "Quantity must be an integer greater than 0!", "Order Form",
		                        JOptionPane.ERROR_MESSAGE);
			        }
	        	} catch (NumberFormatException e) {
	        		JOptionPane.showMessageDialog(null, "Quantity must be an integer greater than 0!", "Order Form",
	                        JOptionPane.ERROR_MESSAGE);
	        	}
	        } while (quantity <= 0);
	        
        
	        do {
		        name = JOptionPane.showInputDialog(null, "Enter your Name", "Order Form",
		                JOptionPane.QUESTION_MESSAGE);
		        if ((name == null || name.isEmpty())) {
		        	JOptionPane.showMessageDialog(null, "Name cannot be empty!", "Order Form",
	                        JOptionPane.ERROR_MESSAGE);
		        }
	        } while ((name == null || name.isEmpty()));

	        /** Order Confirmation Message **/
	        String resultMessage = "Name: " + name + "\nItem: " + item + "\nQuantity: " + quantity;
	        JOptionPane.showMessageDialog(null, resultMessage, "Order Confirmation", JOptionPane.INFORMATION_MESSAGE);
	
	        cont = JOptionPane.showConfirmDialog(null, "Would you like to place another order?", "Order Form", JOptionPane.YES_NO_OPTION);

        } while (cont == 0);
        
        quantity = 0;

    }
}

