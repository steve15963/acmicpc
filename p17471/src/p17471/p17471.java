package p17471;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p17471 {
	static int minimum = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int value[] = new int[N+1];
		boolean selected[] = new boolean[N+1];
		int map[][] = new int[N+1][N+1];
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N;i++) {
			value[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 1 ; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int edgeCount = Integer.parseInt(st.nextToken());
			for(int j = 0; j < edgeCount; j++) {
				int X = Integer.parseInt(st.nextToken());
				map[i][X] = map[X][i] = 1;
			}
		}
		subSet(0,0,N,value,selected,map);
	}
	private static void subSet(int cnt,int index, int N, int[] value, boolean selected[], int[][] map) {
		if(cnt == N) {
			if(DFS(from, map,value,selected,N)) return;
			if(DFS(from, map,value,selected,N)) return;
			
			
			int selectSum = 0;
			int nonSelectSum = 0;
			
			for(int i = 0 ; i <= N ; i++) {
				
			}
			System.out.println();
			return;
		}
		selected[cnt] = true;
		subSet(cnt+1,index+1, N, value, selected, map);
		selected[cnt] = false;
		subSet(cnt+1,index  , N, value, selected, map);
	}
	

}
