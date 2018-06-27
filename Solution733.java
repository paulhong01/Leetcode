// Leetcode 733: Flood Fill
import java.util.*;

public class Solution733{
    public static void main(String args[]){
        int image[][] = {{1,1,1},{1,1,0},{1,0,1}};
        int sr = 1, sc = 1, newColor = 2;
        Solution733 s = new Solution733();
        image = s.floodFill(image, sr, sc, newColor);
        for (int[] i: image){
            for (int j: i)
                System.out.printf("%d ", j);
            System.out.println("");
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // TC:O(N), SC:O(N)
        traversal(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }

    private void traversal(int[][] image, int x, int y, int newColor, int originColor){
        if (x < 0 || x >= image[0].length || y < 0 || y >= image.length || image[x][y] != originColor)
            return;
        
        image[x][y] = newColor;
        traversal(image, x+1, y, newColor, originColor);
        traversal(image, x-1, y, newColor, originColor);
        traversal(image, x, y+1, newColor, originColor);
        traversal(image, x, y-1, newColor, originColor);
        return;
    }
}