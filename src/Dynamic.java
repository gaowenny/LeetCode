import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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

    public int climbStairsRecursion(int n) {
        if(n == 1){
            return 1;
        }else if (n == 2){
            return 2;
        }else {
            return climbStairsRecursion(n-1) + climbStairsRecursion(n-2);
        }
    }

    public int climbStairs(int n){
        int maxWay = 0;
        int[] ways = new  int[n];
        if(n == 1){
            maxWay = 1;
        }else if (n == 2){
            maxWay = 2;
        }else {
            ways[0] = 1;
            ways[1] = 2;
            for(int i = 2; i < n; i++){
                ways[i] = ways[i-2] + ways[i-1];
            }
            maxWay = ways[n-1];
        }
        return maxWay;
    }
    public int climbStairsEx(int n){
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 2);
        for (int i = 3; i <= n; i++){
            map.put(i, map.get(i - 1) + map.get(i - 2));
        }
        return map.get(n);
    }

    public int minCostClimbingStairs(int[] cost) {
        int[] stariCosts = new int[cost.length];
        if(cost.length == 0){
             return  0;
        }else if(cost.length == 1){
            stariCosts[0] = cost[0];
        }else if(cost.length == 2){
            stariCosts[1] = Math.min(cost[0], cost[1]);
        }else if (cost.length == 3){
            stariCosts[2] = Math.min(cost[0] + cost[2], cost[1]);
        } else {
            stariCosts[0] = cost[0];
            stariCosts[1] = Math.min(cost[0], cost[1]);
            stariCosts[2] = Math.min(stariCosts[0] + cost[2], cost[1]);
            for (int i = 3; i < cost.length; i++){
                stariCosts[i] = Math.min(stariCosts[i-1]+cost[i],stariCosts[i-2]+cost[i-1]);
            }
        }
        return stariCosts[cost.length-1];
    }

    //最大整除子集
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<List<Integer>> numsLists = new ArrayList<>();
        List<Integer> resultList = new ArrayList<>();
        if (nums.length == 0){
           return resultList;
        }
        Arrays.sort(nums);
        List<Integer> l1 = new ArrayList<>();
        l1.add(nums[0]);
        numsLists.add(l1);
        for (int i = 1; i< nums.length; i++){
            List<Integer> li = new ArrayList<>();
            li.add(nums[i]);
            for(int j = i - 1; j >= 0 ; j--){
                List<Integer> lLast = numsLists.get(j);
                if(nums[i]%nums[j] == 0 && lLast.size() + 1 > li.size() ){
                    li.clear();
                    li.add(nums[i]);
                    li.addAll(lLast);
                }
            }
            numsLists.add(li);
        }
        for (int i =0; i<numsLists.size(); i++){
            if(numsLists.get(i).size() > resultList.size()){
                resultList = numsLists.get(i);
            }
        }
        return  resultList;
    }

    public List<Integer> largestDivisibleSubsetoFFical(int[] nums) {
        int len = nums.length, m = 0, mi = 0;
        int[] array = new int[len];
        int[] num = new int[len];

        Arrays.sort(nums);

        for (int i = 0; i < len; i++) {
            for (int j = i; j >= 0; j--) {
                if (nums[i] % nums[j] == 0 && array[j] + 1 > array[i]) {
                    array[i] = array[j] + 1;
                    num[i] = j;
                }
            }
            if (array[i] > m) {
                m = array[i];
                mi = i;
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            res.add(nums[mi]);
            mi = num[mi];
        }

        return res;
    }

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for(int i = 0; i<strs.length; i++){
            String s = strs[i];
            int mCount = 0, nCount = 0;
            for (int j = 0; j<s.length(); j++){
                if(s.charAt(j) == '0') mCount += 1;
                if(s.charAt(j) == '1') nCount += 1;
            }
            for (int j = m; j >= mCount; j--){
                for (int k = n; k >= nCount; k--){
                    dp[j][k] = Math.max(dp[j][k], dp[j-mCount][k-nCount] + 1);
                }
            }
        }
        return dp[m][n];
    }

    public int uniquePaths(int m, int n) {
        int[][] path = new int[m][n];
        for(int i = 0; i<m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0){
                    path[i][j] = 1;
                }else if(j==0){
                    path[i][j] = 1;
                }else {
                    path[i][j] = path[i-1][j] + path[i][j-1];
                }
            }
        }
        return path[m-1][n-1];
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int[][] path = new int[m][];
        int n = 0;
        for(int i = 0; i<m; i++){
            n = obstacleGrid[i].length;
            path[i] = new int[n];
            for(int j = 0; j < obstacleGrid[i].length; j++){
                if(obstacleGrid[i][j] == 1){
                    path[i][j] = 0;
                    continue;
                }
                if(i == 0 && j == 0){
                    path[i][j] = 1;
                }else {
                    if (i == 0) {
                        path[i][j] = path[i][j - 1];
                    }
                    if (j == 0) {
                        path[i][j] = path[i-1][j];
                    }
                    if(i !=0 && j!=0){
                        path[i][j] = path[i - 1][j] + path[i][j - 1];
                    }
                }
            }
        }
        return path[m-1][n-1];
    }
    public static void main(String[] args){
        int[] nums = {3,4,8,16,1,9,18,24,43};
        Dynamic o = new Dynamic();
        String[] strs = {"111","1000","1000","1000"};
        int[][] obs = {{1,0}};

        int n = o.climbStairsEx(3);

    }

}
