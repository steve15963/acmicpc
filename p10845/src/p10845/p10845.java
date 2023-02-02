package p10845;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class p10845 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Queue<String> queue = new LinkedList<String>();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int round = Integer.parseInt(bufferedReader.readLine());
		String temp = new String("-1");
		while(round-- > 0) {
			String command = bufferedReader.readLine();
			if(command.equals("pop"))
				System.out.println(queue.isEmpty()?-1:queue.poll());
			else if(command.equals("size"))
				System.out.println(queue.size());
			else if(command.equals("empty"))
				System.out.println(queue.isEmpty()?1:0);
			else if(command.equals("front"))
				System.out.println(queue.isEmpty()?-1:queue.peek());
			else if(command.equals("back"))
				System.out.println(queue.isEmpty()?-1:temp);
			else {
				temp = command.split(" ")[1];
				queue.add(temp);
			}
		}
	}

}
