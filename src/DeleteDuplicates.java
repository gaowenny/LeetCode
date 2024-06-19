public class DeleteDuplicates {
    public LinkNode delteDuplicates(LinkNode head){
        if (head == null)
            return head;
        LinkNode pPre = head;
        LinkNode pNext = pPre.next;
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

    public int removeDuplicates(int[] nums){
        if(nums == null)
            return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++ ) {
            if(nums[i] != nums[j]){
                i++;
                nums[i] = nums[j];
            }
        }
        //不同的个数=跳的次数+1
        return i + 1;
    }
    public LinkNode deleteDuplicatesOffical(LinkNode head){
        LinkNode p = head;
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
        LinkNode l1 = new LinkNode(1);
        l1.next = new LinkNode(1);
        l1.next.next = new LinkNode(2);
        l1.next.next.next= new LinkNode(2);
//        ListNode p1 = l1;
//        for (int i = 2; i< 5; i++){
//            p1.next =  new ListNode(i + 1);
//            p1 = p1.next;
//        }
        DeleteDuplicates d = new DeleteDuplicates();
        LinkNode l3 = d.deleteDuplicatesOffical(l1);

        while (l3 != null){
            System.out.println(l3.val);
            l3 = l3.next;
        }
    }

}
