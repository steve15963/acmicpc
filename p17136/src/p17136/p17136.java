package p17136;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p17136 {
	static int ans = 0;
	static int count;
	static boolean flag;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		//1, 2, 3, 4, 5;
		int colorPaper[] = {0,5,5,5,5,5};
		
		int map[][] = new int[10][10];
		
		//�Է�
		for(int i = 0 ; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < 10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1)
					count++;
			}
		}
		if(count == 0) {
			System.out.println(0);
			return;
		}
		//�Է� ��
		
		//ó��
		//ū �����̺���
		for(int length = 5; length >= 0; length--) {
			DFS(0,map,colorPaper,0,length);
			if(flag) break;
		}
		//ó�� ��
		
		//���
		System.out.println(ans);
		//��� ��

	}
	private static void DFS(int cnt,int[][] map, int[] colorPaper, int start,int length) {
		// ��ĥ�� ��� �Ǿ��ٸ� �����Ѵ�.
		if(count <= 0 || colorPaper[length] == 0) {
			flag = true;
			if(count != 0)
				ans = -1;
			return;
		}
		//�ش� ũ���� �����̰� ���� �ִ°�?
		if(colorPaper[length] == 0) return; 
		
		//���ư��鼭
		for(int i = start / 10; i < 10; i ++) {
			for(int j = start % 10; j < 10; j++) {
				//�ش� ��ġ�� �����̶��
				if(map[i][j] == 1) {
					// ���� �����ؼ�
					//int copyMap[][] = copy(map);
					
					// ��ĥ�غ���.
					int status = paint(map,length,i,j);
					
					//��ĥ�� ĭ�� ���ٸ� �Ұ��� �ϹǷ� ��������
					if(status == 0) continue;
					//��ĥ�� ��ŭ count���� ����.
					count -= status;
					ans++;

					
					//��� ��ĥ���� �ʾҴٸ�. ����.
					colorPaper[length]--;
					DFS(cnt + 1,map, colorPaper, (i * 10) + j + length,length);
					if(flag) return;
				}
			}
		}
	}
	private static int paint(int[][] map, int length, int y, int x) {
		
		if(length == 1) {
			if(map[y][x] == 1) {
				map[y][x] = 2;
				return 1;
			}
			return 0;
		}
		int maxX = x + length;
		int maxY = y + length;
		
		
		//������ �Ѿ ���
		if(!isCan(maxX,maxY))
			return 0;
		
		
		//�˻�
		for(int i = y;i < maxY; i++) {
			for(int j = x;j < maxX; j++) {
				//1 = ����, 2 = ä�� ������
				//�� ������ �ƴϸ� ä�� �Ұ���.
				if(map[i][j] != 1)
					return 0;
			}
		}
		
		//ä���
		for(int i = y;i < maxY; i++) {
			for(int j = x;j < maxX; j++) {
				map[i][j] = 2;
			}
		}
		
		return length * length;
	}
	private static boolean isCan(int i, int j) {
		return 0 <= i && i <= 10 && 0 <= j && j <= 10;
	}


}
