package p17070;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p17070 {
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
		
		//DFS 경로 추적
		DFS(map,N,1,0,0);
		System.out.println(count);
	}
	
	private static void DFS(int[][] map, int n,int x, int y,int d) {
		//기저 조건
		if(x == n-1 && y == n-1) {
			// 도착하면 카운트하고 종료
			count++;
			return;
		}
		//구현
		//방향에 따라서 angle의 범위만큼만 스캔.
		for(int i = angle[d][0] ; i <= angle[d][1]; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			if(
					// 가능한 좌표인지.
					isCan(nextX,nextY,n) &&
					// 가능한 좌표라면 충돌되는 벽이 없는지 검사
					isCollision(map,x,y,nextX,nextY,n,i)
			) {
				//가능한 좌표이면서 충돌하는 벽이 없다면 이동.
				DFS(map, n, nextX, nextY, i);
			}
		}
	}
	private static boolean isCollision(int map[][],int x, int y,int nX,int nY,int n, int d) {
		// 대각선 이동이라면 3개의 좌표를 모두 검사.
		if(d == 1) {
			for(int i = 0 ; i < 3; i++) {
				int nextX = x + dx[i];
				int nextY = y + dy[i];
				// 불가능한 좌표라면 다음 검사
				if(!isCan(nextX,nextY,n)) continue;
				// 벽이 있다면 false리턴
				if(map[nextY][nextX] == 1) return false;
			}
			//모두 통과시 true 리턴
			return true;
		}
		else {
			if(map[nY][nX] == 0) return true;
			return false;
		}
	}

	private static boolean isCan(int x, int y, int n) {
		// 좌표 유효성 검사.
		return 0 <= x && x < n && 0 <= y && y < n;
	}

}
