75. Sort Colors
Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]

input: [0,0,0]
output: [0,0,0]

[1]
output: [1]

input: [1,2,0]
output: [0,1,2]

***************
704.Search element on Sorted Array: 

Brute Force: TC : O(n) target : 6
			 SC : O(1)


	for(i:0  to n)
	{
			arr[i] == target
				return i;

	}

	return -1;
**************************
704.Search  element on Sorted Array:  

Binary Search

{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16} n:16 :: target = -1

{1,2,3,4,5,6,7,8} n:8

{1,2,3,4} n:4

{1,2} n:2

{1} n:1

In Worst case token 4 iterations for 16 elements.

log2^(16) = 4

log2^(n) -> Time Complexity : log(n)
			Space Complexity : O(1)


************
mid princeple :

Assume Max value an  int datatype can store is 12  :

left = 6
right = 8 

 mid = (left+right)/2  -> (6+8)/2 
 = (14)/2  

--> 14 can not be stored in int as the max capacity 
     12 so that gives wrong result.


mid = left +  (right-left)/2 = 6 + 2/2 = 7































