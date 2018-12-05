import Util.ListNode;
import java.io.*;
import java.util.*;


public class LinkedListCycle2 {
    /**The second method to check whether LinkeList has a cycle
     * is to use Two Pointers;
     * @param head
     * @return true or false
     */

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast){
            if (fast == null || fast.next == null){
                return false;
            } else {
                slow = slow.next;
                fast = fast.next.next;
            }
        }
        return true;
    }


    public static void main(String[] args){
        ListNode node = new ListNode(4);
        ListNode head = node;
        node.next = new ListNode(7);
        node = node.next;
        node.next = new ListNode(5);
        node = node.next;
        node.next = null;

        System.out.println(hasCycle(head));
    }
}
