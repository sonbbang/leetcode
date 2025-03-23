import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Solution solution = new Solution();

        //https://leetcode.com/problems/generate-parentheses/
        System.out.println("generateParenthesis:" + solution.generateParenthesis(3));

        //https://leetcode.com/problems/minimum-absolute-difference-in-bst/
        TreeNode left = new TreeNode(4, null, null);
        TreeNode root = new TreeNode(5, left, null);
        System.out.println("getMinimumDifference:" + solution.getMinimumDifference(root));

        //https://leetcode.com/problems/hamming-distance/
        System.out.println("hammingDistance:" + solution.hammingDistance(1,4));

        //https://leetcode.com/problems/merge-two-sorted-lists/
        ListNode next = new ListNode(2, null);
        ListNode list1 = new ListNode(1 ,next);

        next = new ListNode(3, null);
        ListNode list2 = new ListNode(2 ,next);
        ListNode listNode = solution.mergeTwoLists(list1, list2);
        listNode.printList();

    }


}