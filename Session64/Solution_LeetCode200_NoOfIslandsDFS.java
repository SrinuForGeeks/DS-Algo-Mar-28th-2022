import java.util.*;
class Solution_LeetCode200_NoOfIslandsDFS  {
    public int numIslands(char[][] grid) {
        
        int islands = 0;
        
         int m = grid.length;
        int n = grid[0].length;
        
        for(int row = 0; row < m ; row++)
        {
            for(int col = 0 ; col < n ; col++)
            {
                if(grid[row][col] == '1')
                {
                   islands++;
                    dfs(grid, row, col);
                }
            }
        }
        
        return islands;
        
    }
    
    private void dfs(char[][] grid, int row, int col)
    {
        int m = grid.length;
        int n = grid[0].length;
        Stack<int[]> stack = new Stack<>();
        stack.add(new int[]{row,col});
        
        int[][] directions = new int[][]{
        
            {-1,0}, // left
            {1,0},//right
            {0,1}, //up
            {0,-1} // down
        };
        
        while( ! stack.isEmpty() )
        {
            int[] currentCell = stack.pop();
            row = currentCell[0];
            col = currentCell[1];
            
           
            
            for(int index = 0 ; index < 4; index++  )
            {
                int[] dir = directions[index];
                int dir_row = row + dir[0];
                int dir_col = col + dir[1];
                
 if( dir_row < 0 || dir_col < 0 || dir_row == m || dir_col == n || grid[dir_row][dir_col] == '0' )
                {
                    continue;
                }
                
                grid[dir_row][dir_col] = '0';
                stack.add(new int[]{dir_row, dir_col});
            }
        }
        
    }
}