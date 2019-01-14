/***
 *
 * LC 23 hard LinkedList / Divide and Conquer / Heap
 */

import java.util.*;
import Util.ListNode;
public class MergedLSortedList {


    /**
     * Pipeline : implement with Priority Queue
     * 1. put each list in lists to the priority Queue
     * 2. add the top node in the priority to the new returned listNode
     *
     * Time: O(NlogK)  Space(O(n))
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists){

        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> q = new PriorityQueue<>(lists.length, (a, b) -> a.val - b.val);

        for (ListNode l : lists){
            if (l!= null) q.add(l);
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (!q.isEmpty()){
            curr.next = q.poll();
            curr = curr.next;
            if (curr.next != null){
                q.add(curr.next);
            }
        }
        return dummy.next;

    }

    /**
     * Pipeline : divide and conquer, merge two each time. k lists -> k/2 lists -> k/4 lists
     * 1. select 2 list
     * 2. merger the 2 selected  lists
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists2(ListNode[] lists){
        if (lists == null || lists.length == 0) return null;
        return helper(lists, 0, lists.length-1);
    }

    // to merge two lists each time
    public ListNode helper(ListNode[] lists, int l, int r){
        if (l >= r) return lists[r];
        int mid = l + (r-l)/2;
        ListNode l1 = helper(lists, l, mid);
        ListNode l2 = helper(lists, mid + 1, r);
        return merge(l1, l2);
    }

    public ListNode merge(ListNode l1, ListNode l2){
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val){
            l1.next = merge(l1.next, l2);
            return l1;
        }
        l2.next = merge(l2.next, l1);
        return l2;
    }




    }
