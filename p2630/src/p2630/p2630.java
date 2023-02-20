package p2630;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2630 {
	
	public static int blue = 0;
	public static int white = 0;
	public static int map[][];
	
	public static void main(String arg[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i = 0; i < N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		cut(0,0,N);
		
		System.out.println(white);
		System.out.println(blue);
		
		
	}

	private static void cut(int r, int c, int size) {
		int half = size/2;
		int sum = 0;
		for(int i = r, rEnd = r + size; i < rEnd;i++) {
			for(int j = c, cEnd = c + size; j < cEnd;j++) {
				sum += map[i][j];
			}
		}
		
		if(sum == 0) white++;
		else if(sum == size*size) blue++;
		else {
			cut(r		, c			, half);
			cut(r		, c+half	, half);
			cut(r+half	, c			, half);
			cut(r+half	, c+half	, half);
		}
		
	}
}
