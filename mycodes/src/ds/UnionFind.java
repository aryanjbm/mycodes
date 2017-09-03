package ds;
public class UnionFind {
	private int[] arr;
	private int noOfSets;
	private int[] sizes;
	private int[] rank;
	public UnionFind(int size) {
		super();
		this.arr = new int[size];
		this.sizes=new int[size];
		this.rank=new int[size];
		for(int i=0;i<size;i++) {
			arr[i]=i;
			sizes[i]=1;
		}
		this.noOfSets = size;
	}
	
	public int findSet(int a) {
		while(arr[a]!=a) {
			return (arr[a]=this.findSet(arr[a]));
		}
		return a;
	}
	
	
	public boolean isSameSet(int a,int b) {
		return findSet(a)==findSet(b);
	}
	
	public void union(int a,int b) {
		int x=findSet(a);
		int y=findSet(b);
		
		if(x!=y) {
			
			noOfSets-=1;
			
			if(rank[x]>rank[y]) {
				arr[y]=x;
				sizes[x]+=sizes[y];
			}
			else {
				arr[x]=y;
				if(rank[x]==rank[y])
					rank[y]++;
				sizes[y]+=sizes[x];
			}
		}
	}

	
	public int getNoOFSets() {
		return noOfSets;
	}
	


}


