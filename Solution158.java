// Leetcode 158: Read N Characters Given Read4 II - Call multiple times
import java.util.*;

public class Solution158 extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    int buffPtr = 0;
    int buffCnt = 0;
    char[] buffer = new char[4];
    public int read(char[] buf, int n) {
        int count = 0;
        while (count < n) {
            if (buffPtr == 0) {
                buffCnt = read4(buffer);
            }
            if (buffCnt == 0)   break;
            while (count < n && buffPtr < buffCnt) {
                buf[count++] = buffer[buffPtr++];
            }
            if (buffPtr >= buffCnt) {
                buffPtr = 0;
            }
        }
        return count;
    }
}