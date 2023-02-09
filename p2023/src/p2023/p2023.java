package p2023;

import java.io.*;
import java.util.LinkedList;

public class p2023  {
	//정수는 합성수와 소수로 나눠져있고. 합성수는 소수의 합으로 나타낼 수 있다.
	//그러므로 RootN만큼 소수로 나눠본다면 그 수가 소수인지 아닌지 판별 할 수 있다.
	public static boolean isSosu(int number,LinkedList<Integer> sosuList) {
		int numberSqrt = (int) Math.sqrt(number);
		//1 미만인 경우. 거짓.
		if(number <= 1) return false;
		for(Integer num:sosuList) {
			if(numberSqrt <= num) return true;
			if(number % num == 0) return false;
		}
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		LinkedList<Integer> sosuList = new LinkedList<Integer>();
		int sosuRange = (int) Math.sqrt(Math.pow(10, N)) + 1;
		//SosuRang의 RootN만큼 소수를 구한다.
		for(int i = 2; i <= sosuRange; i++) {
			if(isSosu(i,sosuList)) sosuList.add(i);
		}
		
		//old list와 new list를 만들고
		LinkedList<Integer> oldTargetList = new LinkedList<Integer>();
		LinkedList<Integer> newTargetList = null;
		// 1자리수 소수를 미리 넣는다.
		oldTargetList.add(2);
		oldTargetList.add(3);
		oldTargetList.add(5);
		oldTargetList.add(7);
		
		for(int i = 1; i < N;i++) {
			newTargetList = new LinkedList<Integer>();
			while(!oldTargetList.isEmpty()) {
				int sosu = oldTargetList.poll() * 10;
				for(int j = 1; j < 10;j++) {
					int nextSosu = sosu + j;
					if(isSosu(nextSosu, sosuList))
						newTargetList.add(nextSosu);
				}
			}
			// 새로 구한 소수 리스트를 old리스트에 넣어준다.
			oldTargetList = newTargetList;
		}
		for(Integer t: oldTargetList) {
			System.out.println(t);
		}
	}
}
