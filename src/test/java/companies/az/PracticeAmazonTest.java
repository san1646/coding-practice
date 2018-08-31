package companies.az;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PracticeAmazonTest {
    PracticeAmazon practiceAmazon;
    
    @BeforeClass
    public void beforeClass() {
        practiceAmazon = new PracticeAmazon();
    }
    
    @Test
    public void testMinSwapsCouples1() {
        int[] arr1 = {0, 2, 1, 3};
        int swaps1 = practiceAmazon.minSwapsCouples(arr1);
        
        Assert.assertEquals(swaps1, 1);
    }
    
    @Test
    public void testMinSwapsCouples2() {
        int[] arr1 = {3, 2, 0, 1};
        int swaps1 = practiceAmazon.minSwapsCouples(arr1);
        
        Assert.assertEquals(swaps1, 0);
    }
}
