import java.util.HashMap;
import java.util.Stack;

public class ValidBracket {

    private boolean isPair(char c1, char c2){
        return (c1 == '(' && c2 == ')') || (c1 == '[' && c2 == ']') || (c1 == '{' && c2 == '}') ;
    };


    public boolean isValid(String s) {
        Stack stack = new Stack();
        for (int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
                stack.push(s.charAt(i));
            }else if( !stack.empty() && isPair(stack.peek().toString().charAt(0), s.charAt(i)) ){
                stack.pop();
            }else {
                return false;
            }
        }
        return  stack.empty();
    }

    //Official
    private HashMap<Character, Character> mapping;

    public ValidBracket(){
        this.mapping = new HashMap<Character, Character>();
        this.mapping.put(')', '(');
        this.mapping.put(']', '[');
        this.mapping.put('}', '{');
    }

    public boolean isValidOfficial(String s){
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if(this.mapping.containsKey(c)){
                char topElement = stack.empty() ? '#' : stack.pop();
                if (topElement != this.mapping.get(c)){
                    return false;
                }
            }else {
                stack.push(c);
            }
        }
        return  stack.empty();
    }

    public static void main(String[] args){
        String s = "()}]";
        ValidBracket o = new ValidBracket();
        System.out.println(o.isValid(s));
    }
}
