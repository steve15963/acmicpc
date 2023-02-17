package p16435;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p16435 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int fru[] = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N;i++) {
			fru[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(fru);
		
		for(int i = 0 ; i < N;i++) {
			if(fru[i] <= L) L++;
			else break;
		}
		System.out.println(L);
	}

}
