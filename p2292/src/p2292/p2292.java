package p2292;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class p2292 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int input = Integer.parseInt(br.readLine());
		int range = 2;
		int round = 1;
		if(input != 1) {
			while(input >= range) {
				range += 6 * round;
				round++;
			}
		}
		System.out.println(round);
	}

}
