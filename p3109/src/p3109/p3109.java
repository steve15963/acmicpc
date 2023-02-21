package p3109;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p3109 {
	static char map[][];
	static final int dy[] = {-1,0,1};
	static final int dx[] = { 1,1,1};
	static int answer = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(
						System.in
				)
		);
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		
		for(int i = 0 ; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		// 답을 찾으면 answer를 더함.
		for(int i=0; i < R; i++)
            if(DFS(i,0, R,C)) answer++;
		System.out.println(answer);
		
		
	}

	private static boolean DFS(int y, int x, int R, int C) {
//		System.out.println();
//		for(int j = 0 ; j < R; j++) {
//			System.out.println(Arrays.toString(map[j]));
//		}
		
		if(x == C - 1) {
			// 오른쪽 줄에 도착하면.
			return true;
		}
		for(int i = 0 ; i < 3; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			// 갈수 있고
			// 가지 않은 곳이라면
			if(isCan(ny,nx,R,C) && map[ny][nx] == '.') {
				// 더이상 가지말라고 x 체크
				map[ny][nx] = 'x';
				// 여러개 연결 시킬 필요가 없으므로.
				// 하나가 연결되었다면 return true
				if(DFS(ny, nx, R, C)) return true;
				// 실패하였다면 더 시도
			}
		}
		// 모두 시도후 실패
		return false;
	}

	private static boolean isCan(int ny, int nx, int r, int c) {
		return 0 <= ny && ny < r && 0 <= nx && nx < c;
	}
}
