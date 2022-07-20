class LeetCode695_Solution {
    int[][] directions = { {-1,0} , {1,0} , {0,1}, {0,-1}};
    public int maxAreaOfIsland(int[][] grid) {
         int m = grid.length;
        int n = grid[0].length;
        int maxSize = 0;
        for(int row = 0 ; row < m ; row++)
        {
            for(int col = 0 ; col < n ; col++)
            {
                if(grid[row][col] == 1)
                {
                   int size = getSize(row, col, grid);
                   maxSize = Math.max(size, maxSize);
                }
            }
        }
        
        return maxSize;
    }
    
    private int getSize(int row, int col, int[][] grid)
    {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row,col});
        int size = 0 ;
        grid[row][col] = 0;
        while(!queue.isEmpty())
        {
            int[] cell = queue.poll();
            size++;
            
            row = cell[0];
            col = cell[1];
            
            for(int index = 0 ; index < 4 ; index++)
            {
                int[] dir = directions[index];
                int dir_row = row + dir[0];
                int dir_col = col + dir[1];
                
                if(dir_row < 0  || dir_col < 0 || dir_row == m || dir_col == n 
                  || grid[dir_row][dir_col] != 1)
                {
                    continue;
                }
                
                grid[dir_row][dir_col] = 0;
                queue.add(new int[]{dir_row,dir_col});
            }
            
        }
        
        return size;
    }
}