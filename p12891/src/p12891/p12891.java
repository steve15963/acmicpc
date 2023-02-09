package p12891;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class p12891 {
	/**
	 * char값을 해당 index로 매칭하여 반환해주는 메소드
	 * @param data index로 변환하기 위한 char값.
	 * @return index
	 */
	public static int getIndex(char data) {
		switch(data) {
		case 'A':
			return 0;
		case 'C':
			return 1;
		case 'G':
			return 2;
		case 'T':
			return 3;
		}
		return -1;
	}
	/**
	 * ACGT배열 요소보다 visit배열 요소가 크거나 같은가?
	 * @param visit visit요소
	 * @param ACGT ACGT요소
	 * @return
	 */
	public static boolean isCorrect(int visit[],int ACGT[]) {
		int j;
		for(j = 0;j<4;j++) {
			if(visit[j] < ACGT[j]) return false;
		}
		return true;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String SP[] = br.readLine().split(" ");
		int S = Integer.parseInt(SP[0]);
		int P = Integer.parseInt(SP[1]);
		
		char DNA[] = br.readLine().toCharArray();
		
		String SACGT[] = br.readLine().split(" ");
		
		int ACGT[] = new int[SACGT.length];
		
		for(int i = 0 ; i < SACGT.length;i++) {
			ACGT[i] = Integer.parseInt(SACGT[i]);
		}
		
		int count = 0;
		
		int visit[] = new int[4];
		
		int FIndex = 0;
		int RIndex;
		
		
		//p개만큼 포인터에 넣어준다.
		for(RIndex = 0; RIndex < P; RIndex++) {
			visit[
			      getIndex(
			    		  DNA[RIndex]
			      )
			]++;
		}
		// 미리 넣어준 값이 올바른 문자열이면 체크한다.
		if(isCorrect(visit, ACGT)) count++;
		
		// 나머지 요소만큼 반복하며
		for(RIndex = P; RIndex < S;RIndex++) {
			//나머지 요소의 값을 포함하며 visit를 추가해주고
			visit[
			      getIndex(
			    		  DNA[RIndex]
			      )
			]++;
			//FIndex를 빠져나가며 visit에서 해당 값을 감소해준다.
			visit[
			      getIndex(
			    		  DNA[FIndex++]
			      )
			]--;
			//visit의 값이 범위 안에 있는지 검사한다.
			if(isCorrect(visit, ACGT)) count++;
		}
		System.out.println(count);
	}
}
