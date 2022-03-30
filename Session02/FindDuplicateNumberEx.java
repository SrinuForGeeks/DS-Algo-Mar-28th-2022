class FindDuplicateNumber
{
	/*
		Time Complexity : O(n)
		Space Complexity : O(n)
	*/
	public int outPlace(int[] nums)
	{
		int n = nums.length ;
		boolean[] visited = new boolean[n];

		for(int i = 0 ; i < n ; i++)
		{
			int value = nums[i];
			if(visited[value] == true)
			{
				return value;
			}
			visited[value] = true;
		}

		return -1;
	}

	/*
		Math.abs(-1) = 1
		Math.abs(+1) = 1
		Time Complexity : O(n) + O(n) = 2 O(n) = O(n)
		Space Complexity : O(1)
	*/
	public int inPlace(int[] nums)
	{
		int duplicate = -1;
		int n = nums.length ;
		for(int i = 0 ; i < n ; i++)
		{
			int value  = Math.abs(nums[i]);
			if( nums[value] < 0)
			{
				duplicate = value;
				break;
			}

			nums[value] = -nums[value];
		}

		for(int i = 0 ; i < n ; i++)
		{
				nums[i] = Math.abs(nums[i]);
		}

		return duplicate;
	}
}
public class FindDuplicateNumberEx
{
	public static void main(String[] args) {
		FindDuplicateNumber f = new FindDuplicateNumber(); 
		int[] arr = {1,3,4,2,2};

		System.out.println( " Outplace {1,3,4,2,2} -> "+f.outPlace(arr));
		System.out.println( " InPlace {1,3,4,2,2} -> "+f.inPlace(arr));

	}
}







