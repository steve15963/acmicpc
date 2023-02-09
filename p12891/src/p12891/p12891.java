package p12891;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class p12891 {

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
		
		for(RIndex = 0; RIndex < P; RIndex++) {
			visit[
			      getIndex(
			    		  DNA[RIndex]
			      )
			]++;
		}
		if(isCorrect(visit, ACGT)) count++;
		
		for(RIndex = P; RIndex < S;RIndex++) {
			visit[
			      getIndex(
			    		  DNA[RIndex]
			      )
			]++;
			visit[
			      getIndex(
			    		  DNA[FIndex++]
			      )
			]--;
			if(isCorrect(visit, ACGT)) count++;
		}
		System.out.println(count);
	}

}
