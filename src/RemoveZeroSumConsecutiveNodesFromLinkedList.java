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

    // ***************** 1st Method ******************
    // Approach 1: covert linkedList to list and Loop through list
    // Check elements sum up to 0 & remove them
    // Runtime  : 16ms          -> + 5.39%
    // Memory   : 44.12MB       -> + 38.96%
    // Loop till encounter minus element - i-th
    // Check the left element next to the minus element(i-1), if sum=0, delete both of them
    // Otherwise, check the sum of lefter (i-2,i-3,...,0), if at any point sum=0, delete all of them
    public static ListNode removeZeroSumSublists(ListNode head) {
        List<Integer> ls = new ArrayList<>();

        while (head != null) {
            ls.add(head.val);
            head = head.next;
        }

        for(int i=0; i<ls.size(); i++) {
            if(i > 0) {
                int prevI = i-1;
                int curSum = ls.get(i);
                while(prevI >= 0) {
                    curSum += ls.get(prevI);
                    if(curSum == 0) {
                        break;
                    }
                    --prevI;
                }
                // delete element from ls
                while(prevI >= 0 && prevI != i) {
                    ls.set(prevI++,0);
                }
                if(prevI>=0) {
                    ls.set(i,0);
                }
            }
        }

        ListNode ans = new ListNode(0);
        ListNode dummy = ans;
        // read the ls to ListNode
        for(int n : ls) {
            if(n != 0) {
                dummy.next = new ListNode(n);
                dummy = dummy.next;
            }
        }
        return ans.next;
    }
    //  ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach 2: Loop through a copy of listNode head while keeping the sum of each node
    // If at one point sum=0, move head to cur.next & recursive head again
    // Otherwise keep looping cur = cur.next and after exit loop (cur=null),
    // recursive head.next by assigning head.next=recursive(head.next) cos the leftest element of head can't sum up to 0
    // Runtime  : 1ms          -> + 100.00%
    // Memory   : 42.57MB      -> + 98.15%
    public static ListNode removeZeroSumSublists2(ListNode head) {
        if (head == null) return head;
        ListNode cur = head;
        int running_sum = 0;
        while (cur != null) {
            running_sum += cur.val;
            if (running_sum == 0) {
                head = cur.next;
                return removeZeroSumSublists(head);
            }
            cur = cur.next;
        }
        head.next = removeZeroSumSublists(head.next);
        return head;
    }
    //  ***************** End of 2nd Method ******************
}
