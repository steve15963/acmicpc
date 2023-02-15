package p11286;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class p11286 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>(N, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				int a = Math.abs(o1);
				int b = Math.abs(o2);
				if( a > b) return 1;
				else if( a < b) return -1;
				else if( o1 > 0) return 1;
				else return -1;
//				if(a == b)
//					return o1 - o2;
//				return a - b;
			}
		});
		
		for(int i = 0 ; i< N;i++) {
			int X = Integer.parseInt(br.readLine());
			if(X != 0) {
				pq.add(X);
				continue;
			}
			if(pq.isEmpty())
				System.out.println(0);
			else
				System.out.println(pq.poll());
		}

	}

}
