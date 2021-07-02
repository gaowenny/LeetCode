import java.util.Arrays;

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

    public void wiggleSort(int[] nums) {
        int [] newNums = nums.clone();
        Arrays.sort(newNums);
        int j = 0;
        for (int i = newNums.length-1; i>=0; i--){
            int n = newNums.length/2;
            if(j<n){
                nums[j*2+1] = newNums[i];
            }else{
                nums[(j-n)*2] = newNums[i];
            }
            j++;
        }
    }


    public static void main(String[] args){
        int[] nums = {5, 3, 1, 2, 3};
        NumArray o = new NumArray(nums);
        o.wiggleSort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}

