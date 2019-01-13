/**
 * LC 707 easy linked list
 */

import Util.ListNode;
public class DesignLinkedList {

    /**
     * Initialize your data structure here.
     */

    class Node {
        int val;
        Node next;

        public Node(int v) {
            val = v;
        }
    }

    private Node head;
    private Node tail;
    int size;

    public DesignLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index >= size) return -1;
        Node curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;
        if (tail == null) tail = head;
        size++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {

        Node node = new Node(val);
        if (tail != null) {
            tail.next = node;
        } else {
            if (head == null) head = node;
            else head.next = node;
        }
        tail = node;
        size++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        Node node = new Node(val);
        if (index > size) return;

        if (index == size) {
            addAtTail(val);
            return;
        }
        if (index == 0) {
            addAtHead(val);
            return;
        }

        Node curr = head;
        for (int i = 0; i < index - 1; i++) {
            curr = curr.next; // if index = 3, curr is the node with index 2.
        }

        node.next = curr.next;
        curr.next = node;
        size++;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index >= size) return;

        if (index == 0) {
            if (size == 1) {
                head = null;
                tail = null;
            } else {
                head = head.next;
            }
            size--;
            return;
        } else {
            Node curr = head;
            for (int i = 0; i < index - 1; i++) {
                curr = curr.next;
            }
            curr.next = curr.next.next;
            if (index == (size - 1)) tail = curr;
            size--;
        }
    }
}
/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */

