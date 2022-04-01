
Time Complexity : O(n)
Space Complexity : O(1)

char[] message = {'W','e','l','c','o','m','e'};


int start = 0;
ine end = message.length()-1;

while(start < end)
{
	int temp = message[end];
	message[end] = message[start];
	message[start] = temp;
	start++;
	end--;

}
*************

Remove Element: return k , where k represent  number of elements left after removing.

[3,2,2,3]
Remove element 3 : 
[2,2,3,3] k = 2 [First 2 elements, left after removing]



nums = [0,1,2,2,3,0,4,2], val = 2
[0,1,3,0,4,2,2,2] k = 5[First 5 elements, left after removing]


************





[A-Z] -> A,B,C,D,E -> 65 -> 90

[a-Z] -> a,b,c,d,e -> 97 -> 122

{'A','D','C','B','D'} ->length =  n+1 = 5  [1,n]
  0   1   2   3   4

  (byte)char[0]; -> 65%65 = 0
  (byte)char[1]; -> 68%65 = 3

[F,F,F,T]

****************
