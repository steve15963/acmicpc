package p15650;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p15650 {
	
	static int buffer[];
	
	public static void recall(int M,int N,int round, StringBuilder sb,int num) {
		//���� ����
		if(N==round) {
			for(int i = 0; i < N; i++) {
				//���õ� �� ������ �����͸� ��� ���۷� �̵�
				sb.append(buffer[i]).append(" ");
			}
			// ����� �������Ƿ� ����
			sb.append("\n");
			return;
		}
		//���������� �������� ���� ���
		for(int i = 0; i < M;i++) {
			// ������ ������ ū ���
			if(i + 1 > num) {
				// ���ۿ� �����Ͽ� �ְ�
				buffer[round] = i+1;
				// ���
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
