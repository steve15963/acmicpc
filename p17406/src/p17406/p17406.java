package p17406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p17406 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int map[][] = new int[R][C];
		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < C;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
	}

}
