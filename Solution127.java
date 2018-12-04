// Leetcode 127: Word Ladder
import java.util.*;

public class Solution127 {
    public static void main(String[] args) {
        String beginWord = "hot";
        String endWord = "dog";
        String[] word = {"hot","dog"};
        List<String> wordList = Arrays.asList(word);

        Solution127 sol = new Solution127();
        int res = sol.ladderLength(beginWord, endWord, wordList);
        System.out.println(res);
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet();
        for (String w: wordList)    set.add(w);
        if (beginWord.equals(endWord) || !set.contains(endWord))  return 0;

        Queue<String> queue = new LinkedList();
        queue.add(beginWord);
        int distance = 1;
        while (!queue.isEmpty()) {
            int size= queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                // System.out.println(cur);
                for (int idx = 0; idx < cur.length(); idx++) {
                    char[] cur_arr = cur.toCharArray();
                    // if (cur_arr[0] == 'h')  System.out.println("test");
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (cur_arr[0] == 'h' && ch == 'h')  System.out.println("test");
                        if (cur_arr[0] == 'h' && ch == 'h') System.out.println(cur_arr[0]);
                        if (cur_arr[idx] == (ch)) {System.out.println("haha"); continue;}
                        cur_arr[idx] = ch;
                        String temp = new String(cur_arr);
                        if (temp.equals(endWord))   return distance+1;
                        if (!set.contains(temp))    continue;
                        set.remove(temp);
                        queue.add(temp);
                    }
                }
            }
            distance++;
        }

        return 0;

    }
}