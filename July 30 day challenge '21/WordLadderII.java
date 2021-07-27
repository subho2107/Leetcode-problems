import java.io.*;
import java.util.*;

public class WordLadderII {
    Map<String, List<String>>graph;
    List<String>currPath;
    List<List<String>>ans;
    public List<String> getNeighbours(String word, Set<String>wordList){
        List<String>neighbours = new ArrayList<>();
        char[] arr = word.toCharArray();
        for(int i = 0; i < arr.length; i++){
            char orgChar = arr[i];
            for(char ch = 'a'; ch <= 'z'; ch++){
                arr[i] = ch;
                String modifiedString = String.valueOf(arr);
                if(ch == orgChar || !(wordList.contains(modifiedString)))
                    continue;
                neighbours.add(modifiedString);
            }
            arr[i] = orgChar;
        }
        return neighbours;
    }
    public void buildGraph(String beginWord, String endWord, HashSet<String>words){
        Queue<String>queue = new LinkedList<>();
        HashSet<String>visited = new HashSet<>();
        if(words.contains(beginWord))
            words.remove(beginWord);
        visited.add(beginWord);
        queue.add(beginWord);
        while(queue.size() != 0){
            List<String>currLevel = new ArrayList<>();
            for(int i = queue.size()-1; i >= 0; i--){
                String currWord = queue.poll();
                if(!graph.containsKey(currWord))
                    graph.put(currWord, new ArrayList<>());
                List<String>neighbours = getNeighbours(currWord, words);
                for(String neighbour : neighbours){
                    currLevel.add(neighbour);
                    graph.get(currWord).add(neighbour);
                    if(!visited.contains(neighbour)){
                        queue.add(neighbour);
                        visited.add(neighbour);
                    }
                }
            }
            for(String word : currLevel)
            {
                if(words.contains(word))
                    words.remove(word);
            }
        }
    }
    public void generatePaths(String currWord, String endWord){
        if(currWord.equals(endWord)){
            ans.add(new ArrayList<>(currPath));
            return;
        }
        if(!graph.containsKey(currWord))
            return;
        for(String neighbour : graph.get(currWord)){
            currPath.add(neighbour);
            generatePaths(neighbour, endWord);
            currPath.remove(currPath.size()-1);
        }
    }
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        ans = new ArrayList<>();
        currPath = new ArrayList<>();
        currPath.add(beginWord);
        graph = new HashMap<>();
        HashSet<String>present = new HashSet<>(wordList);
        buildGraph(beginWord, endWord, present);
        generatePaths(beginWord, endWord);
        return ans;
    }
}
