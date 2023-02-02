package p1874;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class p1874 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Stack<Integer> stack = new Stack<Integer>();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder stringBuilder = new StringBuilder();
		int round = Integer.parseInt(bufferedReader.readLine());
		int num = 1;
		for(int i = 1; i <= round ;i++) {
			int data = Integer.parseInt(bufferedReader.readLine());
			while(num <= data) {
				stack.add(num++);
				stringBuilder.append("+\n");
			}
			if(stack.peek() == data){
				stack.pop();
				stringBuilder.append("-\n");
			}else {
				bufferedWriter.write("NO");
				bufferedWriter.flush();
				return;
			}
		}
		bufferedWriter.write(stringBuilder.toString());
		bufferedWriter.flush();
		return;
	}
}
