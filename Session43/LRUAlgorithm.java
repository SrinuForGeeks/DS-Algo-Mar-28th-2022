Cache Size : 2 

put(k,v) --> remove((k,v)) = O(1)

get(k) = O(1)

Indirectly when the cache is filled then we are remoing element.2

remove(k,v)

ArrayList (X)
LinkedList (DLL) [Remove & Add O(1)]
Set (X)
Map<Integer, Node> [Get O(1)]

*********
Capacity --> 2

size : 0 , Map[]

put(1,10) --> map.containsKey(1) : false
			  so add the (1,10) to the tail, 
			  (1,10) --> null

			  then add(key:1,node(1)) entry to the Map	
			  	Map [(1,node(1)Addr)]
		


put(2,20) --> map.containsKey(2) : false
			  so add the (2,20) to the tail, 
			  (1,10) --> (2,20) --> null

			  then add(key:2,node(2)) entry to the Map	
			  	Map [(1,node(1)Addr) , (2,node(2)addr)]
		


get(1) --> map.containsKey(1) --> Map [(1,node1Addr), (2,node2Addr)]

	As key:1 is accessed move node(1) to the tail

	(2,20)--> (1,10) --> null
		


put(3,30) : Cache Size reached the Capacity:2
			Remove LRU: As per our use case LRU is always be the 
			Head of in DLL.

			Remove the Head From DLL
			(1,10) --> null 
			Remove the key:2 from map 
			Map [(1,node1Addr)]

			then add (3,30) to the tail of DLL
			(1,10) --> (3,30) --> null 
			add (3, node(3)Addr) to the map
			Map [(1,node(1)Addr), (3,node(3)Addr)]

get(2) --> map.continasKey(2) : false return -1

put(1,15) :  (1,10) --> (3,30) --> null 
			Map [(1,node(1)Addr), (3,node(3)Addr)]

		map.containsKey(1) : true so update the value.
		 Move the key:1 node to the tail.

		 	(3,30) --> (1,15) --> null


put(4,45) :: (3,30) --> (1,15) --> null
			 Map [(1,node(1)Addr), (3,node(3)Addr)]

			 map.containsKey(4) : false : and cache is filled:

			 Remove the head from the DLL, then remove Entry Map
			 (1,15) --> null   Map [(1,node(1)Addr)]
			 then add(4,45) to the tail Of DLL then add entry(4,45) to the map:

			(1,15) --> (4,45) ---> null 
			Map [(1,node(1)Addr),(4, node(4)addr)]

map.get(3) -->  map.containsKey(3) : false  return -1

map.get(1) --> map.containsKey(1) : true
				move node(1) to the tail.

			(4,45) --> (1,15) ---> null 
			Map [(1,node(1)Addr),(4, node(4)addr)]

map.get(4) --> map.containsKey(4) : true
				move node(4) to the tail.

			(1,15) --> (4,45) ---> null 
			Map [(1,node(1)Addr),(4, node(4)addr)]


***************
Edge Cases :

		Cache : null<--(1,10) --> (3,30) --> null 
		Map [(1,node(1)Addr), (3,node(3)Addr)]


Case 1: 
		put(1,15) :  
			map.containsKey(1):true so update the value move to tail.

			Whenever you are moving Head to tail, there won't be prev node:
			Have a null check.

Case 2:

Base Check :
	(3,30) --> (1,15) --> null

	get(1) --> map.containsKey(1) : true
	Map [(1,node(1)Addr), (3,node(3)Addr)]


	move node(1) to the tail : 
	as node(1).next is null it means its already in tail position. 
	

Case 3:

Given the cache Capacity is zero in such cases always get(k) returns -1



1 --> Random Round [Stright forward ]

1 --> Someone from diff country take [clear]

Hyd HR connects to You:

3 Coding Rounds --> Laptop 

lunch in Google -->  

Googlyness & Leadership Round --> 

1 Design Round [Coding] --> 






