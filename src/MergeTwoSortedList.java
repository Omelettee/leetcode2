import Util.ListNode;


//LeetCode 21
public class MergeTwoSortedList {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode head = new ListNode(0);
        ListNode node = head;
        while (l1 != null || l2 != null){
            if (l2 == null || (l1 != null && l2 != null && l1.val <= l2.val)){
                    node.next = l1;
                    l1 = l1.next;
            } else if (l1 == null || (l1 != null && l2 != null && l1.val > l2.val)){
                    node.next = l2;
                    l2 = l2.next;
            }
            node = node.next;

            }

        return head.next;
    }

    /**
     * Resusion
     * public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
     *         if(l1 == null) {
     *             return l2;
     *         } else if(l2 == null) {
     *             return l1;
     *         } else {
     *             ListNode toReturn;
     *             if(l1.val <= l2.val) {
     *                 toReturn = l1;
     *                 toReturn.next = mergeTwoLists(l1.next, l2);
     *             } else {
     *                 toReturn = l2;
     *                 toReturn.next = mergeTwoLists(l1, l2.next);
     *             }
     *             return toReturn;
     *         }
     *     }
     *
     */

    public static void main(String[] args){
        ListNode head1 = new ListNode(4);
        ListNode node1 = head1;
        node1.next = new ListNode(4);
        node1 = node1.next;
        node1.next = new ListNode(5);


        ListNode head2 = new ListNode(5);
        ListNode node2 = head2;
        node2.next = new ListNode(7);
        node2 = node2.next;
        node2.next = new ListNode(19);

        ListNode result = mergeTwoLists(head1, head2);


        while (result != null){
            System.out.println(result.val);
            result = result.next;
        }

    }
}
