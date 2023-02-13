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
		// N개의 인원수 만큼 enqueue;
		for(int i = 1; i <= N; i++) {
			que.add(i);
		}
		//1명이 남을때 까지.
		while(que.size() > 1) {
			//K - 1명을 돌리고.
			for(int j = 0; j < K - 1;j++) {
				que.add(que.poll());
			}
			// K번째 사람을 버퍼에 넣는다.
			sb.append(que.poll()).append(", ");
		}
		//마지막 남은 사람을 버퍼에 넣고
		sb.append(que.poll()).append(">");
		//출력한다.
		System.out.println(sb.toString());
	}
}
