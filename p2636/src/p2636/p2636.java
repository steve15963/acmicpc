package p2636;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class p2636 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int height = Integer.parseInt(st.nextToken());
		int width  = Integer.parseInt(st.nextToken());
		
		int map[][] = new int[height][width];
		
		for(int i = 0 ; i < height;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < width; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int time = 2;
		int oldCount = 0;
		int newCount =0;
		while((newCount = findCheese(map,height,width,time)) > 0) {
			time++;
			oldCount = newCount;
		}
		System.out.println(time - 2);
		System.out.println(oldCount);
	}

	private static int findCheese(int[][] map,int height, int width, int round) {
		boolean visit[][] = new boolean[height][width];
		int dy[] = {-1, 1, 0, 0};
		int dx[] = { 0, 0,-1, 1};
		int count = 0;
		ArrayDeque<Point> queue = new ArrayDeque<>();
		queue.add(new Point(0,0));
		while(!queue.isEmpty()) {
			Point target = queue.poll();
			for(int i = 0 ; i < 4;i++) {
				int nextY = target.y + dy[i];
				int nextX = target.x + dx[i];
				if(isCan(nextX,nextY,height,width) && !visit[nextY][nextX]) {
					visit[nextY][nextX] = true;
					if(map[nextY][nextX] == 1) {
						map[nextY][nextX] = round;
						count++;
					}
					else queue.add(new Point(nextX,nextY));
				}
			}
		}
		return count;
	}

	private static boolean isCan(int nextX, int nextY, int height, int width) {
		return nextX >= 0 && nextX <width && nextY >= 0 && nextY < height;
	}
}
