package p17136;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p17136 {
	static int ans = 0;
	static int count;
	static boolean flag;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		//1, 2, 3, 4, 5;
		int colorPaper[] = {0,5,5,5,5,5};
		
		int map[][] = new int[10][10];
		
		//입력
		for(int i = 0 ; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < 10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1)
					count++;
			}
		}
		if(count == 0) {
			System.out.println(0);
			return;
		}
		//입력 끝
		
		//처리
		//큰 색종이부터
		for(int length = 5; length >= 0; length--) {
			DFS(0,map,colorPaper,0,length);
			if(flag) break;
		}
		//처리 끝
		
		//출력
		System.out.println(ans);
		//출력 끝

	}
	private static void DFS(int cnt,int[][] map, int[] colorPaper, int start,int length) {
		// 색칠이 모두 되었다면 종료한다.
		if(count <= 0 || colorPaper[length] == 0) {
			flag = true;
			if(count != 0)
				ans = -1;
			return;
		}
		//해당 크기의 색종이가 남아 있는가?
		if(colorPaper[length] == 0) return; 
		
		//돌아가면서
		for(int i = start / 10; i < 10; i ++) {
			for(int j = start % 10; j < 10; j++) {
				//해당 위치가 구멍이라면
				if(map[i][j] == 1) {
					// 맵을 복사해서
					//int copyMap[][] = copy(map);
					
					// 색칠해본다.
					int status = paint(map,length,i,j);
					
					//색칠된 칸이 없다면 불가능 하므로 다음꺼로
					if(status == 0) continue;
					//색칠된 만큼 count에서 빼고.
					count -= status;
					ans++;

					
					//모두 색칠되지 않았다면. 진행.
					colorPaper[length]--;
					DFS(cnt + 1,map, colorPaper, (i * 10) + j + length,length);
					if(flag) return;
				}
			}
		}
	}
	private static int paint(int[][] map, int length, int y, int x) {
		
		if(length == 1) {
			if(map[y][x] == 1) {
				map[y][x] = 2;
				return 1;
			}
			return 0;
		}
		int maxX = x + length;
		int maxY = y + length;
		
		
		//범위가 넘어간 경우
		if(!isCan(maxX,maxY))
			return 0;
		
		
		//검색
		for(int i = y;i < maxY; i++) {
			for(int j = x;j < maxX; j++) {
				//1 = 구멍, 2 = 채운 색종이
				//즉 구멍이 아니면 채색 불가능.
				if(map[i][j] != 1)
					return 0;
			}
		}
		
		//채우기
		for(int i = y;i < maxY; i++) {
			for(int j = x;j < maxX; j++) {
				map[i][j] = 2;
			}
		}
		
		return length * length;
	}
	private static boolean isCan(int i, int j) {
		return 0 <= i && i <= 10 && 0 <= j && j <= 10;
	}


}
