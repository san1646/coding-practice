package utils;

public class LinkedList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        /*
         * @Override
         * public boolean equals(Object obj) {
         * // TODO Auto-generated method stub
         * if (obj == null)
         * return false;
         * ListNode n = (ListNode) obj;
         * if (!(n instanceof ListNode))
         * return false;
         * if (this.val == n.val && ((this.next==null) ||this.next.equals(n.next)))
         * return true;
         * 
         * return false;
         * }
         */

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            ListNode n = this;
            sb.append("{");
            while (n != null) {
                sb.append("[");
                sb.append(n.val);
                sb.append("]");
                n = n.next;
            }
            sb.append("}");

            return sb.toString();
        }
    }

    /**
     * https://leetcode.com/problems/swap-nodes-in-pairs/description/
     * 
     * Given a linked list, swap every two adjacent nodes and return its head.
     * 
     * Example:
     * 
     * Given 1->2->3->4, you should return the list as 2->1->4->3.
     * Note:
     * 
     * Your algorithm should use only constant extra space.
     * You may not modify the values in the list's nodes, only nodes itself may be changed.
     * 
     * @param head
     * @return
     *         STATUS: works like a charm 4/5
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pointer = head;

        while (pointer.equals(head) || (pointer.next != null && pointer.next.next != null)) {
            System.out.println("p is ->" + pointer.val);
            if (pointer.equals(head)) {
                head = swapNodes(pointer, pointer.next);
            } else {
                // for all cases other than head and head.next,
                // swap the next and next to next element
                // this way we preserve the previous node pointer
                pointer.next = swapNodes(pointer.next, pointer.next.next);
                pointer = pointer.next.next;
            }
        }
        return head;
    }

    /**
     * Calculate length
     * 
     * @param head
     * @return
     */
    public int lengthOfLinkedList(ListNode head) {
        if (head == null) {
            return 0;
        }
        ListNode pointer = head;

        int l = 1;
        while (pointer.next != null) {
            l++;
            pointer = pointer.next;
        }
        return l;
    }

    /**
     * Reverse a singly linked list.
     * 
     * Example:
     * 
     * Input: 1->2->3->4->5->NULL
     * Output: 5->4->3->2->1->NULL
     * Follow up:
     * 
     * A linked list can be reversed either iteratively or recursively.
     * Could you implement both?
     * https://leetcode.com/problems/reverse-linked-list/description/
     * 
     * @param head
     * @return
     */
    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode curr = head;
        ListNode post = head.next;

        while (curr != null) {
            post = curr.next;
            curr.next = pre;
            pre = curr;
            curr = post;
        }
        return pre;
    }

    private ListNode swapNodes(ListNode one, ListNode two) {

        one.next = two.next;
        two.next = one;
        return two;
    }

}
