class Solution_LeetCode339_Recursive {
    public int depthSum(List<NestedInteger> nestedList) {
        
      return sum(nestedList, 1);
    }
    
    private int sum(List<NestedInteger> nestedList, int depth)
    {
        int total = 0;
        for(NestedInteger n : nestedList)
        {
            if(n.isInteger())
            {
                total = total + n.getInteger() * depth;
            }else
            {
               total = total + sum(n.getList(), depth+1); 
            }
        }
        
        return total;
    }
}


