import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;
import java.util.Stack;
import java.util.ArrayList;

public class GraphDFS
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
	public List<Character> dfs(char v)
	{
		List<Character> dfsList  = new ArrayList<>();
		Set<Character> vistiedSet = new HashSet<>();
		Stack<Character> stack = new Stack<>();
		stack.add(v);

		while(!stack.isEmpty())
		{
			Character currentVertex = stack.pop();

			if(!vistiedSet.contains(currentVertex))
			{
				dfsList.add(currentVertex);
				vistiedSet.add(currentVertex);
			}

			List<Character> edges = graphMap.get(currentVertex);

			for(int index = edges.size()-1 ; index >= 0 ; index--)
			{
				Character ev = edges.get(index);
				if(!vistiedSet.contains(ev))
				{
					stack.push(ev);
				}
			}
		}

		return dfsList;


	}

	public static void main(String[] args) {
		char[][] edges = { {'A','B'}, {'A','C'} , {'A','D'},{'B','E'},{'E','C'}};

		GraphDFS g = new GraphDFS();
		Map<Character,List<Character> > map = g.design(edges);
		System.out.println("Graph --->"+map);

		List<Character> dfsList = g.dfs('A');
		System.out.println(" DFS --> "+dfsList);
	}
}