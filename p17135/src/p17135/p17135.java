package p17135;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p17135 {
	static boolean map[][];
	static boolean copyMap[][];
	static int selectedPosition[] = new int[3];
	static int N,M,D;
	static int maximumKillCount = -1;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(
				new InputStreamReader(
						System.in
				)
		);
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		map = new boolean[N][M];
		
		input(br);
		//select position
			//for(N)
				//killCount += kill(D);
				//move();
		selectPosition(0,0);
		System.out.println(maximumKillCount);

	}
	private static void selectPosition(int cnt,int start) {
		if(cnt == 3) {
			int killCount = 0;
			copyMap = new boolean[N][M];
			for(int i = 0; i < N;i++) {
				System.arraycopy(map[i], 0, copyMap[i], 0, M);
			}
			for(int i = 0 ; i < N; i++) {
				ArrayList<Point> killList = new ArrayList<Point>();
				for(int j = 0; j < 3; j++) {
					archerAiming(killList,selectedPosition[j]);
				}
				killCount += archerShoot(killList);
				
				for(int j = 0; j < N; j++) {
					System.out.println(Arrays.toString(copyMap[j]));
				}
				
				System.out.println();
				
				
				move();
			}
			//System.out.println(Arrays.toString(selectedPosition));
			//System.out.println(killCount);
			maximumKillCount = Math.max(maximumKillCount, killCount);
			return;
		}
		for(int i = start; i < M;i++ ) {
			selectedPosition[cnt] = i;
			selectPosition(cnt+1,i+1);
		}
	}
	private static int archerShoot(ArrayList<Point> killList) {
		int killCount = 0;
		for(Point target : killList) {
			int y = target.y;
			int x = target.x;
			if(copyMap[y][x]) {
				copyMap[y][x] = false;
				killCount++;
			}
		}
		return killCount;
	}
	private static void archerAiming(ArrayList<Point> killList,int archerIndex) {
		for(int i = 0 ; i < D; i++) {
			for(int j = 0; j < M; j++) {
				// i, j 몬스터 위치
				// 0, selectedPosition[archerIndex]
				if(copyMap[i][j] && i + Math.abs(j - archerIndex) + 1 <= D ) {
					killList.add(new Point(j,i));
					return;
				}
			}
		}
		
	}
	private static void move() {
		for(int i = 1; i < N;i++) {
			copyMap[i - 1] = copyMap[i];
		}
		copyMap[N - 1] = new boolean[M];
	}
	private static void input(BufferedReader br) throws IOException {
		for(int i = N - 1; i >= 0; i--) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = st.nextToken().equals("1")? true : false;
			}
		}
	}
}
