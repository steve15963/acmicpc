package p13023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class p13023 {
	static int answer = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
	
		//boolean RShip[][] = new boolean[N][N];
		
		LinkedList<Integer> RShip[] = new LinkedList[N];
        boolean visit[] = new boolean[N];
		for(int i = 0; i < N; i++) {
			RShip[i] = new LinkedList<Integer>();
		}
		
		for(int i = 0 ; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int	to = Integer.parseInt(st.nextToken());
			//RShip[from][to] = RShip[to][from] = true;
			RShip[from].add(to);
			RShip[to].add(from);
		}
		
		for(int i = 0; i < N; i++) {
			//boolean visit[] = new boolean[N];
			visit[i] = true;
			if(DFS(0,i,RShip,visit,N)) break;
            visit[i] = false;
		}
		
		System.out.println(answer);
		
	}
	private static boolean DFS(int cnt,int A, LinkedList<Integer> RShip[], boolean[] visit,int N) {
		if(cnt == N - 1) {
			answer = 1;
			return true;
		}
		for(Integer to : RShip[A]) {
			if(!visit[to]) {
				visit[to] = true;
				if(DFS(cnt + 1, to, RShip, visit, N)) return true;
				visit[to] = false;
			}
		}
//		for(int i = 0 ; i < N; i++) {
//			if(rShip[A][i] && !visit[i]) {
//				visit[i] = true;
//				if(DFS(cnt + 1, i, rShip, visit, N)) return true;
//				visit[i] = false;
//			}
//		}
		return false;
	}
}
