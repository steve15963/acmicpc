package p15961;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p15961 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		int plate[] = new int[N];
		
		
		for(int i = 0 ; i < N; i++) {
			plate[i] = Integer.parseInt(br.readLine());
		}
		
		boolean eaten[] = new boolean[D + 1];
		
		int max = 0;
		
		//시작 위치
		for(int i = 0 ; i < N; i++) {
			//먹은 음식 체크(음식번호가 1번부터 시작하므로. + 1)
			int count = 0;
			//먹을 음식 수
			for(int j = 0; j < K; j ++) {
				// 다음 접시의 번호
				int nextPlate = (i + j) % N;
				// 다음 음식의 번호
				int nextFood = plate[nextPlate];
				//안먹은 음식이면
				if(!eaten[nextFood]) {
					//카운트하고
					count++;
					//먹은 음식으로 체크
					eaten[nextFood] = true;
				}
			}
			
			// K개 만큼 먹으면 쿠폰으로 주는 음식 먹기
			if(!eaten[C]) {
				count++;
				eaten[C] = true;
			}
			
			max = Math.max(max, count);
		}
		System.out.println(max);
	}

}
