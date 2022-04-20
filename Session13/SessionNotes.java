
n = 25 :  Each time we can climb either 1 step or 2 step at time.

No Of Distinct Ways ?


Base Condition: [DP Solution demands seeding of optimal solutions for base sub problems. 
				These can be achieved from Problem Statement.]

As we know user can climb either 1 step or 2 step at time.
so for 
n = 1 ? Distict Ways = 1

n = 2 ? Distict Ways = 2


State/ varibles [ To store optimistic results of subProblem]:

int[] dp = new int[n+1];  //stores each sub problem result, 
						//size: n+1 is needed so we can have nth step result in n index



Recurrence Relation:  n = 25 Distict Ways ?


25 step can be reached from 24th[1step] && 23rd step [2steps]

25 step = No.Of Distict Ways to reach 24th step + No.Of Distict Ways to reach 23th step

So that the price to reach ith step is  dp[i] = dp[i-1] + dp[i-2];
 

************

int[] dp = new int[n+1];

dp[1] = 1;
dp[2] = 2; // Feeding of Base subproblem results.

dp[3] = dp[3-1] + dp[3-2] = dp[2] + dp[1] = 2 + 1 = 3
dp[4] = dp[3] + dp[2] = 3 + 2 = 5
....
....

Time Complexity  : O(n)
Space Complexity : O(n)

Can we improve on Space ? 
***********
To sovle nth problem we just need  (n-1) & (n-2) sub problem resuts.
So that if we maintain only those two subproblem results into two variables,
we can solve in constant Space.
Time Complexity  : O(n)
Space Complexity : O(1)
