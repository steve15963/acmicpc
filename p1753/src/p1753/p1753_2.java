package p1753;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p1753_2{
	static class Node implements Comparable<Node>{
		int to;
		int value;
		public Node(int to, int value) {
			this.to = to;
			this.value = value;
		}
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.value, o.value);
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		
		ArrayList<Node> list[] = new ArrayList[V+1];
		
		for(int i = 0 ; i <= V; i++) {
			list[i] = new ArrayList<Node>();
		}
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to   = Integer.parseInt(st.nextToken());
			int value= Integer.parseInt(st.nextToken());
			list[from].add(new Node(to  ,value));
			//list[to  ].add(new Node(from,value));
		}
		
		PriorityQueue<Node> PQ = new PriorityQueue<Node>();
		int distance[] = new int[V+1];
		boolean visit[] = new boolean[V+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[1] = 0;
		PQ.add(new Node(K, distance[1]));
		while(!PQ.isEmpty()) {
			Node node = PQ.poll();
			int from = node.to;
			if(visit[from]) continue;
			visit[from] = true;
			for(Node nextFrom : list[from]) {
				int to = nextFrom.to;
				int nextValue = nextFrom.value;
				if( !visit[to] && 
					nextValue != 0 && 
					distance[to] > distance[from] + nextValue) {
					distance[to] = distance[from] + nextValue;
					PQ.add(new Node(to,distance[to]));
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i = 1 ; i <= V;i++) {
			sb.append(distance[i] == Integer.MAX_VALUE ? "INF" : distance[i]).append('\n');
		}
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}
}
