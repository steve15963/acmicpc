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
		int selectValue[] = new int[N+1];
		int map[][] = new int[N+1][N+1];
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N;i++) {
			value[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0 ; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int edgeCount = Integer.parseInt(st.nextToken());
			for(int j = 0; j < edgeCount; j++) {
				int X = Integer.parseInt(st.nextToken());
				map[i][X] = map[X][i] = 1;
			}
		}
		subSet(0,N,value,selectValue,1,map);
	}
	private static void subSet(int cnt,int N, int[] value, int[] selectValue, int index, int[][] map) {
		if(cnt == N) {
			for(int i = 0 ; i < index; i++) {
				System.out.print(selectValue[i]);
			}
		}
		selectValue[index] = value[cnt];
		subSet(cnt+1, N, value, selectValue, index+1, map);
		selectValue[index] = value[cnt];
		subSet(cnt+1, N, value, selectValue, index, map);
	}
	

}
