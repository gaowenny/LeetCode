import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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

    }
    public static void main(String[] args){
        int[] nums = {1,4,6,6,6,2,3};
        Array o = new Array();
        String[] words = {"yo","ew","fc","zrc","yodn","fcm","qm","qmo","fcmz","z","ewq","yod","ewqz","y"};
        o.longestWord(words);
    }
}
