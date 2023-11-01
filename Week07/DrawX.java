package Week07;

/**
 * A class that generates a 2-D char array representing an 'X'
 *
 * <p>Purdue University -- CS18000 -- Fall 2023</p>
 *
 * @author Purdue CS 
 * @version October 3, 2023
 */
public class DrawX {
 
    private int size; 
    
    public DrawX(int size) {
        this.size = size; 
    }
       
    public char[][] generateArray() {
        
        char[][] xArray = new char[size][size]; 
        
        for (int row = 0; row < size; ++row) {
            for (int col = 0; col < size; ++ col) {
                xArray[row][col] = ' ';
            }
        }
        
        for (int row = 0; row < size; ++row) {
        	xArray[row][row] = '*';
    		xArray[row][size - (row + 1)] = '*';
        }
        
        return xArray; 
    }
    
}
