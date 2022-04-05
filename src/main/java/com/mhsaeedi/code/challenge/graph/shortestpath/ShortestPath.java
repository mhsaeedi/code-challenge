package com.mhsaeedi.code.challenge.graph.shortestpath;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author : Momo
 * @since : 04.04.22, Mon
 **/
public class ShortestPath
{
	public static void main(String[] args)
	{
		Vertex s = new Vertex("S");
		Vertex a = new Vertex("A");
		Vertex b = new Vertex("B");
		Vertex c = new Vertex("C");
		Vertex d = new Vertex("D");
		Vertex e = new Vertex("E");
		Vertex f = new Vertex("F");

		s.addEdges(new Edge(1, a), new Edge(2, c));
		a.addEdges(new Edge(6, b));
		b.addEdges(new Edge(2, e), new Edge(1, d));
		c.addEdges(new Edge(4, a), new Edge(3, d), new Edge(1, b));
		d.addEdges(new Edge(1, e));
		e.addEdges(new Edge(8, f));

		List<Vertex> graph = Arrays.asList(s, a, b, c, d, e, f);
		Deque<Vertex> sorted = sort(graph);
		Map<String, Integer> shortest = graph.stream().collect(Collectors.toMap(v -> v.name, v -> Integer.MAX_VALUE));
		Vertex current = sorted.pop();
		shortest.put(current.name, 0);
		while (!sorted.isEmpty())
		{
			for (Edge edge : current.edges)
			{
				if (edge.weight + shortest.get(current.name) < shortest.get(edge.vertex.name))
				{
					shortest.put(edge.vertex.name, edge.weight + shortest.get(current.name));
				}
			}
			current = sorted.pop();
		}

		for (Map.Entry<String, Integer> entry : shortest.entrySet())
		{
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}

	}

	private static Deque<Vertex> sort(List<Vertex> graph)
	{
		Set<String> visited = new HashSet<>();
		Deque<Vertex> stack = new ArrayDeque<>();
		for (Vertex vertex : graph)
		{
			if (!visited.contains(vertex.name))
			{
				visit(stack, visited, vertex);
				stack.push(vertex);
			}
		}
		return stack;
	}

	private static void visit(Deque<Vertex> stack, Set<String> visited, Vertex vertex)
	{
		visited.add(vertex.name);
		for (Edge edge : vertex.edges)
		{
			if (!visited.contains(edge.vertex.name))
			{
				visit(stack, visited, edge.vertex);
				stack.push(edge.vertex);
			}
		}

	}

}

class Edge
{
	public final int weight;
	public final Vertex vertex;

	Edge(int weight, Vertex vertex)
	{
		this.weight = weight;
		this.vertex = vertex;
	}
}

class Vertex
{
	public final String name;
	public final List<Edge> edges;

	Vertex(String name)
	{
		edges = new ArrayList<>();
		this.name = name;
	}

	public void addEdges(Edge... edges)
	{
		this.edges.addAll(Arrays.asList(edges));
	}

	@Override
	public String toString()
	{
		return "(" + name + ")";
	}
}
