import java.io.*;
import java.util.*;

public class WordBreak2 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);
        int n = s.length();
        int[] possible = new int[n];
        ArrayList<ArrayList<String>> possibleResults = new ArrayList<>();
        for (int pos = 0; pos < n; pos++) {
            ArrayList<String> temp = new ArrayList<>();
            possibleResults.add(temp);
        }
        for (int endPos = 0; endPos < n; endPos++) {
            for (int startPos = endPos; startPos >= 0; startPos--) {
                if (words.contains(s.substring(startPos, endPos + 1))) {
                    if (startPos == 0)
                        possible[endPos] = Math.max(1, possible[endPos]);
                    else
                        possible[endPos] = Math.max(possible[endPos], possible[startPos - 1]);
                }
            }
        }
        if (possible[possible.length - 1] == 0) return new ArrayList<>();
        for (int endPos = 0; endPos < n; endPos++) {
            for (int startPos = endPos; startPos >= 0; startPos--) {
                String temp = s.substring(startPos, endPos + 1);
                if (words.contains(temp)) {
                    if (startPos == 0) {
                        possibleResults.get(endPos).add(temp);
                    } else {
                        for (String text : possibleResults.get(startPos - 1)) {
                            possibleResults.get(endPos).add(text + " " + temp);
                        }
                    }
                }
            }
        }
        return possibleResults.get(possibleResults.size() - 1);
    }

    public static void main(String[] args) {
        String[] inp = {"cat", "cats", "and", "sand", "dog"};
        ArrayList<String> temp = new ArrayList<>();
        for (String w : inp) {
            temp.add(w);
        }
        String word = "catsanddog";
        new WordBreak2().wordBreak(word, temp);
    }
}
