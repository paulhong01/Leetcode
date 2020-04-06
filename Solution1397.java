// Leetcode 1397: Find All Good Strings
import java.util.*;

class Solution1397 {
    static long m = 1000000007L;
    static String[] froms = new String[501], tos = new String[501]; // the default from and to boundaries;
    String e; // evil
    int el; // length of evil
    ArrayList<Integer> offsets = new ArrayList(51);
    HashMap<String, Long> goods = new HashMap();
    public int findGoodStrings(int n, String s1, String s2, String evil) {
        if(froms[0] == null){
            froms[0] = "";
            tos[0] = "";
            for(int i = 1; i < 501; i++){ // build the default boundaries
                froms[i] = froms[i - 1] + "a";
                tos[i] = tos[i - 1] + "z";
            }
        }
        goods.put("-", 1L); // the dp boundary condition. count 1 when from == to
        e = evil;
        el = e.length();
        for(int i = 1; i < el; i++) if (evil.substring(i, el).equals(evil.substring(0, el - i))) offsets.add(i); // find internal overlaps in the evil such as [abc(ab]cab)
        return (int)countGood(s1, s2);
    }
    long countGood(String from, String to){ // count the good strings between [from] and [to]
        String key = from + "-" + to;
        if(goods.containsKey(key)) return goods.get(key);
        int l = from.length(), f = from.charAt(0) - 'a', t = to.charAt(0) - 'a';
        long cnt = ((t > f + 1 ? countGood(froms[l - 1], tos[l - 1]) * (t - f - 1) : 0) + // count from 'a...a' to 'z...z' for chars between f and t
                (t > f ? countGood(from.substring(1), tos[l - 1]) + countGood(froms[l - 1], to.substring(1)) : countGood(from.substring(1), to.substring(1))) + // count for char f and t
                (m - countEvil(from, to, l))) % m; // remove the strings that start with evil
        goods.put(key, cnt); // add to memorization
        return cnt;
    }
    long countEvil(String from, String to, int l){ // count the strings between [from] and [to] that starts with evil
        if(l < el) return 0L; // when string length is less than evil length, return 0
        int compareFrom = e.compareTo(from.substring(0, el)), compareTo = e.compareTo(to.substring(0, el));
        if(compareFrom < 0 || compareTo > 0) return 0L; // when evil can't appear in the range between from and to, return 0
        long cnt = countGood(compareFrom == 0 ? from.substring(el) : froms[l - el], compareTo == 0 ? to.substring(el): tos[l - el]); // count good
        for(int offset: offsets) // remove the duplicates, for cases such as abcab, where another abcab could start from inside [abc(ab]cab)
            if(l - offset < el) break;
            else cnt = (cnt + m - countEvil(from.substring(0, offset).equals(e.substring(0, offset)) ? from.substring(offset) : froms[l - offset],
                    to.substring(0, offset).equals(e.substring(0, offset)) ? to.substring(offset) : tos[l - offset],l - offset)) % m;
        return cnt;
    }
}