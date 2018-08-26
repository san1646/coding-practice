package utils;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import junit.framework.Assert;
import utils.LeetCode.ListNode;

public class LeetCodeTest {
    LeetCode leetCode;
    
    @BeforeClass
    public void beforeClass() {
        leetCode = new LeetCode();
    }

    @Test
    public void testSwapPair() {
        ListNode one = leetCode.new ListNode(1);
        ListNode two =leetCode.new ListNode(2);
        ListNode head =one; 
        head.next = two;
        
        ListNode newHead = leetCode.swapPairs(head);
        
        System.out.println(">>> "+newHead.toString());
        Assert.assertEquals(two.val, newHead.val);
        Assert.assertEquals(one.val, newHead.next.val);

    }
    
    @Test
    public void testSwapPairs() {
        ListNode one = leetCode.new ListNode(1);
        ListNode two =leetCode.new ListNode(2);
        ListNode three =leetCode.new ListNode(3);
        ListNode four =leetCode.new ListNode(4);
        ListNode head =one; 
        head.next = two;
        head.next.next = three;
        head.next.next.next = four;
        
        ListNode newHead = leetCode.swapPairs(head);
        
        System.out.println(">>> "+newHead.toString());
        Assert.assertEquals(two.val, newHead.val);
        Assert.assertEquals(one.val, newHead.next.val);
        Assert.assertEquals(four.val, newHead.next.next.val);
        Assert.assertEquals(three.val, newHead.next.next.next.val);

    }
    
    @Test
    public void testSwapPairsOdd() {
        ListNode one = leetCode.new ListNode(1);
        ListNode two =leetCode.new ListNode(2);
        ListNode three =leetCode.new ListNode(3);
        ListNode four =leetCode.new ListNode(4);
        ListNode five =leetCode.new ListNode(5);
        ListNode six =leetCode.new ListNode(6);
        ListNode head =one; 
        one.next = two;
        two.next = three;
        three.next = four;
        four.next=five;
        five.next=six;
        
        ListNode newHead = leetCode.swapPairs(head);
        
        System.out.println(">>> "+newHead.toString());
        Assert.assertEquals(two.val, newHead.val);
        Assert.assertEquals(one.val, newHead.next.val);
        Assert.assertEquals(four.val, newHead.next.next.val);
        Assert.assertEquals(three.val, newHead.next.next.next.val);
        Assert.assertEquals(six.val, newHead.next.next.next.next.val);
        Assert.assertEquals(five.val, newHead.next.next.next.next.next.val);

    }
}
