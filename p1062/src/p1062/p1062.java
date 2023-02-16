package p1062;

import java.io.BufferedReader;
import java.io.*;

public class p1062 {
	static boolean visit[] = {
		true ,false,true ,false,false,false,
		false,false,true ,false,false,false,
		false,true ,false,false,false,false,
		false,true ,false,false,false,false,
		false,false
	};
	static int count = 0;
	public static void main(String[] args) throws NumberFormatException,IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String sData[] = br.readLine().split(" "); 
		int N = Integer.parseInt(sData[0]);
		int K = Integer.parseInt(sData[1]);
		
		if(K < 5) {
			System.out.println(0);
			return;
		}
		
		for(int i = 0 ; i < N; i++) {
			char charWord[] = 
					br.readLine()
					.replaceAll("a", "")
					.replaceAll("c", "")
					.replaceAll("n", "")
					.replaceAll("t", "")
					.replaceAll("i", "")
					.toCharArray();
			
			int maxChoice = K - 5;
			
			for(int j = 0; j < maxChoice; j++) {
				if(!visit[
				         charWord[j]
				   ]
				) {
					
					
				}
			}
		}
		
		
		
	}
	
	
}
