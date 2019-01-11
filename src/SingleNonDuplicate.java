public class SingleNonDuplicate {

    public int singleNonDuplicate(int[] nums) {
        int result = 0;
        for(int i = 0; i < nums.length ; i++){
            result = nums[i] - result;
        }
        return Math.abs(result);
    }

    public static void main(String[] args){
        SingleNonDuplicate o = new SingleNonDuplicate();
        int[] nums = {3,3,7,7,10,11,11};
        System.out.print(o.singleNonDuplicate(nums));
    }
}
