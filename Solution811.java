import java.util.*;

class Solution811{
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> m = new HashMap();
        for(String s: cpdomains){
            int i = s.indexOf(' ');
            int n = Integer.parseInt(s.substring(0, i));
            String temp_s = s.substring(i+1);
            for(int j = 0; j < temp_s.length(); j++){
                if (temp_s.charAt(j) == '.'){
                    String temp_ss = temp_s.substring(j+1);
                    m.put(temp_ss, m.getOrDefault(temp_ss, 0)+n);
                }
            }
            m.put(temp_s, m.getOrDefault(temp_s, 0)+n);
        }
        List<String> res = new ArrayList();
        for (String s: m.keySet()){
            res.add(Integer.toString(m.get(s)) + " " + s);
        }
        return res;
    }

    public static void main(String[] args){
        Solution811 s = new Solution811();
        String temp[] = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        List<String> result = s.subdomainVisits(temp);
        System.out.println(result);
        /*
        for(int i = 0; i < result.size(); i++){
            System.out.printf("%s \n", result[i]);
        }*/
    }
}
