import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokenizer = null;
	static PriorityQueue<Integer> heap;
	static int[] C = new int[100010];
	static int[] val = new int[100010];
	static int[][] ch = new int[100010][2];
	static int[] Q = new int[100010];
	static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args){
		int T = nextInt();
		int x;

		heap = new PriorityQueue<Integer>(100010, new Comparator<Integer>(){
			public int compare(Integer a, Integer b) {
				return C[a] > C[b] ? -1 : 1;
			}
		});

		for(int t=1; t<=T; t++){
			int n = nextInt();
			for(int i=1; i<=n; i++){
				C[i] = 0;
			}
			int mx = 0;
			for(int i=1; i<=n; i++){
				x = nextInt();
				C[x]++;
				mx = Math.max(mx, C[x]);
			}

			if(4 * (n - mx) + 1 >= n){
				solve(n);
				out.println("Yes");
				for(int i=1; i<=n; i++){
					out.printf("%d %d %d\n", val[i], ch[i][0], ch[i][1]);
				}
			} else {
				out.println("No");
			}
			out.flush();
		}
	}

	static void solve(int n){
		for(int i=1; i<=n; i++){
			ch[i][0] = ch[i][1] = 0;
			if(C[i] > 0){
				heap.add(i);
			}
		}

		int p1, p2;

		p1 = heap.poll();
		val[1] = p1;
		if(--C[p1] > 0){
			heap.add(p1);
		}

		int head = 0, tail = 0;
		Q[tail++] = 1;
		int num = 2, x;

		while(!heap.isEmpty()){
			p1 = heap.poll();
			x = Q[head++];

			if(C[p1] >= 2 && p1 != val[x]){
				ch[x][0] = num;
				ch[x][1] = num + 1;
				val[num] = val[num + 1] = p1;
				Q[tail++] = num;
				Q[tail++] = num + 1;
				num += 2;
				C[p1] -= 2;
				if(C[p1] > 0)	heap.add(p1);
			} else if(!heap.isEmpty()){
				p2 = heap.poll();
				ch[x][0] = num;
				ch[x][1] = num + 1;
				if(p1 > val[x] || p2 < val[x]){
					val[num] = p1;
					val[num+1] = p2;
				} else {
					val[num] = p2;
					val[num+1] = p1;
				}
				Q[tail++] = num;
				Q[tail++] = num + 1;
				num += 2;
				if(--C[p1] > 0)	heap.add(p1);
				if(--C[p2] > 0)	heap.add(p2);
			} else if(p1 != val[x]){
				val[num] = p1;
				if(p1 > val[x]){
					ch[x][0] = num;
				} else {
					ch[x][1] = num;
				}
				Q[tail++] = num;
				num += 1;
				if(--C[p1] > 0)	heap.add(p1);
			} else {
				heap.add(p1);
			}
		}
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