
import java.util.Arrays;
import java.util.Stack;


public class LCString {
    public String reverseWords(String s) {
        Stack<String> t = new Stack<>();
        String sTemp = "";
        for(int i = 0; i<s.length();i++){
            if(!Character.isSpaceChar(s.charAt(i))){
                sTemp = sTemp + Character.toString(s.charAt(i));
            }else if(sTemp != ""){
                t.push(sTemp);
                sTemp = "";
            }
        }
        if (sTemp != ""){
            t.push(sTemp);
        }
        String result = "";
        while (!t.empty()){
            result = result  + t.pop() + " ";
        }
        if(result != "") {
            return result.substring(0, result.length() - 1);
        }else{
            return result;
        }
    }


    public boolean isUnique(String astr) {
        char[] chars = astr.toCharArray();
        Arrays.sort(chars);
        for(int i = 0; i<chars.length-1; i++){
             if((chars[i] ^ chars[i+1]) == 0){
                 return false;
             }
        }
        return true;
    }

    public static void main(String[] args){
        String s = "kzwunahkiz";
        LCString o = new LCString();

        System.out.println(o.isUnique(s));
    }
}

