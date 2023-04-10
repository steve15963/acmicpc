package p1708;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class p1708 {

	static class Node{
		int x;
		int y;
		double angle;
		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
			this.angle = -1;
		}
	}
	static Node startNode = null;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = null;
		
		ArrayList<Node> nodeList = new ArrayList<>();
		
		
		//리스트 입력 받기
		// 최대한 아래 노드 찾기. - > 시작점 찾기
		startNode = new Node(Integer.MAX_VALUE, Integer.MAX_VALUE);
		for(int i = 0 ; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			Node temp = new Node(
					Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken())
			);
			if(temp.y < startNode.y)
				startNode = temp;
			else if(temp.y == startNode.y && temp.x < startNode.x)
				startNode = temp;
			else
				nodeList.add(temp);
		}
		
		//앵글 순으로 정렬하기
		
		Collections.sort(nodeList, new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				if(o1.angle == -1) {
					o1.angle = Math.toDegrees(
							Math.atan2(
									startNode.y - o1.y,
									startNode.x - o1.x
							)
					);
				}
				if(o2.angle == -1) {
					o2.angle = Math.toDegrees(
							Math.atan2(
									startNode.y - o2.y,
									startNode.x - o2.x
							)
					);
				}
				return Double.compare(o1.angle, o2.angle);
			}
			
		});
		

	}

}
