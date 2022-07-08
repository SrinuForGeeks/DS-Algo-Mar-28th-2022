import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;

public class Graph
{
	public Map<Character,List<Character> > design(char[][] edges)
	{
		Map<Character,List<Character> > map = new HashMap<>();
			for(int index = 0 ; index < edges.length; index++)
			{
				char[] edge  = edges[index];

				map.putIfAbsent(edge[0], new LinkedList<>());
				map.putIfAbsent(edge[1], new LinkedList<>());

				map.get(edge[0]).add(edge[1]);
				map.get(edge[1]).add(edge[0]);


			}

			return map;
	}

	public static void main(String[] args) {
		char[][] edges = { {'A','B'}, {'A','C'} , {'B','D'},{'B','C'},{'C','D'},{'D','E'} };

		Graph g = new Graph();
		Map<Character,List<Character> > map = g.design(edges);
		System.out.println(map);
	}
}