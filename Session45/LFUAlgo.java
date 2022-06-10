ArrayList --> (X)
LinkedList --> (Tick)
Set --> (X)
Map -> (tick)
How Many Maps we need :
	1. Map<Key, Node> keyMap :: get(key) --> O(1)
	2. Map<Counter, DLList> counterMap ::  --->  add & remove O(1)

Most clitrical part is maintaining the LFUCounter 

Node: 
	key,
	value,
	counter

 Cache Capacity : 2
*********************

Case1 : Adding (key,value) & cache is not filled:

		    put(1,10) : 
			LFUCounter  = 1 
			keyMap [(1 = node(1)Addr)]
			counterMap [1 = node(k:1,v:10,c:1) --> null]


Case2 :  Accessing valid Key & Updating the LFUCounter.

get(1) :

keyMap.contiansKeys(1) : true 

keyMap.get(1) --> node(1)
LFUCounter  = 1 
node(1).counter = 1

1. Think about updation of LFUCounter when ?
	if( LFUCounter == node(1).counter )
	{
		check the counterMap currentSize with LFUCounter :
		counterMap.get(LFUCounter).size which is one 1:
		And we are removing node(1) in the next step:
		So that afterRemove, 
		 counterMap.get(LFUCounter).size will become 0.
		 So that 
		 LFUCounter =  LFUCounter + 1  
		[Becasue node(1) will be moved to  LFUCounter + 1]
	}
		

2. remove node(1) from counterMap --> counterMap [1 = --> null]

3. Add node(1) to the node(1).counter+1 = 2 
		
		counterMap [
					1 = --> null,
					2 =  node(k:1,v:10,c:2) --> null
					]

		LFUCounter = 2
		keyMap: (1 --> node(1))


put(2,20) --> Same as cas1:

		 keyMap.contiansKey(2) :  False && keyMapSize < Capacity
		 so just add the (2,20) to the counterMap, & keyMap
		 then update the LFUCounter to 1.

		 counterMap [
					1 = --> node(k:2,v:20,c:1) --> null,
					2 =  node(k:1,v:10,c:2) --> null
					]

		keyMap: (1 --> node(1) , 2 --> node(2))

		LFUCounter = 1



Case3: Adding (key,value) & cache is  filled, remvoe the LFU element

		put(3,30)
		keyMap.contiansKey(3) :  False &&  keyMapSize(2) == Capacity (2)
		
		1. remove the LFU element = counterMap.get(LFUCounter).removeHead()
		=  counterMap.get(1).removeHead(); // node(k:2,v:20,c:1) is remvoed
		counterMap: [
					1 =  --> null,
					2 =  node(k:1,v:10,c:2) --> null
					]

		2. remove LFU from keyMap
		 keyMap: (1 --> node(1) )


  	then add the (3,30) to the counterMap, & keyMap
		 then update the LFUCounter to 1.

		 counterMap [
					1 =  --> (3,30) --> null,
					2 =  node(k:1,v:10,c:2) --> null
					]

		keyMap: (1 --> node(1), 3 ---> node(3) )
		LFUCounter = 1


Case4 : Update the existing (key,value) Pair
	    	Flow is same as  
	    	Case2 : Accessing valid Key & Updating the LFUCounter.
	    	Extra step is update the value of the node.


Fallow the same for all other cases :
