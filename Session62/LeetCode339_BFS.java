class LeetCode339_BFS {
    public int depthSum(List<NestedInteger> nestedList) {
        
        int depth = 1;
        int total = 0;
        Queue<NestedInteger> queue = new LinkedList<>();
        for(NestedInteger ni : nestedList)
        {
            queue.add(ni);
        }
        
        while( !queue.isEmpty() )
        {
            int size = queue.size();
            while(size > 0 )
            {
               NestedInteger ni = queue.poll();
                if(ni.isInteger() )
                {
                    total = total + ni.getInteger() * depth;
                }else
                {
                    for(NestedInteger n : ni.getList())
                    {
                        queue.add(n);
                    }
                }
                
                size--;
            }
            depth++; 
        }
        
        return total;
    }
}