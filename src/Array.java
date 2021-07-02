import java.util.*;

public class Array {
    //287 寻找重复数
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i<nums.length-1; i++) {
           if (nums[i+1] - nums[i] ==0){
               return nums[i];
           }
        }
        return nums[nums.length-1];
    }
    //慢指针 slow 和快指针 fast，慢指针每次走一步，快指针每次走两步，根据「Floyd 判圈算法」
    // 两个指针在有环的情况下一定会相遇，此时我们再将slow 放置起点 00，两个指针每次同时移动一步，相遇的点就是答案。
    public int findDuplicateEx(int[] nums){
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
   // 720. 词典中最长的单词
    public String longestWord(String[] words) {
        Set<String> wordSet = new HashSet<>();
        for (String word : words) {
            wordSet.add(word);
        }
        Arrays.sort(words, (a, b) -> a.length() == b.length()
                ? a.compareTo(b) : b.length() - a.length());
        for (String word : words) {
            boolean yes = true;
            for (int i = 1; i < word.length(); i++){
                if(!wordSet.contains(word.substring(0,i))){
                    yes = false;
                    break;
                }
            }
            if(yes) return word;
        }
        return "";
    }
//1685. 有序数组中差绝对值之和
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int[] result = new int[nums.length];
        int[][] abs = new int[nums.length][nums.length];
        for(int i = 0; i<nums.length; i++){
            for(int j = i; j < nums.length; j++){
                abs[i][j] = Math.abs(nums[i] - nums[j]);
            }
        }
        for(int i = 0; i<nums.length; i++){
            result[i] = 0;
            for(int j = 0; j< nums.length; j++){
                int temp = abs[i][j];
                if(abs[i][j] == 0){
                    temp = abs[j][i];
                }
                result[i] = result[i] + temp;
            }
        }
        return result;
    }

    public int[] getSumAbsoluteDifferencesEx(int[] nums) {
        int[] result = new int[nums.length];
        int sum = 0;
        for(int i = 0; i<nums.length; i++){
            sum += nums[i];
        }
        int su = 0;
        for(int i = 0; i<nums.length; i++){
            result[i] = sum - nums[i] * nums.length + (nums[i] * i - su)*2;
            su += nums[i];
        }
        return result;
    }

//    167. 两数之和 II - 输入有序数组
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        for(int i = 0; i < numbers.length; i++){
            int j = i + 1;
            while(j < numbers.length && numbers[i] + numbers[j] <= target){
                if(numbers[i] + numbers[j] == target){
                    result[0] = i + 1;
                    result[1] = j + 1;
                    return result;
                }
                j++;
            }
        }
        return result;
    }
    public int[] twoSumEx(int[] numbers, int target) {
        int[] result = new int[2];
        int slow = 0;
        int fast = numbers.length - 1;
        while (slow < fast){
            int temp = numbers[slow] + numbers[fast];
            if(temp > target){
                fast--;
            }else if(temp == target){
                result[0] = slow + 1;
                result[1] = fast + 1;
                return result;
            }else{
                slow++;
            }
        }
        return result;
    }
    //1. 两数之和
    public int[] twoSum1(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int temp = target - nums[i];
            if(hashMap.containsKey(temp)){
                result[0] = i;
                result[1] =  hashMap.get(temp);
                return result;
            }
            hashMap.put(nums[i], i);
        }
        return result;
    }
    public List<List<Integer>> threeSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i< nums.length; i++){
            if(nums[i] > target) break;
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int slow = i + 1, fast = nums.length - 1;
            while (slow < fast ){
                int temp = nums[slow] + nums[fast] + nums[i];
                if(temp == target){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[slow]);
                    list.add(nums[fast]);
                    result.add(list);
                    while(slow < fast && nums[slow] == nums[slow+1]) slow++;
                    while (slow < fast && nums[fast] == nums[fast-1]) fast--;
                    slow++;
                    fast--;
                } else if(temp < target ){
                    slow++;
                }else fast--;
            }
        }
        return result;
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int j = 0; j < nums.length; j++){
            if(j > 0 && nums[j] == nums[j - 1]) continue;
            for (int i = j + 1; i< nums.length; i++){
                if(i > j + 1 && nums[i] == nums[i - 1]) continue;
                int slow = i + 1, fast = nums.length - 1;
                while (slow < fast ){
                    int temp = nums[slow] + nums[fast] + nums[i] + nums[j];
                    if(temp == target){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[slow]);
                        list.add(nums[fast]);
                        list.add(nums[j]);
                        result.add(list);
                        while(slow < fast && nums[slow] == nums[slow+1]) slow++;
                        while (slow < fast && nums[fast] == nums[fast-1]) fast--;
                        slow++;
                        fast--;
                    } else if(temp < target ){
                        slow++;
                    }else fast--;
                }
            }
        }
        return result;
    }

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int result = 0;
        HashMap<Integer, Integer> sumFirst = new HashMap<>();
        for (int i : nums1) {
            for (int j : nums2) {
                sumFirst.put(i+j, sumFirst.getOrDefault(i+j, 0) + 1);
            }
        }
        for (int i : nums3) {
            for (int j : nums4) {
                if(sumFirst.containsKey(-i-j)){
                    result += sumFirst.getOrDefault(-i-j, 0);
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        int[] nums = {-2,-1,-1,1,1,2,2};
        Array o = new Array();
        List<List<Integer>> result = o.fourSum(nums, 0);
        for (List<Integer> list : result) {
            System.out.print(list);
        }
    }
}
