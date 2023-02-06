package p1244;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p1244 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		Integer.parseInt(br.readLine()); //스위치 길이 버림
		char SWMap[] = br.readLine().replaceAll(" ", "").toCharArray();
		int MAPLength = SWMap.length;
		int round = Integer.parseInt(br.readLine());
		while(round-- > 0) {
			String data[] = br.readLine().split(" ");
			int num = Integer.parseInt(data[1]);
			if(data[0].equals("1")) {
				for(int i=num-1; i < MAPLength; i = i + num) {
					SWMap[i] = SWMap[i] == '1' ? '0' : '1';
				}
			}
			else {
				int i = 0;
				num--;
				while(num - i >= 0 && num + i < MAPLength) {
					if(SWMap[num - i] == SWMap[num + i]) {
						SWMap[num - i] = SWMap[num - i] == '1'? '0':'1';
						SWMap[num + i] = SWMap[num - i];
					}
					i++;
				}
			}
		}
		System.out.println(SWMap);
	}

}