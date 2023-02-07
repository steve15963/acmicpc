package p11660;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p11660 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		String lengthS[] = br.readLine().split(" "); 
	
		int M = Integer.parseInt(lengthS[0]);
		int N = Integer.parseInt(lengthS[1]);
		int data[][] = new int[M + 1][M + 1];
		
		for(int i = 1;i<=M;i++) {
			int j = 1;
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			while(st.hasMoreTokens()) {
				data[i][j] = data[i][j-1] + Integer.parseInt(st.nextToken());
				j++;
			}
		}
		
		for(int i=0; i < N ;i++) {
			String test = br.readLine();
			String point[] = test.split(" ");
			int ax = Integer.parseInt(point[0]);
			int ay = Integer.parseInt(point[1]);
			int bx = Integer.parseInt(point[2]);
			int by = Integer.parseInt(point[3]);
			int sum = 0;
			for(int j = ay;j <= by;j++) {
				sum += data[j][bx] - data[j][ax];
			}
			sb.append(sum).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
