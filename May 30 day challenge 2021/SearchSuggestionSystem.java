import java.io.*;
import java.util.*;

public class SearchSuggestionSystem {
    class TrieNode {
        char val;
        TreeMap<Character, TrieNode> children;
        boolean isWord;

        TrieNode(char ch) {
            val = ch;
            children = new TreeMap<>();
            isWord = false;
        }
    }

    List<String> list;

    public void dfs(TrieNode currNode, String word) {
        if (list.size() == 3)
            return;
        if (currNode.isWord)
            list.add(word);
        for (char child : currNode.children.keySet()) {
            dfs(currNode.children.get(child), word + child);
        }
    }
    //using trie
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        TrieNode root = new TrieNode('*');
        for (String product : products) {
            TrieNode dup = root;
            for (char ch : product.toCharArray()) {
                if (!dup.children.containsKey(ch))
                    dup.children.put(ch, new TrieNode(ch));
                dup = dup.children.get(ch);
            }
            dup.isWord = true;
        }
        List<List<String>> ans = new ArrayList<>();
        String prefix = "";
        for (char ch : searchWord.toCharArray()) {
            prefix += ch;
            TrieNode dup = root;
            for (char ch2 : prefix.toCharArray()) {
                if (!dup.children.containsKey(ch2))
                    dup.children.put(ch2, new TrieNode(ch2));
                dup = dup.children.get(ch2);
            }
            list = new ArrayList<>();
            dfs(dup, prefix);
            ans.add(list);
        }
        return ans;
    }
    //binary search method
    public List<List<String>> suggestedProducts2(String[] products, String searchWord) {
        Arrays.sort(products, (o1, o2)->{
            return o1.compareTo(o2);
        });
        int n = products.length;
        List<List<String>>ans = new ArrayList<>();
        List<String>temp;
        String prefix = "";
        int low = 0;
        for(char ch : searchWord.toCharArray()){
            prefix += ch;
            temp = new ArrayList<>();
            int high = n-1, m = prefix.length(), mid=0;
            while(low <= high){
                mid = (low+high)/2;
                String curr = products[mid];
                if(curr.compareTo(prefix) < 0)
                    low = mid+1;
                else
                    high = mid-1;
            }
            int pos = low, max = Math.min(pos+3, n);
            if(pos < n && products[pos].startsWith(prefix)){
                while(pos < max && products[pos].startsWith(prefix))
                {
                    if (products[pos].length() < m || !products[pos].substring(0, m).equals(prefix))
                        break;
                    temp.add(products[pos]);
                    pos++;
                }
            }
            ans.add(temp);
        }
        return ans;
    }
}
