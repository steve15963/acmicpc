package p15686;

import java.awt.Point;
import java.io.*;
import java.util.*;

public class p15686 {
	static int distanse = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		ArrayList<Point> chiken = new ArrayList<Point>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N; j++) {
				int t = Integer.parseInt(st.nextToken());
				if(t == 1) 		zip.add(new Point(j, i));
				else if(t == 2) chiken.add(new Point(j, i));
			}
		}
		Integer mask = 0;
		
		System.out.println(distanse);
	}
}
