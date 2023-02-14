package p16926;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class p16926 {

	public static void main(String[] args) throws IOException {
		int dy[] = {0, 1,   0,  -1};
		int dx[] = {1, 0,  -1, 0};
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//첫 init용 데이터
		String sData[] = br.readLine().split(" ");
		
		int y 		= Integer.parseInt(sData[0]);
		int x 		= Integer.parseInt(sData[1]);
		int round 	= Integer.parseInt(sData[2]);
		
		//몇 레이어 인지.
		int rotateDep = Math.min(x, y) / 2;
		// 입력 맵 
		int map[][] = new int[y][x];

		for(int i = 0 ; i < y; i ++) {
			sData = br.readLine().split(" ");
			for(int j = 0; j <  x; j ++) {
				map[i][j] = Integer.parseInt(sData[j]);
			}
		}
		
		
		LinkedList<Integer> queue = new LinkedList<Integer>();
		//레이어 만큼 반복
		for(int i = 0 ; i < rotateDep; i++) {
			int nx = i;
			int ny = i;
			int mode = 0;
			// 레이어의 엘리먼트수
			int rotate = (((x - (i * 2)) * 2) + ((y - (i * 2)) * 2));
			// 첫 엘리먼트를 넣고
			queue.add(map[i][i]);
			// 레이어의 엘리먼트 만큼 반복한다
			for(int j = 0 ; j<rotate-1; j++) {
				int checkX = nx + dx[mode];
				int	checkY = ny + dy[mode];
				if(i <= checkX && checkX < x - i && i <= checkY && checkY < y - i) {
					queue.add(map[checkY][checkX]);
					nx = checkX;
					ny = checkY;
				}
				else{
					mode++;
				}
			}
			queue.pollLast();
			// 한바퀴를 돌면 재자리 이므로 mod로 중복 제거
			int rotateCount = round % (rotate - 4);
			// 나머지 만큼 회전
			for(int j = 0; j < rotateCount; j++) {
				queue.add(queue.poll());
			}
			nx = i;
			ny = i;
			mode = 0;
			// map에 삽입
			while(!queue.isEmpty()) {
				int checkX = nx + dx[mode];
				int	checkY = ny + dy[mode];
				if(i <= checkX && checkX < x - i && i <= checkY && checkY < y - i) {
					map[ny][nx] = queue.poll();
					nx = checkX;
					ny = checkY;
				}
				else{
					mode++;
				}
			}
			queue.clear();
		}
		//출력
		for(int i = 0; i < y; i++) {
			for(int j = 0; j < x; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
