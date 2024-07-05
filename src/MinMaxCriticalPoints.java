import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinMaxCriticalPoints {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) {
            this.val = val; this.next = next;
        }
    }
    public static void printList(ListNode node) {
        while (node != null)
        {
            System.out.print(node.val + " —> ");
            node = node.next;
        }
        System.out.print("null\n");
    }

    public static void main(String[] args) {
        // head = [1,1,2,3,3] -> [1,2,3]
//        ListNode head = new ListNode(5);
//        head.next = new ListNode(3);
//        head.next.next = new ListNode(1);
//        head.next.next.next = new ListNode(2);
//        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = new ListNode(1);
//        head.next.next.next.next.next.next = new ListNode(2);

        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next.next.next = new ListNode(7);

        System.out.println(Arrays.toString(nodesBetweenCriticalPoints2(head)));
    }

    // ***************** 1st Method ******************
    // Approach 1: Init List ls to store all critical points
    // Loop through head, if prev < cur > next or prev > cur < next, add nodePos to ls
    // If ls.size() < 2, return [-1,-1]
    // Find min and max from ls and return [min,max]
    // Runtime  : 10ms      -> + 26.23%
    // Memory   : 65.84MB   -> + 15.85%
    public static int[] nodesBetweenCriticalPoints(ListNode head) {
        List<Integer> ls = new ArrayList<>();
        int nodePos = 0;

        ListNode prev = null;
        ListNode cur = head;
        ListNode next = cur;
        while(next != null) {
            if(prev != null) {
                if(prev.val < cur.val && cur.val > next.val) {
                    ls.add(nodePos);
                }
                if(prev.val > cur.val && cur.val < next.val) {
                    ls.add(nodePos);
                }
            }
            prev = cur;
            cur = next;
            next = next.next;
            nodePos++;
        }

        if(ls.size() < 2) return new int[]{-1,-1};

        int max = ls.get(ls.size()-1) - ls.get(0);
        int min = Integer.MAX_VALUE;
        for(int i=0; i+1<ls.size(); i++) {
            min = Math.min(min, ls.get(i+1)-ls.get(i));
        }
        return new int[]{min,max};
    }
    //  ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach 2: Optimized above approach by using integer min & max instead of List
    // Update min when critical points is met && startPos != -1
    // Each iteration update curPos to pos, prev to cur, cur to next, pos++
    // Out of loop, check if startPos == -1 or min == Integer.MAX_VALUE, return [-1,-1]
    // Otherwise, calculate max and return [min,max]
    // Runtime  : 4ms      -> + 100.00%
    // Memory   : 57.26MB  -> + 85.06%
    public static int[] nodesBetweenCriticalPoints2(ListNode head) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int startPos = -1, curPos = -1;
        int pos = 0;
        ListNode prev = head;
        ListNode cur = head.next;
        while(cur.next != null) {
            if((prev.val < cur.val && cur.val > cur.next.val) || (prev.val > cur.val && cur.val < cur.next.val)) {
                if(startPos == -1) {
                    startPos = pos;
                } else {
                    min = Math.min(min, pos-curPos);
                }
                curPos = pos;
            }
            prev = cur;
            cur = cur.next;
            pos++;
        }

        if(startPos == -1 || min == Integer.MAX_VALUE) return new int[]{-1,-1};
        max = Math.max(max, curPos-startPos);
        return new int[]{min,max};
    }
    //  ***************** End of 2nd Method ******************
}
