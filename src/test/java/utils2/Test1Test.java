package utils2;

import org.testng.Assert;
import org.testng.annotations.Test;

import utils.Test1;

public class Test1Test {
    Test1 test1 = new Test1();

    /*public static void main(String[] args) {
	int[] pop = { 15, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
    }*/

    @Test
    public void test456() {
	int[] arr = { 15, 1, 2, 3 };

	int count = test1.minimumSwaps(arr);
	Assert.assertEquals(count, 1);

    }
}
