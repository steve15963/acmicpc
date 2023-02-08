package p2961;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2961 {
	public static int round;
	public static int sin[];
	public static int ssun[];
	
	public static boolean visit[];
	
	public static int min = Integer.MAX_VALUE;
	public static void recall(int cnt, int sinTotal, int ssunTotal) {
		if(round == cnt) {
			return;
		}
		for(int i = 0; i < round; i++) {
			if(!visit[i]) {
				visit[i] = true;
				sinTotal *= sin[i];
				ssunTotal += ssun[i];
				min = Math.min(
						min,
						Math.abs(sinTotal-ssunTotal)
				);
				recall(cnt+1,sinTotal,ssunTotal);
				sinTotal /= sin[i];
				ssunTotal -= ssun[i];
				visit[i] = false;
			}
		}
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		round = Integer.parseInt(br.readLine());
		sin  = new int[round];
		ssun = new int[round];
		visit = new boolean[round];
		for(int i = 0 ; i <round; i++) {
			String t []  = br.readLine().split(" ");
			sin[i] = Integer.parseInt(t[0]);
			ssun[i] = Integer.parseInt(t[1]);
		}
		recall(0,1,0);
		System.out.println(min);
	}
}
