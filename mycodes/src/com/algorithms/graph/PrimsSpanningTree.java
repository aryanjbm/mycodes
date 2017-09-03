package com.algorithms.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;


class Pair implements Comparable<Pair>{
	int y;
	int w;
	@Override
	public int compareTo(Pair arg0) {
		// TODO Auto-generated method stub
		if(w<arg0.w)
			return -1;
		else if (w>arg0.w)
			return 1;
		else
			return new Integer(y).compareTo(arg0.y);
	}
	public Pair(int y, int w) {
		super();
		
		this.y = y;
		this.w = w;
	}
	
	
	
	
	
	
}


public class PrimsSpanningTree {
	public static List<List<Pair>> graph;
	public static int visited[];
	public static long prims() {
		long total=0;
		Queue<Pair> queue =new PriorityQueue<>();
		queue.add(new Pair(0, 0));
	
		while(!queue.isEmpty()) {
			Pair x=queue.remove();
			if(visited[x.y]==0)
				continue;
			total+=x.w;
			visited[x.y]=0;
			for(int i=0;i<graph.get(x.y).size();i++) {
				Pair v=graph.get(x.y).get(i);
				if(visited[v.y]==-1) {
					queue.add(v);
				}
					
			}
			
			
		}
		
		
		return total;
		
	}
	
	
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		visited=new int[n];
		graph=new ArrayList<>();
		for(int i=0;i<n;i++) {
			graph.add(new ArrayList<>());
		}
		
		Arrays.fill(visited,-1);
		
		
		int m=scanner.nextInt();
		for(int i=0;i<m;i++) {
			int a=scanner.nextInt()-1;
			int b=scanner.nextInt()-1;
			int w=scanner.nextInt();
			graph.get(a).add(new Pair(b, w));
			graph.get(b).add(new Pair(a, w));
			
		}
		
		System.out.println(prims());
		
		
		
	}

}
