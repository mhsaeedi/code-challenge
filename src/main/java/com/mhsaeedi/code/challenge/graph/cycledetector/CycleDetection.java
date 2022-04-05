package com.mhsaeedi.code.challenge.graph.cycledetector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author : Momo
 * @since : 04.04.22, Mon
 **/
public class CycleDetection
{
	public static void main(String[] args)
	{
		Vertex a = new Vertex("A");
		Vertex b = new Vertex("B");
		Vertex c = new Vertex("C");
		Vertex d = new Vertex("D");
		Vertex e = new Vertex("E");
		Vertex f = new Vertex("F");

		d.addNeighbors(a,e);
		a.addNeighbors(c);
		c.addNeighbors(b, f);
		//e.addNeighbors(d);

		List<Vertex> graph = Arrays.asList(a, b, c, d, e, f);

		cycleCheck(d, new HashSet<>());

	}

	private static void cycleCheck(Vertex vertex, Set<String> visiting)
	{

		visiting.add(vertex.name);
		vertex.neighbors.stream().forEach(n-> {
			if(visiting.contains(n.name))
				throw new CycleDetectionException("Cycle detected at: " + vertex.name );
			cycleCheck(n,visiting);
		});

		System.out.println("Visit: " + vertex.name);

	}

}

class CycleDetectionException extends RuntimeException
{
	public CycleDetectionException(String message)
	{
		super(message);
	}

}

class Vertex
{
	public final String name;
	public final List<Vertex> neighbors;

	Vertex(String name)
	{
		this.name = name;
		this.neighbors = new ArrayList<>();
	}

	void addNeighbors(Vertex... vertexes)
	{
		neighbors.addAll(Arrays.asList(vertexes));
	}
}
