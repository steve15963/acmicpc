package p2839;

import java.io.*;
import java.util.*;

public class p2839 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		int K5 = 0;
		int K3 = 0;
		
		for(K5 = N / 5; K5 >= 0; K5--) {
			if( ((N - (5 * K5)) % 3) == 0) {
				K3 = (N - (5 * K5)) / 3;
				break;
			}
		}
		
		System.out.println(K5 + K3 <= 0 ? - 1 : K5 + K3);
	}

}
