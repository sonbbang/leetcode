public class ListNode {
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

    // 리스트의 모든 값을 출력하는 메소드
    public void printList() {
        ListNode current = this; // 현재 노드부터 시작
        while (current != null) {
            System.out.print(current.val + "->"); // 현재 노드의 값 출력
            current = current.next; // 다음 노드로 이동
        }
        System.out.println(); // 출력 후 새로운 줄로 넘어감
    }

}
