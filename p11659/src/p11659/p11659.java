package p11659;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p11659 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String lengthS[] = br.readLine().split(" "); 
		String datas[] = br.readLine().split(" ");
		int data[] = new int[datas.length+1];
		int M = Integer.parseInt(lengthS[0]);
		int N = Integer.parseInt(lengthS[1]);
		data[0] = 0;
		for(int i=1; i <= M ;i++) {
			data[i] = data[i-1] + Integer.parseInt(datas[i-1]);
		}
		
		for(int i=0; i < N ;i++) {
			String point[] = br.readLine().split(" ");
			int start = Integer.parseInt(point[0]) - 1;
			int end = Integer.parseInt(point[1]);

			System.out.println(data[end] - data[start]);
		}
	}
}
