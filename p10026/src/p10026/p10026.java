package p10026;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class p10026 {
	static final int dy[] = {-1, 1, 0, 0};
	static final int dx[] = { 0, 0,-1, 1};
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		char map[][] = new char[N][N];
		boolean visit[][] = new boolean[N][N];
		
		for(int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		int COLOR[] = new int[3];

		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visit[i][j]) {
					BFS(new Point(j,i),map,visit);
					if(map[i][j] == 'R') COLOR[0] ++;
					else if(map[i][j] == 'G') COLOR[1] ++;
					else if(map[i][j] == 'B') COLOR[2] ++;
				}
			}
		}
		int totalColor = COLOR[0] + COLOR[1] + COLOR[2];
		
		visit = new boolean[N][N];
		int weekCOLOR[] = new int[2];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visit[i][j]) {
					weekBFS(new Point(j,i),map,visit);
					if(map[i][j] == 'R') weekCOLOR[0] ++;
					else if(map[i][j] == 'G') weekCOLOR[0] ++;
					else if(map[i][j] == 'B') weekCOLOR[1] ++;
				}
			}
		}
		
		
		int weekTotalColor = weekCOLOR[0] + weekCOLOR[1];
		System.out.println(totalColor + " " + weekTotalColor);

	}

	private static void BFS(Point startPoint, char[][] map, boolean[][] visit) {
		Queue<Point> queue = new ArrayDeque<>();
		queue.add(startPoint);
		visit[startPoint.y][startPoint.x] = true;
		while(!queue.isEmpty()) {
			Point target = queue.poll();
			for(int d = 0 ; d < 4; d++) {
				int nextY = target.y + dy[d];
				int nextX = target.x + dx[d];
				if(isCan(nextY,nextX) 
						&& !visit[nextY][nextX] 
						&& map[startPoint.y][startPoint.x] == map[nextY][nextX]) {
					queue.add(new Point(nextX,nextY));
					visit[nextY][nextX] = true;
				}
			}
		}
	}
	
	private static void weekBFS(Point startPoint, char[][] map, boolean[][] visit) {
		Queue<Point> queue = new ArrayDeque<>();
		queue.add(startPoint);
		visit[startPoint.y][startPoint.x] = true;
		if(map[startPoint.y][startPoint.x] == 'B') {
			while(!queue.isEmpty()) {
				Point target = queue.poll();
				for(int d = 0 ; d < 4; d++) {
					int nextY = target.y + dy[d];
					int nextX = target.x + dx[d];
					if(isCan(nextY,nextX) 
							&& !visit[nextY][nextX] 
							&& map[nextY][nextX] == 'B') {
						queue.add(new Point(nextX,nextY));
						visit[nextY][nextX] = true;
					}
				}
			}
		}
		else {
			while(!queue.isEmpty()) {
				Point target = queue.poll();
				for(int d = 0 ; d < 4; d++) {
					int nextY = target.y + dy[d];
					int nextX = target.x + dx[d];
					if(isCan(nextY,nextX) 
							&& !visit[nextY][nextX] 
							&& map[nextY][nextX] != 'B') {
						queue.add(new Point(nextX,nextY));
						visit[nextY][nextX] = true;
					}
				}
			}
		}
	}
	
	

	private static boolean isCan(int nextY, int nextX) {
		return 0 <= nextY && nextY < N & 0 <= nextX && nextX < N;
	}

}
