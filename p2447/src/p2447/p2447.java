package p2447;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2447 {
	static boolean map[][];
	static StringBuilder sb;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new boolean[N][N];
		sb = new StringBuilder();
		recall(0,0,N);
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				sb.append(map[i][j] ? '*' :' ');
			}
			sb.append('\n');
		}
		System.out.println(sb.toString());
	}

	private static void recall(int y, int x, int size) {
		if(size == 1) {
			map[y][x] = true;
//			map[y][x+1] = '*';
//			map[y][x+2] = '*';
//			map[y+1][x] ='*';
//			map[y+1][x+2] = '*';
//			map[y+2][x] = '*';
//			map[y+2][x+1] = '*';
//			map[y+2][x+2] = '*';
			return;
		}
		int sizeD3 = size / 3;
		recall(y				, x					, sizeD3);
		recall(y				, x + sizeD3		, sizeD3);
		recall(y				, x + sizeD3 * 2	, sizeD3);
		recall(y + sizeD3		, x					, sizeD3);
		// 중앙값은 콜 금지.
		recall(y + sizeD3		, x + sizeD3 * 2	, sizeD3);
		recall(y + sizeD3 * 2	, x					, sizeD3);
		recall(y + sizeD3 * 2	, x + sizeD3		, sizeD3);
		recall(y + sizeD3 * 2	, x + sizeD3 * 2	, sizeD3);
		return;
	}
}
