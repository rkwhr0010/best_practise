package algorithm.bfs.pratise;

import java.util.LinkedList;
import java.util.Queue;

public class 최단 {
	//한 턴당 움직이는 경우의 수
	static int[] dis = {1,-1,5};
	//최대 거리
	static int max;
	//메모이제이션
	static boolean[] chk;
	//시작 위치
	static int start;
	//목적지
	static int end;
	//최단거리 
	static int answer;
	public static void main(String[] args) {
		max = 10000;
		chk = new boolean[max+1];//0사용 안함
		start = 4;
		end = 50;
		BFS(start);
		System.out.println(answer);
	}
	private static void BFS(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		
		while(!q.isEmpty()) {
			answer++;
			for(int i=0,len = q.size();i<len;i++) {
				int value = q.poll();
				if(value == end) return;
				
				for(int next : dis) {
					int nv = next + value;
					if(nv>=1&&nv<=10000&& chk[nv]==false) {
						q.add(nv);
						chk[nv]= true;
					}
				}
			}
		}
	}
}
