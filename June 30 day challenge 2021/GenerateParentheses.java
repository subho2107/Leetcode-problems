import java.util.*;

public class GenerateParentheses {
    char [] arr;
    List<String>ans;
    public void formParenthesesCombination(int i, int openBracket, int closeBracket){
        if(i == arr.length){
            Stack<Character>stack = new Stack<>();
            for(char ch : arr){
                if(stack.isEmpty())
                    stack.push(ch);
                else if(ch == ')' && stack.peek() == '(')
                    stack.pop();
                else
                    stack.push(ch);
            }
            if(stack.size() == 0){
                ans.add(String.valueOf(arr));
            }
            return;
        }
        if(openBracket >= 0){
            arr[i] = '(';
            formParenthesesCombination(i+1, openBracket-1, closeBracket);
        }
        if(closeBracket >= 0){
            arr[i] = ')';
            formParenthesesCombination(i+1, openBracket, closeBracket - 1);
        }
    }
    public List<String> generateParenthesis(int n) {
        arr = new char[n*2];
        ans = new ArrayList<>();
        formParenthesesCombination(0, n, n);
        return ans;
    }
}
