package p2910;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class p2910 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String NC[] = br.readLine().split(" ");
		int N = Integer.parseInt(NC[0]);
		int C = Integer.parseInt(NC[1]);
		LinkedList<Integer> LL = new LinkedList<Integer>();
		LinkedHashMap<Integer, Integer> hm = new LinkedHashMap<Integer,Integer>();
		String sData[] = br.readLine().split(" ");
		for(int i = 0; i < N; i++) {
			Integer t = Integer.parseInt(sData[i]);
			LL.add(t);
			hm.put(t,i);
		}
		ArrayList<Integer> keyList = new ArrayList<Integer>(hm.keySet());
		Arrays.sort(LL,(Integer i1,Integer i2) -> {
			return 1;
		});
		for(Integer test:keyList) {
			System.out.print(test + " ");
		}
	}
}
