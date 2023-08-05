import java.util.*;

public class MergeKSortedLists {

//    *****************List Node Declaration******************
     public static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) {
             this.val = val; this.next = next;
         }
     }

//    *****************End of Declaration******************


//    ***************** 1st Method : Compare One By One ******************
    // Runtime  : 326ms        -> + 9.7%%
    // Memory   : 43.9MB      -> + 91.49%%
    public static ListNode mergeKLists(ListNode[] lists) {
         ListNode resNode = new ListNode();
         if(lists.length == 0 || checkNull(lists)) return null;

         int k = 0;
         int minIndex = -1;
         int curMin = Integer.MAX_VALUE;
         while(k < lists.length) {
             if(curMin > lists[k].val) {
                 minIndex = k;
                 curMin = lists[k].val;
             }
             k++;
         }

//         System.out.println("MinIndex = " + minIndex + "\n" + lists[minIndex].val + "-" + lists[minIndex].next.val + "-" + lists[minIndex].next.next.val);
         lists[minIndex] = lists[minIndex].next;
//         System.out.println(lists[minIndex].val);

        resNode.val = curMin;
         ListNode res = resNode;
//         System.out.println("res = " + res.val);

//         ListNode res = new ListNode();
         int totalElements = countElements(lists);
         int currentTotal = 1;
         while(currentTotal <= totalElements) {
             int min = Integer.MAX_VALUE;
             int kMin = -1;
             for(int i=0; i<lists.length; i++) {
                 if(lists[i] == null) continue;
                 if(min > lists[i].val) {
                     kMin = i;
                     min = lists[i].val;
                 }
             }
             lists[kMin] = lists[kMin].next;
             ListNode currMin = new ListNode(min);
             res.next = currMin;
             res = currMin;
             System.out.println("res = " + res.val);
             currentTotal++;
         }

         ListNode copyRes = resNode;
         while(copyRes != null) {
             System.out.println(copyRes.val);
             copyRes = copyRes.next;
         }
         return resNode;
    }

    public static Boolean checkNull(ListNode[] lists) {
        ListNode[] copy = lists.clone();
        int count = 0;
        for(int i=0; i<copy.length; i++) {
            if(copy[i] == null)
                count++;
        }

//        System.out.println("All NULL LIST");
        return count == copy.length;
    }
    public static int countElements (ListNode[] copyLists) {
        // count element in lists
        ListNode[] copy = copyLists.clone();
        int total = 0;
        for(int i=0; i<copy.length; i++) {
            while(copy[i] != null) {
                total++;
                copy[i] = copy[i].next;
            }
        }
        return total;
    }

//    ***************** End of 1st Method ******************

//    ***************** Optimize 1st Method : Compare One By One ******************
    // Using Priority Queue
    public static ListNode mergeKListsOptimize(ListNode[] lists) {
        Comparator<ListNode> cmp;
        cmp = new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                // TODO Auto-generated method stub
                return o1.val-o2.val;
            }
        };

        Queue<ListNode> q = new PriorityQueue<ListNode>(cmp);
        // Add only the head of each list in lists : [1,1,2,4]
        // q = [1,1,2,4]
        for(ListNode l : lists) {
//            System.out.println(l.val);
            if(l!=null) {
                q.add(l);
            }
        }

        ListNode head = new ListNode(0);
        ListNode point = head;
        while(!q.isEmpty()){
            point.next = q.poll();
            point = point.next;
            ListNode next = point.next;
            if(next!=null){
                q.add(next);
            }
        }
        return head.next;
    }
//    ***************** End of Optimize 1st Method ******************

//    ***************** 2nd Method : Merge to List ******************
    // Using List
    // Runtime  : 125ms        -> + 17.59%%%
    // Memory   : 43.6MB      -> + 96.73%
    public static ListNode mergeKLists2(ListNode[] lists) {
        if (lists.length == 0 || checkNull(lists)) return null;
        ListNode resNode = new ListNode();
        List<Integer> myList = new ArrayList<>();

        for (ListNode ln : lists) {
            while (ln != null) {
                myList.add(ln.val);
                ln = ln.next;
            }
        }


        Collections.sort(myList);
        System.out.println(myList);

        resNode.val = myList.get(0);
        ListNode nextNode = resNode;
        for(int i=1; i<myList.size(); i++) {
            ListNode currentNode = new ListNode(myList.get(i));
            nextNode.next = currentNode;
            nextNode = currentNode;
        }
//
//        ListNode copyRes = resNode;
//        while(copyRes != null) {
//            System.out.println(copyRes.val);
//            copyRes = copyRes.next;
//        }

        return resNode;
    }

//    ***************** End of 2nd Method ******************

//    ***************** 2nd Method Revise : Merge to List ******************
// Runtime  : 7ms        -> + 59.78%
// Memory   : 43.6MB      -> + 96.63%
    public ListNode mergeKLists2_revise(ListNode[] lists) {
        List<Integer> myList = new ArrayList<>();

        for (ListNode ln : lists) {
            while (ln != null) {
                myList.add(ln.val);
                ln = ln.next;
            }
        }
        Collections.sort(myList);

        ListNode resNode = new ListNode(0);
        ListNode nextNode = resNode;
        for(int i : myList) {
            ListNode currentNode = new ListNode(i);
            nextNode.next = currentNode;
            nextNode = currentNode;
        }
        nextNode.next = null;
        return resNode.next;
    }
//    ***************** End of 2nd Method Revision ******************

