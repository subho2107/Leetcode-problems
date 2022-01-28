import java.io.*;
import java.util.*;

class DesignAddAndSearchWordsDataStructure1 {
    class TrieNode{
        Map<Character, TrieNode>children;
        boolean word;
        TrieNode(){
            children = new HashMap<>();
            word = false;
        }
    }
    class WordDictionary {
        TrieNode root;
        public WordDictionary() {
            root = new TrieNode();
        }

        public void addWord(String word) {
            TrieNode dupRoot = root;
            for(char ch : word.toCharArray()){
                if(!dupRoot.children.containsKey(ch))
                    dupRoot.children.put(ch, new TrieNode());
                dupRoot = dupRoot.children.get(ch);
            }
            dupRoot.word = true;
        }

        public boolean search(String word) {
            TrieNode dupRoot = root, orgRoot = root;
            for(int i = 0; i < word.length(); i++){
                char ch = word.charAt(i);
                if(ch != '.' && !dupRoot.children.containsKey(ch))
                    return false;
                if(ch == '.'){
                    boolean check = false;
                    String newWord = word.substring(i+1);
                    for(char child : dupRoot.children.keySet()){
                        root = dupRoot;
                        if(search(child+newWord)){
                            check = true;
                            break;
                        }
                    }
                    root = orgRoot;
                    return check;
                }
                dupRoot = dupRoot.children.get(ch);
            }
            return dupRoot.word;
        }
    }
}
class DesignAddAndSearchWordsDataStructure2{
    class TrieNode{
        Map<Character, TrieNode>children;
        boolean word;
        char ch;
        TrieNode(char ch){
            children = new HashMap<>();
            word = false;
            this.ch = ch;
        }
    }
    class Trie{
        TrieNode root;
        Trie(){
            root = new TrieNode('*');
        }
        public void addWord(String word) {
            TrieNode currNode = root;
            for(char ch : word.toCharArray()){
                if(!currNode.children.containsKey(ch))
                    currNode.children.put(ch, new TrieNode(ch));
                currNode = currNode.children.get(ch);
            }
            currNode.word = true;
        }
        public boolean dfs(TrieNode node, int pos, String word){
            if(pos == word.length())
                return node.word;
            char ch = word.charAt(pos);
            if(ch == '.'){
                for(char child : node.children.keySet()){
                    if(dfs(node.children.get(child), pos+1, word))
                        return true;
                }
            }
            if(node.children.containsKey(ch))
                return dfs(node.children.get(ch), pos+1, word);
            return false;
        }
        public boolean search(String word){
            return dfs(root, 0, word);
        }
    }
    class WordDictionary {
        Trie trie;
        public WordDictionary() {
            trie = new Trie();
        }

        public void addWord(String word) {
            trie.addWord(word);
        }

        public boolean search(String word) {
            return trie.search(word);
        }
    }
}