package companies.thoughtworks;

public class Practice {

    /**
     * This prints a concentric square with center at 1, and incrementing as we go
     * out
     * 
     * 
     */
    public void printSquareWithNumbers(int max) {
	int sqSize = 2 * max - 1;

	for (int y = sqSize; y >0; y--) {
	    for (int x = 1; x <= sqSize; x++) {
		if(y==sqSize || y ==1) {
		    System.out.print(" ["+max+"]");
		}else if(x==sqSize || x ==1) {
		    System.out.print(" ["+max+"]");
		}else {
		System.out.print(" ["+(y+1)/2+"]");
		}
		if(x==sqSize) {
		    System.out.println();
		}		
	    }
	}
    }
}
