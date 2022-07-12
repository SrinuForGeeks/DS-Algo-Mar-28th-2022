import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;
import java.util.Queue;
import java.util.ArrayList;

public class GraphBFS
{
	Map<Character,List<Character> > graphMap = new HashMap<>();

	public Map<Character,List<Character> > design(char[][] edges)
	{
		
			for(int index = 0 ; index < edges.length; index++)
			{
				char[] edge  = edges[index];

				graphMap.putIfAbsent(edge[0], new LinkedList<>());
				graphMap.putIfAbsent(edge[1], new LinkedList<>());

				graphMap.get(edge[0]).add(edge[1]);
				graphMap.get(edge[1]).add(edge[0]);


			}

			return graphMap;
	}

	/*
		Time Complexity  : O(V+E)
		Space Complexity : O(V)
	*/
	public List<Character> bfs(char v)
	{
		List<Character> bfsList  = new ArrayList<>();
		Set<Character> vistiedSet = new HashSet<>();
		Queue<Character> queue = new LinkedList<>();
		queue.add(v);

		while(!queue.isEmpty())
		{
			int levelSize = queue.size();
			while(levelSize > 0 )
			{
				Character currentVertex = queue.poll();

			if(!vistiedSet.contains(currentVertex))
			{
				bfsList.add(currentVertex);
				vistiedSet.add(currentVertex);
			}

			List<Character> edges = graphMap.get(currentVertex);

			for(int index = 0 ; index < edges.size() ; index++)
			{
				Character ev = edges.get(index);
				if(!vistiedSet.contains(ev))
				{
					queue.add(ev);
				}
			}
			levelSize--;
			}
			
		}

		return bfsList;


	}

	public static void main(String[] args) {
		char[][] edges = { {'A','B'}, {'A','C'} , {'A','D'},{'B','E'},{'E','C'}};

		GraphBFS g = new GraphBFS();
		Map<Character,List<Character> > map = g.design(edges);
		System.out.println("Graph --->"+map);

		List<Character> bfsList = g.bfs('A');
		System.out.println(" BFS --> "+bfsList);
	}
}