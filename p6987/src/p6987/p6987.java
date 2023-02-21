package p6987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p6987 {
	static int map[][][] = new int[4][6][3];
	static int makeScore[][] = new int[6][3];
	static int answer[] = new int[4];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int TC = 0 ; TC < 4; TC++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 6; i++) {
				for(int j = 0; j < 3; j++) {
					map[TC][i][j] = Integer.parseInt(st.nextToken());
				}
			}
		}
		dfs(0,1);
		for(int i = 0 ; i < 4; i++) {
			System.out.println(answer[i] + " ");
		}
		
	}
	private static void dfs(int home, int away) {
		//모드 조합이 끝난경우
		//만들어진 스코어가 유효한지 검사하고
		//
		if(home == 6) {
			for(int i = 0 ; i < 4; i++) {
				if(isCan(i))
					answer[i]= 1;
			}
			return;
		}
		//away팀이 index를 넘어가려고 할때.
		//다음 조합에 대한 호출을 이어가고.
		//종료함
		if(away == 6) {
			dfs(home+1,home+2);
			return;
		}
		for(int i = 0; i < 3; i++) {
			switch(i) {
			// home win away lose
			case 0:
				makeScore[home][0]++;
				makeScore[away][2]++;
				dfs(home,away+1);
				makeScore[home][0]--;
				makeScore[away][2]--;
				break;
			// draw
			case 1:
				makeScore[home][1]++;
				makeScore[away][1]++;
				dfs(home,away+1);
				makeScore[home][1]--;
				makeScore[away][1]--;
				break;
			// home lose away win
			case 2:
				makeScore[home][2]++;
				makeScore[away][0]++;
				dfs(home,away+1);
				makeScore[home][2]--;
				makeScore[away][0]--;
				break;
			}
		}
	}
	private static boolean isCan(int tc) {
		for(int i = 0 ; i < 6 ; i++) {
			for(int j = 0; j<3;j++) {
				if(makeScore[i][j] != map[tc][i][j])
					return false;
			}
		}
		return true;
	}
}
