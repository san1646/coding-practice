package companies.thoughtworks;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

public class PracticeTest {
    Practice p = new Practice();
  @BeforeClass
  public void beforeClass() {
  }


  @Test
  public void printSquareWithNumbers() {
    //throw new RuntimeException("Test not implemented");
      p.printSquareWithNumbers(3);
  }
}
