package p10866;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class p10866 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		LinkedList<String> deque = new LinkedList<String>();
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N ; i ++) {
			String command[] = br.readLine().split(" ");
			if(command[0].equals("push_front"))
				deque.addFirst(command[1]);
			
			else if(command[0].equals("push_back"))
				deque.addLast(command[1]);
			
			else if(command[0].equals("pop_front")) {
				if(deque.isEmpty()) sb.append(-1).append("\n");
				else sb.append(deque.pollFirst()).append("\n");
			}
			
			else if(command[0].equals("pop_back")) {
				if(deque.isEmpty()) sb.append(-1).append("\n");
				else sb.append(deque.pollLast()).append("\n");
			}
			
			else if(command[0].equals("size"))
				sb.append(deque.size()).append("\n");
			
			else if(command[0].equals("empty"))
				sb.append(deque.isEmpty() ? 1 : 0).append("\n");
			
			else if(command[0].equals("front")) {
				if(deque.isEmpty()) sb.append(-1).append("\n");
				else sb.append(deque.getFirst()).append("\n");
			}
			
			else if(command[0].equals("back")){
				if(deque.isEmpty()) sb.append(-1).append("\n");
				else sb.append(deque.getLast()).append("\n");
			}
		}
		System.out.println(sb.toString());
	}
}
