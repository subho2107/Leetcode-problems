import java.io.*;
import java.util.*;

public class LetterCombinationsOfAPhoneNumber {
    List<String>ans;
    public void backtrack(List<String> list, int pos, String temp){
        if(pos > list.size()-1){
            if(temp.length() > 0)
                ans.add(temp);
            return;
        }
        for(char ch : list.get(pos).toCharArray()){
            backtrack(list, pos+1, temp+ch);
        }
    }
    public List<String> letterCombinations(String digits) {
        ans  = new ArrayList<>();
        HashMap<Character, String>map = new HashMap<>();
        map.put('2', "abc");map.put('3', "def");
        map.put('4', "ghi");map.put('5', "jkl");map.put('6', "mno");
        map.put('7', "pqrs");map.put('8', "tuv");map.put('9', "wxyz");
        List<String>list = new ArrayList<>();
        for(char ch : digits.toCharArray())
            list.add(map.get(ch));
        backtrack(list, 0, "");
        return ans;
    }
}
