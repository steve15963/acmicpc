package p2023;

import java.io.*;
import java.util.LinkedList;

public class p2023  {
	//������ �ռ����� �Ҽ��� �������ְ�. �ռ����� �Ҽ��� ������ ��Ÿ�� �� �ִ�.
	//�׷��Ƿ� RootN��ŭ �Ҽ��� �������ٸ� �� ���� �Ҽ����� �ƴ��� �Ǻ� �� �� �ִ�.
	public static boolean isSosu(int number,LinkedList<Integer> sosuList) {
		int numberSqrt = (int) Math.sqrt(number);
		//1 �̸��� ���. ����.
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
		//SosuRang�� RootN��ŭ �Ҽ��� ���Ѵ�.
		for(int i = 2; i <= sosuRange; i++) {
			if(isSosu(i,sosuList)) sosuList.add(i);
		}
		
		//old list�� new list�� �����
		LinkedList<Integer> oldTargetList = new LinkedList<Integer>();
		LinkedList<Integer> newTargetList = null;
		// 1�ڸ��� �Ҽ��� �̸� �ִ´�.
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
			// ���� ���� �Ҽ� ����Ʈ�� old����Ʈ�� �־��ش�.
			oldTargetList = newTargetList;
		}
		for(Integer t: oldTargetList) {
			System.out.println(t);
		}
	}
}
