package p10953;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class p10953 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int round = Integer.parseInt(br.readLine());
		for(int i = 0 ; i< round;i++) {
			String data[] = br.readLine().split(",");
			int a = Integer.parseInt(data[0]);
			int b = Integer.parseInt(data[1]);
			System.out.println(a+b);
		}
	}
}
