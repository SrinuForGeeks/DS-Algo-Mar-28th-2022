public class QuickFind
{
	int[]  root = null;

	public QuickFind(int size)
	{
		root = new int[size];
		for(int vertex = 0 ; vertex < size; vertex++)
		{
			root[vertex] = vertex;
		}
	}

	/*
		Time complexity : O(1)
	*/
	public int find(int vertex)
	{
		return root[vertex];
	}

	/*
		Time complexity : O(1)
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

		if(rootX != rootY)
		{
			root[vy] = rootX;

			for(int vertex = 0 ; vertex < root.length; vertex++)
			{
				if(root[vertex] == rootY)
				{
					root[vertex] = rootX;
				}
			}
		}
	}

	public void print()
	{
		for(int vertex = 0 ; vertex < root.length; vertex++)
			{
		System.out.println("vertex(" +vertex + ") -->  Root("+root[vertex]+")");
			}	
	}

	

	public static void main(String[] args) {
		
		QuickFind ds = new QuickFind(8);

		ds.union(0,1);
		
		ds.union(0,3);

		ds.union(1,2);

		ds.union(4,5);

		ds.union(4,6);

		ds.print();

		System.out.println(" is v(2) and V(3) are connected --> "+ds.isConnected(2,3));

	   System.out.println(" is v(2) and V(6) are connected --> "+ds.isConnected(2,6));

	   ds.union(3,4);

	   System.out.println(" \n After Union of (3,4)");
	   		ds.print();

	 System.out.println(" is v(2) and V(6) are connected --> "+ds.isConnected(2,6));

	}
}