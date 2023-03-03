package p7576;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class p7576 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int map[][] = new int[N][M];
		
		
		ArrayDeque<Point> queue = new ArrayDeque<>();
		
		
		int emptyCount = 0;
		
		for(int i = 0 ; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) queue.add(new Point(j,i));
				else if(map[i][j] == -1) emptyCount++;
			}
		}
		int startCount = queue.size();
		int dy[] = {-1, 1, 0, 0};
		int dx[] = { 0, 0,-1, 1};
		
		int round = 0;
		while(!queue.isEmpty()) {
			for(int i = 0, size = queue.size(); i< size; i++) {
				Point tomato = queue.poll();
				for(int j = 0; j < 4; j++) {
					int nextY = tomato.y + dy[j];
					int nextX = tomato.x + dx[j];
					if(isCan(nextX,nextY,M,N) && map[nextY][nextX] == 0) {
						map[nextY][nextX] = 1;
						queue.add(new Point(nextX,nextY));
						startCount++;
					}
				}
			}
			round++;
			print(map);
			System.out.println();
		}
		if(((M * N) - emptyCount) == startCount) System.out.println(round-1);
		else System.out.println(-1);
	}

	private static void print(int[][] map) {
		for(int i = 0 ; i < map.length;i++) {
			for(int j = 0 ; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		
	}

	private static boolean isCan(int nextX, int nextY,int M, int N) {
		
		return 0 <= nextX && nextX < M && 0 <= nextY && nextY < N;
	}

}
