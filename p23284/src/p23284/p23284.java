package p23284;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p23284 {
	static int length;
	static boolean visit[];
	static int selected[];
	static void dfs(int cnt,int num) {
		if(cnt == length) {
			
			System.out.println(Arrays.toString(selected));
			return;
		}
		for(int i = 0 ; i < length;i++) {
			if(!visit[i] && i >= num - 1) {
				visit[i] = true;
				selected[cnt] = i + 1;
				dfs(cnt+1, i);
				visit[i] = false;
			}
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		length = Integer.parseInt(br.readLine());
		visit = new boolean[length];
		selected = new int[length];
		dfs(0,0);
	}

}
