import java.io.*;
import java.util.*;
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer>stack = new Stack<>();
        for(String i : tokens){
            char ch = i.charAt(i.length()-1);
            if(Character.isDigit(ch))
                stack.add(Integer.parseInt(i));
            else{
                int a = stack.pop(), b = stack.pop();
                int val = 0;
                switch(ch){
                    case '+':
                        val = a+b;
                        break;
                    case '-':
                        val = b-a;
                        break;
                    case '/':
                        val = b/a;
                        break;
                    case '*':
                        val = a*b;
                }
                stack.add(val);
            }
        }
        return stack.pop();
    }
}
