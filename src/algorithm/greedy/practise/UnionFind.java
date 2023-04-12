package algorithm.greedy.practise;

import java.util.Scanner;

public class UnionFind {
	
	static int[] unf; //집합번호를 저장하는 배열 unf[1] = 5 ; 1은 5 그룹에 속한다.
	static int[] uni;
	
	public static int Find(int v){
		if(v==unf[v]) return unf[v];
		 else return unf[v]=Find(unf[v]);
	}
	
	//두 수를 집합 맺어줌
	public static void Union(int a, int b){
		int fa=Find(a);
		int fb=Find(b);
		if(fa!=fb) unf[fa]=fb;
	}
	
	static void union(int a, int b) {
		int fa = find(a);
		int fb = find(b);
		if(fa != fb) unf[fa]=fb;
	}
	static int find(int v) {
		if(v == unf[v]) return unf[v];
		else return unf[v] = find(unf[v]);
	}
	static int fi (int v) {
		if(uni[v] == v) return uni[v];
		else return uni[v] = fi(uni[v]);
	}
	static int fi2(int v) {
		if(uni[v] == v) return v;
		else return uni[v] = find(uni[v]);
	}
	
	
	public static void main(String[] args){
		Scanner kb = new Scanner(System.in);
		int n=9; //반 학생수
		int m=7; //숫자 쌍 수
		int[][] node = 
			{{}
			,{1,2}
			,{2,3}
			,{3,4}
			,{1,5}
			,{6,7}
			,{7,8}
			,{8,9}};
		
		unf=new int[n+1];
		uni=new int[n+1];
		for(int i=1; i<=n; i++) unf[i]=i;
		for(int i=1; i<=m; i++){
			int a=node[i][0];
			int b=node[i][1];
			Union(a, b);
		}
		//a와 b는 친구니?
		int fa=Find(3);
		int fb=Find(8);
		if(fa==fb) System.out.println("YES");
		else System.out.println("NO");		
	}
}