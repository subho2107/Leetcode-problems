import java.io.*;
import java.util.*;

public class ValidParantheses {
    public boolean shouldPop(char ch , char ch2){
        return (ch == '(' && ch2 == ')')||(ch == '[' && ch2 == ']')||(ch == '{' && ch2 == '}');
    }
    public boolean isValid(String s) {
        Stack<Character>stack = new Stack<>();
        for(char ch : s.toCharArray()){
            if(stack.isEmpty())
                stack.push(ch);
            else{
                if(shouldPop(stack.peek(), ch))
                    stack.pop();
                else
                    stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
