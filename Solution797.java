//Leetcode 797: All Paths From Source to Target
class Solution797 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList();
        List<Integer> path = new ArrayList();
        
        path.add(0);
        dfs(result, path, 0, graph);
        return result;
    }
    
    private void dfs(List<List<Integer>> result, List<Integer> path, int idx, int[][] graph) {
        if (idx == graph.length - 1) {
            result.add(new ArrayList(path));
            return;
        }
        
        for(int g: graph[idx]) {
            path.add(g);
            dfs(result, path, g, graph);
            path.remove(path.size()-1);
        }
    }
}