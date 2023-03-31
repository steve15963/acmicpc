package p4485;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p4485_dakistra {
	
	static final int dy[] = {-1, 0, 1, 0};
	static final int dx[] = { 0, 1, 0,-1};
	static int size = 0;
	
	static int startValue;
	
	static class Node implements Comparable<Node>{
	    int to, weight;

	    public Node(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}

		@Override
	    public int compareTo(Node o) {
	        return weight - o.weight;
	    }
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int TC = 1 ;true;TC++) {
			int N = Integer.parseInt(br.readLine());
			if(N == 0) return;
			size = N * N;
			
			List<Node> from[] = new ArrayList[size];
			for(int i = 0; i < size; i++){
				from[i] = new ArrayList<>();
	        }
			
			for(int i = 0 ; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j < N; j++) {
					int value = Integer.parseInt(st.nextToken());
					if(i == 0  && j == 0) startValue = value;
					// 4방 탐색
					for(int d = 0;  d < 4 ; d++) {
						int nextX = j + dx[d];
						int nextY = i + dy[d];
						
						//좌표가 가능하면
						if(isCan(N, nextX, nextY)) {
							//외부(nextY * N + nextX)에서
							//나에게 올 때(i * N + j).
							//값은 value가 든다.
							from[nextY * N + nextX].add( 
									new Node(
											i * N + j,
											value
									)
							);	
						}
					}
				}
			}
			int distance[] = dakistra(0,from,N);
			System.out.printf("Problem %d: %d\n",TC,distance[size - 1]);
		}
	}
	private static int[] dakistra(int start, List<Node>[] adjList,int N) {
		int distance[] = new int[N * N + 1];
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		//시작하자 마자 코인을 먹으므로.
		distance[0] = startValue;
		
		boolean[] visit = new boolean[size];
		PriorityQueue<Node> queue = new PriorityQueue<>();
		
		//start포인트에서 부터 시작하고
		//시작 지점이므로 가중치는 0이다.
		queue.add(new Node(start,0));
		
		while(!queue.isEmpty()) {
			//방문할 노드를 뽑는다.
			Node curNode = queue.poll();
			//다음 노드값을 받는다.
			int to = curNode.to;
			
			//만약 다음 노드가 방문한 노드라면 건너 뛰고.
			if(visit[to] == true) continue;
			//아니라면 마킹한다.
	        visit[to] = true;
			
	        //내가 방문한 노드의 간선을 얻어온다.
			for(Node node: adjList[to]) {
				// 내가 이전에 방문했던 길이와, 현재에서 다음 노드까지의 가중치중
				// 내가 이전에 방문했던 길이가 길다면. 값을 변경하겠다.
				if(distance[node.to] > distance[to] + node.weight) {
					//최신 값으로 갱신하고.
					distance[node.to] = distance[to] + node.weight;
					//해당 노드이후를 갱신한다.
					queue.add(new Node(node.to, distance[node.to]));
				}
			}
		}
		return distance;
	}
	private static boolean isCan(int n, int nextX, int nextY) {
		return 0 <= nextX &&  nextX < n && 0 <= nextY && nextY < n;
	}
}
