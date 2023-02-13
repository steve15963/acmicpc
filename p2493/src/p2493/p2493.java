package p2493;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class pair{
	int index;
	int height;
	public pair(int index, int height) {
		this.index = index;
		this.height = height;
	}
}
public class p2493 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(
					br.readLine(),
					" "
		);
		Stack<pair> stack = new Stack<pair>();
		for(int i = 1 ; i <= N; i++) {
			int parse = Integer.parseInt(st.nextToken());
			while(!stack.isEmpty()) {
				if(stack.peek().height >= parse ) {
					sb.append(stack.peek().index).append(" ");
					break;
				}
				stack.pop();
			}
			if(stack.isEmpty()) sb.append(0).append(" ");
			stack.push(new pair(i,parse));
		}
		System.out.println(sb.toString());
	}
}
