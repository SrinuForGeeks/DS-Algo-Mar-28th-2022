class Solution_LeetCode339_DFS {
    public int depthSum(List<NestedInteger> nestedList) {
        
        Stack<NestedIntegerDepth> stack = new Stack<>();
        for(NestedInteger n : nestedList)
        {
            stack.push(new NestedIntegerDepth(n, 1));
        }
        
        int total = 0;
        while( !stack.isEmpty())
        {
           NestedIntegerDepth nestedIntegerDepth = stack.pop();
            NestedInteger n = nestedIntegerDepth.ni;
            int currentDepth = nestedIntegerDepth.depth;
            
            if(n.isInteger())
            {
                total = total + n.getInteger()*currentDepth;
            }else
            {
                for(NestedInteger nint : n.getList())
                {
                    stack.push(new NestedIntegerDepth(nint, currentDepth+1));
                }
            }
        }
        
        return total;
    }
}

class NestedIntegerDepth
{
    NestedInteger ni;
    int depth;
    
    public NestedIntegerDepth(NestedInteger ni , int depth)
    {
        this.ni = ni;
        this.depth = depth;
    }
    
}