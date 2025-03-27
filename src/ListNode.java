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
    public String printList() {
        String ret = "";
        ListNode current = this; // 현재 노드부터 시작
        while (current != null) {
            ret += current.val;
            if (current.next != null) {
                ret += "->"; // 다음 노드가 있으면 '->' 추가
            }
            current = current.next; // 다음 노드로 이동
        }
        return ret;
    }

}
