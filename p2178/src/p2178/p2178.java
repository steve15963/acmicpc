package p2178;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

import java.io.IOException;

public class p2178 {
	static char map[][];
	static final int dy[] = {-1, 1, 0,0};
	static final int dx[] = { 0, 0,-1,1};
	static int answer = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(
						System.in
				)
		);
		StringTokenizer st = new StringTokenizer(
				br.readLine()
		);
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		
		for(int i = 0 ; i< N; i++) {
			map[i] = br.readLine()
					.toCharArray();
		}
		
		DFS(1,0,0,N,M);
		System.out.println(answer);

	}
	private static void DFS(int cnt,int y, int x, int n, int m) {
		
		if(y == n - 1 && x == m - 1) {
			answer = Math.min(answer, cnt);
			return;
		}
		for(int i = 0 ; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(isCan(ny,nx,n,m) && map[ny][nx] == '1') {
				map[ny][nx] = '0';
				DFS(cnt + 1, ny, nx, n, m);
				map[ny][nx] = '1';

			}
		}
		
		
	}
	private static boolean isCan(int ny, int nx, int n, int m) {
		return 0 <= ny && ny <n && 0 <= nx && nx < m; 
	}

}