//    ***************** 3rd Method : Min Heap (Priority Queue)******************
    // use min heap
    // null
    public static ListNode mergeKLists3(ListNode[] lists)
    {
        // create an empty min-heap using a comparison object for ordering the min-heap
        PriorityQueue<ListNode> pq = new PriorityQueue<>();
        pq = new PriorityQueue<>(Comparator.comparingInt(a -> ((ListNode) a).val));

        // push the first node of each list into the min-heap
        pq.addAll(Arrays.asList(lists).subList(0, lists.length));

        // take two pointers, head and tail, where the head points to the first node
        // of the output list and tail points to its last node
        ListNode head = null, last = null;

        // run till min-heap is empty
        while (!pq.isEmpty())
        {
            // extract the minimum node from the min-heap
            ListNode min = pq.poll();

            // add the minimum node to the output list
            if (head == null) {
                head = last = min;
            }
            else {
                last.next = min;
                last = min;
            }

            // take the next node from the "same" list and insert it into the min-heap
            if (min.next != null) {
                pq.add(min.next);
            }
        }

        // return head node of the merged list
        return head;
    }

//    ***************** End of 3rd Method ******************


//    ***************** 4th Method : ******************
    // Takes two lists sorted in increasing order and merges their nodes
    // to make one big sorted list returned
    public static ListNode sortedMerge(ListNode a, ListNode b)
    {
        // base cases
        if (a == null) {
            return b;
        }
        else if (b == null) {
            return a;
        }

        ListNode result;

        // pick either `a` or `b`, and recur
        if (a.val <= b.val)
        {
            result = a;
            result.next = sortedMerge(a.next, b);
        }
        else {
            result = b;
            result.next = sortedMerge(a, b.next);
        }

        return result;
    }

    // The main function to merge given `k` sorted linked lists.
    // It takes array `lists` of size `k` and generates the sorted output
    public static ListNode mergeKLists4(ListNode[] lists)
    {
        // base case
        if (lists == null || lists.length == 0) {
            return null;
        }

        int last = lists.length - 1;

        // repeat until only one list is left
        while (last != 0)
        {
            int i = 0, j = last;

            // `(i, j)` forms a pair
            while (i < j)
            {
                // merge list `j` with `i`
                lists[i] = sortedMerge(lists[i], lists[j]);

                // consider the next pair
                i++;
                j--;

                // if all pairs are merged, update last
                if (i >= j) {
                    last = j;
                }
            }
        }

        return lists[0];
    }

//    ***************** End of 4th Method ******************

//     ***************** 5th Method : Recursion + D&C ******************
// Runtime  : 2ms        -> + 96.49%
// Memory   : 47.9MB      -> + 14.82%%

    public static ListNode mergeKLists5(ListNode[] lists) {
        return mL(lists, 0, lists.length - 1);
    }

    private static ListNode mL(ListNode[] lists, int l, int r) {
        if (r < l) return null;
        if (r == l) return lists[r];

        int mid = (l + r) / 2;
        ListNode a = mL(lists, l, mid), b = mL(lists, mid + 1, r);
        ListNode dmHead = new ListNode(0), cur = dmHead;
        System.out.println("a = " + a.val + ", b = " + b.val);
        while (a != null && b != null) {
            if (a.val < b.val) {
                cur.next = a;
                a = a.next;
            } else {
                cur.next = b;
                b = b.next;
            }
            cur = cur.next;
        }
        cur.next = (a != null) ? a : b;

        System.out.println("********* " + dmHead.next.val + " *********" );
        return dmHead.next;
    }

//    ***************** End of 5th Method ******************

//    ***************** 6th Method : Divide & Conquer ******************
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode h = new ListNode(0);
        ListNode ans=h;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                h.next = l1;
                h = h.next;
                l1 = l1.next;
            } else {
                h.next = l2;
                h = h.next;
                l2 = l2.next;
            }
        }
        if(l1==null){
            h.next=l2;
        }
        if(l2==null){
            h.next=l1;
        }
        return ans.next;
    }
    public static ListNode mergeKLists6(ListNode[] lists) {
        if(lists.length==0){
            return null;
        }
        int interval = 1;
        while(interval<lists.length){
            System.out.println(lists.length);
            for (int i = 0; i + interval< lists.length; i=i+interval*2) {
                lists[i]=mergeTwoLists(lists[i],lists[i+interval]);
            }
            interval*=2;
        }

        return lists[0];
    }
//    ***************** End of 6th Method ******************

    public static void main(String[] args) {
//        ListNode l1 = new ListNode (1, new ListNode(4, new ListNode(5)));
//        ListNode l2 = new ListNode (1, new ListNode(3, new ListNode(4)));
//        ListNode l3 = new ListNode (2, new ListNode(6));

        ListNode[] lists = {new ListNode (1, new ListNode(4, new ListNode(5))),
                new ListNode (1, new ListNode(3, new ListNode(4))),
                new ListNode (2, new ListNode(6)),
                new ListNode (4, new ListNode(8))};
//        ListNode[] lists = {};

//        System.out.println(lists.length);
//        System.out.println(mergeKLists3(lists));
//        System.out.println(mergeKLists(lists));
//        printList(mergeKLists2(lists));
        printList(mergeKListsOptimize(lists));
    }

    // Utility function to print contents of a linked list
    public static void printList(ListNode node)
    {
        while (node != null)
        {
            System.out.print(node.val + " —> ");
            node = node.next;
        }
        System.out.print("null");
    }
}
