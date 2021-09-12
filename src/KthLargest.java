import java.util.*;

public class KthLargest {
    private List<Integer> list;
    PriorityQueue<Integer> queue;
    private int index;
    public KthLargest(int k, int[] nums) {
        index = k;
        list = new ArrayList<>();
        for (int n: nums){
            add(n);
        }
    }


    public int add(int val) {
        list.add(val);
        Collections.sort(list);
        if (list.size() > index) {
            list.remove(0);
        }
        return list.get(0);
    }


    public static void main(String[] args){
        int[] nums = {4, 5, 8, 2};
        KthLargest kthLargest = new KthLargest(3, nums);
        int num = kthLargest.add(3);
        num = kthLargest.add(5);
        System.out.print(num);
    }
}
