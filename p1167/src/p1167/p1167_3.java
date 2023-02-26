package p1167;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p1167_3 {
	
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
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int V = Integer.parseInt(br.readLine());
		
		PriorityQueue<Node> graphList[] = new PriorityQueue[V+1];
		boolean visit[] = new boolean[V+1];
		int dijkstraValue[] = new int[V+1];
		
		
		
		for(int i = 0 ; i < V+1; i++) {
			graphList[i] = new PriorityQueue<Node>(Collections.reverseOrder());
		}
		
		
		for(int i = 1 ; i < V; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			while(st.hasMoreTokens()) {
				int to = Integer.parseInt(st.nextToken());
				if(to == -1) break;
				int value = Integer.parseInt(st.nextToken());
				graphList[from].add(new Node(to, value));
			}
		}
		for(int i = 1 ; i < V; i++) {
			DFS(dijkstraValue, graphList,visit, i, 0);
			for(int j = 0 ; j < V+1; j++) {
				dijkstraValue[j] = 0;
			}
		}
		System.out.println(maxSumValue);
	}
	//
	private static void DFS(int[] dijkstraValue, PriorityQueue<Node>[] graphList,boolean[] visit, int from, int sum) {
		if(visit[from]) return;
		dijkstraValue[from] = sum;
		visit[from]= true;
		maxSumValue = Math.max(maxSumValue, sum);
		for(Node node:graphList[from]) {
			int nextSum = sum + node.value;
			if(dijkstraValue[node.to] <= nextSum)
				DFS(dijkstraValue, graphList,visit, node.to, nextSum);
		}
		visit[from]= false;
	}
}
