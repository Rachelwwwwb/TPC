import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokenizer = null;
	static ArrayList<ArrayList<Integer>> V = new ArrayList<ArrayList<Integer>>();
	static ArrayList<ArrayList<Integer>> G = new ArrayList<ArrayList<Integer>>();
	static boolean[] vis = new boolean[100010];
	static PriorityQueue<Integer> Q = new PriorityQueue<Integer>();
	static int[] cur = new int[100010];
	static int[] len = new int[100010];
	static int[] ST = new int[100010];

	public static void main(String[] args){
		for(int i=1; i<=100010; i++){
			V.add(new ArrayList<Integer>());
			G.add(new ArrayList<Integer>());
		}
		int T = nextInt();
		int n, m;
		int x, y;

		for(int t=1; t<=T; t++){
			n = nextInt();
			m = nextInt();

			for(int i=1; i<=n; i++){
				vis[i] = false;
				V.get(i).clear();
				G.get(i).clear();
			}

			for(int i=1; i<=m; i++){
				x = nextInt();
				y = nextInt();
				V.get(x).add(y);
				V.get(y).add(x);
			}

			build_tree(n);
			out();
		}
	}

	static void build_tree(int n){
		//这题用递归会栈溢出，所以只能手动模拟递归 （╯‵□′）╯︵┴─┴
		for(int i=1; i<=n; i++){
			Collections.sort(V.get(i), new Comparator<Integer>(){
				public int compare(Integer a, Integer b){
					return a > b ? -1 : 1;
				}
			});

			cur[i] = 0;
			len[i] = V.get(i).size();
		}

		int top = 0;

		ST[top++] = 1;
		int x, y;
		vis[1] = true;

		while(top > 0){
			x = ST[--top];

			if(cur[x] < len[x]){
				y = V.get(x).get(cur[x]);
				cur[x]++;
				ST[top++] = x;
				if(!vis[y]){
					vis[y] = true;
					G.get(x).add(y);
					ST[top++] = y;
				}
			}
		}
	}

	static void out(){
		System.out.print("1");

		for(Integer j : G.get(1)){
			Q.add(j);
		}

		int x;

		while(!Q.isEmpty()){
			x = Q.poll();
			System.out.print(" " + x);
			for(Integer j : G.get(x)){
				Q.add(j);
			}
		}

		System.out.print("\n");
	}

	static String next(){
		while(tokenizer == null || !tokenizer.hasMoreTokens()){
			try{
				tokenizer = new StringTokenizer(reader.readLine());
			} catch (IOException e){
				throw new RuntimeException(e);
			}
		}
		return tokenizer.nextToken();
	}

	static int nextInt(){
		return Integer.parseInt(next());
	}
}