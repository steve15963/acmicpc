package p2477;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p2477 {
	static int minX = Integer.MAX_VALUE;
	static int minY = Integer.MAX_VALUE;
	static int maxX = Integer.MIN_VALUE;
	static int maxY = Integer.MIN_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int x = 0;
		int y = 0;
		ArrayList<Point> al = new ArrayList<>();
		for(int i = 0 ; i < 6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int length = Integer.parseInt(st.nextToken());
			//©Л аб го ╩С
			if(d == 1) {
				x += length;
			}
			else if(d == 2) {
				x -= length;
			}
			else if(d == 3) {
				y += length;
			}
			else if(d == 4) {
				y -= length;
			}
			al.add(new Point(x,y));
			minX = Math.min(minX, x);
			minY = Math.min(minY, y);
			maxX = Math.max(maxX, x);
			maxY = Math.max(maxY, y);
		}
		Point target = null;
		for(Point t : al) {
			if(minX != t.x && maxX != t.x && minY != t.y && maxY != t.y) {
				target = t;
			}
		}
		
		boolean conor[] = new boolean[4];
		
		for(Point t : al) {
			if(minX == t.x && minY == t.y) {
				conor[0] = true;
			}
			else if(maxX == t.x && minY == t.y){
				conor[1] = true;
			}
			else if(minX == t.x && maxY == t.y){
				conor[2] = true;
			}
			else if(maxX == t.x && maxY == t.y){
				conor[3] = true;
			}
		}
		Point nonConor = null;
		int i = 0;
		for(; i < 4; i++) {
			if(!conor[i]) break;
		}
		
		if(i == 0) {
			nonConor = new Point(minX,minY);
		}
		else if(i == 1) {
			nonConor = new Point(maxX,minY);
		}
		else if(i == 2) {
			nonConor = new Point(minX,maxY);
		}
		else if(i == 3) {
			nonConor = new Point(maxX,maxY);
		}
		
		int xLength = Math.abs(target.x - nonConor.x);
		int yLength = Math.abs(target.y - nonConor.y);
		
		System.out.println(
				N * (
						(
								(maxX-minX) 
								* 
								(maxY-minY)
						)
						- 
						(xLength * yLength)
					)
				);
	}


}
