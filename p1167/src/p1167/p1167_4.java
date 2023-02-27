package p1167;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p1167_4 {
	
	static class Node implements Comparable<Node>{
		int value;
		int to;
		public Node(int to, int value) {
			super();
			this.value = value;
			this.to =  to;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.value - o.value;
		}
		
		
	}
	
	static int maxSumValue = Integer.MIN_VALUE;
	static int maxIndex = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int V = Integer.parseInt(br.readLine());
		
		PriorityQueue<Node> graphList[] = new PriorityQueue[V+1];
		boolean visit[] = new boolean[V+1];
		
		
		for(int i = 0 ; i < V+1; i++) {
			graphList[i] = new PriorityQueue<Node>();
		}
		
		
		for(int i = 1 ; i <= V; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			while(st.hasMoreTokens()) {
				int to = Integer.parseInt(st.nextToken());
				if(to == -1) break;
				int value = Integer.parseInt(st.nextToken());
				graphList[from].add(new Node(to, value));
			}
		}
		
		DFS(1, graphList, visit, 0);
		maxSumValue = Integer.MIN_VALUE;
		DFS(maxIndex,graphList,visit,0);
		System.out.println(maxSumValue);
		
	}

	private static void DFS(int from, PriorityQueue<Node>[] graphList, boolean[] visit,int sum) {
		if(maxSumValue < sum) {
			maxSumValue = sum;
			maxIndex = from;
		}
		visit[from] = true;
		for(Node node:graphList[from]) {
			if(visit[node.to]) continue;
			DFS(node.to,graphList,visit,sum + node.value);
		}
		visit[from] = false;
	}
}
