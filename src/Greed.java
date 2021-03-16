import java.lang.reflect.Array;
import java.util.Arrays;

public class Greed {
    public int minDeletionSize(String[] A) {
        int nSize = 0;
        int nLength = A[0].length();
        for (int i = 0; i<nLength; i++){
            int j;
            for (j = 1; j < A.length; j++){
                if (A[j].charAt(i) - A[j-1].charAt(i) < 0){
                    break;
                }
            }
            if (j < A.length || (A[A.length-1].charAt(i)) - A[A.length-2].charAt(i) < 0){
                nSize++;
            }
        }
        return nSize;
    }

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int sIndex = s.length - 1, gIndex = g.length - 1, childs = 0;
        while (sIndex >= 0 && gIndex >= 0 ){
           if(g[gIndex] <= s[sIndex]){
               childs++;
               gIndex--;
               sIndex--;
           }else {
               gIndex--;
           }
        }
        return childs;
    }

    public static void main(String[] args){
        String[] A = {"rrjk","furt","guzm"};
        int[] g = {2,3,1};
        int[] s = {3};
        Greed o = new Greed();
        int n = o.findContentChildren(g,s);
        System.out.println(n);
    }
}
