import java.util.Stack;

public class Histogram {
    public int largestRectangleArea(int[] heights) {
        
        Stack<Data> stack = new Stack<>();
        int n = heights.length;
        int maxArea = 0;
        
        for(int index = 0 ; index < n ; index++)
        {
            int current = heights[index];
            if(stack.isEmpty() || stack.peek().height < current)
            {
                stack.push(new Data(index, current));
            }else
            {
                Data top = null;
                while(!stack.isEmpty() && stack.peek().height >= current)
                {
                    top = stack.pop();
                    int width =  index - top.index;
                    
                    maxArea = Math.max(maxArea, width*top.height);
                }
                
                stack.push(new Data(top.index, current));
            }
            
        }
        
        while(!stack.isEmpty())
        {
            Data top = stack.pop();
            int width = n - top.index;
            maxArea = Math.max(maxArea, width*top.height);
            
        }
        
        return maxArea;
        
    }

    public static void main(String[] args) {
        Histogram s = new Histogram();
        int[] arr = {7,3,8,4};

        int maxArea = s.largestRectangleArea(arr);
        System.out.println (" {7,3,8,4} Largest Rectangle Area = "+maxArea);
    }
    
}

class Data
{
    int index;
    int height;
    
    public Data(int index, int height)
    {
        this.index = index;
        this.height = height;
    }
}