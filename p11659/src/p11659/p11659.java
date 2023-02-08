package p11659;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p11659 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		String lengthS[] = br.readLine().split(" "); 
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int M = Integer.parseInt(lengthS[0]);
		int N = Integer.parseInt(lengthS[1]);
		int data[] = new int[M+1];
		data[0] = 0;
		int i = 1;
		//부분합 생성
		while(st.hasMoreTokens()) {
			data[i] = data[i-1] + Integer.parseInt(st.nextToken());
			i++;
		}
		
		for(int j=0; j < N ;j++) {
			String point[] = br.readLine().split(" ");
			int start = Integer.parseInt(point[0]) - 1;
			int end = Integer.parseInt(point[1]);
			//최대합 - 최소합 = 부분합
			sb.append(data[end] - data[start]).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
