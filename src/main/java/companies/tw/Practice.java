package companies.tw;

public class Practice {

    /**
     * This prints a concentric square with center at 1, and incrementing as we go
     * out
     * 
     * @param max
     */
    public void printSquareWithConcentricNumbers(int max) {
	int sqSize = 2 * max - 1;

	for (int y = 0; y < sqSize; y++) {
	    for (int x = 0; x < sqSize; x++) {
		System.out.print(" [" + (1 + Math.max(Math.abs(max - y - 1), Math.abs(max - x - 1))) + "]");
	    }
	    System.out.println();
	}
    }

    /**
     * Print a rhombus with increasing width upto firstNOddNumbers
     * @param firstNOddNumbers - 
     */
    public void printPerfectRhombus(int firstNOddNumbers) {

	int count = 1;
	for (int y = 1; y <= firstNOddNumbers; y++) {
	    for (int x = 1; x <= Math.abs(firstNOddNumbers - y); x++) {
		System.out.print("[ ]");
	    }

	    for (int x = 1; x <= 2 * y - 1; x++) {
		System.out.print("[" + count + "]");
		count++;
	    }
	    System.out.println();
	}
	// count=1;
	for (int y = firstNOddNumbers - 1; y >= 1; y--) {
	    for (int x = 1; x <= Math.abs(firstNOddNumbers - y); x++) {
		System.out.print("[ ]");
	    }
	    for (int x = 1; x <= 2 * y - 1; x++) {
		System.out.print("[" + count + "]");
		count++;
	    }
	    System.out.println();
	}

    }
    
    
}
