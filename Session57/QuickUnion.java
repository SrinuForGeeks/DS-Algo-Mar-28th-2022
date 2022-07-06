public class QuickUnion
{
	int[]  root = null;

	public QuickUnion(int size)
	{
		root = new int[size];
		for(int vertex = 0 ; vertex < size; vertex++)
		{
			root[vertex] = vertex;
		}
	}

	/*
		Time complexity : O(n) ~ O(1)/O(logn)
	*/
	public int find(int vertex)
	{
		while(vertex != root[vertex])
		{
			vertex = root[vertex];
		}
		return vertex;
	}

	/*
		Time complexity : O(n)
	*/
	public boolean isConnected(int vx, int vy)
	{
		return find(vx) == find(vy);
	}

	/*
		Time complexity : O(n)
	*/
	public void union(int vx,int vy)
	{
		int rootX = find(vx);
		int rootY = find(vy);
		root[rootY] = rootX;
	}

	public void print()
	{
		for(int vertex = 0 ; vertex < root.length; vertex++)
			{
		System.out.println("vertex(" +vertex + ") -->  Root("+root[vertex]+")");
			}	
	}

	

	public static void main(String[] args) {
		
		QuickUnion ds = new QuickUnion(8);

		ds.union(0,1);
		
		ds.union(0,3);

		ds.union(1,2);
				/*  0 - 1 - 2
					|
					3
				*/


		ds.union(4,5);

		ds.union(4,6);

			/*  	4 - 5
					|
					6
				*/

		ds.print();

		System.out.println(" is v(2) and V(3) are connected --> "+ds.isConnected(2,3));

	   System.out.println(" is v(2) and V(6) are connected --> "+ds.isConnected(2,6));

	   ds.union(3,4);
	   			/*  			
	   				0 - 1 - 2
					|
					3
					|
					4 - 5
					|
					6
				*/
				

	   System.out.println(" \n After Union of (3,4)");
	   		ds.print();

	 System.out.println(" is v(2) and V(6) are connected --> "+ds.isConnected(2,6));

	}
}