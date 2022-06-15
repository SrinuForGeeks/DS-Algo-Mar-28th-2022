150. Evaluate Reverse Polish Notation

 "2","1","+","3","*" -->
 ( (2+1) , "3","*") 
 ((3) * (3)) = 9


"4","13","5","/","+"
["4", (13/5),"+"] = ["4",2,"+"]
[4+2] = 6

****************
Algorithm:
	--> If the current iterated value is a digit push to the stack.
	--> When ever we find an operator, pop the last two digits from the stack.
	--> Apply the operator then push the result to stack.
{ "2","1","+","3","*"} : stack []

index:0 as it is digit(2) add to Stack [2]

index:1 as it is digit(1) add to Stack [2, 1]

index:2 It is an operator(+) --> Pop() the two elements from the stack:
		int b = stack.pop(); [1]
		int a = stack.pop(); [2]
		Now stack is Empty:
		Apply the operator(+) -> 1+2 = 3
		push the result to the stack. stack[3]

index:3 as it is digit(3) add to Stack [3, 3]

index:4 It is an operator(*)  --> Pop() the two elements from the stack:
			int b = stack.pop(); [3]
			int a = stack.pop(); [3]
			Now stack is Empty:
		Apply the operator(*) -> 3*3 = 9
		push the result to the stack. stack[9]
				
return stack.pop();

Time Complexity : O(n)
Space Complexity: O(n) ~ On and average : O(1)


***************
1047. Remove All Adjacent Duplicates In String

Input: s = "abbaca"
  a"bb"aca -> "aa"ca -> ca

Input: s = "azxxzy"
 "azxxzy" --> az"xx"zy -> a"zz"y --> ay

**********

"abbaca" :: stack[]
Algorithm: 
	--> If the stack.peek() is not current Character 
		then add to stack otherwise remove peek() from the stack.
	--> Iterate the stack, return reverse result.

index:0 -> As stack is Empty just add --> stack['a']

index:1 -> currentCh ='b' and stack.peek is 'a' so 
			add currentCh to stack --> stack['a','b']

index:2 ->currentCh ='b' and stack.peek is 'b' so 
			pop from the stack --> stack['a']

index:3 ->currentCh ='a' and stack.peek is 'a' so 
			pop from the stack --> stack[]


index:4 -> As stack is Empty just add --> stack['c']


index:5 ->currentCh ='a' and stack.peek is 'c' so 
			add to the stack --> stack['a','c']

Iterate the stack --> "ca" --> return revers --> "ac"

Time Complexity : O(n) [String] + O(n) [Stack]  = O(n)

Space Complexiyt : O(n)

***************
496. Next Greater Element I

	Algorithm: 
		-> Starts from nums2.length-1 index.
		-> Iterate the stack till you find the next greater element.
			If you find then add map(nums2[index],stack.peek()) 
					otherwise map(nums2[index],-1).
		-> Each iteration add current nums2[index] to stack.

nums1 = [4,1,2], nums2 = [1,3,4,2] 
Output: [-1,3,-1]

 nums2 = [1,3,4,2]   Map[], Stack[] 

 index:3  Map[2->-1] , Stack[2]

 index:2   Stack has [2], currentElement:4 so stack will be Empty.
 			 Map[2->-1, 4 -> -1]
 			 Add 4 to stack [4]


index:1 Stack has [4] currentElement:3 so Add (3 --> 4) to map 
			Map[2->-1, 4 -> -1, 3 --> 4]
			Add 3 to stack [4,3]


index:0  Stack has [4,3] currentElement:1 so Add (1->3) to map  
					Map[2->-1, 4 -> -1, 3 --> 4, 1 --> 3]
					Add 1 to stack [4,3,1]

Final Result:
nums1 = [4,1,2] --> [-1,3,-1]

**************


Input: nums1 = [2,4], nums2 = [1,2,3,4]
Output: [3,-1]



nums1: [1,3,5,2,4]
nums2: [6,5,4,3,2,1,7]

 nums2: [6,5,4,3,2,1,'7']
  stack :[7]  map[(7,-1)]

 
 nums2: [6,5,4,3,2,'1',7]
 stack :[7,1]  map[(7,-1),(1,7)]

 nums2: [6,5,4,3,'2',1,7]

 		stack :[7,1]  map[(7,-1),(1,7)]
 		 stack.peek()[1] < [2]  stack.pop()
 		 	stack :[7]  map[(7,-1),(1,7)]

 		 	 		 stack.peek()[7] > [2]  
 		 	 		 	map[(7,-1),(1,7),(2,7)]
						stack :[7,2]


 nums2: [6,5,4,'3',2,1,7]
 		map[(7,-1),(1,7),(2,7),(3,7)]
	   stack :[7,3]

nums2: [6,5,'4',3,2,1,7]
 		map[(7,-1),(1,7),(2,7),(3,7),(4,7)]
	   stack :[7,4]

nums2: [6,'5',4,3,2,1,7]
 		map[(7,-1),(1,7),(2,7),(3,7),(4,7),(5,7)]
	   stack :[7,5]


nums2: ['6',5,4,3,2,1,7]
 		map[(7,-1),(1,7),(2,7),(3,7),(4,7),(5,7),(6,7)]
	   stack :[7,6]


nums1: [1,3,5,2,4] = [7,7,7,7,7]

 




