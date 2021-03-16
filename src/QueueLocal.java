import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class QueueLocal {
    public int shortestSubarray(int[] A, int K) {
        int minLength = A.length + 1;
        int[] sums = new int[A.length + 1];
        for (int i = 1; i < A.length + 1; i++){
            sums[i] = sums[i-1] + A[i-1];
        }
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < A.length + 1; i++){
            while (!q.isEmpty() && sums[i] - sums[q.getLast()] <= 0){
                q.removeLast();
            }
            while (!q.isEmpty() && sums[i] - sums[q.getFirst()] >= K){
                int m = q.getFirst();
                minLength = i - q.getFirst() > minLength ? minLength : i-q.getFirst();
                q.removeFirst();
            }
            q.addLast(i);
        }
        minLength = minLength == A.length + 1 ? -1 : minLength;
        return minLength ;
    };

    public static void main(String[] args){
        int[] a = {84,-37,-20,32,40,95};
        int k = 167;
        QueueLocal oQueue = new QueueLocal();
        System.out.println(oQueue.shortestSubarray(a,k));

    }
}
