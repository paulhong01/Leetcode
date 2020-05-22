// Leetcode 451: Sort Characters By Frequency

class Solution451 {
    public String frequencySort(String s) {
        // TC:O(Nlog(N)), SC:O(N)
        Map<Character, Integer> map = new HashMap<>();
        for (char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        
        PriorityQueue<Pair<Integer, Character>> pq = new PriorityQueue<>(new Comparator<>() {
            public int compare(Pair<Integer, Character> a, Pair<Integer, Character> b) {
                return b.getKey() - a.getKey();
            }
        });
        for (char c: map.keySet()) {
            pq.add(new Pair(map.get(c), c));
        }
        
        StringBuilder ret = new StringBuilder();
        while (!pq.isEmpty()) {
            Pair<Integer, Character> cur = pq.poll();
            for (int i = 0; i < cur.getKey(); i++) {
                ret.append(cur.getValue());
            }
        }
        return ret.toString();
    }
}