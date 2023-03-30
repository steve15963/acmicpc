package p4485;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class p4485 {
	
	static final int dy[] = {-1, 0, 1, 0};
	static final int dx[] = { 0, 1, 0,-1};
	
	static int maxMoney = 0;
	
	static class Point{
		int x;
		int y;
		int money;
		public Point(int x, int y, int money) {
			super();
			this.x = x;
			this.y = y;
			this.money = money;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int TC = 1 ;true;TC++) {
			int N = Integer.parseInt(br.readLine());
			if(N == 0) return;
			int map[][] = new int[N][N];
			boolean visit[][] = new boolean[N][N];
			for(int i = 0 ; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			maxMoney = 0;
			Stack<Point> DFS = new Stack<>();
			DFS.push(new Point(0,0,0));
			while(!DFS.isEmpty()) {
				Point target = DFS.pop();
				int x = target.x;
				int y = target.y;
				int money = target.money;
				
				//방문한 노드면. 
				if(visit[y][x]) continue;
				
				//방문하지 않았다면.
				visit[y][x] = true;
				
				//기저 조건
				if(x == N - 1 && y == N - 1) {
					maxMoney = Math.max(maxMoney, money);
					continue;
				}
				
				// 진행
				for(int i = 0 ; i < 4 ; i++) {
					int nextX = x + dx[i];
					int nextY = y + dy[i];
					if(isCan(N,nextX,nextY)) {
						DFS.push(new Point(nextX, nextY, money + map[nextY][nextX]));
					}
				}
				visit[y][x] = false;
			}
			System.out.printf("Problem %d: %d\n",TC,maxMoney);
		}
	}

	private static boolean isCan(int n, int nextX, int nextY) {
		return 0 <= nextX &&  nextX < n && 0 <= nextY && nextY < n;
	}

}
