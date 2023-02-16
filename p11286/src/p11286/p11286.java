package p11286;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class p11286 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>(N, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				int a = Math.abs(o1);
				int b = Math.abs(o2);
				//배열에서 절댓값이 가장 작은 값으로
				//절댓값이 가장 작은 값이 여러개일 때는, 가장 작은 수(정수상태로)
				if( a > b) return 1;
				else if( a < b) return -1;
				// 둘다 아니면 같다.
				// o1이 양수라면. o2가 음수이다.(둘다 같은 부호라면 상관없다.)
				else if( o1 > 0) return 1;
				else return -1;
//				if(a == b)
//					return o1 - o2;
//				return a - b;
			}
		});
		
		for(int i = 0 ; i< N;i++) {
			int X = Integer.parseInt(br.readLine());
			// x가 0이 아니라면 배열에 x라는 값을 넣는(추가하는) 연산
			if(X != 0) {
				pq.add(X);
				continue;
			}
			//x가 0이라면 배열에서 절댓값이 가장 작은 값을 출력하고
			//만약 배열이 비어 있는 경우인데 절댓값이 가장 작은 값을 출력하라고 한 경우에는 0을 출력
			if(pq.isEmpty())
				System.out.println(0);
			else
				//절댓값이 가장 작은 값이 여러개일 때는, 가장 작은 수를 출력하고, 그 값을 배열에서 제거
				System.out.println(pq.poll());
		}

	}

}
