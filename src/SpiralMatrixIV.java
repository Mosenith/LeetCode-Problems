import java.util.Arrays;
import java.util.Stack;

public class SpiralMatrixIV {
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

    // Utility function to print contents of a linked list
    public static void printList(ListNode node)
    {
        while (node.next != null)
        {
            System.out.print(node.next.val + " —> ");
            node = node.next;
        }
        System.out.print("null");
    }

    public static void main(String[] args) {
        // 3,0,2,6,8,1,7,9,4,2,5,5,0
        ListNode head = new ListNode(3, new ListNode(0, new ListNode(2, new ListNode(6,
                new ListNode(8, new ListNode(1, new ListNode(7, new ListNode(9,
                        new ListNode(4, new ListNode(2, new ListNode(5, new ListNode(5,
                                new ListNode(0)))))))))))));

        SpiralMatrixIV obj = new SpiralMatrixIV();
        Arrays.deepToString(obj.spiralMatrix(3, 4, head));
    }


    // right, down, left, up
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        // get total number of elements in head
        int total = 0;
        ListNode temp = head;
        while(temp != null) {
            total++;
            temp = temp.next;
        }
        System.out.println(total);

        int[][] result = new int[m][n];
        int direction = 1; // 1-4: right, down, left, up
        Stack<Integer> stk = new Stack<>();
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(direction == 1) {
                    result[i][j] = (head != null) ? head.val : -1;
                } else {
                    stk.push((head != null) ? head.val : -1);
                }
                head = (head != null) ? head.next : null;
            }
            direction++;
            System.out.println(Arrays.deepToString(result));
            System.out.println("current stk -> " + stk);
            System.out.println("***************");
        }
        return null;
    }
}
//    *****************End of Declaration******************}
