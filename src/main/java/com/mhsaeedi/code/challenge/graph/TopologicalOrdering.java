package com.mhsaeedi.code.challenge.graph;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author : Momo
 * @since : 04.04.22, Mon
 **/
public class TopologicalOrdering
{
	public static void main(String[] args){
		Vertex a = new Vertex("A");
		Vertex b = new Vertex("B");
		Vertex c = new Vertex("C");
		Vertex d = new Vertex("D");
		Vertex e = new Vertex("E");
		Vertex f = new Vertex("F");
		Vertex g = new Vertex("G");
		Vertex h = new Vertex("H");
		Vertex i = new Vertex("I");
		Vertex j = new Vertex("J");

		a.addNeighbors(b,f);
		b.addNeighbors(h);
		d.addNeighbors(c,i,e);
		e.addNeighbors(i);
		g.addNeighbors(a,b,c);
		i.addNeighbors(c);
		j.addNeighbors(e);

		List<Vertex> graph = new ArrayList<>();
		graph.add(a);
		graph.add(b);
		graph.add(c);
		graph.add(d);
		graph.add(e);
		graph.add(f);
		graph.add(g);
		graph.add(h);
		graph.add(i);
		graph.add(j);

		Deque<Vertex> ordered = sort(graph);
		while(!ordered.isEmpty())
			System.out.println(ordered.pop());


	}

	private static Deque<Vertex> sort(List<Vertex> graph){
		Deque<Vertex> stack = new LinkedList<>();
		graph.stream().filter(n->!n.isVisited()).forEach(n->visit(stack, n));
		return stack;
	}

	private static void visit(Deque<Vertex> stack, Vertex v){
		v.setVisited(true);
		v.neighbors.stream().filter(n->!n.isVisited()).forEach(n -> visit(stack,n));
		stack.push(v);
	}


}


class Vertex {
	public final String name;
	public final List<Vertex> neighbors;
	private boolean visited;
	public Vertex(String name){
		this.name = name;
		this.neighbors = new ArrayList<>();
		visited =false;
	}
	public void setVisited(boolean visited){
		this.visited = visited;
	}

	public boolean isVisited(){
		return visited;
	}

	@Override
	public String toString(){
		return "(" + name + ", " + visited + ")";
	}



	public void addNeighbors(Vertex... vertexes){
		neighbors.addAll(Stream.of(vertexes).collect(Collectors.toList()));
	}
}
