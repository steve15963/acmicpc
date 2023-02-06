package p1021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class p1021 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String NM[] = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);
		int data[] = new int[M];
		String data_temp[] = br.readLine().split(" ");
		for(int i = 0 ; i < M; i++) {
			data[i] = Integer.parseInt(data_temp[i]);
		}
		
		LinkedList<Integer> qu = new LinkedList<Integer>();
		for(int i = 1; i <= N ;i++) {
			qu.add(i);
		}
		int count  = 0;
		for(int i = 0; i < M ;i++) {
			int index = qu.indexOf(data[i]);
			if(index >= qu.size() / 2 ) {
				while(data[i] != qu.peek()) {
					qu.addFirst(qu.pollLast());
					count++;
				}
				qu.poll();
				//count++;
			}
			else {
				while(data[i] != qu.peek()) {
					qu.add(qu.poll());
					count++;
				}
				qu.poll();
				//count++;
			}
			
		}
		System.out.println(count);
	}

}
