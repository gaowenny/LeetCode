
import javax.print.DocFlavor;
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
};
class NodeList{
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

    private void stackPop(Stack stack, ListNode listNode){
        while (!stack.isEmpty()){
            listNode.next = new ListNode((int)stack.pop());
            listNode = listNode.next;
        }
    }
    // 分割链表1966
    public ListNode partition(ListNode head, int x){
        ListNode p = head;
        ListNode minHead = new ListNode(0);
        ListNode maxHead = new ListNode(0);
        ListNode minTail = minHead;
        ListNode maxSlow = maxHead;
        ListNode maxTail =  maxHead;
        while (null != p){
            if (p.val < x){
                minTail.next = p;
                minTail = minTail.next;
            }else if (p.val == x){
                maxTail.next = p;
                maxSlow = maxTail;
                maxTail = maxTail.next;
            }else {
                ListNode temp = new ListNode(p.val);
                if (maxSlow.equals(maxTail)){
                    maxTail.next = temp;
                    maxSlow = maxTail;
                    maxTail = maxTail.next;
                }else {
                    temp.next = maxTail;
                    maxSlow.next = temp;
                    maxSlow = maxSlow.next;
                }
            }
            p = p.next;
        }
        minTail.next = maxHead.next;
        maxTail.next = null;
        return minHead.next;
    }

    // 141 环形链表
    public boolean hasCycle(ListNode head) {
       if(head == null || head.next == null){
           return false;
       }
       ListNode slow = head;
       ListNode fast = head.next;
       while (slow != fast){
           if (fast == null || fast.next == null){
               return false;
           }
           slow = slow.next;
           fast = fast.next.next;
       }
       return true;
    }
//环形链表检测2
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        do{
            if (fast == null || fast.next == null){
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        } while (slow != fast);
        ListNode p  = head;
        while (p != slow){
            slow = slow.next;
            p = p.next;
        }
        return p;
    }




    public static void main(String[] args){
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(2);
        list.add(0);
        list.add(-4);

        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(0);
        ListNode l4 = new ListNode(-4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l2;

        NodeList o = new NodeList();
        o.detectCycle(l1);

        while (null != l1){
            System.out.print(l1.val);
            l1 = l1.next;
        }
    }

}

