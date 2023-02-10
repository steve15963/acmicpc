package p2910;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class p2910 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String NC[] = br.readLine().split(" ");
		int N = Integer.parseInt(NC[0]);
		int C = Integer.parseInt(NC[1]);
		int visit[] = new int[C+1];
		LinkedList<Integer> index = new LinkedList<Integer>();
		index.add(0);
		Integer data[] = new Integer[N];
		String sData[] = br.readLine().split(" ");

		for(int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(sData[i]);
			if(visit[data[i]] == 0) {
				index.add(data[i]);
			}
			visit[data[i]]++;
		}
		Arrays.sort(data, (Integer d1,Integer d2)-> {
			if(visit[d2] > visit[d1]) 
				return 1;
			else if(visit[d2] < visit[d1]) 
				return -1;
			else if(index.indexOf(d2) < index.indexOf(d1))
				return 1;
			else if(index.indexOf(d2) > index.indexOf(d1))
				return -1;
			else
				return 0;
		});
		for(Integer element:data) {
			System.out.print(element + " ");
		}
	}
	
}
