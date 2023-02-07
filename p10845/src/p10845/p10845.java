package p10845;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class p10845 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Queue<String> queue = new LinkedList<String>();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder builder = new StringBuilder();
		int round = Integer.parseInt(bufferedReader.readLine());
		String temp = new String("-1");
		while(round-- > 0) {
			String command = bufferedReader.readLine();
			if(command.equals("pop"))
				builder.append(queue.isEmpty()?-1:queue.poll()).append("\n");
			
			else if(command.equals("size"))
				builder.append(queue.size()).append("\n");
			
			else if(command.equals("empty"))
				builder.append(queue.isEmpty()?1:0).append("\n");
			
			else if(command.equals("front"))
				builder.append(queue.isEmpty()?-1:queue.peek()).append("\n");
			
			else if(command.equals("back"))
				builder.append(queue.isEmpty()?-1:temp).append("\n");
			
			else {
				temp = command.split(" ")[1];
				queue.add(temp);
			}
		}
		bufferedWriter.write(builder.toString());
		bufferedWriter.flush();
	}
}
