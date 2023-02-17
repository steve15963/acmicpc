package p17406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p17406 {

	public static void main(String[] args) throws IOException {
		
		final int dy[] = {1,0,-1,0};
		final int dx[] = {0,1,0,-1};
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int K = Integer.parseInt(st.nextToken());
		
		int map[][] = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int S = Integer.parseInt(st.nextToken());
			/*
			  	가장 왼쪽 윗 칸이 (r-s, c-s),
				가장 오른쪽 아랫 칸이 (r+s, c+s)인 정사각형을
				시계 방향으로 한 칸씩 돌린다는 의미
			 */
			
			int mode = 0;
			
			// 배열이 0부터 시작하므로 -1함
			int leftTopY = R - S - 1;
			int leftTopX = C - S - 1;
			int rightBottomY = R + S - 1;
			int rightBottomX = C + S - 1;
			
			
			//가로변 *2 +  새로변 * 2 = 길이
			//중복되는것도 있으나 방향 전환 회수와 일치하므로 그냥 진행.
			int round = ((rightBottomX - leftTopX) * 2 )+ ((rightBottomY - leftTopY) * 2);
			
			int x = leftTopX;
			int y = leftTopY;
			
			int nextX;
			int nextY;
			
			int temp = map[y][x];
			
			while(round-- >= 0) {
				nextX = x + dx[mode];
				nextY = y + dy[mode];
				if(
						nextY < leftTopY &&
						nextY > rightBottomY &&
						nextX < leftTopX &&
						nextX > rightBottomX
				) {
					mode++;
					continue;
				}
				temp = map[nextY][nextX];
				map[nextY][nextX] = map[y][x];
			}
			map[leftTopY][leftTopX] = temp;
			for(int j = 0; j < N; j++) {
				for(int k = 0; k < M; k++) {
					System.out.print(map[j][k] + " ");
				}
				System.out.println();
			}
			System.out.println();
		}
	}
}
