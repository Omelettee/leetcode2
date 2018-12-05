import Util.ListNode;
import java.io.*;
import java.util.*;


public class LinkedListCycle {
    public static boolean hasCycle(ListNode head) {
        if (head == null) return false;

        //hashmap : node -> next
        Set<ListNode> record = new HashSet<>();
        while(head != null){
            if(record.contains(head)){
                return true;
            } else {
                record.add(head);
                head = head.next;
            }

        }
        return false;
    }


    public static void main(String[] args){
        ListNode node = new ListNode(4);
        ListNode head = node;
        node.next = new ListNode(7);
        node = node.next;
        node.next = new ListNode(5);
        node = node.next;
        node.next = head;

        System.out.println(hasCycle(head));


    }
}
