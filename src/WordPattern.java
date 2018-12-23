import java.util.HashMap;
import java.util.HashSet;

public class WordPattern {

    public boolean wordPattern(String pattern, String str) {
        String[] strArry = str.split(" ");
        if(strArry.length != pattern.length()){
            return false;
        }
        HashMap<Character, String> hashMap = new HashMap<Character, String>();
        for(int i = 0; i < pattern.length(); i++){
            if(!hashMap.containsKey(pattern.charAt(i))){
                if(hashMap.containsValue(strArry[i])){
                    return false;
                }
                hashMap.put(pattern.charAt(i), strArry[i]);
            }else if(!hashMap.get(pattern.charAt(i)).equals(strArry[i])){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        WordPattern o = new WordPattern();
        System.out.println(o.wordPattern("abba", "dog dog dog dog"));
    }
}
