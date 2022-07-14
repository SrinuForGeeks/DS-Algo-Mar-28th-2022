import java.util.*;

class Solution_LeetCode797_BFS {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        int n = graph.length;
        Queue<Integer> queue = new LinkedList<>();
        Queue<List<Integer>> pathQueue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        
        queue.add(0);
      
        List<Integer> path = new LinkedList<>();
        path.add(0);
        
        pathQueue.add(path);
        
        while(!queue.isEmpty())
        {
            int currentVertex = queue.poll();
            List<Integer> currentPath = pathQueue.poll();
            
           int[] edges = graph[currentVertex];
            
            for(int index = 0 ; index <edges.length ; index++ )
            {
                int currentEdge = edges[index];
                
                List<Integer>  clonePath = new ArrayList<>(currentPath);
                clonePath.add(currentEdge);
                
                if( currentEdge == n-1)
                { 
                    result.add(clonePath);
                }else
                {
                    queue.add(currentEdge);
                    pathQueue.add(clonePath);
                }
            }
        }
        
        return result;
    }
    
}