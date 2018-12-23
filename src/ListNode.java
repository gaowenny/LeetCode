public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
};

class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pHead = new ListNode(0);
        pHead.next = head;
        ListNode pFirst = pHead;
        ListNode pSecond = pHead;
        for(int i = 0; i <= n; i++){
            pFirst = pFirst.next;
        }
        while (pFirst != null){
            pFirst = pFirst.next;
            pSecond = pSecond.next;
        }
        pSecond.next = pSecond.next.next;
        return pHead.next;
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(3);
        ListNode p1 = l1;
        ListNode p2 = l2;
//        for (int i = 3; i< 6; i++){
//            p1.next =  new ListNode(i + 1);
//            p2.next = new ListNode(i + 2);
//            p1 = p1.next;
//            p2 = p2.next;
//        }
        l1.next = l2;
        RemoveNthFromEnd o = new RemoveNthFromEnd();
        o.removeNthFromEnd(l1, 2);
    }
}
