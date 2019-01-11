public class MaximumProduct {

    public int maximumProduct(int[] nums) {
        if (nums.length == 3){
            return nums[0] * nums[1] * nums[2];
        }
        int temp;
        for (int i = 0; i < nums.length - 1; i++){
            for (int j = 0; j < nums.length - 1 -i  ; j++){
                if (nums[j] < nums[j + 1]){
                    temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }

        }
        return Math.max(nums[0] * nums[1] * nums[2], nums[0] * nums[nums.length - 1] * nums[nums.length - 2]);
    }
}
