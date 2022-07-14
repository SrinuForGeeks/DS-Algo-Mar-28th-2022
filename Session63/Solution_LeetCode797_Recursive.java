import java.util.*;
 class Solution_LeetCode797_Recursive {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
    
          List<Integer> path =  new ArrayList<>();
            path.add(0);
          
        allPaths(0, path, result , graph);
        return result;
    }
    
    private void allPaths(int vertex, 
                          List<Integer> path, 
                          List<List<Integer>> result,
                          int[][] graph)
    {
        
        
      if(vertex == graph.length-1)
      {
          result.add(new ArrayList<>(path));
          return;
      }
        int[] edges = graph[vertex];
        for(int index = 0 ; index < edges.length; index++)
        {
           int edge = edges[index];
           path.add(edge);
           allPaths(edge,  path, result, graph);
           path.remove(path.size()-1);
        }

    }
}