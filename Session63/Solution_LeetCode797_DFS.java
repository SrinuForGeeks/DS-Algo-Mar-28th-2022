import java.util.*;

class Solution_LeetCode797_DFS {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        int n = graph.length;
        Stack<Integer> stack = new Stack<>();
        Stack<List<Integer>> pathStack = new Stack<>();
        List<List<Integer>> result = new ArrayList<>();
        
        stack.push(0);
      
        List<Integer> path = new LinkedList<>();
        path.add(0);
        
        pathStack.push(path);
        
        while(!stack.isEmpty())
        {
            int currentVertex = stack.pop();
            List<Integer> currentPath = pathStack.pop();
            
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
                    stack.push(currentEdge);
                    pathStack.push(clonePath);
                }
            }
        }
        
        return result;
    }
    
}