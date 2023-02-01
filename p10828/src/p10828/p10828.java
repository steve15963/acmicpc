package p10828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class p10828 {

	public static void main(String[] args) throws IOException {
		Stack<Integer> st = new Stack<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int round = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < round; i++) {
			
			String command[] = br.readLine().split(" ");
			if(command.length == 1) {
				if(command[0].equals("top")) {
					if(st.empty()) System.out.println(-1);
					else System.out.println(st.peek());
				}
				else if(command[0].equals("pop")) {
					if(st.empty()) System.out.println(-1);
					else System.out.println(st.pop());
				}
				else if(command[0].equals("empty")) {
					if(st.empty()) System.out.println(1);
					else System.out.println(0);
				}
				else if(command[0].equals("size"))
					System.out.println(st.size());
			}
			else {
				st.push(Integer.parseInt(command[1]));
			}
        }
	}

}
