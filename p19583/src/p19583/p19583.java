package p19583;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

class HourMin{
	int hour;
	int min;
	public boolean lower(HourMin b) {
		if(hour < b.hour) return true;
		else if(hour == b.hour && min < b.min)return true;
		return false;
	}
	public boolean lowerEquals(HourMin b) {
		if(hour < b.hour) return true;
		else if(hour == b.hour && min <= b.min)return true;
		return false;
	}
	public boolean bigger(HourMin b) { //a가 더 큰가?
		if(hour > b.hour) return true;
		else if(hour == b.hour && min > b.min)return true;
		return false;
	}
	public boolean biggerEquals(HourMin b) { //a가 더 큰가?
		if(hour > b.hour) return true;
		else if(hour == b.hour && min >= b.min)return true;
		return false;
	}
	public boolean equals(HourMin b) {
		if(hour == b.hour && min == b.min)return true;
		return false;
	}
	public HourMin(String time) {
		String hms[] = time.split(":");
		hour = Integer.parseInt(hms[0]);
		min = Integer.parseInt(hms[1]);
	}
}

public class p19583 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String time[] = br.readLine().split(" ");
		HourMin S = new HourMin(time[0]);
		HourMin E = new HourMin(time[1]);
		HourMin Q = new HourMin(time[2]);
		
		int count = 0;
		
		Set<String> check = new HashSet<String>();
		Set<String> quick = new HashSet<String>();
		
		String comment;
		while((comment = br.readLine()) !=null ) {
			String commentSplit[] = comment.split(" ");
			HourMin hm = new HourMin(commentSplit[0]);
			if(S.biggerEquals(hm))
				check.add(commentSplit[1]);
			else if((E.lowerEquals(hm)) && (Q.biggerEquals(hm)))
				quick.add(commentSplit[1]);
		}
		for(String id:quick) {
			if(check.contains(id)) count++;
		}
		System.out.println(count);
	}
}
