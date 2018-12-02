public class DeleteDuplicates {
    public ListNode delteDuplicates(ListNode head){
        if (head == null)
            return head;
        ListNode pPre = head;
        ListNode pNext = pPre.next;
        while (pNext != null ){
            if (pPre.val == pNext.val){
                pPre.next = pNext.next;
                pNext = pPre.next;
                continue;
            }
            pPre = pPre.next;
            pNext = pPre.next;
        }
        return head;
    }
    public ListNode deleteDuplicatesOffical(ListNode head){
        ListNode p = head;
        while (p != null && p.next != null){
            if (p.val == p.next.val){
                p.next = p.next.next;
            }else {
                p = p.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(2);
        l1.next.next.next= new ListNode(2);
//        ListNode p1 = l1;
//        for (int i = 2; i< 5; i++){
//            p1.next =  new ListNode(i + 1);
//            p1 = p1.next;
//        }
        DeleteDuplicates d = new DeleteDuplicates();
        ListNode l3 = d.deleteDuplicatesOffical(l1);

        while (l3 != null){
            System.out.println(l3.val);
            l3 = l3.next;
        }
    }

}
