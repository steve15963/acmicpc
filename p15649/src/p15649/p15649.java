package p15649;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p15649 {
	
	static boolean visit[];
	static int buffer[];
	
	public static void recall(int M,int N,int round, StringBuilder sb) {
		if(N==round) {
			for(int i = 0; i < N; i++) {
				sb.append(buffer[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for(int i = 0; i < M;i++) {
			if( !visit[i]) {
				visit[i] = true;
				buffer[round] = i+1;
				recall(M,N,round+1,sb);
				visit[i] = false;
			}
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input[] = br.readLine().split(" ");
		
		StringBuilder sb = new StringBuilder();
		
		int M = Integer.parseInt(input[0]);
		int N = Integer.parseInt(input[1]);
		
		visit = new boolean[M];
		buffer = new int[N];
		
		recall(M,N,0,sb);
		System.out.println(sb.toString());
	}

}
