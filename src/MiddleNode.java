public class MiddleNode {
    public ListNode middleNode(ListNode head) {
        ListNode p = head;
        int nCount = 0;
        while (p != null){
            nCount ++;
            p = p.next;
        }
        int nMiddle = nCount / 2;
        p = head;
        for (int i = 0; i < nMiddle; i++){
            p = p.next;
        }
        return  p;
    }

    //官方 快慢指针
    public ListNode middleNodeOfficial(ListNode head){
        ListNode pSlow = head;
        ListNode pFast = head;
        while (pFast != null && pFast.next != null){
            pSlow = pSlow.next;
            pFast = pFast.next.next;
        }
        return  pSlow;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode p1 = l1;
        for (int i = 2; i< 5; i++){
            p1.next =  new ListNode(i + 1);
            p1 = p1.next;
        }
        MiddleNode m = new MiddleNode();
        ListNode l3 = m.middleNodeOfficial(l1);

        while (l3 != null){
            System.out.println(l3.val);
            l3 = l3.next;
        }
    }
}
