class Solution950 {

    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        Arrays.sort(deck);
        Queue<Integer> queue = new LinkedList();
        for (int i = n-1; i >= 0; i--) {
            if (queue.size() > 0)   queue.add(queue.poll());
            queue.add(deck[i]);
        }
        
        int[] result = new int[n];
        for (int i = n-1; i >= 0; i--) {
            result[i] = queue.poll();
        }
        return result;
    }
}