package algorithm.bfs.pratise;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class 중요_미로최단연습 {
	static class Route{
		public int x, y;
		Route(int x, int y){
			this.x=x;
			this.y=y;
		}
	}
	
	static int[] dx={-1, 0, 1, 0};
	static int[] dy={0, 1, 0, -1};
	static int[][] board, dis;
	
	static {
		int[][] input = {
				{0, 0, 0, 0, 0, 0, 0},
				{0, 1, 1, 1, 1, 1, 0},
				{0, 0, 0, 1, 0, 0, 0},
				{1, 1, 0, 1, 0, 1, 1},
				{1, 1, 0, 1, 0, 0, 0},
				{1, 0, 0, 0, 1, 0, 0},
				{1, 0, 1, 0, 0, 0, 0}
		};
		
		
		board=new int[8][8];
		dis=new int[8][8];
		for(int i=1; i<=7; i++){
			for(int j=1; j<=7; j++){
				board[i][j]=input[i-1][j-1];
			}
		}
	}
	
	
	static void BFS(int x, int y) {
		Queue<Route> Q = new LinkedList<>();
		Q.offer(new Route(x, y));
		board[x][y] = 1;
		
		while(!Q.isEmpty()) {
			Route p = Q.poll();
			for (int i = 0; i < dx.length; i++) {
				int nx = p.x+dx[i];
				int ny = p.y+dy[i];
				if(fromClosedTo(nx, ny) && board[nx][ny]==0) {
					board[nx][ny]=1;
					Q.offer(new Route(nx, ny));
					dis[nx][ny]= dis[p.x][p.y]+1;
				}
			}
		}
	}
	static void BFS4(int x, int y) {
		LinkedList<Route> q = new LinkedList<>();
		q.offer(new Route(x, y));
		board[x][y]=1;
		
		while(!q.isEmpty()) {
			Route r = q.poll();
			for(int i=0;i<dy.length;i++) {
				int nx = r.x+dx[i];
				int ny = r.y+dy[i];
				if(fromClosedTo(nx, ny)&& board[nx][ny]==0) {
					board[nx][ny] = 1;
					dis[nx][ny] = dis[r.x][r.y]+1;
					q.offer(new Route(nx, ny));
				}
				
			}
		}
	}
	
	static void B(int x, int y) {
		LinkedList<Route> list = new LinkedList<>();
		//현재 시작점
		list.add(new Route(x, y));
		//현재 방문했다.
		board[x][y] = 1;
		
		//안비었다
		while(!list.isEmpty()) {
			//현 위치
			Route now = list.poll();
			//다음 위치
			for(int i=0;i<dx.length;i++) {
				//다음으로 갈 위치 얻기
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				//유효한 위치인가?, 방문한적 있는가?
				if(fromClosedTo(nx, ny) && board[nx][ny] == 0) {
					//방명록 작성
					board[nx][ny] = 1;
					dis[nx][ny] = dis[now.x][now.y]+1; //좀 더 시간이 걸린다.
					list.add(new Route(nx, ny));
				}
			}
		}
	}
	
	static void BB(int x, int y) {
		//선입 선출을 위함
		ArrayDeque<Route> deque = new ArrayDeque<>();
		//방명록 작성
		board[x][y] = 1;
		deque.offer(new Route(x, y));
		
		//비어있냐
		while(!deque.isEmpty()) {
			//현재 위치
			Route now = deque.pollFirst();
			//다음으로 갈 위치값 
			for(int i=0; i<dx.length;i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				//타당성 검사
				if(fromClosedTo(nx, ny) && board[nx][ny] == 0) {
					//방명록 작성
					board[nx][ny]  = 1;
					dis[nx][ny]  = dis[now.x][now.y] +1;
					deque.offer(new Route(nx, ny));
				}
			}
		}
	}
	
	
	private static boolean fromClosedTo(int nx, int ny) {
		return nx>=1 && nx <=7 && ny>=1 && ny<=7;
	}
	
	
	
	public static void main(String[] args) {
//		BFS2(1, 1);
		BB(1, 1);
		if(dis[7][7]==0) System.out.println(-1);
		else System.out.println(dis[7][7]);
	}
}
/*
12
*/