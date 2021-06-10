//其实跟动态规划没什么关系
public class NumArray {
    private int[] nSums;

    public NumArray(int[] nums) {
        nSums = new int [nums.length];
        if (nums.length == 0){
            return;
        }
        nSums[0] = nums[0];
        for (int i = 1; i< nums.length; i++){
            nSums[i] = nums[i] + nSums[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        if(i == 0){
            return nSums[j];
        }else {
            return nSums[j] - nSums[i-1];
        }
    }


    public static void main(String[] args){
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray o = new NumArray(nums);
        System.out.println(o.sumRange(2,5));
    }
}

