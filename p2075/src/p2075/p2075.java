package p2075;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p2075 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		for(int i = 0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			while(st.hasMoreTokens()) {
				pq.add(Integer.parseInt(st.nextToken()));
			}
		}
		for(int i = 0; i < N - 1; i++) pq.poll();
		System.out.println(pq.peek());
		/*
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		for(int i = 0;i<N;i++) {
			String inputS[] = br.readLine().split(" ");
			for(int j = 0; j < N; j++) {
				pq.add(Integer.parseInt(inputS[j]));
			}
		}
		for(int i = 0; i < N - 1; i++) pq.poll();
		System.out.println(pq.peek());
		*/
		/*
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Integer data[] = new Integer[N*N];
		for(int i = 0;i<N;i++) {
			String inputS[] = br.readLine().split(" ");
			for(int j = 0; j < N; j++) {
				data[(N * i) + j] = Integer.parseInt(inputS[j]);
			}
		}
		Arrays.sort(data,Collections.reverseOrder());
		System.out.println(data[N-1]);
		*/
	}
}
