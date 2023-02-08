package p15650;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p15650 {
	
	static int buffer[];
	
	public static void recall(int M,int N,int round, StringBuilder sb,int num) {
		//종료 조건
		if(N==round) {
			for(int i = 0; i < N; i++) {
				//선택된 수 버퍼의 데이터를 출력 버퍼로 이동
				sb.append(buffer[i]).append(" ");
			}
			// 출력이 끝났으므로 개행
			sb.append("\n");
			return;
		}
		//종료조건이 만족되지 않은 경우
		for(int i = 0; i < M;i++) {
			// 기존의 수보다 큰 경우
			if(i + 1 > num) {
				// 버퍼에 선택하여 넣고
				buffer[round] = i+1;
				// 재귀
				recall(M,N,round+1,sb,i+1);
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input[] = br.readLine().split(" ");
		
		StringBuilder sb = new StringBuilder();
		
		int M = Integer.parseInt(input[0]);
		int N = Integer.parseInt(input[1]);
		
		buffer = new int[N];
		
		recall(M,N,0,sb,0);
		System.out.println(sb.toString());
	}

}
