public class MathClass {

    // 每当与最大值对齐一次，则需要将最小值增加m次，这时候比最小值大的数均会大于原先的最大数。
    // 多来几次这样的操作，会发现 移动次数等于res = (xn-min)+(xn-1-min)+....(x1-min)=sum(nums) -min * len(nums)
    public int minMoves(int[] nums) {
        int nMin = Integer.MAX_VALUE;
        int nSum = 0;
        for(int i = 0; i < nums.length; i++){
            nSum += nums[i];
            if(nums[i] < nMin)
                nMin = nums[i];
        }
        return nSum - (nMin * nums.length);
    }
    public int minMoves2(int[] nums) {
      for(int i = 0; i < nums.length -1; i++){
          for(int j = 0; j < nums.length - i -1; j++){
              if(nums[j] > nums[j+1]){
                  int temp = nums[j];
                  nums[j] = nums[j+1];
                  nums[j+1] = temp;
              }
          }
      }
      int nCert = nums[(nums.length -1) / 2];
      int nCount = 0;
      for(int i = 0; i < nums.length; i++){
          nCount = nCount + Math.abs(nums[i] - nCert);
      }
      return nCount;
    }

    public static void main(String[] args){
        MathClass o= new MathClass();
        int[] nums = {1,2,3,4,5,6};
        System.out.println(o.minMoves2(nums));
    }
}
