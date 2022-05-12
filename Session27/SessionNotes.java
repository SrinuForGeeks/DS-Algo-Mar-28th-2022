w {1,2,3}

p {5,2,4}

c:5 

int[][] dp = new int[w.length][c+1];


			Lets Solve the Base Sub Problem i:0  ->
					we can include i:0 element only w[0] <= c otherwise its 0.
					profit[0]+ dp[0][c-w[0]]; c:1 -> 5 + dp[0]c[0] = 5+0 = 5
											  c:2 -> 5+ dp[0][1] = 5+5 = 10
											  c:3 -> 5+ dp[0][2] = 5+10 = 15
											  c:4 -> 5+ dp[0][3] = 5+15 = 20
											  c:5 -> 5+ dp[0][4] = 5+20 = 25



							c:0 	c:1   	c:2      c:3     c:4    c:5
 
i:0 w{1} p{5}				0		5  		10		  15      20     25


i:1 w{1,2} p{5,2}		    0       5  	 	10 		  15	  20     25


i:2 w{1,2,3} p{5,2,4}       0       5  	 	10		  15      20     25


								Max(p[2]+dp[2][2], dp[1][5])
								Max(4+10,25)




								Element



			include w[i]<=c 					exclude w[i] > c 
										 		 dp[i-1][c]
			Max(include, exclude)

			Max(profits[i] + dp[i][c-w[i]], dp[i-1][c])





int[] weights = {3,2,1};  
int[] profits = {25,9,4};


i:0 [1] i:2 [2]
w{3,1,1} -> {25,4,4} -> p:33

i:0 [1] i:2 [1]-->  
w{3,2} --> p{25,9} --> p:34

i:2 2 i:3 1
{2,2,1} --> {9,9,4} -> p:22

i:2[1] i:3 3

{2,1,1,1} -> {9,4,4,4} p:21

i:3 5 
{1,1,1,1,1} -> {5,5,5,5,5} 20

***********

{100,200,500,2000} Notes:

{1,2,5,20} : 5

How Many notes :  Return minumal note count : output 1
		{1,1,1,1,1} -> 5
		{1,1,1,2} -> 4
		{1,2,2} -> 3
		{5} -> 1

************************

{1,2,5}  amount : 5

{1,5,5} --> minimal noteCount 3


	w <= c
	min(include, exclude)
	min(1+dp[i][c-w[i]] , dp[i-1][c])


	w > c
	exclude : dp[i-1][c]


Base SubProblem 

				int[][] dp = new int[w.length][c+1];

coins{1,2,5}  amount : 5
Base SubProblem i:0
	
	coins[0] <= c
	 1+dp[0][c-w[0]]



							c:0 	c:1   	c:2      c:3     c:4    c:5
 
i:0 {1}						0       1 		2         3       4      5


i:1 {1,2}		   			0       1       1         2       2       3 


i:2 {1,2,5}   				0       1       1         2       2       1


			i:2	Min(1+dp[2][0], dp[1][5]) -> Min(1+0,3)



	w <= c
	min(include, exclude)
	min(1+dp[i][c-w[i]] , dp[i-1][c])


	w > c
	exclude : dp[i-1][c]



*******