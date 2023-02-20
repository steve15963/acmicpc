package p1074;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1074 {
	static int N;
	static int R;
	static int C;
	static int answer;
	static int count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		cut(0, 0, (int)Math.pow(2, N));
		//자기 자신이 중복카운트되어 -1
		System.out.println(answer-1);
	}

	private static void cut(int y, int x, int size) {
		int half = size / 2;
		int addY = y + half;
		int addX = x + half;
		// size 2라면 2*2이므로 몇번째 위치한건지 검색
		if(size == 2) {
			for(int i = 0; i < 2;i++) {
				for(int j =0; j < 2;j++) {
					count++;
					if(y+i == R && x +j == C) {
						answer = count;
						return;
					}
				}
			}
		}
		
		// size가 2 이상이라면
		// 레인지 안에 포함되는가?.
		// 2사분면
		if(y <= R  && R < addY && x <= C && C < addX) {
			cut(y, x, half);
		}
		
		// 안된다면 half개 추가.
		// 아래 반복.
		else count += half * half;
		
		// 1사분면
		if(y <= R  && R < addY && addX <= C && C < addX + half) {
			cut(y, addX, half);
		}
		else count += half * half;
		
		// 3사분면
		if(addY <= R  && R < addY + half && x <= C && C < addX) {
			cut(addY, x, half);
		}
		else count += half * half;
		
		// 4사분면
		if(addY <= R  && R < addY + half && addX <= C && C < addX +half) {
			cut(addY, addX, half);
		}
		else count += half * half;
	}
}
