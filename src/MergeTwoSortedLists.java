import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeTwoSortedLists {

    //Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // Runtime  : 0ms        -> + 100%
    // Memory   : 42.2MB      -> + 71.32%%
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;

        ListNode resNode = new ListNode();

        if(list1.val < list2.val) {
            resNode.val = list1.val;
            list1 = list1.next;
        } else {
            resNode.val = list2.val;
            list2 = list2.next;
        }

//        System.out.println(list2.val);
        ListNode cur = resNode;

        while(list1 != null && list2 != null) {
            int min = (list1.val < list2.val) ? list1.val : list2.val;
//            System.out.print("min : " + min);
            ListNode minNode = new ListNode(min);
//            cur.val = min;
            cur.next = minNode;
            cur = minNode;
//            System.out.println(", resNode : " + cur.val);

            if(list1.val < list2.val)
                list1 = list1.next;
            else
                list2 = list2.next;

        }

        if(list1 != null) {
            cur.next = list1;
            cur = list1;
        } else if(list2 != null) {
            cur.next = list2;
            cur = list2;
        }

        return resNode;
    }

    public static void printListNode(ListNode ln) {
        while(ln != null) {
            System.out.println(ln.val);
            ln = ln.next;
        }
    }

    // Runtime  : 0ms        -> + 100%
    // Memory   : 41.9MB      -> + 79.21%%
    /*Using Recursion
    Could also do recursion in one Method*/
    /*public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        return recursion(list1,list2);
    }

    public ListNode recursion(ListNode l1, ListNode l2)
    {
        if(l1 == null)
        {
            return l2;
        }
        if(l2==null)
        {
            return l1;
        }
        if(l1.val>l2.val)
        {
            return new ListNode(l2.val,recursion(l2.next, l1));
        }
        else
        {
            return new ListNode(l1.val, recursion(l2, l1.next));
        }
    }*/

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));

//        ListNode list1 = null;
//        ListNode list2 = new ListNode(0);

//        System.out.println(mergeTwoLists2(list1, list2));

        // result : 1,4
       printListNode(mergeTwoLists(list1, list2));

    }
}
