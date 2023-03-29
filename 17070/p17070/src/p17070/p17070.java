package p17070;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class p17070 {
	static class Point{
		int x;
		int y;
		int d;
		public Point(int x, int y, int d) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
		}
		
	}

	static int dy[] = {0,1,1};
	static int dx[] = {1,1,0};
	
	static int angle[][]= {
			{0,1},
			{0,2},
			{1,2}
	};
	
	static int count = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int map[][] = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		DFS(map,N,1,0,0);
		System.out.println(count);

		count = 0;
		Queue<Point> queue = new ArrayDeque<>();
		
		queue.add(new Point(0,1,0));
		while(!queue.isEmpty()) {
			Point point = queue.poll();
			int x = point.x;
			int y = point.y;
			if(x == N-1 && y == N-1) {
				count++;
				continue;
			}
			int d = point.d;
			
			for(int i = angle[d][0] ; i <= angle[d][1]; i++) {
				int nextX = x + dx[i];
				int nextY = y + dy[i];
				if(
						isCan(nextX,nextY,N) &&
						isCollision(map,x,y,nextX,nextY,N,i)
				) {
					queue.add(new Point(nextX, nextY, i));
				}
			}
		}
		System.out.println(count);
		
		
		
	}
	
	private static void DFS(int[][] map, int n,int x, int y,int d) {
		//기저 조건
		if(x == n-1 && y == n-1) {
			count++;
			return;
		}
		//구현
		for(int i = angle[d][0] ; i <= angle[d][1]; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			if(
					isCan(nextX,nextY,n) &&
					isCollision(map,x,y,nextX,nextY,n,i)
			) {
				DFS(map, n, nextX, nextY, i);
			}
		}
	}
	private static boolean isCollision(int map[][],int x, int y,int nX,int nY,int n, int d) {
		if(d == 1) {
			for(int i = 0 ; i < 3; i++) {
				int nextX = x + dx[i];
				int nextY = y + dy[i];
				if(!isCan(nextX,nextY,n)) continue;
				if(map[nextY][nextX] == 1) return false;
			}
			return true;
		}
		else {
			if(map[nY][nX] == 0) return true;
			return false;
		}
	}

	private static boolean isCan(int x, int y, int n) {
		return 0 <= x && x < n && 0 <= y && y < n;
	}

}
