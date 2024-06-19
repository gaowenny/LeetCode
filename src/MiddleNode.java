public class MiddleNode {
    public LinkNode middleNode(LinkNode head) {
        LinkNode p = head;
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
    public LinkNode middleNodeOfficial(LinkNode head){
        LinkNode pSlow = head;
        LinkNode pFast = head;
        while (pFast != null && pFast.next != null){
            pSlow = pSlow.next;
            pFast = pFast.next.next;
        }
        return  pSlow;
    }

    public static void main(String[] args) {
        LinkNode l1 = new LinkNode(1);
        LinkNode p1 = l1;
        for (int i = 2; i< 5; i++){
            p1.next =  new LinkNode(i + 1);
            p1 = p1.next;
        }
        MiddleNode m = new MiddleNode();
        LinkNode l3 = m.middleNodeOfficial(l1);

        while (l3 != null){
            System.out.println(l3.val);
            l3 = l3.next;
        }
    }
}
