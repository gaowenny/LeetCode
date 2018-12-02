public class DynamicProgramStock {
  public int  maxProfit(int[] prices) {
      if (prices.length == 0){
          return 0;
      }
      int nMaxProfit = 0;
      int nMinStock = prices[0];
      for (int i = 0; i< prices.length; i++){
          if (prices[i] < nMinStock){
              nMinStock = prices[i];
          } else if(nMaxProfit < prices[i] - nMinStock){
              nMaxProfit = prices[i] - nMinStock;
          }
      }
      return  nMaxProfit;
  }

  public static void main(String[] args){
      DynamicProgramStock o = new DynamicProgramStock();
      int[] aStocks = {7,1,5,3,6,4};
      int nMaxProfit = o.maxProfit(aStocks);
      System.out.println(nMaxProfit);
  }
}
