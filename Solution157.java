// Leetcode 157 : Read N Characters Given Read4
import java.util.*;

/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf);
 */
public class Solution157 extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        boolean eof = false;
        char[] temp = new char[4];
        int total = 0;
        while (!eof && total < n) {
            int ret = read4(temp);
            
            eof = (ret < 4);
            
            ret = Math.min(ret, n-total);
            
            for (int i = 0; i < ret; i++) {
                buf[total++] = temp[i];
            }
        }
        return total;
    }
}