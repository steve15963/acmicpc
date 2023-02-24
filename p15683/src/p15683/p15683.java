package p15683;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p15683 {
	static int maximum = Integer.MIN_VALUE;
	static int seletedValue[];
	static class CCTV{
		int x;
		int y;
		int type;
		public CCTV(int x, int y, int type) {
			super();
			this.x = x;
			this.y = y;
			this.type = type;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int map[][] = new int[N][M];
		
		int wall = 0;
		
		ArrayList<CCTV> CCTVList = new ArrayList<>();
		
		for(int i = 0 ; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 6) {
					wall++;
				}else if(map[i][j] != 0)
					CCTVList.add(new CCTV(j,i,map[i][j]));
			}
		}
		int size = CCTVList.size();
		seletedValue = new int[size];
		DFS(0,CCTVList,size,map,N,M);
		System.out.println(N*M - maximum - wall);
	}

	private static void DFS(int cnt, ArrayList<CCTV> CCTVList,int size, int[][] map,int N, int M) {
		if(cnt == size) {
			int sum = 0;
			for(int i = 0; i < size; i++) {
				sum += seletedValue[i];
			}
			
//			for(int i = 0 ; i < N; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
//			System.out.println(sum);
//			System.out.println();
//			
//			
			maximum = Math.max(maximum, sum);
			return;
		}
		CCTV target = CCTVList.get(cnt);
		int type = target.type;
		
		int copyMap[][];
		
		if(type == 1) {
			for(int d = 0 ; d < 4; d++) {
				copyMap = new int[N][M];
				copy(map,copyMap,N,M);
				seletedValue[cnt] = draw1(copyMap,target.x,target.y,d,N,M);
				DFS(cnt+1, CCTVList, size, copyMap, N, M);
			}
		}else if(type == 2) {
			for(int d = 0 ; d < 2; d++) {
				copyMap = new int[N][M];
				copy(map,copyMap,N,M);
				seletedValue[cnt] = draw2(copyMap,target.x,target.y,d,N,M);
				DFS(cnt+1, CCTVList, size, copyMap, N, M);
			}
		}else if(type == 3) {
			for(int d = 0 ; d < 4; d++) {
				copyMap = new int[N][M];
				copy(map,copyMap,N,M);
				seletedValue[cnt] = draw3(copyMap,target.x,target.y,d,N,M);
				DFS(cnt+1, CCTVList, size, copyMap, N, M);
			}
		}else if(type == 4) {
			for(int d = 0 ; d < 4; d++) {
				copyMap = new int[N][M];
				copy(map,copyMap,N,M);
				seletedValue[cnt] = draw4(copyMap,target.x,target.y,d,N,M);
				DFS(cnt+1, CCTVList, size, copyMap, N, M);
			}
		}else if(type == 5) {
			for(int d = 0 ; d < 1; d++) {
				copyMap = new int[N][M];
				copy(map,copyMap,N,M);
				seletedValue[cnt] = draw5(copyMap,target.x,target.y,d,N,M);
				DFS(cnt+1, CCTVList, size, copyMap, N, M);
			}
		}
		
	}

	private static void copy(int[][] map, int[][] copyMap, int n, int m) {
		for(int i = 0; i < n; i++) {
			System.arraycopy(map[i], 0, copyMap[i], 0, m);
		}
	}

	private static int draw5(int map[][],int x, int y, int d, int n, int m) {
		int count = 0;
		if(d == 0) {
			count += topSum(map,x,y,n,m);
			count += bottomSum(map,x,y,n,m);
			count += leftSum(map,x,y,n,m);
			count += rightSum(map,x,y,n,m);
		}
		return count;
	}

	private static int draw4(int map[][],int x, int y, int d, int n, int m) {
		int count = 0;
		if(d == 0) {
			count += leftSum(map,x,y,n,m);
			count += topSum(map,x,y,n,m);
			count += rightSum(map,x,y,n,m);
		}else if(d == 1) {
			count += topSum(map,x,y,n,m);
			count += rightSum(map,x,y,n,m);
			count += bottomSum(map,x,y,n,m);
		}else if(d == 2) {
			count += rightSum(map,x,y,n,m);
			count += bottomSum(map,x,y,n,m);
			count += leftSum(map,x,y,n,m);
		}else if(d == 3) {
			count += bottomSum(map,x,y,n,m);
			count += leftSum(map,x,y,n,m);
			count += topSum(map,x,y,n,m);
		}
		return count;
	}

	private static int draw3(int map[][],int x, int y, int d, int n, int m) {
		int count = 0;
		if(d == 0) {
			count += topSum(map,x,y,n,m);
			count += rightSum(map,x,y,n,m);
		}else if(d == 1) {
			count += rightSum(map,x,y,n,m);
			count += bottomSum(map,x,y,n,m);
		}else if(d == 2) {
			count += bottomSum(map,x,y,n,m);
			count += leftSum(map,x,y,n,m);
		}else if(d == 3) {
			count += leftSum(map,x,y,n,m);
			count += topSum(map,x,y,n,m);
		}
		return count;
	}

	private static int draw2(int map[][],int x, int y, int d, int n, int m) {
		int count = 0;
		if(d == 0) {
			count += topSum(map,x,y,n,m);
			count += bottomSum(map,x,y,n,m);
		}else if(d == 1) {
			count += leftSum(map,x,y,n,m);
			count += rightSum(map,x,y,n,m);
		}
		return count;
	}

	// 상하 좌우
	private static int draw1(int map[][],int x, int y, int d, int n, int m) {
		int count = 0;
		if(d == 0) {
			count += topSum(map,x,y,n,m);
		}else if(d == 1) {
			count += bottomSum(map,x,y,n,m);
		}else if(d == 2) {
			count += leftSum(map,x,y,n,m);
		}else if(d == 3) {
			count += rightSum(map,x,y,n,m);
		}
		return count;
	}

	private static int rightSum(int map[][],int x, int y, int n, int m) {
		int count = 0;
		for(;x < m; x++) {
			if(map[y][x] == 6) break;
			else if(map[y][x] == 7)continue;
			map[y][x] = 7;
			count++;
		}
		return count;
	}

	private static int leftSum(int map[][],int x, int y, int n, int m) {
		int count = 0;
		for(;x >= 0; x--) {
			if(map[y][x] == 6) break;
			else if(map[y][x] == 7)continue;
			map[y][x] = 7;
			count++;
		}
		return count;
	}

	private static int bottomSum(int map[][],int x, int y, int n, int m) {
		int count = 0;
		for(;y < n; y++) {
			if(map[y][x] == 6) break;
			else if(map[y][x] == 7)continue;
			map[y][x] = 7;
			count++;
		}
		return count;
	}

	private static int topSum(int map[][],int x, int y, int n, int m) {
		int count = 0;
		for(;y >= 0; y--) {
			if(map[y][x] == 6) break;
			else if(map[y][x] == 7)continue;
			map[y][x] = 7;
			count++;
		}
		return count;
	}

}
