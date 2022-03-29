class MountainArrayProblem {
    /*
    Time Complexity : O(n)
    Space Complexity : O(1)
    */
    public boolean validMountainArray(int[] arr) {
        
        int index = 0;
        int n = arr.length;
        
        //walkUp 
        while(index < n-1)
        {
            if(arr[index] >= arr[index+1])
            {
              break;
            }
            index++;
        }
      
        
        //Base Checks 
        if(index == n-1 || index == 0)
        {
            return false;
        }
        
        // walkDown
        while(index < n-1)
        {
            if(arr[index] <= arr[index+1])
            {
                break;
            }
            index++;
        }
        
        return index == n-1;
    }
}

public class MountainArrayEx
{
    public static void main(String[] args) {
        
        MountainArrayProblem s = new MountainArrayProblem();
        int[] arr1 = {3,5,5};
        boolean result1 = s.validMountainArray(arr1);
        System.out.println(" For input {3,5,5} = "+result1);


        int[] arr2 = {0,3,2,1};
        boolean result2 = s.validMountainArray(arr2);
        System.out.println(" For input {0,3,2,1} = "+result2);
    }
}