import java.util.*;

public class Solution {

    ArrayList<String> ret = new ArrayList<>();

    //backtracking
    //~recursion+ termination check
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

    //트리 순회(재귀)
    //preorder : self left right
    //inorder : left self right
    //postorder : left right self
    //이진검색트리 성질 -> inorder -> 오름차순 정렬이 됨!
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
                //ret.printList();
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
                //ret.printList();
            }
        }
        return ret;
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        char[] arr = s.toCharArray();
        for (char c : arr) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.size() == 0 || stack.pop() != '(') {
                    return false;
                }
            } else if (c == '}') {
                if (stack.size() == 0 || stack.pop() != '{') {
                    return false;
                }
            } else if (c == ']') {
                if (stack.size() == 0 || stack.pop() != '[') {
                    return false;
                }
            } else {
                return false;
            }

        }
        return stack.size() == 0;
    }

    //1 2 3 5 8: 피보나치 수열
    //f(n)=f(n-1)+f(n-2)
    //f(5)=f(4)+f(3)
    //f(4)=f(3)+f(2)
    //다이나믹 프로그래밍 -> 공간복잡도 O(n) 시간복잡도 O(n)
    //점화식을 찾아야한다.
    public int climbStairs(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;

        int[] d = new int[n + 1];
        d[1] = 1;
        d[2] = 2;
        for (int i = 3; i < n; i++) {
            d[i] = d[i - 1] + d[i - 2];
        }
        return d[n];
    }

    /*
    pre : self children
    post: children self
     */
    public List<Integer> preorder(Node root) {
        List<Integer> ret = new ArrayList<>();
        traverse(root, ret);
        return ret;
    }

    private void traverse(Node root, List<Integer> ret) {
        if (root == null) return;
        ret.add(root.val);

        if (root.children != null) {
            for (Node child : root.children) {
                traverse(child, ret);
            }
        }
    }

    //워커 러너 테크닉
    //walker : 한번에 한칸씩
    //runner : 한번에 두칸씩
    //runner가 끝나면 walker는 중간에 와있음
    //구현을 위한 브레인 스토밍
    //walker: 1 2x
    //runner: 1 2 nullx
    //
    //walker: 1 2x 3
    //runner: 1 2 3 nullx
    //while loop 마다
    //러너 1칸 전진 웤커 1칸 전진 러너 1칸 전진
    public ListNode middleNode(ListNode head) {
        ListNode walker = head;
        ListNode runner = head;
        while (runner != null) {
            runner = runner.next;
            if (runner != null) {
                walker = walker.next;
                runner = runner.next;
            }
        }
        return walker;
    }

    /*
    시간복잡도 <-> 공간복잡도
    대안 1. brute-force 모든 조합을 시도. 2중 루프 n*(n-1) / 2
        - 시간:O(n^2)
        - 공간:O(1)
    대안 2. 해쉬맵 사용, 루프 1개 돌면서 이미 봤던 값을 해쉬맵에 넣음
        - 시간: O(n)
        - 공간: O(n)
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();//키-값, 밸류-인덱스

        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if (map.containsKey(target - cur)) {
                int[] ret = new int[2];
                ret[0] = map.get(target - cur);
                ret[1] = i;
                return ret;
            } else {
                map.put(cur, i);
            }
        }
        return null;

    }

    public int singleNumber(int[] nums) {
        return 0;
    }
}

