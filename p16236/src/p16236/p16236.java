package p16236;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class p16236 {
	// 가장 처음에 아기 상어의 크기는 2
	// 아기 상어는 1초에 상하좌우로 인접한 한 칸씩 이동
	// 아기 상어는 자신의 크기보다 큰 물고기가 있는 칸은 지나갈 수 없고
	// 아기 상어는 자신의 크기보다 작은 물고기만 먹을 수 있다
	// 크기가 같은 물고기는 먹을 수 없지만, 그 물고기가 있는 칸은 지나갈 수 있다. 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int map[][] = new int[N][N];
		
		StringTokenizer st;
		
		Point shark = null;
		for(int i = 0 ; i < N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) shark = new Point(j,i);
			}
		}
		int time = 0;
		Point fish = null;
		int sharkSize = 2;
		while((fish = findFish(map,shark,sharkSize,N)) != null) {
			while(!eat(map,shark,fish)) {
				time++;
			}
		}

	}

	private static boolean eat(int[][] map, Point shark, Point fish) {
		// TODO Auto-generated method stub
		return false;
	}

	private static Point findFish(int[][] map, Point shark,int sharkSize,int N) {
		int dy[] = {-1, 0, 0, 1};
		int dx[] = { 0,-1, 1, 0};
		int x = shark.x;
		int y = shark.y;
		boolean visit[][] = new boolean[N][N];
		ArrayDeque<Point> queue = new ArrayDeque<>();
		queue.add(new Point(0,0));
		while(!queue.isEmpty()) {
			for(int i = 0 , qSize = queue.size(); i < qSize; i++) {
				Point target = queue.poll();
				int nextY = target.y + dy[i];
				int nextX = target.x + dx[i];
				if(isCan(nextX,nextY,N) && !visit[nextY][nextX]) {
					visit[nextY][nextX] = true;
					if(map[nextY][nextX] > sharkSize) return new Point(nextX,nextY);
					queue.add(new Point(nextX,nextY));
				}
			}
		}
		return null;
	}

	private static boolean isCan(int nextX, int nextY, int N) {
		return nextX >= 0 && nextX < N && nextY >= 0 && nextY < N;
	}

}
