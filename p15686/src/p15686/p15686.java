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
		
		ArrayList<Point> zip = new ArrayList<Point>();
		
		ArrayList<Point> selectChiekn = new ArrayList<Point>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N; j++) {
				int t = Integer.parseInt(st.nextToken());
				if(t == 1) 		zip.add(new Point(j, i));
				else if(t == 2) chiken.add(new Point(j, i));
			}
		}
		Integer mask = 0;
		recall(0,M,chiken,zip,selectChiekn,mask);
		
		System.out.println(distanse);
	}

	private static void recall(int cnt,int M,ArrayList<Point> chiken, ArrayList<Point> zip,ArrayList<Point> selectChiekn,Integer mask) {
		
		//(r1, c1)과 (r2, c2) 사이의 거리는 |r1-r2| + |c1-c2|
		if(cnt == M) {
			int sumDistance = 0;
			for(int i = 0; i < zip.size();i++) {
				int zipToChikenMinimumDistance = Integer.MAX_VALUE;
				Point zipTemp = zip.get(i);
				int zipX = (int)zipTemp.getX();
				int zipY = (int)zipTemp.getY();
				for(int j = 0; j < selectChiekn.size(); j++) {
					Point chikenTemp = selectChiekn.get(j);
					int chikenX = (int)chikenTemp.getX();
					int chikenY = (int)chikenTemp.getY();
					zipToChikenMinimumDistance = Math.min(
							zipToChikenMinimumDistance,
							Math.abs(zipX - chikenX)
							+
							Math.abs(zipY - chikenY)
					);
				}
				sumDistance += zipToChikenMinimumDistance;
			}
			distanse = Math.min(distanse, sumDistance);
		}
		for(int i = cnt; i < chiken.size();i++) {
			if((mask & ( 1 << cnt)) == 0) {
				selectChiekn.add(cnt,chiken.get(i));
				recall(cnt + 1, M, chiken, zip, selectChiekn,mask | (1 << cnt));
				selectChiekn.remove(cnt);
			}
		}
	}
}
