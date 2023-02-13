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
		for(int i = 1; i <= N; i++) {
			que.add(i);
		}
		
		while(que.size() > 1) {
			for(int j = 0; j < K - 1;j++) {
				que.add(que.poll());
			}
			sb.append(que.poll()).append(", ");
		}
		sb.append(que.poll()).append(">");
		System.out.println(sb.toString());
	}
}
