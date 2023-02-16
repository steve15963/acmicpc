package p2563;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class p2563 {
	static boolean map[][] = new boolean[100][100];
	public static void main(String[] args) throws NumberFormatException,IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int CommandLength = Integer.parseInt(br.readLine());
		int size = 0;
		for(int round = 0; round < CommandLength; round++) {
			String sData[] = br.readLine().split(" ");
			int left = Integer.parseInt(sData[0]);
			int right = Integer.parseInt(sData[1]);
			
			for(int i = left; i < left + 10; i++) {
				for(int j = right; j < right + 10; j++) {
					if(!map[i][j]) {
						map[i][j] = true;
						size++;
					}
				}
			}
		}
		System.out.println(size);
	}
}
