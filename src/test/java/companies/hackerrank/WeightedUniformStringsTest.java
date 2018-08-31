package companies.hackerrank;

import static org.junit.Assert.assertTrue;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WeightedUniformStringsTest {
    WeightedUniformStrings wus = new WeightedUniformStrings();

    @Test
    public void test1() {
        String s = "aaabbbbcccddd";
        int[] queries = {5, 9, 7, 8, 12, 5};
        String[] result = wus.weightedUniformStrings(s, queries);
        
        Assert.assertTrue(result.length==6);
        
        //[NO, YES, NO, YES, YES, NO]
        Assert.assertTrue(result[0].equalsIgnoreCase("yes"));//5
        Assert.assertTrue(result[1].equalsIgnoreCase("no"));//9
        Assert.assertTrue(result[2].equalsIgnoreCase("yes"));//7
        Assert.assertTrue(result[3].equalsIgnoreCase("yes"));//8
        Assert.assertTrue(result[4].equalsIgnoreCase("no"));//12
        Assert.assertTrue(result[4].equalsIgnoreCase("yes"));//5
    }
    
    
    @Test
    public void test2() {
        String s = "abccddde";
        int[] queries = {6, 1, 3, 12, 5, 9, 10};
        String[] result = wus.weightedUniformStrings(s, queries);
        
        Assert.assertTrue(result.length==7);
        //[1, 2, 3, 6, 4, 8, 12, 5]
        //[YES, YES, YES, YES, NO, NO]
        Assert.assertTrue(result[0].equalsIgnoreCase("yes"));//6
        Assert.assertTrue(result[1].equalsIgnoreCase("yes"));//1
        Assert.assertTrue(result[2].equalsIgnoreCase("yes"));//3
        Assert.assertTrue(result[3].equalsIgnoreCase("yes"));//12
        Assert.assertTrue(result[4].equalsIgnoreCase("no"));//5
        Assert.assertTrue(result[4].equalsIgnoreCase("no"));//9
        Assert.assertTrue(result[4].equalsIgnoreCase("no"));//10
    }
}
