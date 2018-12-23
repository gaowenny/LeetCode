import java.util.HashMap;

public class MaxProfitAssignment {

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker){
        int[] workProfit = new int[worker.length];
        int nMaxProfit = 0;
        for(int i = 0; i < profit.length; i++){
            for(int j = i + 1; j < profit.length; j++){
                if (profit[j] > profit[i]){
                    int nTemp = profit[i];
                    profit[i] = profit[j];
                    profit[j] = nTemp;
                    nTemp = difficulty[i];
                    difficulty[i] = difficulty[j];
                    difficulty[j] = nTemp;
                }
            }
        }

        for(int i = 0; i < worker.length; i++){
           for(int j = 0; j < difficulty.length; j++){
               if(worker[i] >= difficulty[j]){
                   workProfit[i] = profit[j];
                   break;
               }
           }
        }
        for(int i = 0; i < workProfit.length; i++){
            nMaxProfit += workProfit[i];
        }
        return nMaxProfit;
    }

    public static void main(String[] args){

        MaxProfitAssignment o = new MaxProfitAssignment();
        int[] di = {13,37,58};
        int[] pr = {4,90,96};
        int[] worker = {34,73,45};
        System.out.println(o.maxProfitAssignment(di, pr, worker));
    }
}
