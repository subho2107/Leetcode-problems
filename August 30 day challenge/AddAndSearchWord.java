import javax.swing.tree.TreeNode;
import java.util.HashMap;

class TrieNode
{
    char value;
    boolean end;
    HashMap<Character, TrieNode> children;
    TrieNode(char ch)
    {
        this.value = ch;
        this.children = new HashMap<>();
        this.end=false;
    }
}
class Trie {

    /** Initialize your data structure here. */
    TrieNode head;
    public Trie() {
        this.head = new TrieNode('*');
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode current = this.head;
        for (int pos = 0; pos < word.length(); pos++) {
            char ch = word.charAt(pos);
            if (!current.children.containsKey(ch))
            {
                current.children.put(ch,new TrieNode(ch));
            }
            current = current.children.get(ch);
        }
        current.end = true;
    }
    public boolean dfs(TrieNode node, int pos, String word){
        if(pos == word.length()) return node.end;

        if( word.charAt(pos) == '.')
            for(char child :node.children.keySet()) {
                if(dfs(node.children.get(child), pos + 1, word) )return true;
            }

        if(node.children.containsKey(word.charAt(pos)))
            return dfs(node.children.get(word.charAt(pos)), pos+1, word);

        return false;
    }
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return dfs(this.head, 0, word);
    }
    public boolean startsWith(String prefix) {
        boolean exists = true;
        TrieNode current = this.head;
        for (int pos = 0; pos < prefix.length(); pos++) {
            char ch = prefix.charAt(pos);
            if (!current.children.containsKey(ch))
            {
                exists = false;
                break;
            }
            current = current.children.get(ch);
        }

        return exists;
    }
}
class WordDictionary {

    /** Initialize your data structure here. */
    Trie trie;
    public WordDictionary() {
        trie = new Trie();
    }
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        trie.insert(word);
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return trie.search(word);
    }
}
public class AddAndSearchWord{
    public static void main(String[] args) {
        WordDictionary obj = new WordDictionary();
        obj.addWord("a");
        obj.addWord("ab");
        System.out.println(obj.search("a."));
        System.out.println(obj.search(".a"));
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */