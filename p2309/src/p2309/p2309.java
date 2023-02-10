package p2309;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p2309 {
	static boolean visit[] = new boolean[9];
	static int nan7[] = new int[7];
	static int nan9[] = new int[9];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ;i < 9;i++) {
			nan9[i] = Integer.parseInt(br.readLine());
		}
		recall(0,0);
		Arrays.sort(nan7);
		for(int e:nan7) {
			sb.append(e).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static boolean recall(int cnt,int sum) {
		if(cnt == 7) {
			if(sum == 100) return true;
			return false;
		}
		for(int i = 0; i < 9; i++) {
			if(visit[i] == false) {
				visit[i] = true;
				if(recall(cnt+1,sum+nan9[i])) {
					nan7[cnt] = nan9[i];
					return true;
				}
				visit[i] = false;
			}
		}
		return false;
	}
}
