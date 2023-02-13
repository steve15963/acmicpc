package p1158;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class p1158 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("<");
		String sData[] = br.readLine().split(" ");
		
		
		int N = Integer.parseInt(sData[0]);
		int K = Integer.parseInt(sData[1]);
		
		Queue<Integer> que = new LinkedList<Integer>();
		// N���� �ο��� ��ŭ enqueue;
		for(int i = 1; i <= N; i++) {
			que.add(i);
		}
		//1���� ������ ����.
		while(que.size() > 1) {
			//K - 1���� ������.
			for(int j = 0; j < K - 1;j++) {
				que.add(que.poll());
			}
			// K��° ����� ���ۿ� �ִ´�.
			sb.append(que.poll()).append(", ");
		}
		//������ ���� ����� ���ۿ� �ְ�
		sb.append(que.poll()).append(">");
		//����Ѵ�.
		System.out.println(sb.toString());
	}
}
