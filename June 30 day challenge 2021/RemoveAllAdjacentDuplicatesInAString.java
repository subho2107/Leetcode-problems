import java.io.*;
import java.util.*;

public class RemoveAllAdjacentDuplicatesInAString {
    public String removeDuplicates(String s) {
        Stack<Character>stack = new Stack<>();
        for(char ch : s.toCharArray()){
            if(stack.isEmpty())
                stack.add(ch);
            else if(stack.peek() == ch)
                stack.pop();
            else
                stack.push(ch);
        }
        StringBuffer sb = new StringBuffer();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        sb.reverse();
        return sb.toString();
    }
}
