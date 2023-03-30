package p14502;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class p14502 {
	static final int ny[] = {-1, 0, 1, 0};
	static final int nx[] = { 0, 1, 0,-1};
	
	static int safeZone = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		int map[][] = new int[R][C];
		
		List<Point> virusList = new ArrayList<Point>();
		
		for(int i = 0 ; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2)
					virusList.add(new Point(j,i));
			}
		}
		DrawWall(R,C,map,virusList,0,0);
		System.out.println(safeZone);
	}

	private static void DrawWall(int R, int C, int[][] map,List<Point> virusList, int cnt, int start) {
		if(cnt == 3) {
			int copyMap[][] = new int[R][C];
			for(int i = 0 ; i < R; i++) {
				System.arraycopy(map[i], 0, copyMap[i], 0, C);
			}
			safeZone = Math.max(safeZone,ExpandVirus(R,C,copyMap,virusList));
			return;
		}
		for(int i = start ; i < R * C; i++) {
			if(map[ i / C][ i % C ] == 0) {
				map[ i / C][ i % C ] = 1;
				DrawWall(R, C, map,virusList, cnt + 1, i);
				map[ i / C][ i % C ] = 0;
 			}
		}
	}
	private static int ExpandVirus(int r, int c, int[][] map,List<Point> virusList) {
		Queue<Point> ExpandVirusList = new ArrayDeque<>(virusList);
		while(!ExpandVirusList.isEmpty()) {
			Point target = ExpandVirusList.poll();
			int x = target.x;
			int y = target.y;
			for(int i = 0 ; i < 4; i++) {
				int nextX = x + nx[i];
				int nextY = y + ny[i];
				if(isCan(r,c,nextY,nextX) && map[nextY][nextX] == 0) {
					map[nextY][nextX] = 3;
					ExpandVirusList.add(new Point(nextX,nextY));
				}
			}
		}
		int count = 0;
		for(int i = 0 ; i < r; i++) {
			for(int j = 0 ; j < c;j++) {
				if(map[i][j] == 0) 
					count++;
			}
		}
		return count;
	}
	private static boolean isCan(int r, int c, int y, int x) {
		return 0 <= y && y < r && 0 <= x && x < c;
	}
}
