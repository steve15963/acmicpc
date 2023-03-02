package p1753;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p1753 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int K = Integer.parseInt(st.nextToken());
		
		int adjMatrix[][] = new int[V+1][V+1];
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to   = Integer.parseInt(st.nextToken());
			int value= Integer.parseInt(st.nextToken());
			adjMatrix[from][to] = adjMatrix[to][from] = value;
		}
		
		int     distance[] = new int[V + 1];
		boolean visited [] = new boolean[V + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		distance[K] = 0;
		
		int min= 0,current = K;
		
		for(int i = 0; i < V; ++i) {
			// 다음으로 검색할 노드 찾기(그래서 최소 값을 찾기 위해 탐색)
			current = -1;
			min = Integer.MAX_VALUE;
			for(int j = 0; j < V; j++) {
				// 방문한적이 없고
				// 내 거리가 최소 거리보다 짧은경우 교환
				if(!visited[j]
					&& distance[j] < min) {
					min = distance[j];
					current = j;
				}
			}
			//방문할 노드가 없으므로 정지
			if(current == -1) break;
			
			// 방문한 것으로 간주하고 true
			visited[current] = true;
			
			for(int j = 0 ; j < V; j++) {
				if(!visited[j]
					&& adjMatrix[current][j] != 0
					&& distance[j] > min + adjMatrix[current][j]) {
					distance[j] = min + adjMatrix[current][j];
				}
			}
		}
		for(int i = 1 ; i <= V;i++) {
			System.out.print((distance[i] == Integer.MAX_VALUE ? "INF" : distance[i]) + " ");
		}
	}
}
