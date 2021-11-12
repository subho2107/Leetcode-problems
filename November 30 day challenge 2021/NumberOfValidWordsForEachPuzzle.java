import java.io.*;
import java.util.*;

public class NumberOfValidWordsForEachPuzzle {
    private int getBitmask(String word){
        int bitmask = 0;
        for(char ch : word.toCharArray())
            bitmask |= 1<<(ch-'a');
        return bitmask;
    }
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        Map<Integer, Integer>wordCnt = new HashMap<>();
        for(String word : words){
            int mask = getBitmask(word);
            wordCnt.put(mask, wordCnt.getOrDefault(mask, 0)+1);
        }
        List<Integer>ans = new ArrayList<>();
        for(String puzzle : puzzles){
            int currAns = 0;
            int firstMask = getBitmask(puzzle.charAt(0)+"");
            currAns += wordCnt.getOrDefault(firstMask, 0);
            int mask = getBitmask(puzzle.substring(1));
            for(int submask = mask; submask > 0; submask = (submask - 1)&mask){
                currAns += wordCnt.getOrDefault(submask | firstMask, 0);
            }
            ans.add(currAns);
        }
        return ans;
    }
}
