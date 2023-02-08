package p1991;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Node{
	char data;
	Node left;
	Node right;
	public Node() {
	}
	public Node(char data) {
		this.data = data;
	}
	public boolean isEqualData(char data) {
		if (data != this.data)
			return false;
		return true;
	}
	public Node search(Node p,char data) {
		if(p.isEqualData(data)) return p;
		if(p.left != null) {
			Node l = search(p.left, data);
			if( l != null) return l;
		}
		if(p.right != null) {
			Node r = search(p.right, data);
			if( r != null) return r;
		}
		return null;
	}
	public boolean addleft(Node p,Node c) {
		Node n = search(p, p.data);
		if(n == null) return false;
		n.left = c;
		return true;
	}
	public boolean addright(Node p,Node c) {
		Node n = search(p, p.data);
		if(n == null) return false;
		n.right = c;
		return true;
	}
	public void pre_print(Node p,StringBuilder sb) {
		sb.append(p.data);
		if(p.left != null) {
			pre_print(p.left,sb);
		}
		if(p.right != null) {
			pre_print(p.right,sb);
		}
	}
	public void ino_print(Node p,StringBuilder sb) {
		if(p.left != null) {
			ino_print(p.left,sb);
		}
		sb.append(p.data);
		if(p.right != null) {
			ino_print(p.right,sb);
		}
	}
	public void pos_print(Node p,StringBuilder sb) {
		if(p.left != null) {
			pos_print(p.left,sb);
		}
		if(p.right != null) {
			pos_print(p.right,sb);
		}
		sb.append(p.data);
	}
}

public class p1991 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int round = Integer.parseInt(br.readLine());
		 
		String line[] = br.readLine().split(" ");
		
		Node root = new Node(line[0].charAt(0));
		if(!line[1].equals("."))
			root.addleft(root, new Node(line[1].charAt(0)));
		if(!line[2].equals("."))
			root.addright(root, new Node(line[2].charAt(0)));
		
		for(int i = 1 ; i < round; i++) {
			line = br.readLine().split(" ");
			Node t = root.search(root, line[0].charAt(0));
			if( t != null) {
				if(!line[1].equals("."))
					t.addleft(t, new Node(line[1].charAt(0)));
				if(!line[2].equals("."))
					t.addright(t, new Node(line[2].charAt(0)));
			}
		}
		StringBuilder sb = new StringBuilder();
		root.pre_print(root, sb);
		sb.append("\n");
		root.ino_print(root, sb);
		sb.append("\n");
		root.pos_print(root, sb);
		System.out.println(sb.toString());

	}
}
