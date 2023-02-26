package p1167;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p1167 {
	
	static class Node{
		int value;
		int to;
		public Node(int to, int value) {
			super();
			this.value = value;
			this.to =  to;
		}
		
	}
	
	static int maxSumValue = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int V = Integer.parseInt(br.readLine());
		
		ArrayList<Node> graphList[] = new ArrayList[V+1];
		boolean visit[] = new boolean[V+1];
		
		
		for(int i = 0 ; i < V+1; i++) {
			graphList[i] = new ArrayList<Node>();
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
		
		
		
		for(int i = 1 ; i < V+1; i++) {
			visit[i] = true;
			DFS(i,graphList,visit,0);
			visit[i] = false;
		}

		System.out.println(maxSumValue);
		
	}

	private static void DFS(int from, ArrayList<Node>[] graphList, boolean[] visit,int sum) {
		maxSumValue = Math.max(maxSumValue, sum);
		for(Node node:graphList[from]) {
			if(visit[node.to]) continue;
			visit[node.to] = true;
			DFS(node.to,graphList,visit,sum + node.value);
			visit[node.to] = false;
		}
	}

}
