package p16935;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p16935 {
	static void reverse(int map[][],int N,int M) {
		for(int i = 0; i < N / 2 ; i++) {
			int tmap[] = map[i];
			map[i] = map[N - i -1];
			map[N - i - 1] = tmap;
		}
	}
	static void mirror(int map[][],int N,int M) {
		for(int i = 0; i < N ; i++) {
			int tmap[] = new int[M];
			for(int j = 0 ; j < M; j++) {
				tmap[j] = map[i][ (M - 1) - j];
			}
			map[i] = tmap;
		}
	}
	static int[][] right(int map[][],int N,int M) {
		int tmap[][] = new int[M][N];
		for(int i = 0; i < N ; i++) {
			for(int j = 0; j < M; j++) {
				tmap[j][ (N - 1) - i] = map[i][j];
			}
		}
		return tmap;
	}
	static int[][] left(int map[][],int N,int M) {
		int tmap[][] = new int[M][N];
		for(int i = 0; i < N ; i++) {
			for(int j = 0; j < M; j++) {
				tmap[M - 1 - j][i] = map[i][j];
			}
		}
		return tmap;
	}
	
	static int[][][] arraySplite(int map[][],int N, int M) {
		int DN = N / 2;
		int DM = M / 2;
		int sliceMap[][][] = new int[4][DN][DM];
		for(int i = 0 ; i < DN; i++) {
			for(int j = 0 ; j < DM; j++) {
				sliceMap[0][i][j] = map[i][j];
			}
		}
		
		for(int i = 0 ; i < DN; i++) {
			for(int j = DM  ; j < M; j++) {
				sliceMap[1][i][j - DM] = map[i][j];
			}
		}
		
		for(int i = DN ; i < N; i++) {
			for(int j = DM ; j < M; j++) {
				sliceMap[2][i - DN][j - DM] = map[i][j];
			}
		}	
		
		for(int i = DN ; i < N; i++) {
			for(int j = 0; j < DM; j++) {
				sliceMap[3][i - DN][j] = map[i][j];
			}
		}
		
		
		return sliceMap;
	}
	
	static void arrayMerge(int sliceMap[][][],int map[][],int N, int M) {
		int DN = N / 2;
		int DM = M / 2;
		for(int i = 0 ; i < DN; i++) {
			for(int j = 0 ; j < DM; j++) {
				map[i][j] = sliceMap[0][i][j];
			}
		}
		
		for(int i = 0 ; i < DN; i++) {
			for(int j = DM  ; j < M; j++) {
				map[i][j] = sliceMap[1][i][j - DM];
			}
		}
		
		for(int i = DN ; i < N; i++) {
			for(int j = DM ; j < M; j++) {
				map[i][j] = sliceMap[2][i - DN][j - DM];
			}
		}
		
		for(int i = DN ; i < N; i++) {
			for(int j = 0; j < DM; j++) {
				map[i][j] = sliceMap[3][i - DN][j];
			}
		}
		return;
	}
	
	static void spliteRotate(int map[][],int N,int M) {
		int sliceMap[][][] = arraySplite(map, N, M);
		int tSplitMap[][] = sliceMap[0];
		sliceMap[0] = sliceMap[3];
		sliceMap[3] = sliceMap[2];
		sliceMap[2] = sliceMap[1];
		sliceMap[1] = tSplitMap;
		arrayMerge(sliceMap, map, N, M);
	}
	static void spliteCross(int map[][],int N,int M) {
		int sliceMap[][][] = arraySplite(map, N, M);
		int tSplitMap[][] = sliceMap[0];
		sliceMap[0] = sliceMap[1];
		sliceMap[1] = sliceMap[2];
		sliceMap[2] = sliceMap[3];
		sliceMap[3] = tSplitMap;
		arrayMerge(sliceMap, map, N, M);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String sData[] = br.readLine().split(" ");
		
		int N = Integer.parseInt(sData[0]);
		int M = Integer.parseInt(sData[1]);
		int R = Integer.parseInt(sData[2]);
		
		int map[][] = new int[N][M];
		
		for(int i = 0 ; i < N;i ++) {
			sData = br.readLine().split(" ");
			for(int j = 0 ; j < M; j++) {
				map[i][j] = Integer.parseInt(sData[j]);
			}
		}
		sData = br.readLine().split(" ");
		for(int i = 0 ; i< R;i++) {
			int t;
			switch (sData[i].charAt(0)) {
				case '1':
					reverse(map, N, M);
					break;
				case '2':
					mirror(map, N, M);
					break;
				case '3':
					map = right(map, N, M);
					t = N;
					N = M;
					M = t;
					break;
				case '4':
					map = left(map, N, M);
					t = N;
					N = M;
					M = t;
					break;
				case '5':
					spliteRotate(map, N, M);
					break;
				case '6':
					spliteCross(map, N, M);
					break;
			}
		}
		for(int[] ee:map) {
			for(int e:ee) {
				System.out.print(e + " ");
			}
			System.out.println();
		}
	}
}
