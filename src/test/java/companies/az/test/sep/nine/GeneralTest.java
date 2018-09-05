package companies.az.test.sep.nine;

import java.util.ArrayList;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GeneralTest {

    Problem1 problem1 = new Problem1();

    Problem2 problem2 = new Problem2();

    @Test(groups = "problem1")
    public void test1Problem1() {
        int numDestinations = 3;
        List<List<Integer>> allLocations = new ArrayList<>();

        // (1,2) (3, 4) (1, -1)
        List<Integer> temp = new ArrayList<Integer>();
        temp.add(1);
        temp.add(2);
        allLocations.add(temp);

        List<Integer> temp1 = new ArrayList<Integer>();
        temp1.add(3);
        temp1.add(4);
        allLocations.add(temp1);

        List<Integer> temp2 = new ArrayList<Integer>();
        temp2.add(1);
        temp2.add(-1);
        allLocations.add(temp2);

        int numDeliveries = 2;
        List<List<Integer>> result = problem1.ClosestXdestinations(numDestinations, allLocations, numDeliveries);

        // 1, -1; 1, 2
        Assert.assertEquals(result.get(0).get(0), new Integer(1));
        Assert.assertEquals(result.get(0).get(1), new Integer(-1));

        Assert.assertEquals(result.get(1).get(0), new Integer(1));
        Assert.assertEquals(result.get(1).get(1), new Integer(2));

        Assert.assertEquals(result.size(), 2);
    }

    @Test(groups = "problem1")
    public void test2Problem1() {
        int numDestinations = 3;
        List<List<Integer>> allLocations = new ArrayList<>();

        // (3, 3) (4, 4) (5, 5)
        List<Integer> temp = new ArrayList<Integer>();
        temp.add(3);
        temp.add(3);
        allLocations.add(temp);

        List<Integer> temp1 = new ArrayList<Integer>();
        temp1.add(4);
        temp1.add(4);
        allLocations.add(temp1);

        List<Integer> temp2 = new ArrayList<Integer>();
        temp2.add(5);
        temp2.add(5);
        allLocations.add(temp2);

        int numDeliveries = 1;
        List<List<Integer>> result = problem1.ClosestXdestinations(numDestinations, allLocations, numDeliveries);

        // (3, 3)
        Assert.assertEquals(result.get(0).get(0), new Integer(3));
        Assert.assertEquals(result.get(0).get(1), new Integer(3));

        Assert.assertEquals(result.size(), 1);

        // 2 testing more combinations
        numDeliveries = 3;
        result = problem1.ClosestXdestinations(numDestinations, allLocations, numDeliveries);

        // (3, 3) (4, 4) (5, 5)
        Assert.assertEquals(result.get(0).get(0), new Integer(3));
        Assert.assertEquals(result.get(0).get(1), new Integer(3));

        Assert.assertEquals(result.get(1).get(0), new Integer(4));
        Assert.assertEquals(result.get(1).get(1), new Integer(4));

        Assert.assertEquals(result.get(2).get(0), new Integer(5));
        Assert.assertEquals(result.get(2).get(1), new Integer(5));

        Assert.assertEquals(result.size(), 3);
    }

    @Test(groups = "problem1")
    public void test3Problem1() {
        int numDestinations = 3;
        List<List<Integer>> allLocations = new ArrayList<>();

        // (1, 2) (3, 4) (8, 8) (1, -1)
        List<Integer> temp = new ArrayList<Integer>();
        temp.add(1);
        temp.add(2);
        allLocations.add(temp);

        List<Integer> temp1 = new ArrayList<Integer>();
        temp1.add(3);
        temp1.add(4);
        allLocations.add(temp1);

        List<Integer> temp2 = new ArrayList<Integer>();
        temp2.add(8);
        temp2.add(8);
        allLocations.add(temp2);

        List<Integer> temp3 = new ArrayList<Integer>();
        temp3.add(1);
        temp3.add(-1);
        allLocations.add(temp3);

        int numDeliveries = 2;
        List<List<Integer>> result = problem1.ClosestXdestinations(numDestinations, allLocations, numDeliveries);

        // 1, -1; 1, 2
        Assert.assertEquals(result.get(0).get(0), new Integer(1));
        Assert.assertEquals(result.get(0).get(1), new Integer(-1));

        Assert.assertEquals(result.get(1).get(0), new Integer(1));
        Assert.assertEquals(result.get(1).get(1), new Integer(2));

        Assert.assertEquals(result.size(), 2);
    }

    @Test(groups = "problem1")
    public void test4Problem1() {
        int numDestinations = 0;
        List<List<Integer>> allLocations = new ArrayList<>();

        // null
        int numDeliveries = 0;
        List<List<Integer>> result = problem1.ClosestXdestinations(numDestinations, allLocations, numDeliveries);

        Assert.assertEquals(result.size(), 0);
    }

    @Test(groups = "problem2")
    public void test1Problem2() {
        int deviceCapacity = 10;
        List<List<Integer>> foregroundAppList = new ArrayList<>();

        // (1, 3) (2, 5) (3, 7) (4, 10)
        List<Integer> temp = new ArrayList<Integer>();
        temp.add(1);
        temp.add(3);
        foregroundAppList.add(temp);

        List<Integer> temp1 = new ArrayList<Integer>();
        temp1.add(2);
        temp1.add(5);
        foregroundAppList.add(temp1);

        List<Integer> temp2 = new ArrayList<Integer>();
        temp2.add(3);
        temp2.add(7);
        foregroundAppList.add(temp2);

        List<Integer> temp3 = new ArrayList<Integer>();
        temp3.add(4);
        temp3.add(10);
        foregroundAppList.add(temp3);

        // (1, 2) (2, 3) (3, 4) (4, 5)
        List<List<Integer>> backgroundAppList = new ArrayList<>();
        List<Integer> bt1 = new ArrayList<Integer>();
        bt1.add(1);
        bt1.add(2);
        backgroundAppList.add(bt1);
        
        List<Integer> bt2 = new ArrayList<Integer>();
        bt2.add(2);
        bt2.add(3);
        backgroundAppList.add(bt2);
        
        List<Integer> bt3 = new ArrayList<Integer>();
        bt3.add(3);
        bt3.add(4);
        backgroundAppList.add(bt3);
        
        List<Integer> bt4 = new ArrayList<Integer>();
        bt4.add(4);
        bt4.add(5);
        backgroundAppList.add(bt4);
        List<List<Integer>> result = problem2.optimalUtilization(deviceCapacity, foregroundAppList, backgroundAppList);

        // (2, 4) (3, 2)
        Assert.assertEquals(result.get(0).get(0), new Integer(2));
        Assert.assertEquals(result.get(0).get(1), new Integer(4));

        Assert.assertEquals(result.get(1).get(0), new Integer(3));
        Assert.assertEquals(result.get(1).get(1), new Integer(2));

        Assert.assertEquals(result.size(), 2);
    }

}
