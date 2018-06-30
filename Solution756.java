// Leetcode 756: Pyramid Transition Matrix
import java.util.*;

public class Solution756{
    public static void main(String args[]){
        String bottom = "XYZ";
        //String bottom = "XXYX";
        String temp[] = {"XYD", "YZE", "DEA", "FFF"};
        //String temp[] = {"XXX", "XXY", "XYX", "XYY", "YXZ"};
        List<String> allowed = Arrays.asList(temp);

        Solution756 s = new Solution756();
        boolean result = s.pyramidTransition(bottom, allowed);
        if (result){
            System.out.println("True!");
        }else{
            System.out.println("False");
        }
    }

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        // Create Map for allowed
        Map<String, Set<String>> m = new HashMap();
        for(String temp: allowed){
            String key = temp.substring(0, 2);
            if (!m.containsKey(key)){
                m.put(key, new HashSet<String>());
            }
            m.get(key).add(temp.substring(2));
        }
        /*
        for(String key: m.keySet()){
            System.out.printf("Key: %s Value: %s\n", key, m.get(key));
        }
        */

        Stack<String> s = new Stack();
        s.push(bottom);
        while (!s.isEmpty()){
            String cur = s.pop();
            //System.out.println("Cur:"+cur);
            if (cur.length() == 1)
                return true;
            
            Queue<String> q = new LinkedList();
            for (int i = 2; i <= cur.length(); i++){
                String key = cur.substring(i-2, i);
                //System.out.println(key);
                if (!m.containsKey(key)){
                    q.clear();
                    break;
                }
            
                Set<String> value = m.get(key);
                if (q.isEmpty()){
                    for (String value_in: value){
                        q.add(value_in);
                    }
                } else{
                    int size = q.size();
                    for (int j1 = 0; j1 < size; j1++){
                        String temp = q.poll();
                        for (String value_in: value){
                            q.add(temp+value_in);
                        }
                    }
                }
            }

            while (!q.isEmpty()){
                String in = q.poll();
                s.push(in);
            }
        }


        return false;
    }
}