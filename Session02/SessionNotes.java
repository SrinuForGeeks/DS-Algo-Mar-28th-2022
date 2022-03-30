In-Place Algo: 
Space Complexity : O(1)

int[] arr = {1,2,3,4};


square :

	for(int i = 0 ; i < arr.length ; i++)
	{
		arr[i] = arr[i] * arr[i];
	}

int[] arr = {2,4,8,16};


Out-Place Algo: 
Space Complexity : O(n)
int[] arr = {1,2,3,4};
int[] square = new int[arr.length];

for(int i = 0 ; i < arr.length ; i++)
	{
		square[i] = arr[i] * arr[i];
	}


********
nums = {1,3,4,2,2} ; [1,4] -> length = n+1 = 5  , n=4

nums = [3,1,3,4,2] ; [1,4]

***********

41. Return First Missing Possitive :  Anology

return smallest missing positive integer. 

value >= 1

Example 1:

Input: nums = [1,2,0] -> [1,2,3]
Output: 3


Example 2:
Input: nums = [3,4,-1,1] -> [1,2,3,4]
Output: 2



Example 3:
Input: nums = [7,8,9,11,12] -> [1,2,3,4,5]
Output: 1


Example 4: 
Input: nums = [1,2,3,4,5] -> 6
Output: 6

Example 5:
Input: nums = [-11,-12,-1,3,0] -> [1,2,3,4,5]
Output: 1


Example 6:
Input: nums = [-11,-12,-1,3,1] -> [1,2,3,4,5]
Output: 2


Clue :
99% value should with length of the array(n)
1% value will be n+1

 [-11,-12,-1,3,1] 

 isOnePresent : Yes

 Values we should not care : value <= 0 || value > n Replace them one


 [1,1,1,3,1] ----> Apply Outplace Algo: boolean[] = 
 								[F[i:0],F[i:1],F[i:2],F[i:3],F[i:3]]


boolean[] =  [F[i:0],T[i:1],F[i:2],T[i:3],F[i:3]]

Output : 2

*********








