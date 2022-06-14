921. Minimum Add to Make Parentheses Valid

Time Complexity : O(n) 
Space Complexity : O(n)

"()))((" = openStack::[]   --> closedStack::[]

-> '(')))(( --> currentCh is "(" so insert into OpenStack.
openStack:: ['('] --> closedStack::[]



-> (')'))(( --> currentCh is ")" and the openStack.peek() is '(' 
				so pop() from closedStack.

openStack::[]  --> closedStack::[]


-> ()')')(( --> currentCh is ")" and the openStack.isEmpty() so 
				insert into closedStack.

openStack::  --> closedStack:: [')']




-> ())')'(( -> currentCh is  ')' and the openStack.isEmpty() so 
				insert into closedStack.

openStack::  --> closedStack:: ") --> )"




-> ()))'('( --> currentCh is "(" so insert into OpenStack.

openStack:: "("  --> closedStack:: ") --> )"



-> ()))('(' --> currentCh is "(" so insert into OpenStack.

openStack:: "( --> ("  --> closedStack:: ") --> )"


return openStack.size() + closedStack.size() = 4 

**************************


Time Complexity : O(n) 
Space Complexity : O(1)

"()))((" = openCount =  0, closedCount = 0

-> '(')))(( --> currentCh is "(" so increment the openCount
openCount = 1 , closedCount = 0.


-> (')'))(( --> currentCh is ")" and openCount > 0 so decrement openCount.
			openCount = 0 , closedCount = 0.


-> ()')')(( --> currentCh is ")" and openCount = 0 so increment closedCount.

			openCount = 0 , closedCount = 1




-> ())')'(( ->  currentCh is ")" and openCount = 0 so increment closedCount.

			openCount = 0 , closedCount = 2





-> ()))'('( --> currentCh is "("  so increment the openCount

			openCount = 1 , closedCount = 2



-> ()))('(' --> currentCh is "("  so increment the openCount

			openCount = 2 , closedCount = 2

return openCount + closedCount = 4 

**************************

