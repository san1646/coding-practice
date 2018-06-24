package companies.tw;

import org.testng.annotations.Test;

import companies.tw.Practice;

import org.testng.annotations.BeforeClass;

public class PracticeTest {
    Practice p = new Practice();
  @BeforeClass
  public void beforeClass() {
  }


  @Test
  public void testPrintSquareWithNumbers() {
      p.printSquareWithConcentricNumbers(5);
  }
  
  @Test
  public void testPrintPerfectRhombus() {
      p.printPerfectRhombus(4);
  }
  
  
}
