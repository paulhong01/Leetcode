class Solution349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> s = new HashSet();
        for (int i = 0; i < nums1.length; i++){
            s.add(nums1[i]);
        }
        
        List<Integer> r = new ArrayList();
        int count = 0;
        for (int i = 0; i < nums2.length; i++){
            if (s.contains(nums2[i])){
                r.add(nums2[i]);
                s.remove(nums2[i]);
            }
        }
        
        int []result = new int[r.size()];
        for (int i = 0; i < r.size(); i++){
            result[i] = r.get(i);
        }
        return result;
    }
}