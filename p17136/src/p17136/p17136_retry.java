package p17136;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p17136_retry {
	static int ans = -1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		//1, 2, 3, 4, 5;
		int colorPaper[] = {0,5,5,5,5,5};
		
		int map[][] = new int[10][10];
		
		int hole = 0;
		//입력
		for(int i = 0 ; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < 10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1)
					hole++;
			}
		}
		if(hole == 0) {
			System.out.println(0);
			return;
		}
		//입력 끝
		
		//처리
		DFS(0,hole,map,colorPaper);
		//처리 끝
		
		//출력
		System.out.println(ans);
		//출력 끝

	}
	private static void DFS(int cnt, int hole, int[][] map,int colorPaper[]) {
		if(cnt == 25) {
			return;
		}
		if(hole == 0) {
			if(ans == - 1)
				ans = cnt;
			else {
				ans = Math.min(ans, cnt);
			}
			return;
		}
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				if(map[i][j] == 1) {
					for(int length = 5; length >= 0; length--) {
						if(colorPaper[length] == 0) { 
							continue;
						}
						if(isCanDraw(map,i,j,length)) {
							int copyMap[][] = copy(map);
							int block = Draw(copyMap,i,j,length);
							colorPaper[length]--;
							DFS(cnt+1, hole - block, copyMap, colorPaper);
							colorPaper[length]++;
						}
					}
					
					return;
				}
			}
		}
	}
	private static int Draw(int[][] map, int y, int x, int length) {
		if(length == 1) {
			if(map[y][x] == 1) {
				map[y][x] = 2;
				return 1;
			}
			return 0;
		}
		int maxX = x + length;
		int maxY = y + length;
		
		for(int i = y;i < maxY; i++) {
			for(int j = x;j < maxX; j++) {
				map[i][j] = 2;
			}
		}
		return length * length;
	}
	private static boolean isCanDraw(int[][] map, int y, int x, int length) {
		if(length == 1) {
			if(map[y][x] == 1)
				return true;
			return false;
		}
		
		int maxX = x + length;
		int maxY = y + length;
		
		
		//범위가 넘어간 경우
		if(!isCan(maxX,maxY))
			return false;
		
		
		//검색
		for(int i = y;i < maxY; i++) {
			for(int j = x;j < maxX; j++) {
				//1 = 구멍, 2 = 채운 색종이
				//즉 구멍이 아니면 채색 불가능.
				if(map[i][j] != 1)
					return false;
			}
		}
		return true;
	}
	
	private static boolean isCan(int i, int j) {
		return 0 <= i && i <= 10 && 0 <= j && j <= 10;
	}
	
	private static int[][] copy(int[][] map) {
		int copyMap[][] = new int[10][10];
		for(int i = 0 ; i < 10; i++) {
			System.arraycopy(map[i], 0, copyMap[i], 0, 10);
		}
		return copyMap;
	}
	
}
