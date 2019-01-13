/***
 * LC 155 easy stack
 *
 * The following is the third method to implement this question
 * we could solve this problem with LinkedList
 *
 * In the node class, each of the node has properties of val and min
 */

public class MinStack3 {

    private class Node{
        int min;
        int val;
        Node next;

        private Node(int min, int val){
            this.min = min;
            this.val = val;
            next = null;
        }
    }

    private Node head;

    public MinStack3(){
        head = null;
    }

    public void push(int x){
        if (head == null){
            head = new Node(x, x);
        } else {
            int min = Math.min(head.min, x);
            Node node = new Node(min, x);
            node.next = head;
            head = node;
        }
    }

    public void pop(){
        head = head.next;
    }

    public int top(){
        return head.val;
    }

    public int getMin(){
        return head.min;
    }
}
