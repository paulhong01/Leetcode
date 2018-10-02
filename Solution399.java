// Leetcode 399: Evaluate Division

class Solution399 {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        HashMap<String, List<String>> graph = new HashMap();
        HashMap<String, List<Double>> edge = new HashMap();
        
        for (int i = 0; i < equations.length; i++) {
            List tempgraph = graph.getOrDefault(equations[i][0], null);
            if (tempgraph == null) {
                graph.put(equations[i][0], new ArrayList<String>());
                edge.put(equations[i][0], new ArrayList<Double>());
            } 
            graph.get(equations[i][0]).add(equations[i][1]);
            edge.get(equations[i][0]).add(values[i]);
            
            tempgraph = graph.getOrDefault(equations[i][1], null);
            if (tempgraph == null) {
                graph.put(equations[i][1], new ArrayList<String>());
                edge.put(equations[i][1], new ArrayList<Double>());
            } 
            graph.get(equations[i][1]).add(equations[i][0]);
            edge.get(equations[i][1]).add(1/values[i]);
        }
        
        double[] result = new double[queries.length];
        Arrays.fill(result, -1.0);
        for (int i = 0; i < queries.length; i++) {
            String start = queries[i][0];
            String goal = queries[i][1];
            Set<String> visited = new HashSet();
            double cur = 1;
            dfs(start, goal, cur, visited, graph, edge, result, i);
        }
        
        return result;
    }
    
    private void dfs(String start, String goal, double cur, Set<String> visited, Map<String, List<String>> graph, Map<String, List<Double>> edge, double[] result, int idx) {
        List<String> graphtemp = graph.getOrDefault(start, null);
        List<Double> edgetemp = edge.getOrDefault(start, null);
        if (graphtemp == null) {
            return;
        } else if (start.equals(goal)) {
            // System.out.println("haha");
            result[idx] = cur;
            return;
        }
        // System.out.println(start);
        visited.add(start);
        
        for (int i = 0; i < graphtemp.size(); i++) {
            if (!visited.contains(graphtemp.get(i))) {
                dfs(graphtemp.get(i), goal, cur*edgetemp.get(i), visited, graph, edge, result, idx);
            }
        }
    }
}