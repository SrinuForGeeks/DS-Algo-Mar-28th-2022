public class TrapingRainWater {
    public int trap(int[] height) {
        
        int n = height.length;
        
        if(n == 1)
        {
            return 0;
        }
        
        int[] leftMaxArr = new int[n];
        leftMaxArr[0] = 0;
        int leftMax = height[0] ;
        
        int[] rightMaxArr = new int[n];
        rightMaxArr[n-1] = 0;
        int rightMax = height[n-1];
        
        
        // Fill the leftMax
        for(int index = 1;  index < n ; index++)
        {
            leftMax = Math.max(leftMax, height[index]);
            leftMaxArr[index] = leftMax;
        }
        
         // Fill the rightMax
        for(int index = n-2;  index >= 0 ; index--)
        {
            rightMax = Math.max(rightMax, height[index]);
            rightMaxArr[index] = rightMax;
        }
        
        int res = 0;
        
        
         for(int index = 0;  index < n ; index++)
        {
            int minHeight = Math.min(leftMaxArr[index], rightMaxArr[index]);
             
             if(minHeight-height[index] > 0)
             {
                 res = res + minHeight-height[index];
             }
        }
        
        return res;
    }

    public static void main(String[] args) {
        TrapingRainWater s = new TrapingRainWater();
        int[] height = {4,2,0,3,2,5};

        int total = s.trap(height);
        System.out.println(" {4,2,0,3,2,5} Total Store = "+total);
    }
}