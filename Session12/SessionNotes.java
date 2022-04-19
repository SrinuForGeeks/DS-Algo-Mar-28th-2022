BruteForce Approch :

int[] arr = {4,5,6,7,8,1,2,3} target : 1

Time Complexity : O(n)
Space Complexity : O(1)

for(int i = 0 ; i < arr.length ; i++)
{
	if( arr[i] == target)
	{
		return i;
	}
}

return -1;


*********
BruteForce Approch for pivotIndex:

pivotIndex: O(n)
for(int i = 0 ; i < arr.length-1 ; i++)
{
	if( arr[i] > arr[i+1] )
	{
		return i+1;
	}
}


**********
Optimistic Algorithms, refer the PDF








