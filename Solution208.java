// Leetcode 208: Implement Trie (Prefix Tree)
import java.util.*;

class Trie {
    class TrieNode {
        char c;
        Map<Character, TrieNode> children;
        boolean isWord;
        
        public TrieNode() {
            children = new HashMap();
            isWord = false;
        }
        
        public TrieNode(char in) {
            c = in;
            children = new HashMap();
            isWord = false;
        }
    }

    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!cur.children.containsKey(c)) {
                cur.children.put(c, new TrieNode(c));
            }
            cur = cur.children.get(c);
            if (i == word.length()-1) {
                cur.isWord = true;
            }
        }
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!cur.children.containsKey(c)) {
                return false;
            }
            cur = cur.children.get(c);
            if (i == word.length()-1) {
                return cur.isWord;
            }
        }
        return false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (char c : prefix.toCharArray()) {
            if (!cur.children.containsKey(c)) {
                return false;
            }
            cur = cur.children.get(c);
        }
        return true;
    }
}