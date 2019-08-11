
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
};
class Node{
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

    public void reorderList(ListNode head) {
        List<Integer> l = new ArrayList<Integer>();
        ListNode pFirst = head;
        while (pFirst != null){
            l.add(pFirst.val);
            pFirst = pFirst.next;
        }
        pFirst = head;
        int i = 0;
        while (pFirst != null && pFirst.next != null){
            pFirst.val = l.get(i);
            pFirst.next.val = l.get(l.size() - 1 - i);
            pFirst = pFirst.next.next;
            i++;
        }
        if(pFirst != null){
            pFirst.val = l.get(l.size() / 2);
        }

    }

    /*剑指offer 05、输入个链表的头结点，从尾到头反过来打印出每个结点的值。*/
    public void printListReversingly(ListNode node){
        Stack stack = new Stack();
        while (node != null){
            stack.push(node.val);
            node = node.next;
        }
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(3);
        ListNode p1 = l1;
        ListNode p2 = l2;
        for (int i = 3; i< 6; i++){
            p1.next =  new ListNode(i + 1);
            p2.next = new ListNode(i + 2);
            p1 = p1.next;
            p2 = p2.next;
        }
//        l1.next = l2;
        Node o = new Node();
//        o.removeNthFromEnd(l1, 2);
//        o.reorderList(l1);
        o.printListReversingly(l1);
    }

}

