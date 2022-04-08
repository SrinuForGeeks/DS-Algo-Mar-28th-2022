input1 : num1 : [1,3] num2: [2]

merge Of num1, num2 --> arr =  {1,2,3} -> if length is odd n/2 index value is the median : 2



input2 : num1 : [1,3] num2: [2,4]

merge Of num1, num2 --> arr = {1,2,3,4} 
				->  length is  even here
				mid = n/2; index : 2

				(arr[mid] + arr[mid-1]) / 2  is median
				median =(2+3)/2 = 2.5


Time Complexity :  O(m+n) -> arr1 : n , arr2 : m 
Space Complexity:  O(m+n)


