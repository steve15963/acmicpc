package p14235;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class p14235 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		for(int i = 0 ; i < N; i++) {
			String line[] =  br.readLine().split(" ");
			if(line.length == 1) {
				Integer answer = pq.poll();
				sb.append(answer == null ? -1 : answer).append("\n");
				continue;
			}
			for(int j = 1; j < line.length; j++) {
				pq.add(Integer.parseInt(line[j]));
			}
		}
		System.out.println(sb.toString());
	}

}
