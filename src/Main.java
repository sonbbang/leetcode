import java.util.ArrayList;
import java.util.Arrays;
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

        //https://leetcode.com/problems/valid-parentheses/description
        System.out.println("isValid:" + solution.isValid("(()"));

        //https://leetcode.com/problems/climbing-stairs
        System.out.println("climbStairs:" + solution.climbStairs(3));

        //https://leetcode.com/problems/n-ary-tree-preorder-traversal
        Node child5 = new Node(5, null);
        Node child6 = new Node(6, null);

        Node child3 = new Node(3, Arrays.asList(child5, child6));
        Node child2 = new Node(2, null);
        Node child4 = new Node(4, null);

        Node rootNode = new Node(1, Arrays.asList(child3, child2, child4));
        System.out.println("preorder:" + solution.preorder(rootNode));

        //https://leetcode.com/problems/middle-of-the-linked-list
        ListNode head4 = new ListNode(4);
        ListNode head3 = new ListNode(3, head4);
        ListNode head2 = new ListNode(2, head3);
        ListNode head1 = new ListNode(1, head2);
        System.out.println("middleNode:" + solution.middleNode(head1).val);

        //https://leetcode.com/problems/two-sum
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] ret = solution.twoSum(nums, target);
        System.out.println("twoSum:" + ret[0] + "," + ret[1]);

        https://leetcode.com/problems/single-number
        nums = new int[]{2, 2, 1};
        System.out.println("singleNumber:" + solution.singleNumber(nums));
    }




}