// Leetcode 2800: Shortest String That Contains Three Strings


class Solution2800 {
    public String minimumString(String a, String b, String c) {
        // TC:O(N^2), SC:O(1)
        List<StringBuilder> list = new ArrayList<StringBuilder>();
        list.add(helper(new StringBuilder(a), new StringBuilder(b), new StringBuilder(c)));
        list.add(helper(new StringBuilder(a), new StringBuilder(c), new StringBuilder(b)));
        list.add(helper(new StringBuilder(b), new StringBuilder(a), new StringBuilder(c)));
        list.add(helper(new StringBuilder(b), new StringBuilder(c), new StringBuilder(a)));
        list.add(helper(new StringBuilder(c), new StringBuilder(a), new StringBuilder(b)));
        list.add(helper(new StringBuilder(c), new StringBuilder(b), new StringBuilder(a)));

        StringBuilder ret = list.get(0);
        for (int i = 1; i < 6; i++) {
            if (ret.length() == list.get(i).length() && list.get(i).toString().compareTo(ret.toString()) == -1) {
                ret = list.get(i);
            } else if (list.get(i).length() < ret.length()) {
                ret = list.get(i);
            }
        }
        return ret.toString();
    }

    private StringBuilder merge(StringBuilder a, StringBuilder b) {
        if (a.indexOf(b.toString()) != -1) {
            return a;
        }

        for (int i = Math.min(a.length(), b.length()); i >= 0; i--) {
            if (a.substring(a.length()-i) == b.substring(0, i)) {
                return a.append(b.substring(i));
            }
        }
        return a.append(b);
    }

    private StringBuilder helper(StringBuilder a, StringBuilder b, StringBuilder c) {
        return merge(merge(a, b), c);
    }
}
