package p15961;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p15961_2 {
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
		
		//먹은 음식 체크(음식번호가 1번부터 시작하므로. + 1)
		int eaten[] = new int[D + 1];
		

		int max = 0;
		
		//원형 큐라고 생각하고
		// 0번부터
		int front = 0;
		// K번까지 먹음(단 0번부터 시작하므로 K - 1까지.
		int rear = K - 1;
		
		/////////////////////////////
		//초기화 시작.
		//처음 K개 먹은 값 넣기.
		for(int i = 0 ; i < K; i++) {
			//다음 음식 번호는
			int nextFood = plate[i];
			//안먹은 음식이면
			if(eaten[nextFood] == 0) {
				//카운트하고
				max++;
			}
			//먹은 음식은 증가함
			eaten[nextFood]++;
		}
		// K개 만큼 먹으면 쿠폰으로 주는 음식 먹기
		if(eaten[C] == 0) {
			max++;
		}
		// 초기화 끝
		/////////////////////
		
		int count = max;
		//N번 접시만큼 반복하겠다.
		for(int i = 1 ; i < N; i++) {
			// 뺼 음식
			int minusFood = plate[front];
			//뺼 음식을 빼고 먹은 수가 0 이라면
			//윈도우 안에 음식이 없으니 count를 뺴줌.
			eaten[minusFood]--;
			if(eaten[minusFood] == 0) {
				count--;
			}
			
			front = (front+1) % N;
			rear  = (rear+1) % N;
			
			//새로 넣을 음식.
			int nextFood = plate[rear];
			
			//넣기전 음식이 0 이라면
			//count를 1 더해줌
			if(eaten[nextFood] == 0) {
				count++;
			}
			//먹음 음식의 카운트를 더함.
			eaten[nextFood]++;
			max = Math.max(max, count + (eaten[C] == 0 ? 1 : 0));
			
			
		}
		System.out.println(max);
	}

}
