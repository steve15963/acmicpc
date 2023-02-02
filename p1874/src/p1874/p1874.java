package p1874;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class p1874 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Stack<Integer> stack = new Stack<Integer>();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder stringBuilder = new StringBuilder();
		int round = Integer.parseInt(bufferedReader.readLine());
		int num = 1;
		for(int i = 1; i <= round ;i++) {
			int data = Integer.parseInt(bufferedReader.readLine());
			while(num <= data) {
				stack.add(num++);
				stringBuilder = stringBuilder.append("+\n");
			}
			if(stack.peek() != data){
				stack.pop();
				stringBuilder = stringBuilder.append("-\n");
			}
		}
		System.out.print(stringBuilder.toString());
		return;
	}

}
