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

    public static void main(String[] args){
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        Dynamic o = new Dynamic();

        System.out.println(o.maxSubArray(nums));
    }

}
