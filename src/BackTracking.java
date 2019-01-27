import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BackTracking {
    public List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList<>();
        upperLetter(S, result, new StringBuilder(),0);
        return result;
    }
    private void upperLetter(String s, List<String> list, StringBuilder sb, int index){
        if (index == s.length()){
            list.add(sb.toString());
            return;
        }
        char c = s.charAt(index);
        if(Character.isDigit(c)){
            sb.append(c);
            upperLetter(s, list, sb,index + 1 );
            sb.deleteCharAt(sb.length()-1);
        }
        if(((c <= 'z') && (c >= 'a'))|| ((c <= 'Z') && (c>= 'A'))){
            sb.append(Character.toLowerCase(c));
            upperLetter(s, list, sb,index + 1);
            sb.deleteCharAt(sb.length()-1);

            sb.append(Character.toUpperCase(c));
            upperLetter(s, list, sb,index + 1);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    private void BinaryHourRank(List<Integer> list, int count, int index, int[] nums, List<Integer> tempList){
        if(count == 0 && index <= nums.length) {
            int sum = 0;
            for (int i = 0; i < tempList.size(); i++) {
                sum += tempList.get(i);
            }
            if (sum < 12)
                list.add(sum);
            return;
        }else if(count > nums.length - index || index == nums.length){
            return;
        }else {
           tempList.add(nums[index]);
           BinaryHourRank(list, count - 1, index + 1, nums, tempList);
           tempList.remove(tempList.indexOf(nums[index]));
           BinaryHourRank(list, count, index + 1, nums, tempList);
        }
    }

    private void BinaryMinutRank(List<String> list, int count, int index, int[] nums, List<Integer> tempList){
        if(count == 0 && index <= nums.length){
            int sum = 0;
            for (int i = 0; i < tempList.size(); i++) {
                    sum += tempList.get(i);
            }
            if (sum <= 59){
                if (sum < 10){
                    list.add(String.format("0%d", sum));
                }else
                    list.add(String.valueOf(sum));
            }
            return;
        }else if(count > nums.length - index || index == nums.length){
            return;
        }else {
            tempList.add(nums[index]);
            BinaryMinutRank(list, count-1, index+1, nums, tempList);
            tempList.remove(tempList.indexOf(nums[index]));
            BinaryMinutRank(list, count, index+1, nums, tempList);
        }
    }
    private void BinaryTimeRank(List<Integer> list, int count, int index, int[] nums){
        if(count == 0 && index <= nums.length){
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                if (record[i] == 1) {
                    sum += nums[i];
                }
            }
            if (sum < 12)
                list.add(sum);
            return;
        }else if(count > nums.length - index || index == nums.length){
            return;
        }else {
            record[index] = 1;
            BinaryTimeRank(list, count-1, index+1, nums);
            record[index] = 0;
            BinaryTimeRank(list, count, index+1, nums);
        }
    }
    private void BinaryMinuteRank(List<String> list, int count, int index, int[] nums){
        if(count == 0 && index <= nums.length){
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                if (recordm[i] == 1) {
                    sum += nums[i];
                }
            }
            if (sum <= 59){
                if (sum < 10){
                    list.add(String.format("0%d", sum));
                }else
                    list.add(String.valueOf(sum));
            }
            return;
        }else if(count > nums.length - index || index == nums.length){
            return;
        }else {
            recordm[index] = 1;
            BinaryMinuteRank(list, count-1, index+1, nums);
            recordm[index] = 0;
            BinaryMinuteRank(list, count, index+1, nums);
        }
    }
    public List<String> readBinaryWatch(int num) {

        int[] hours = {1,2,4,8};
        int[] minuts = {1,2,4,8,16,32};
        List<String> result = new ArrayList<>();
        for (int i = 0; i <= num; i++){
            List<Integer> hourList = new ArrayList<>();
            List<Integer> tempList = new ArrayList<>();
            List<String> minuteList = new ArrayList<>();
            BinaryHourRank(hourList, i, 0, hours, tempList);
            BinaryMinutRank(minuteList, num - i, 0, minuts, tempList);
            for(Integer h: hourList){
                for(String m: minuteList){
                    result.add(String.format("%d:%s", h, m));
                }
            }
        }
        return result;
    }
    private static int[] record;
    private static int[] recordm;
    public void back(int k,int m,int[] array) {
        if (m == 0 && k <= array.length) {
            for (int i = 0; i < array.length; i++) {
                if (record[i] == 1) {
                    System.out.print(array[i] + " ");
                    //record[i] = 0;
                }
            }
            System.out.println();
            return;
        } else if (m > array.length - k || k == array.length) {
            return;
        } else {
            record[k] = 1;
            back(k + 1, m - 1, array);
            record[k] = 0;
            back(k + 1, m, array);
        }
    }


    public  void parentheses(String sublist, ArrayList<String> results, int leftnum, int rightnum){
        if(leftnum==0&&rightnum==0)//结束
            results.add(sublist);
        if(rightnum>leftnum)//选择和条件。对于不同的if顺序，输出的结果顺序是不一样的，但是构成一样的解空间
            parentheses(sublist+")", results, leftnum, rightnum-1);
        if(leftnum>0)
            parentheses(sublist+"(", results, leftnum-1, rightnum);
    }

    public  void pailie(String s, String temp){//参数设计地尽量地简洁
        if(s.length()==0){
            System.out.println(temp);
            return;
        }
        for(int i=0;i<s.length();i++){
            String news=s.substring(0, i)+s.substring(i+1,s.length());//去掉String中的某个字母
            pailie(news, temp+s.charAt(i));
        }
    }

    private void letterCombinaRank(List<String> letters, String digits, int index, List<String> result, StringBuilder temp){
        if(index == digits.length()){
            result.add(temp.toString());
            return ;
        };
        int n = Integer.parseInt(String.valueOf(digits.charAt(index)));
        for (int i = 0; i<letters.get(n).length(); i++){
            letterCombinaRank(letters, digits, index+1, result, temp.append(letters.get(n).charAt(i)));
            temp.deleteCharAt(temp.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String > result = new ArrayList<>();
        if (digits.length() == 0)
            return result;
        List<String> letters = new ArrayList<>();
        letters.add("");
        letters.add("");
        letters.add("abc");
        letters.add("def");
        letters.add("ghi");
        letters.add("jkl");
        letters.add("mno");
        letters.add("pqrs");
        letters.add("tuv");
        letters.add("wxyz");
        letterCombinaRank(letters, digits, 0, result, new StringBuilder());
        return result;
    }

    public boolean isExist(List<Integer> num, List<List<Integer>> lists){
        for (int i = 0; i < lists.size(); i++){
            if (lists.get(i).equals(num)){
                return true;
            }
        }
        return false;
    }

    private void permuteRank(List<Integer> nums, List<Integer> temp, List<List<Integer>> result){
        if(nums.size() == 0){
            if(isExist(temp, result)){
                return;
            }
            List<Integer> l = new ArrayList<>();
            l.addAll(temp);
            result.add(l);
            return;
        }
        for(int i = 0; i < nums.size(); i++){
            temp.add(nums.get(i));
            List<Integer> newNum = new ArrayList<>();
            newNum.addAll(nums);
            newNum.remove(i);
            permuteRank(newNum, temp, result);
            temp.remove(temp.size() - 1);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        List<Integer> num = new ArrayList<>();
        for(int i = 0; i< nums.length; i++){
            num.add(nums[i]);
        }
        permuteRank(num, temp, result);
        return result;
    }

    public static void main(String[] args){
        BackTracking o = new BackTracking();
        int[] nums = {1,1,3};
//        o.back(0, 2,nums);//两个方法都可以

//       System.out.println( o.letterCasePermutation("1ab2"));
//        o.pailie("ab", "");
        System.out.println(o.permute(nums));
    }
}
