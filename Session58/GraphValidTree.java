import java.util.Stack;
public class GraphValidTree {
    /*
    Time Complexity  : O(n*2) = O(2n) = O(n)
    Space Complexity : O(n)
    */
    public boolean validTree(int n, int[][] edges) {
        
        if(edges.length != n-1)
        {
            return false;
        }
        
        UnionFind ds = new UnionFind(n);
        
        for(int index = 0 ; index < edges.length ; index++)
        {
            int[] edge = edges[index];
            
            boolean flag = ds.uninon(edge[0],edge[1]);
            if(flag == false)
            {
                return false;
            }
        }
        
        return true;
    }
    public static void main(String[] args) {
        GraphValidTree s = new GraphValidTree();
        boolean flag = s.validTree(5,new int[][]{{0,1},{0,2},{0,3},{1,4}});
        System.out.println("{{0,1},{0,2},{0,3},{1,4}} --> isValidTree = "+flag);
        flag = s.validTree(5,new int[][]{{0,1},{0,2},{0,3},{1,2}});
        System.out.println("{{0,1},{0,2},{0,3},{1,2}} --> isValidTree = "+flag);

    }
}

class UnionFind
{
    private int[] root = null;
    
    public UnionFind(int size)
    {
        root = new int[size];
        
        for(int index = 0 ; index < size; index++)
        {
            root[index] = index;
        }
    }
    
    public int find(int v)
    {
        Stack<Integer> stack = new Stack<>();
        while(v != root[v])
        {
            v = root[v];
            stack.push(v);
        }
        
        while( !stack.isEmpty())
        {
            root[stack.pop()] = v;
        }
        
        return v;
    }
    
    public boolean uninon(int vx, int vy)
    {
        int rootX = find(vx);
        int rootY = find(vy);
        
        if(rootX == rootY)
        {
            return false;
        }
        
        root[rootY] = rootX;
        
        return true;
    }
}


