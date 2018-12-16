import java.util.HashSet;
import java.util.Set;

public class CandySwap {
    public int[] fairCandySwap(int[] A, int[] B) {
        int[] result = new int[2];
        int nSumA = 0;
        int nSumB = 0;
        for (int i = 0; i < A.length; i++){
            nSumA += A[i];
        }
        for (int i = 0; i < B.length; i++){
            nSumB += B[i];
        }
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < B.length; j++){
                if(B[j] + nSumA - A[i] == A[i] + nSumB - B[j]){
                    result[0] = A[i];
                    result[1] = B[j];
                    return result;
                }
            }
        }
        return result;
    }

    public int[] fairCandySwapOffical(int[] A, int[]B){
        int sa = 0, sb = 0;  // sum of A, B respectively
        for (int x: A) sa += x;
        for (int x: B) sb += x;
        int delta = (sb - sa) / 2;
        // If Alice gives x, she expects to receive x + delta

        Set<Integer> setB = new HashSet<>();
        for (int x: B) setB.add(x);

        for (int x: A)
            if (setB.contains(x + delta))
                return new int[]{x, x + delta};

        throw null;
    }
    public static void main(String[] args){

        int[] A = {1,2,5};
        int[] B = {2,4};
        CandySwap o = new CandySwap();
        int[] r = o.fairCandySwap(A, B);
    }
}
