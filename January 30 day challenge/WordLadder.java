import java.util.*;
class WordNode {
    int level;
    String word;

    WordNode(int val, String text) {
        level = val;
        word = text;
    }
}
class WordLadder {
    public boolean onlyOneCharDiff(String word1, String word2) {
        int cnt = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i))
                cnt++;
        }
        return cnt == 1;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord))
            return 0;
        int minAns = Integer.MAX_VALUE;
        int n = wordList.size();
        Queue<WordNode> words = new LinkedList<>();
        words.add(new WordNode(0, beginWord));
        HashSet<Integer>notVisited = new HashSet<>();
        for(int i = 0; i < n; i++)
            notVisited.add(i);
        for (int i = 0; i < n; i++) {
            if (wordList.get(i).equals(beginWord))
                notVisited.remove(i);
        }
        while (!words.isEmpty()) {
            WordNode node = words.poll();
            int level = node.level;
            ArrayList<Integer>temp = new ArrayList<>();
            for (int i : notVisited) {
                String currWord = wordList.get(i);
                if (onlyOneCharDiff(node.word, currWord)) {
                    if (currWord.equals(endWord)) {
                        minAns = Math.min(minAns, level + 1);
                    }
                    temp.add(i);
                    words.add(new WordNode(level + 1, currWord));
                }
            }
            for(int i : temp)
                notVisited.remove(i);
        }
        if(minAns == Integer.MAX_VALUE)
            return 0;
        return minAns+1;
    }
}