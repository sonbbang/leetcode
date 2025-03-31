import java.util.Arrays;

public class Main {

    //기술면접 라이브코딩 기본편
    //https://www.youtube.com/watch?v=Bt11jaoqt_Y&list=PL2mzT_U4XxDm7p6g1o3KeQMsyRLfzSaVW&index=1
    public static void main(String[] args) {

        Solution solution = new Solution();
        //1. https://leetcode.com/problems/generate-parentheses/
        System.out.println("1.generateParenthesis:" + solution.generateParenthesis(3));

        //2. https://leetcode.com/problems/minimum-absolute-difference-in-bst/
        /*
            1
             \
              3
             /
            2
        */
        TreeNode left = new TreeNode(2, null, null);   // 하위 노드
        TreeNode middle = new TreeNode(3, left, null);       // 중간 노드
        TreeNode root = new TreeNode(1, null, middle);       // 최상위 노드
        System.out.println("2.getMinimumDifference:" + solution.getMinimumDifference(root));

        //3. https://leetcode.com/problems/hamming-distance/
        System.out.println("3.hammingDistance:" + solution.hammingDistance(1, 4));

        //4. https://leetcode.com/problems/merge-two-sorted-lists/
        // 첫 번째 리스트: 1->2->4
        ListNode next = new ListNode(2, null);
        ListNode list1 = new ListNode(1, next);
        next = new ListNode(4, null);
        list1.next.next = next;

        // 두 번째 리스트: 1->3->4
        next = new ListNode(3, null);
        ListNode list2 = new ListNode(1, next);
        next = new ListNode(4, null);
        list2.next.next = next;

        ListNode listNode = solution.mergeTwoLists(list1, list2);
        System.out.println("4.mergeTwoLists:" + listNode.printList());

        //5. https://leetcode.com/problems/valid-parentheses/description
        System.out.println("5.isValid:" + solution.isValid("()"));
        System.out.println("5.isValid:" + solution.isValid("(()"));

        //6.https://leetcode.com/problems/climbing-stairs
        System.out.println("6.climbStairs:" + solution.climbStairs(3));

        //7.https://leetcode.com/problems/n-ary-tree-preorder-traversal
        /*
              1
           /  |  \
          3   2  4
         / \
        5   6
        */
        Node child5 = new Node(5, null);
        Node child6 = new Node(6, null);

        Node child3 = new Node(3, Arrays.asList(child5, child6));
        Node child2 = new Node(2, null);
        Node child4 = new Node(4, null);

        Node rootNode = new Node(1, Arrays.asList(child3, child2, child4));
        System.out.println("7.preorder:" + solution.preorder(rootNode));

        //8.https://leetcode.com/problems/middle-of-the-linked-list
        ListNode head4 = new ListNode(4);
        ListNode head3 = new ListNode(3, head4);
        ListNode head2 = new ListNode(2, head3);
        ListNode head1 = new ListNode(1, head2);
        System.out.println("8.middleNode:" + listNode.printList());
        System.out.println("8.middleNode:" + solution.middleNode(head1).val);

        //9.https://leetcode.com/problems/two-sum
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] ret = solution.twoSum(nums, target);
        System.out.println("9.twoSum:" + ret[0] + "," + ret[1]);

        //10.https://leetcode.com/problems/single-number
        //nums = new int[]{2, 2, 1};
        nums = new int[]{4, 1, 2, 1, 2};
        System.out.println("10.singleNumber:" + solution.singleNumber(nums));

        //11.https://leetcode.com/problems/binary-tree-level-order-traversal-ii
        /*
            3
           / \
          9  20
             / \
            15  7
        */
        left = new TreeNode(9, null, null);  // 중간 노드 9
        middle = new TreeNode(20, new TreeNode(15, null, null), new TreeNode(7, null, null)); // 20 밑에 15, 7 연결
        root = new TreeNode(3, left, middle);  // 최상위 노드 3
        System.out.println("11.levelOrderBottom:" + solution.levelOrderBottom(root));

        //12.https://leetcode.com/problems/binary-tree-inorder-traversal
        /*
            1
             \
              2
             /
            3
        */
        left = new TreeNode(3, null, null);   // 하위 노드
        middle = new TreeNode(2, left, null);       // 중간 노드
        root = new TreeNode(1, null, middle);       // 최상위 노드
        System.out.println("12.inorderTraversal:" + solution.inorderTraversal(root));


    }



}