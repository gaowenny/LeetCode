
import java.util.*;


public class MergeSortedList {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        int val = (l1.val < l2.val)? l1.val: l2.val;
        ListNode l3 = new ListNode(val);
        ListNode firstNode = l3;
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
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(3);
        ListNode p1 = l1;
        ListNode p2 = l2;
        for (int i = 3; i< 5; i++){
            p1.next =  new ListNode(i + 1);
            p2.next = new ListNode(i + 2);
            p1 = p1.next;
            p2 = p2.next;
        }
        ListNode l3 = m.mergeTwoLists(l1, l2);
        while (l3 != null){
           System.out.println(l3.val);
           l3 = l3.next;
        }
    }
}
