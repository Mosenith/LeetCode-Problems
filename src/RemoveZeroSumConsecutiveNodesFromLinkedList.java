import java.util.ArrayList;
import java.util.List;

public class RemoveZeroSumConsecutiveNodesFromLinkedList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    private static void printListNode(ListNode myNode) {
        while (myNode != null) {
            System.out.println(myNode.val);
            myNode = myNode.next;
        }
        System.out.println("~~~~~~~~");
    }
    public static void main(String[] args) {
        ListNode myNode = new ListNode(5, new ListNode(-3,
                new ListNode(-4, new ListNode(1, new ListNode(6,
                        new ListNode(-2, new ListNode(-5)))))));

        removeZeroSumSublists(myNode);
    }

    // Loop till encounter minus element - i-th
    // Check the left element next to the minus element(i-1), if sum=0, delete both of them
    // Otherwise, check the sum of lefter (i-2,i-3,...,0), if at any point sum=0, delete all of them
    public static ListNode removeZeroSumSublists(ListNode head) {
        List<Integer> ls = new ArrayList<>();

        // covert linkedList to list
        while (head != null) {
            ls.add(head.val);
            head = head.next;
        }
        System.out.println(ls);

        // Loop through list & check elements sum up to 0 & remove them
        for(int i=0; i<ls.size(); i++) {
            if(ls.get(i) < 0) {
                int prevI = i-1;
                int curSum = ls.get(i);
                System.out.println("Start prevI = " + prevI + ", i = " + i);
                while(prevI >= 0) {
                    curSum += ls.get(prevI);
                    if(curSum == 0) {
                        break;
                    }
                    --prevI;
                }
                System.out.println(prevI + " & " + i);
                // delete element from ls
                while(prevI >= 0 && prevI != i) {
                    ls.set(prevI++,0);
                }
                if(prevI>=0) {
                    ls.set(i,0);
                }
            }
            System.out.println(ls);
            System.out.println("*******\n");
        }

        System.out.println(ls);
        ListNode ans = new ListNode(0);
        ListNode dummy = ans;
        // read the ls to ListNode
        for(int n : ls) {
            if(n != 0) {
                dummy.next = new ListNode(n);
                dummy = dummy.next;
            }
        }

        printListNode(ans);

        return ans.next;
    }
}
