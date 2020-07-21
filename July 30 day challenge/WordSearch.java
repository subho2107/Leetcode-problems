import java.io.*;
import java.util.*;
class TrieNode
{
    char value;
    boolean end;
    HashMap<Character, TrieNode>children;
    String word;
    TrieNode(char ch)
    {
        this.value = ch;
        this.children = new HashMap<>();
        this.end=false;
        this.word = null;
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
                current.children.put(ch,new TrieNode(ch));
            current = current.children.get(ch);
        }
        current.end = true;
        current.word = word;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        boolean exists = true;
        TrieNode current = this.head;
        for (int pos = 0; pos < word.length(); pos++) {
            char ch = word.charAt(pos);
            if (!current.children.containsKey(ch))
            {
                exists = false;
                break;
            }
            current = current.children.get(ch);
        }
        if (!exists)
            return false;
        else
            return current.end;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
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
class WordSearch {
    public boolean exist(char[][] board, String word) {
        Trie trie = new Trie();
        trie.insert(word);
        for (int rowPos = 0; rowPos < board.length; rowPos++) {
            for (int colPos = 0; colPos < board[0].length; colPos++) {
                if (dfs(board, rowPos, colPos, trie.head)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int rowPos, int colPos, TrieNode trie) {
        char ch = board[rowPos][colPos];
        if (ch == '*' || !trie.children.containsKey(ch)) return false;
        trie = trie.children.get(ch);
        if (trie.end) {
            return true;
        }
        board[rowPos][colPos] = '*';
        if (colPos > 0 && dfs(board, rowPos, colPos - 1, trie))return true;
        if (rowPos > 0 && dfs(board, rowPos - 1, colPos, trie)) return true;
        if (colPos < board[0].length - 1 && dfs(board, rowPos, colPos + 1, trie))return true;
        if (rowPos < board.length - 1 &&  dfs(board, rowPos + 1, colPos, trie)) return true;
        board[rowPos][colPos] = ch;
        return false;
    }
}
