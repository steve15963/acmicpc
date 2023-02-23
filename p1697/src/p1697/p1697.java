package p1697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p1697 {
	public static int answer = 0;
	public static boolean visit[] = new boolean[100001];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		BFS(N,K);
		System.out.println(answer);
	}
	public static void BFS(int N, int K) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(N);
		visit[N] = true;
		while(!queue.isEmpty()) {
			for(int i = 0, size = queue.size(); i < size; i++) {
				int nextN = queue.poll();
				if(nextN == K) {
					return;
				}
				if(nextN + 1 < 100001 && !visit[nextN + 1]) {
					visit[nextN+1] = true;
					queue.add(nextN + 1);
				}
				if(nextN - 1 >= 0 && !visit[nextN - 1]) {
					visit[nextN-1] = true;
					queue.add(nextN - 1);
					
				}
				if(nextN * 2 < 100001 && !visit[nextN * 2]) {
					visit[nextN*2] = true;
					queue.add(nextN * 2);
				}
			}
			answer++;
		}
	}
}
