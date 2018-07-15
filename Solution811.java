// Leetcode 811 : Subdomain Visit Count
import java.util.*;

class Solution811{
    public static void main(String[] args){
        Solution811 s = new Solution811();
        String temp[] = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        List<String> result = s.subdomainVisits(temp);
        System.out.println(result);
    }

    public List<String> subdomainVisits(String[] cpdomains) {
        // TC:O(N), SC:O(N), where N = N is the length of cpdomains since there can be only 3 subdomains at most.
        Map<String, Integer> m = new HashMap();
        for (String s: cpdomains){
            int idxblank = s.indexOf(' ');
            int value = Integer.parseInt(s.substring(0, idxblank));
            String domain = s.substring(idxblank+1);
            int idxdot;
            do{
                idxdot = domain.indexOf('.');
                m.put(domain, m.getOrDefault(domain, 0)+value);
                domain = domain.substring(idxdot+1);
            } while (idxdot != -1);
        }

        List<String> result = new ArrayList();
        for(String key: m.keySet()){
            result.add(Integer.toString(m.get(key)) + " " + key);
        }

        return result;
    }
}

