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

        //https://leetcode.com/problems/valid-parentheses/description
        System.out.println("isValid:" + solution.isValid("(()"));

        //https://leetcode.com/problems/climbing-stairs
        System.out.println("isValid:" + solution.climbStairs(3));

        //https://leetcode.com/problems/n-ary-tree-preorder-traversal
        Node child1 = new Node(1, null);
        Node child2 = new Node(2, null);
        ArrayList<Node> childs = new ArrayList<>();
        childs.add(child1);
        childs.add(child2);

        Node rootNode = new Node(3, childs);
        System.out.println("preorder:" + solution.preorder(rootNode));

    }


}