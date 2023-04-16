// Leetcode 2601: Prime Subtraction Operation

class Solution2601 {
    List<Integer> prime_num;
    public boolean primeSubOperation(int[] nums) {
        // TC:O(N), SC:O(1)
        InitializePrimeNum();
        int last = 0;
        for (int num : nums) {
            int cur_min = num;
            for (int prime : prime_num) {
                if (num - prime <= last) {
                    break;
                }
                cur_min = num - prime;
            }
            if (cur_min <= last) {
                return false;
            }
            last = cur_min;
        }
        return true;
    }

    private void InitializePrimeNum() {
        prime_num = new ArrayList<Integer>();
        prime_num.add(2);
        for (int i = 3; i < 1000; i++) {
            boolean is_prime = true;
            for (int p : prime_num) {
                if (i % p == 0) {
                    is_prime = false;
                    break;
                }
            }
            if (is_prime) {
                prime_num.add(i);
            }
        }
    }
}
