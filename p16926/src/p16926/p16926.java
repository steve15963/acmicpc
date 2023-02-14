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
		
		//ù init�� ������
		String sData[] = br.readLine().split(" ");
		
		int y 		= Integer.parseInt(sData[0]);
		int x 		= Integer.parseInt(sData[1]);
		int round 	= Integer.parseInt(sData[2]);
		
		//�� ���̾� ����.
		int rotateDep = Math.min(x, y) / 2;
		// �Է� �� 
		int map[][] = new int[y][x];

		for(int i = 0 ; i < y; i ++) {
			sData = br.readLine().split(" ");
			for(int j = 0; j <  x; j ++) {
				map[i][j] = Integer.parseInt(sData[j]);
			}
		}
		
		
		LinkedList<Integer> queue = new LinkedList<Integer>();
		//���̾� ��ŭ �ݺ�
		for(int i = 0 ; i < rotateDep; i++) {
			int nx = i;
			int ny = i;
			int mode = 0;
			// ���̾��� ������Ʈ��
			int rotate = (((x - (i * 2)) * 2) + ((y - (i * 2)) * 2));
			// ù ������Ʈ�� �ְ�
			queue.add(map[i][i]);
			// ���̾��� ������Ʈ ��ŭ �ݺ��Ѵ�
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
			// �ѹ����� ���� ���ڸ� �̹Ƿ� mod�� �ߺ� ����
			int rotateCount = round % (rotate - 4);
			// ������ ��ŭ ȸ��
			for(int j = 0; j < rotateCount; j++) {
				queue.add(queue.poll());
			}
			nx = i;
			ny = i;
			mode = 0;
			// map�� ����
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
		//���
		for(int i = 0; i < y; i++) {
			for(int j = 0; j < x; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
