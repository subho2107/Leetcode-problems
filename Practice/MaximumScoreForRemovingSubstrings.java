import java.io.*;
import java.util.*;

public class MaximumScoreForRemovingSubstrings {
    public int maximumGain(String s, int x, int y) {
        Stack<Character>stack = new Stack<>(), stack2 = new Stack<>();
        int val = 0, max = Math.max(x, y), min = Math.min(x, y);
        char first = x > y ? 'a' : 'b', second = x > y ? 'b': 'a';
        for(char ch : s.toCharArray()){
            if(!stack.isEmpty() && stack.peek() == first && ch == second){
                val += max;
                stack.pop();
            }
            else
                stack.push(ch);
        }
        while(!stack.isEmpty()){
            char ch = stack.pop();
            if(!stack2.isEmpty() && stack2.peek() == first && ch == second){
                val += min;
                stack2.pop();
            }
            else
                stack2.push(ch);
        }
        return val;

    }
}
