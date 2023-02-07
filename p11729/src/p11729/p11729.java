package p11729;
import java.util.Stack;

public class p11729 {

	public static void main(String[] args) {
		Stack st[] = new Stack[]{
				new Stack<Integer>(),
				new Stack<Integer>(),
				new Stack<Integer>()
		};
		st[0].add(Integer.valueOf(1));
		System.out.print(st[0].pop());
	}

}
