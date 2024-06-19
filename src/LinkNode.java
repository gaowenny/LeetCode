
import java.util.*;

public class LinkNode<T> {
    T val;
    LinkNode next;
    LinkNode(T x) {
        val = x;
    }
};


class Node{
    public LinkNode removeNthFromEnd(LinkNode head, int n) {
        LinkNode pHead = new LinkNode(0);
        pHead.next = head;
        LinkNode pFirst = pHead;
        LinkNode pSecond = pHead;
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

    public void reorderList(LinkNode<Integer> head) {
        List<Integer> l = new ArrayList<Integer>();
        LinkNode<Integer> pFirst = head;
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
    public void printListReversingly(LinkNode node){
        Stack stack = new Stack();
        while (node != null){
            stack.push(node.val);
            node = node.next;
        }
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }

    private void stackPop(Stack stack, LinkNode linkNode){
        while (!stack.isEmpty()){
            linkNode.next = new LinkNode((int)stack.pop());
            linkNode = linkNode.next;
        }
    }
    // 分割链表1966
    public LinkNode partition(LinkNode<Integer> head, int x){
        LinkNode<Integer> p = head;
        LinkNode<Integer> minHead = new LinkNode(0);
        LinkNode<Integer> maxHead = new LinkNode(0);
        LinkNode<Integer> minTail = minHead;
        LinkNode<Integer> maxSlow = maxHead;
        LinkNode<Integer> maxTail =  maxHead;
        while (null != p){
            if (p.val < x){
                minTail.next = p;
                minTail = minTail.next;
            }else if (p.val == x){
                maxTail.next = p;
                maxSlow = maxTail;
                maxTail = maxTail.next;
            }else {
                LinkNode temp = new LinkNode(p.val);
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
    public boolean hasCycle(LinkNode head) {
       if(head == null || head.next == null){
           return false;
       }
       LinkNode slow = head;
       LinkNode fast = head.next;
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
    public LinkNode detectCycle(LinkNode head) {
        if(head == null || head.next == null){
            return null;
        }
        LinkNode slow = head;
        LinkNode fast = head;
        do{
            if (fast == null || fast.next == null){
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        } while (slow != fast);
        LinkNode p  = head;
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

        LinkNode l1 = new LinkNode(3);
        LinkNode l2 = new LinkNode(2);
        LinkNode l3 = new LinkNode(0);
        LinkNode l4 = new LinkNode(-4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l2;

        Node o = new Node();
        o.detectCycle(l1);

        while (null != l1){
            System.out.print(l1.val);
            l1 = l1.next;
        }
    }

}

