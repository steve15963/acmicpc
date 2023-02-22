package p1068;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Node{
	int data;
	Node pa;
	List<Node> child = new ArrayList<Node>();
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (data != other.data)
			return false;
		return true;
	}
	public Node() {
	}
	public Node(int data) {
		this.data = data;
	}
	public boolean isEqualData(int data) {
		if (data != this.data)
			return false;
		return true;
	}
	public Node search(Node p,int data) {
		if(p.isEqualData(data)) return p;
		Node t = null;
		for(Node ch : p.child) {
			if((t = search(ch, data)) != null)
				return t;
		}
		return null;
	}
	public void add(Node node){
		child.add(node);
	}
	public int CountLeafNode(Node node) {
		int sum = 0;
		if(child.size() == 0) return 1;
		for(Node ch : child) {
			sum += CountLeafNode(ch);
		}
		return sum;
	}
	
}

public class p1068 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int round = Integer.parseInt(br.readLine());
		
		Node root = null;
		
		StringTokenizer st = new StringTokenizer(br. readLine());
		for(int i = 0; i < round; i++) {
			int t = Integer.parseInt(st.nextToken());
			if(t == -1) {
				root = new Node(i);
			}
			else {
				Node findNode = root.search(root, t);
				Node newNode = new Node(i);
				newNode.pa = findNode;
				findNode.add(newNode);
			}
		}
		int deleteNum = Integer.parseInt(br.readLine());
		
		if(deleteNum == 0) {
			System.out.println(0);
			return;
		}
		
		Node deleteNode = root.search(root, deleteNum);
		
		deleteNode.pa.child.remove(new Node(deleteNum));
		
		System.out.println(root.CountLeafNode(root));
	}
}
