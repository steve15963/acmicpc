package p1541;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1541 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), "-");
		
		int start = getPlusTotal(st.nextToken());

		while(st.hasMoreTokens()) {
			start -= getPlusTotal(st.nextToken());
		}
		
		System.out.println(start);
	}
	public static int getPlusTotal(String plusString){
		StringTokenizer st = new StringTokenizer(plusString,"+");
		int sum = 0;
		while(st.hasMoreTokens()) {
			sum += Integer.parseInt(st.nextToken());
		}
		return sum;
	}

}
