package com.algorithms.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import ds.UnionFind;


class Triplet implements Comparable<Triplet>{
	int x;
	int y;
	int w;
	@Override
	public int compareTo(Triplet arg0) {
		// TODO Auto-generated method stub
		if(w<arg0.w)
			return -1;
		else if (w>arg0.w)
			return 1;
		else
			return new Integer(y).compareTo(arg0.y);
	}
	public Triplet(int x, int y, int w) {
		super();
		this.x = x;
		this.y = y;
		this.w = w;
	}
	
	
	
	
	
	
}


public class MinimumSpanningTree {
	public static List<Triplet> edgeList;
	public static int v;
	static int total=0;
	public static int kruskal() {
		UnionFind sets = new UnionFind(v);
		Collections.sort(edgeList);
		for(Triplet triple:edgeList) {
			if(sets.findSet(triple.x)!=sets.findSet(triple.y)) {
				total+=triple.w;
				sets.union(triple.x, triple.y);
			}
		}
		
		
		return total;
		
	}
	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		v=scanner.nextInt();
		edgeList=new ArrayList<>();
		int m=scanner.nextInt();
		for(int i=0;i<m;i++) {
			int x=scanner.nextInt()-1;
			int y=scanner.nextInt()-1;
			int w=scanner.nextInt();
			edgeList.add(new Triplet(x,y,w));
		}
		
		kruskal();
		System.out.println(total);
	}

}
