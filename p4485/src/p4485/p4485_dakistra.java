package p4485;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p4485_dakistra {
	
	static class Node implements Comparable<Node>{
	    int end, weight;

	    public Node(int end, int weight){
	        this.end = end;
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
			int size = N * N;
			
			List<Node> adjList[] = new ArrayList[size ];
			for(int i = 0; i < size; i++){
				adjList[i] = new ArrayList<>();
	        }
			
			for(int i = 0 ; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j < N; j++) {
					for(int k = 0 ; k < 4; k ++) {
						
					}
					
					//map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
		}
	}
	private static boolean isCan(int n, int nextX, int nextY) {
		return 0 <= nextX &&  nextX < n && 0 <= nextY && nextY < n;
	}
}
