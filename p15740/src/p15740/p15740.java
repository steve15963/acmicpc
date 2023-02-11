package p15740;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class p15740 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String data[] = br.readLine().split(" ");
		BigInteger A = new BigInteger(data[0]);
		BigInteger B = new BigInteger(data[1]);
		
		BigInteger C = A.add(B);
		System.out.println(C.toString());

	}

}
