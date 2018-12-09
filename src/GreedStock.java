public class GreedStock {

    public int maxProfit(int[] prices) {
        int nMax = 0;
        for (int i = 0; i < prices.length - 1; i++){
            if(prices[i + 1] > prices[i]){
                nMax = nMax + prices[i + 1] - prices[i];
            }
        }

        return nMax;
    }
    public int maxProfitPeak(int[] prices) {
        int i = 0;
        int valley = prices[0];
        int peak = prices[0];
        int maxprofit = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1])
                i++;
            valley = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1])
                i++;
            peak = prices[i];
            maxprofit += peak - valley;
        }
        return maxprofit;
    }
    public static void main(String[] args){
        int[] a = {7,1,5,3,6,7,1,4};
        GreedStock o = new GreedStock();
        System.out.println(o.maxProfitPeak(a));
    }
}
