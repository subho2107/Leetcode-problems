import java.io.*;
import java.util.*;

public class BasicCalculatorII {
    public int getPrecedence(char op) {
        if (op == '*' || op == '/')
            return 2;
        else
            return 1;
    }

    public int calc(int a, int b, char operator) {
        if (operator == '-')
            return a - b;
        else if (operator == '+')
            return a + b;
        else if (operator == '*')
            return a * b;
        else
            return (int) Math.floor(a / b);
    }

    public int calculate(String s) {
        Stack<Integer> values = new Stack<>();
        Stack<Character> operator = new Stack<>();
        String temp = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ')
                continue;
            if (Character.isDigit(ch))
                temp += ch;
            else {
                values.add(Integer.parseInt(temp));
                temp = "";
                int tempPrecedence = getPrecedence(ch);
                while (!operator.isEmpty() && getPrecedence(operator.peek()) >= tempPrecedence) {
                    int a = values.pop(), b = values.pop();
                    char currOperator = operator.pop();
                    int val = calc(b, a, currOperator);
                    values.push(val);
                }
                operator.push(ch);
            }
        }
        if (temp.length() != 0)
            values.add(Integer.parseInt(temp));
        while (!operator.isEmpty()) {
            int a = values.pop(), b = values.pop();
            char currOperator = operator.pop();
            int val = calc(b, a, currOperator);
            values.push(val);
        }
        return values.pop();
    }

    public static void main(String[] args) throws Exception {
        String s = " 3/2 ";
        System.out.println(new BasicCalculatorII().calculate(s));
    }
}
