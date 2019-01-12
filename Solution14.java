// Leetcode 14: Longest Common Prefix

// Method 1: Brute force
// TC:O(S), SC:O(1)
// class Solution {
//     public String longestCommonPrefix(String[] strs) {
//         // Method 1: Brute force
//         StringBuilder result = new StringBuilder();
//         if (strs.length == 0 || strs.length == 1)   return strs.length == 0?"":strs[0];
//         int minlen = findMinLength(strs);
//         for (int i = 0; i < minlen; i++) {
//             boolean same = true;
//             char cur = strs[0].charAt(i);
//             for (int j = 1; j < strs.length; j++) {
//                 if (strs[j].charAt(i) != cur)   same = false;
//             }
//             if (same) {
//                 result.append(cur);
//             } else {
//                 return result.toString();
//             }
//         }
//         return result.toString();
//     }
    
//     private int findMinLength(String[] strs) {
//         int minlength = Integer.MAX_VALUE;
//         for (int i = 0; i < strs.length; i++) {
//             minlength = Math.min(minlength, strs[i].length());
//         }
//         return minlength;
//     }
// }

class TrieNode {
    Map<Character, TrieNode> children;
    boolean isword;
    
    public TrieNode() {
        children = new HashMap();
        isword = false;
    }
}

class Trie {
    public TrieNode root;
    
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String str) {
        TrieNode cur = root;
        for (int i = 0; i < str.length(); i++) {
            Map<Character, TrieNode> child = cur.children;
            char c = str.charAt(i);
            TrieNode next = child.get(c);
            if (next == null) {
                child.put(c, new TrieNode());
            }
            cur = child.get(c);
        }
        cur.isword = true;
    }
}


class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)   return new String();
        
        Trie trie = new Trie();
        for (String s: strs) {
            trie.insert(s);
        }
        
        StringBuilder result = new StringBuilder();
        TrieNode cur = trie.root;
        while (cur.children.size() == 1 && !cur.isword) {
            Iterator iter = cur.children.keySet().iterator();
            while (iter.hasNext()) {
                Character ch = (Character)iter.next();
                result.append(ch);
                cur = cur.children.get(ch);
            }
        }
        return result.toString();
    }
}