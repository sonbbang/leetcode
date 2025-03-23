import java.util.ArrayList;
import java.util.List;

public class Solution {

    ArrayList<String> ret = new ArrayList<>();

    public List<String> generateParenthesis(int n) {

        List<String> ret = new ArrayList<>();
        process(n, 0, 0, "", ret); //recurse;
        return ret;
    }

    //numClosed > numOpen -> invalid
    private void process(int n, int numOpen, int numClosed, String str, List<String> ret) {

        //System.out.println("numOpen: " + numOpen + " numClosed: " + numClosed);

        //termination check
        if (numOpen == n && numClosed == n) {
            //System.out.println("str: " + str);
            ret.add(str);
            return;
        }

        //recurse next
        if (numOpen < n) {
            process(n, numOpen + 1, numClosed, str + "(", ret); //add open bracket
        }

        if (numOpen > numClosed) {
            process(n, numOpen, numClosed + 1, str + ")", ret); //add closed bracket
        }
    }

    boolean init;
    int min;
    int prev;

    public int getMinimumDifference(TreeNode root) {
        init = false;
        min = Integer.MAX_VALUE;
        inorder(root);
        return min;
    }

    public void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);
        //self 처리
        if (!init) {
            init = true;
        } else {
            min = Math.min(min, root.val - prev);
        }
        prev = root.val;
        inorder(root.right);
    }

    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int cnt = 0;
        for (int i = 0; i < 32; i++) {
            cnt += (xor >> i) & 1;
        }
        return cnt;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode ret = null;
        ListNode cur = null;

        while (l1 != null || l2 != null) {
            if (l2 == null || (l1 != null && l1.val < l2.val)) {
                //pick from l1
                if (ret == null) {
                    ret = l1;
                    cur = l1;
                    l1 = l1.next;
                } else {
                    cur.next = l1;
                    cur = l1;
                    l1 = l1.next;
                }
            } else {
                //pick from l2
                if (ret == null) {
                    ret = l2;
                    cur = l2;
                    l2 = l2.next;
                } else {
                    cur.next = l2;
                    cur = l2;
                    l2 = l2.next;
                }
            }
        }
        return ret;
    }

}

