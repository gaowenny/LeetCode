public class Dynamic {

    public int lengthOfLIS(int[] nums) {
        int nMax = 0;
        int[] maxLengthList =new int[nums.length];
        for(int i =0; i< nums.length; i++){
            maxLengthList[i] = 1;
            for (int j = 0; j< i; j++){
                if(nums[i] > nums[j] && maxLengthList[i] <= maxLengthList[j] + 1){
                    maxLengthList[i] = maxLengthList[j] + 1;
                }
            }
            if(maxLengthList[i] > nMax){
                nMax = maxLengthList[i];
            }
        }
        return nMax;
    }

    //oLog(n)   dp里的序列不是正确的
    public int LengthOfLISOffical(int[] nums) {

        int maxL = 0;
        int[] dp = new int[nums.length];
        for (int num : nums) {
            // 二分法查找, 也可以调用库函数如binary_search
            int lo = 0, hi = maxL;
            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;
                if (dp[mid] < num)
                    lo = mid + 1;
                else
                    hi = mid;
            }
            dp[lo] = num;
            if (lo == maxL)
                maxL++;
        }
        return maxL;
    }

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

    public int maxSubArray(int[] nums) {
        int[] dps = new int[nums.length];
        dps[0] = nums[0];
        int max = nums[0];
        for(int i = 1; i < nums.length; i++){
            dps[i] = Math.max(dps[i - 1] + nums[i], nums[i]);
            max = Math.max(dps[i], max);
        }
        return max;
    }


    public int rob(int[] nums) {
        int maxProfit = 0;
        int[] profits = new int[nums.length];
        if(nums.length == 0){
            maxProfit = 0;
        }else if (nums.length == 1){
            maxProfit =  nums[0];
        }else if(nums.length == 2){
            maxProfit = Math.max(nums[0], nums[1]);
        }else if(nums.length == 3){
            maxProfit = Math.max(nums[0] + nums[2], nums[1]);
        }else{
            profits[0] = nums[0];
            profits[1] = nums[1];
            profits[2] = Math.max(profits[0] + nums[2], profits[1]);
            maxProfit = profits[2];
            for (int i = 3; i < nums.length; i++){
                profits[i] = Math.max(Math.max(profits[i-2]+nums[i], profits[i-3]+nums[i-1]), profits[i-3] + nums[i]);
                maxProfit = Math.max(maxProfit, profits[i]);
            }
        }
        return maxProfit;
    }
    public static void main(String[] args){
        int[] nums = {2,1,1,2,3,4,5,6,7,8,3,2,1,5,3,4,6};
        Dynamic o = new Dynamic();

        System.out.println(o.rob(nums));
    }

}
