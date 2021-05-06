import java.util.Arrays;

public class Sort {
    //324. 摆动排序 II
    public void wiggleSort(int[] nums) {
        int [] newNums = nums.clone();
//        for (int i = 0; i<newNums.length; i++) {
//            for (int j = i + 1; j < newNums.length; j++){
//                if (newNums[j] > newNums[i]){
//                    int temp = newNums[i];
//                    newNums[i] = newNums[j];
//                    newNums[j] = temp;
//                }
//            }
//        }
//        for (int i = 0; i<newNums.length; i++){
//            int n = newNums.length/2;
//            if(i<n){
//                nums[i*2+1] = newNums[i];
//            }else{
//                nums[(i-n)*2] = newNums[i];
//            }
//        }
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
        for(int num : nums){
            System.out.print(num);
        }
    }

    //179. 最大数 1 <= nums.length <= 100   0 <= nums[i] <= 109
    public String largestNumber(int[] nums) {
        String[] array = new String[nums.length];
        for (int i = 0;i < nums.length; i++){
            array[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(array, (x, y)-> (y + x).compareTo((x+y)));
        if(array[0].equals("0")){
            return "0";
        }
        StringBuilder s = new StringBuilder();
        for (String s1 : array) {
            s.append(s1);
        }
        return s.toString();
    }

    private int partition(int[] nums, int startIndex, int endIndex){
        int pivot = nums[startIndex];
        int left = startIndex;
        int right = endIndex;
        while (right != left){
            while (right > left){
                if(nums[right] < pivot){
                    nums[left] = nums[right];
                    left++;
                    break;
                }
                right--;
            }
            while (right > left){
                if(nums[left] > pivot){
                    nums[right] = nums[left];
                    right--;
                    break;
                }
                left++;
            }
        }
        nums[left] = pivot;
        return left;
    }
    // 快排
    public void quickSort(int[] nums, int startIndex, int endIndex){
        if (startIndex >= endIndex){
            return;
        }
        int part = partition(nums, startIndex, endIndex);
        quickSort(nums, startIndex, part - 1);
        quickSort(nums, part + 1, endIndex);
    }

    public static void main(String[] args){
        Sort o = new Sort();
        int[] nums = {4,7,6,5,3,2,8,1};
        o.quickSort(nums, 0, nums.length-1);
        for (int num : nums) {
            System.out.print(num);
        }
    }
}
