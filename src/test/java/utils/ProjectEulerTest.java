package utils;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class ProjectEulerTest {
    
  ProjectEuler euler;
    
  @Test(dataProvider = "dp")
  public void f(Integer n, String s) {
  }
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }


  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
    };
  }
  @BeforeClass
  public void beforeClass() {
    euler = new ProjectEuler();
  }

  @AfterClass
  public void afterClass() {
  }

  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

  @BeforeSuite
  public void beforeSuite() {
  }

  @AfterSuite
  public void afterSuite() {
  }


  @Test
  public void isPalindrome() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void isPrime() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void largestPalindromeProduct() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void largestPrimeFactor() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void lengthOfNumber() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void main() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void smallestMultiple() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void testSumSquareDifference() {
      System.out.println("sumSquareDifference(100) : "+euler.sumSquareDifference(100));
  }
  
  @Test
  public void testFindNthPrime() {
      System.out.println("findNthPrime(10001) : "+euler.nthPrime(10001));
  }
  
  /**
   * @see utils.ProjectEuler#productOfAdjacentN(int, String)
   */
    @Test
    public void testProductOfAdjacentN() {
        String thousandDigits = "7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450";
        
        Long productOf4 = 5832L;
        Long result = euler.productOfAdjacentN(4, thousandDigits);
        System.out.println("productOfAdjacentN(4, thousandDigits) : " + result);
        Assert.assertEquals(result, productOf4);
        
        Long productOf13 = 23514624000L;
        result = euler.productOfAdjacentN(13, thousandDigits);
        
        System.out.println("productOfAdjacentN(13, thousandDigits) : " + result);
        Assert.assertEquals(result, productOf13);
    }
  
    /**
     * @see utils.ProjectEuler#specialPythagoreanTripletProblem9(int)
     */
    @Test
    private void testSpecialPythagoreanTripletProblem9() {
        euler.specialPythagoreanTripletProblem9(1000);
    }
    
    @Test
    void testCalculateIncrementalAverage()  {
        float avg = 0l;
        for (int i = 1; i <= 10; i++) {
            avg =  euler.calculateIncrementalAverage(avg, Long.valueOf(i), i);
            System.out.println(" val=" + i + ": avg=" +avg);
        }
    }
}
