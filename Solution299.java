// Leetcode 299: Bulls and Cows

class Solution299 {
    
        public static void main(String[] args) {
            Solution299 sol = new Solution299();
            String secret = "1807", guess = "7810";
            System.out.println(sol.getHint(secret, guess));
        }
        public String getHint(String secret, String guess) {
            // Method 1: TC:O(n), three pass
            // int[] record = new int[10];
            // // Update record
            // for (char c: secret.toCharArray()) {
            //     record[c-'0']++;
            // }
            
            // int A = 0, B = 0;
            // for (int i = 0; i < guess.length(); i++) {
            //     if (guess.charAt(i) == secret.charAt(i) && record[guess.charAt(i) - '0'] > 0) {
            //         A++;
            //         record[guess.charAt(i) - '0']--;
            //     } 
            // }
            
            // for (int i = 0; i < guess.length(); i++) {
            //     if (guess.charAt(i) != secret.charAt(i) && record[guess.charAt(i) - '0'] > 0) {
            //         B++;
            //         record[guess.charAt(i) - '0']--;
            //     }
            // }
            
            // String result = String.valueOf(A) + "A" + String.valueOf(B) + "B";
            // return result;
            
            // Method 2: TC:O(n), One pass
            int[] recordg = new int[10];
            int[] records = new int[10];
            int A = 0, B = 0;
            for (int i = 0; i < secret.length(); i++) {
                if (secret.charAt(i) == guess.charAt(i)) {
                    A++;
                } else {
                    recordg[secret.charAt(i) - '0']++;
                    records[guess.charAt(i) - '0']++;
                }
            }      
            
            for (char c = '0'; c <= '9'; c++) {
                B += Math.min(recordg[c - '0'], records[c - '0']);
            }
            return String.valueOf(A) + "A" + String.valueOf(B) + "B";
        }
    }