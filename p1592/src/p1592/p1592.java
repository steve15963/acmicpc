package p1592;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1592 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String NML[] = br.readLine().split(" ");
		
		int N = Integer.parseInt(NML[0]);
		int M = Integer.parseInt(NML[1]);
		int L = Integer.parseInt(NML[2]);
		
		
		int mans[] = new int[N+1];
		
		int ballIndex = 1;
		mans[ballIndex] = 1;
		
		int count = 0;
		
		while(mans[ballIndex] < M) {
			ballIndex = (ballIndex + L) % N;
			mans[ballIndex]++;
			count++;
		}
		System.out.println(count);
	}
}
