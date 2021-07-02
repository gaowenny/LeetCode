import java.util.HashMap;

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
    public String originalDigits(String s) {
        HashMap<Character, String> hashWord = new HashMap<>();
        hashWord.put('z', "zero");
        hashWord.put('w', "two");
        hashWord.put('u', "four");
        hashWord.put('x', "six");
        hashWord.put('g', "ehight");
        hashWord.put('o', "one");
        hashWord.put('h', "three");
        hashWord.put('f', "five");
        hashWord.put('s', "seven");
        hashWord.put('i', "nine");
        int[] num = {0,2,4,6,8,1,3,5,7,9};
        int[] sResult = new int[10];
        HashMap<Character, Integer> hashChar = new HashMap<>();
        for(int i = 0; i< s.length(); i++){
            if (hashChar.containsValue(s.charAt(i))){
//                hashChar. = hashChar.get()
            }
        }
        Character[] letter = {'z','w','u','x','g','o','h','f','s','i'};
        for (int i = 0; i < letter.length; i++){

        }
        return "";
    }
    public static void main(String[] args){
        MathClass o= new MathClass();
        int[] nums = {1,2,3,4,5,6};
        System.out.println(o.minMoves2(nums));
    }
}
