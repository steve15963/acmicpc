package p2667;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.io.IOException;


public class p2667 {

	static int N;
	static char map[][];
	static int dy[] = {-1, 1, 0, 0};
	static int dx[] = { 0, 0,-1, 1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new char[N][N];
		
		
		
		for(int i = 0 ; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		ArrayList<Integer> dange = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0 ; j < N; j++) {
				if(map[i][j] == '1') {
					dange.add( BFS(i,j) );
				}
			}
		}
		
		Collections.sort(dange);
		StringBuilder sb = new StringBuilder().append(dange.size()).append("\n");
		for(Integer num:dange) {
			sb.append(num).append("\n");
		}
		System.out.println(sb.toString());

	}
	private static int BFS(int Y, int X) {
		ArrayDeque<Point> queue = new ArrayDeque<>();
		queue.add(new Point(X,Y));
		map[Y][X] = '2';
		int count = 1;
		while(!queue.isEmpty()) {
			Point target = queue.poll();
			for(int i = 0 ; i < 4; i++) {
				int nextY = target.y + dy[i];
				int nextX = target.x + dx[i];
				if(isCan(nextX,nextY) && map[nextY][nextX] == '1') {
					map[nextY][nextX] = '2';
					queue.add(new Point(nextX,nextY));
					count++;
				}
			}
			
		}
		return count;
	}
	private static boolean isCan(int X, int Y) {
		// TODO Auto-generated method stub
		return 0 <= X && X < N && 0 <= Y && Y < N;
	}


}
