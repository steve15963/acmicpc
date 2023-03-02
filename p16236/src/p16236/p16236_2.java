package p16236;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//백준 16236. 아기 상어
public class p16236_2 {
	//입력받은 array
	static int[][]map;
	//입력받은 n, 상어 x,y좌표, 이동 시간(답), 현재 상어 크기, 현재 먹은 물고기 수, 남은 물고기 수
	static int n,curX,curY,answer=0,curSize=2,curEaten=0,left;
	static int[]dx = {-1,0,0,1};
	static int[]dy = {0,-1,1,0};
	//bfs
	static void bfs() {
		int x,y,nx,ny,depth;
		//방문 여부 체크
		boolean[][]visited = new boolean[n][n];
		Queue<int[]>q = new LinkedList<int[]>();
		//현재 상어 위치 q에 offer, 방문 여부 체크
		q.offer(new int[]{curX,curY,1});
		visited[curX][curY]=true;
		//다음 먹을 물고기 위치와 가는 데 걸린 시간 초기화
		int nextX=-1,nextY=-1,nextDepth=Integer.MAX_VALUE;
		
		while(!q.isEmpty()) {
			int[]temp = q.poll();
			x=temp[0];
			y=temp[1];
			depth=temp[2];
			//다음 먹기로 정해진 물고기까지의 이동거리보다 탐색할 위치가 더 오래 걸리면 탐색 종료
			if(nextDepth<depth)break;
			//4방으로 이동
			for(int i=0;i<4;i++) {
				nx=x+dx[i];
				ny=y+dy[i];
				//map안에 있고, 현재 상어의 크기보다 작은 곳으로 이동
				if(nx>=0&&nx<n&&ny>=0&&ny<n&&!visited[nx][ny]&&map[nx][ny]<=curSize) {
					//이동한 위치에 물고기가 있고 현재 상어의 크기보다 작을 때
					if(map[nx][ny]>0&&curSize>map[nx][ny]) {
						//다음 먹을 물고기가 정해지지 않았을 때
						if(nextX==-1) {
							nextX=nx;
							nextY=ny;
							nextDepth=depth;
						}
						//다음 먹을 물고기가 정해졌을 때
						else {
							//다음 먹을 물고기보다 현재 물고기가 더 위쪽에 위치 -> 다음 먹을 물고기 변경
							if(nextX>nx) {
								nextX=nx;
								nextY=ny;
							}
							//다음 먹을 물고기보다 현재 물고기가 더 왼쪽에 위치 -> 다음 먹을 물고기 변경
							else if(nextX==nx) {
								if(nextY>ny) {
									nextX=nx;
									nextY=ny;
								}							
							}
						}
					}
					//방문 여부 체크
					visited[nx][ny]=true;
					//큐 offer
					q.offer(new int[]{nx,ny,depth+1});
				}
			}
		}
		//먹을 수 있는 물고기가 있을 때
		if(nextX!=-1) {
			map[nextX][nextY]=0;
			answer+=nextDepth;
			left--;
			curX=nextX;
			curY=nextY;
			curEaten++;
			//현재 먹은 물고기 수와 현재 상어의 크기가 같을 때 크기 up
			if(curEaten==curSize) {
				curEaten=0;
				curSize++;
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		left=0;
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==9) {
					curX=i;
					curY=j;
					map[curX][curY]=0;
				}
				//물고기 수 count
				else if(map[i][j]>0)left++;
			}
		}
		int temp;
		//남은 물고기가 없을 때까지
		while(left!=0) {
			//탐색 전 물고기 수 저장 
			temp=left;
			bfs();
			//탐색하고도 남은 물고기 수가 같으면 종료-> 더 이상 먹을 수 있는 물고기가 없음
			if(temp==left)break;
		}
		System.out.println(answer);
	}
}
