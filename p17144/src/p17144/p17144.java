package p17144;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class p17144 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		int map[][] = new int[R][C];
		
		int divHeight = 0;
		
		for(int i = 0 ; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == -1) divHeight = i;
			}
		}
		int topMap[][]    = divMapTop(map,divHeight); 
		int bottomMap[][] = divMapBottom(map, divHeight,R);
		
		
		for(int time = 0; time < T; time++) {
			//expanse
			expanse(map,R,C);
			print(map,R,C);
			System.out.println();
			//move
			move(topMap,bottomMap,R,C,divHeight);
			print(map,R,C);
			System.out.println();
			
		}
		//sout(count);
		System.out.println(sum(map,R,C));
	}

	private static int sum(int[][] map, int Y, int X) {
		int sum = 0 ;
		for(int i = 0 ; i < Y; i++) {
			for(int j = 0; j < X; j++) {
				if(map[i][j] != -1)
					sum += map[i][j];
			}
		}
		return sum;
	}

	private static void move(int[][] topMap, int[][] bottomMap, int r, int c,int divHeight) {
		
		//start topMove
		topMove(topMap,divHeight,c);
		//end   end topMove
		
		//start bottoMmove
		bottomMove(bottomMap,r - divHeight,c);
		//end   end bottomMove
		
	}

	private static void topMove(int[][] topMap, int r, int c) {
		ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
		int dy[] = { 1, 0,-1, 0};
		int dx[] = { 0, 1, 0,-1};
		int d = 0;
		int nextY = 0;
		int nextX = 0;
		while(d < 4) {
			nextY += dy[d];
			nextX += dx[d];
			if(isCan(nextY,nextX,r,c) ) {
				if(topMap[nextY][nextX] != -1)
					queue.add(topMap[nextY][nextX]);
			}
			else {
				nextX -= dx[d];
				nextY -= dy[d];
				d++;
			}
		}
		
		d = 0;
		nextY = 1;
		nextX = 0;
		while(!queue.isEmpty()) {
			nextY += dy[d];
			nextX += dx[d];
			if(isCan(nextY,nextX,r,c)) {
				if(topMap[nextY][nextX] == -1) {
					queue.poll();
					queue.addFirst(0);
				}
				else {
					int t = queue.poll();
					topMap[nextY][nextX] = t;
				}
			}
			else {
				nextX -= dx[d];
				nextY -= dy[d];
				d = (d + 1) % 4;
			}
		}
	}
		

	private static void bottomMove(int[][] bottomMap, int r, int c) {
		Queue<Integer> queue = new ArrayDeque<Integer>();
		int dy[] = { 0, 1, 0,-1};
		int dx[] = { 1, 0,-1, 0};
		int d = 0;
		int nextY = 0;
		int nextX = 0;
		while(d < 4) {
			nextY += dy[d];
			nextX += dx[d];
			
		
			if(isCan(nextY,nextX,r,c)) {
				if(bottomMap[nextY][nextX] != -1)
					queue.add(bottomMap[nextY][nextX]);
			}
			else {
				nextX -= dx[d];
				nextY -= dy[d];
				d++;
			}
		}
		
		d = 0;
		nextY = 0;
		nextX = 1;
		while(!queue.isEmpty()) {
			nextY += dy[d];
			nextX += dx[d];
			if(isCan(nextY,nextX,r,c)) {
				if(bottomMap[nextY][nextX] == -1) {
					queue.poll();
					queue.add(0);
				}
				else {
					int t = queue.poll();
					bottomMap[nextY][nextX] = t;
				}
			}
			else {
				nextX -= dx[d];
				nextY -= dy[d];
				d = (d + 1) % 4;
			}
		}
	}

	private static int[][] divMapTop(int[][] map,int divHeight) {
		int topMap[][] = new int[divHeight][];
		for(int i = 0 ; i < divHeight; i++) {
			topMap[i] = map[i];
		}
		return topMap;
	}
	private static int[][] divMapBottom(int[][] map,int divHeight,int R) {
		int bottomMap[][] = new int[R - divHeight][];
		for(int i = divHeight ; i < R; i++) {
			bottomMap[i - divHeight] = map[i];
		}
		return bottomMap;
	}

	private static void print(int[][] map, int Y, int X) {
		
		for(int i = 0 ; i < Y; i++) {
			for(int j = 0; j < X; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}

	private static void expanse(int[][] map, int Y, int X) {
		int tempMap[][] = new int[Y][X];
		int dy[] = {-1, 1, 0, 0};
		int dx[] = { 0, 0,-1, 1};
		for(int i = 0 ; i < Y; i++) {
			for(int j = 0; j < X; j++) {
				if(map[i][j] != 0) {
					int d5Value = map[i][j] / 5;
					int count = 0;
					for(int d = 0; d < 4; d++) {
						int nextY = i + dy[d];
						int nextX = j + dx[d];
						if(isCan(nextY,nextX,Y,X) && map[nextY][nextX] != -1) {
							tempMap[nextY][nextX] += d5Value;
							count++;
						}
					}
					map[i][j] = map[i][j] - (d5Value * count);
				}
			}
		}
		for(int i = 0 ; i < Y; i++) {
			for(int j = 0; j < X; j++) {
				map[i][j] += tempMap[i][j];
			}
		}
	}

	private static boolean isCan(int nextY, int nextX, int Y, int X) {
		// TODO Auto-generated method stub
		return 0 <= nextY && nextY < Y && 0 <= nextX && nextX < X;
	}
}
