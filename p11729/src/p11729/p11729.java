package p11729;

import java.util.Scanner;
import java.util.Stack;

public class p11729 {
	public static void hano(StringBuilder sb, Stack st[], int input, int from, int to ) {
		if(input == 0) return;
		st[to].add(st[from].pop());
		sb.append(input).append(" : ");
		
		
	}
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Stack st[] = new Stack[]{
				new Stack<Integer>(),
				new Stack<Integer>(),
				new Stack<Integer>()
		};
		
		Scanner in = new Scanner(System.in);
		
		int input = in.nextInt();
		for(int i = 1; i<=input; i++) {
			st[0].add(Integer.valueOf(i));
		}
		hano(sb,st,input,1,3);
	}

}
