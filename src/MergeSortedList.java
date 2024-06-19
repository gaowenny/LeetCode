public class MergeSortedList {

    public LinkNode mergeTwoLists(LinkNode<Integer> l1, LinkNode<Integer> l2) {
        int val = (l1.val < l2.val)? l1.val: l2.val;
        LinkNode l3 = new LinkNode(val);
        LinkNode firstNode = l3;
        while (l1 != null && l2 != null){
            if (l1.val <= l2.val){
                l3.next = l1;
                l1 = l1.next;
            }else {
               l3.next = l2;
               l2 = l2.next;
            }
            l3 = l3.next;
        }
        while (l1 != null){
            l3.next = l1;
            l1 = l1.next;
            l3 = l3.next;
        }
        while (l2 != null){
            l3.next = l2;
            l2 =l2.next;
            l3 = l3.next;
        }
        return firstNode.next;
    };


    public static void main(String[] args) {
	// write your code here
        MergeSortedList m = new MergeSortedList();
        LinkNode l1 = new LinkNode(1);
        LinkNode l2 = new LinkNode(3);
        LinkNode p1 = l1;
        LinkNode p2 = l2;
        for (int i = 3; i< 5; i++){
            p1.next =  new LinkNode(i + 1);
            p2.next = new LinkNode(i + 2);
            p1 = p1.next;
            p2 = p2.next;
        }
        LinkNode l3 = m.mergeTwoLists(l1, l2);
        while (l3 != null){
           System.out.println(l3.val);
           l3 = l3.next;
        }
    }
}
