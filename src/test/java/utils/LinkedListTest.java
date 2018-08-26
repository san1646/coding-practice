package utils;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import junit.framework.Assert;
import utils.LinkedList.ListNode;

public class LinkedListTest {
    LinkedList linkedList;

    @BeforeClass
    public void beforeClass() {
        linkedList = new LinkedList();
    }

    @Test
    public void testSwapPair() {
        ListNode one = linkedList.new ListNode(1);
        ListNode two = linkedList.new ListNode(2);
        ListNode head = one;
        head.next = two;

        ListNode newHead = linkedList.swapPairs(head);

        System.out.println(">>> " + newHead.toString());
        Assert.assertEquals(two.val, newHead.val);
        Assert.assertEquals(one.val, newHead.next.val);

    }

    @Test
    public void testSwapPairs() {
        ListNode one = linkedList.new ListNode(1);
        ListNode two = linkedList.new ListNode(2);
        ListNode three = linkedList.new ListNode(3);
        ListNode four = linkedList.new ListNode(4);
        ListNode head = one;
        head.next = two;
        head.next.next = three;
        head.next.next.next = four;

        ListNode newHead = linkedList.swapPairs(head);

        System.out.println(">>> " + newHead.toString());
        Assert.assertEquals(two.val, newHead.val);
        Assert.assertEquals(one.val, newHead.next.val);
        Assert.assertEquals(four.val, newHead.next.next.val);
        Assert.assertEquals(three.val, newHead.next.next.next.val);

    }

    @Test
    public void testSwap3Pairs() {
        ListNode one = linkedList.new ListNode(1);
        ListNode two = linkedList.new ListNode(2);
        ListNode three = linkedList.new ListNode(3);
        ListNode four = linkedList.new ListNode(4);
        ListNode five = linkedList.new ListNode(5);
        ListNode six = linkedList.new ListNode(6);
        ListNode head = one;
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;

        ListNode newHead = linkedList.swapPairs(head);

        System.out.println(">>> " + newHead.toString());
        Assert.assertEquals(two.val, newHead.val);
        Assert.assertEquals(one.val, newHead.next.val);
        Assert.assertEquals(four.val, newHead.next.next.val);
        Assert.assertEquals(three.val, newHead.next.next.next.val);
        Assert.assertEquals(six.val, newHead.next.next.next.next.val);
        Assert.assertEquals(five.val, newHead.next.next.next.next.next.val);

    }

    @Test
    public void testLengthOfLinkedList() {
        ListNode one = linkedList.new ListNode(1);
        ListNode two = linkedList.new ListNode(2);
        ListNode three = linkedList.new ListNode(3);
        ListNode four = linkedList.new ListNode(4);
        ListNode five = linkedList.new ListNode(5);
        ListNode six = linkedList.new ListNode(6);
        ListNode head = one;
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;

        int l = linkedList.lengthOfLinkedList(head);

        System.out.println("length>>> " + l);
        Assert.assertEquals(6, l);
    }
    
    @Test
    public void testLengthOfLinkedList1() {
        ListNode one = linkedList.new ListNode(1);
        ListNode head = one;

        int l = linkedList.lengthOfLinkedList(head);
        System.out.println("length>>> " + l);
        Assert.assertEquals(1, l);
        
        l = linkedList.lengthOfLinkedList(null);
        System.out.println("length>>> " + l);
        Assert.assertEquals(0, l);
        
        
    }
}
