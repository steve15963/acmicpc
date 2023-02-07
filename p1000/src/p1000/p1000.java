package p1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p1000 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String data[] = br.readLine().split(" ");
		int num1 = Integer.parseInt(data[0]);
		int num2 = Integer.parseInt(data[1]);
		bw.write(String.valueOf(num1+num2));
		bw.flush();
		bw.close();
	}
}
