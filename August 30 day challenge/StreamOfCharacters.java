import java.util.*;
class StreamChecker {
    Trie trie;
    String queries;
    public StreamChecker(String[] words) {
        queries = "";
        trie = new Trie();
        for (String word:words) {
            trie.addWord(new StringBuilder().append(word).reverse().toString());
        }
    }
    public boolean query(char letter) {
        queries += letter;
        return trie.findWord(queries);
    }
    class TrieNode {
        char ch;
        HashMap<Character, TrieNode> children;
        boolean endWord ;

        public TrieNode(char ch){
            this.ch = ch;
            this.children =new HashMap<>();
            this.endWord = false;
        }
    }

    class Trie {
        TrieNode root;
        public Trie() {
            root = new TrieNode('*');
        }

        public void addWord(String word) {
            TrieNode dupRoot = root;
            for (int pos = 0; pos < word.length(); pos++) {
                char ch = word.charAt(pos);
                if (dupRoot.children.containsKey(ch))
                    dupRoot = dupRoot.children.get(ch);
                else {
                    dupRoot.children.put(ch, new TrieNode(ch));
                    dupRoot = dupRoot.children.get(ch);
                }
            }
            dupRoot.endWord = true;
        }

        public boolean findWord(String word) {
            TrieNode dupRoot = root;
            for (int pos = word.length()-1; pos >= 0; pos--) {
                char ch = word.charAt(pos);
                if (dupRoot.children.containsKey(ch)) {
                    if (dupRoot.children.get(ch).endWord)
                        return true;
                    dupRoot = dupRoot.children.get(ch);
                }
                else
                    break;
            }
            return false;
        }

    }
}
class StreamOfCharacter{
    public static void main(String[] args) {
        StreamChecker sc = new StreamChecker(new String[]{"ab","ba","aaab","abab","baa"});
        char [] chars = {'a','a','a','a','a','b','a','b','a','b','b','b','a','b','a','b','b','b','b','a','b','a','b','a','a','a','b','a','a','a'};
        for (char ch:chars)
        {
            System.out.println(sc.query(ch));
        }
    }
}