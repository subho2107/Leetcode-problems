import java.io.*;
import java.util.*;

public class MinimumRemoveToMakeValidParentheses {
    public String minRemoveToMakeValid(String s) {
        Stack<Character>stack = new Stack<>();
        Stack<Integer>stackPos = new Stack<>();
        int i = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isAlphabetic(ch)) {
                i++;
                continue;
            }
            if (stack.isEmpty()) {
                stack.add(ch);
                stackPos.add(i);
            }
            else if (stack.peek() == '(' && ch == ')') {
                stack.pop();stackPos.pop();
            }
            else {
                stack.push(ch);
                stackPos.push(i);
            }
            i++;
        }
        HashSet<Integer>hashSet = new HashSet<>();
        for (int stackPo : stackPos) {
            hashSet.add(stackPo);
        }
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < s.length(); j++) {
            char ch = s.charAt(j);
            if (Character.isAlphabetic(ch))
                sb.append(ch);
            else if (!hashSet.contains(j))
                sb.append(ch);
        }
        return sb.toString();
    }
}
