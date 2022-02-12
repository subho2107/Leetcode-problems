import java.io.*;
import java.util.*;
public class WordLadderFeb22 {
    private boolean differsByOneChar(String s1, String s2){
        int pos = 0, n = s1.length();
        for(int i = 0; i < n; i++){
            char ch1 = s1.charAt(i), ch2 = s2.charAt(i);
            if(ch1 != ch2){
                pos++;
                if(pos > 1)
                    return false;
            }
        }
        return true;
    }
    private boolean foundInCurrChild(String curr, Queue<String>queue, Set<String>prevUsed, List<String>wordList, String endWord){
        for(String s : wordList){
            if(!prevUsed.contains(s) && differsByOneChar(s, curr)){
                if(s.equals(endWord)){
                    return true;
                }
                prevUsed.add(s);
                queue.add(s);
            }
        }
        return false;
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord))
            return 0;
        if(beginWord.equals(endWord))
            return 1;
        Queue<String>queue = new LinkedList<>();
        Set<String>prevUsed = new HashSet<>();
        queue.add(beginWord);
        int ans = 1;
        boolean check = false;
        while(!queue.isEmpty()){
            for(int i = queue.size(); i > 0; i--){
                String curr = queue.poll();
                if(foundInCurrChild(curr, queue, prevUsed, wordList, endWord)){
                    check = true;
                    break;
                }
            }
            ans++;
            if(check)
                break;
        }
        return check ?ans:0;
    }
}
