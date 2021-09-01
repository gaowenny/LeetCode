import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

class RecentCounter {
    Queue<Integer> requestList;
    public RecentCounter() {
        requestList = new PriorityQueue<>();
    }

    public int ping(int t) {
        requestList.offer(t);
        Queue<Integer> list = requestList;
        while (list.peek()<=t-3000){
            list.remove();
        }
        return list.size();
    }
}