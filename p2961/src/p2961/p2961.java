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
			//재료가 선택되지 않았다면.
			if(!visit[i]) {
				//재료를 선택하고
				visit[i] = true;
				//해당 값을 더하고.
				sinTotal *= sin[i];
				ssunTotal += ssun[i];
				// 최소값인지 구하고
				min = Math.min(
						min,
						Math.abs(sinTotal-ssunTotal)
				);
				// 재귀로 타 조합에 대해서 검사한다.
				recall(cnt+1,sinTotal,ssunTotal);
				// 나의 값에 대한 계산을 취소한다.
				sinTotal /= sin[i];
				ssunTotal -= ssun[i];
				//재료 선택을 취소한다.
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
		// 요리 재료 입력 받기.
		for(int i = 0 ; i <round; i++) {
			String t []  = br.readLine().split(" ");
			sin[i] = Integer.parseInt(t[0]);
			ssun[i] = Integer.parseInt(t[1]);
		}
		//조합 구하기 시작.
		recall(0,1,0);
		System.out.println(min);
	}
}
