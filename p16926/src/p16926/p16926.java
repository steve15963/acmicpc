package p16926;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p16926 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String sData[] = br.readLine().split(" ");
		
		int y 		= Integer.parseInt(sData[0]);
		int x 		= Integer.parseInt(sData[1]);
		int round 	= Integer.parseInt(sData[2]);
		
		int map[][] = new int[y][x];
		
		
		for(int i = 0 ; i < y; i ++) {
			sData = br.readLine().split(" ");
			for(int j = 0; j <  x; j ++) {
				map[i][j] = Integer.parseInt(sData[j]);
			}
		}
		
	}

}
