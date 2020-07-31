import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main{
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokenizer = null;
	static int[] map, fac, buf;
	static boolean[] vis;

	public static void main(String[] args){
		init();
		
		int T = nextInt();
		int[] idx = new int[10];
		String s;
		int v;

		int[] A = new int[9];

		for(int t=1; t<=T; t++){
			for(int i=0; i<3; i++){
				s = next();
				for(int j=0; j<3; j++){
					v = ((int)s.charAt(j)) - ((int)'1');
					
					idx[v] = i * 3 + j;
				}
			}

			for(int i=0; i<3; i++){
				s = next();
				for(int j=0; j<3; j++){
					v = ((int)s.charAt(j)) - ((int)'1');
					A[i*3+j] = idx[v];
				}
			}

			v = encode(A);

			if(map[v] != -1){
				System.out.println(map[v]);
			} else {
				System.out.println("impossible");
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

	static void init(){
		int[] A = new int[9];
		for(int i=0; i<9; i++){
            A[i] = i;
		}

		buf = new int[9];
		fac = new int[9];
		fac[0] = 1;
		for(int i=1; i<9; i++)	fac[i] = fac[i-1] * i;
		
		vis = new boolean[9];

		int x = encode(A);

		int sum = fac[8] * 9 + 10;
		map = new int[sum];
		
		for(int i=0; i<sum; i++)	map[i] = -1;
		map[x] = 0;

		int[] Q = new int[sum];
		int head = 0, tail = 0;

		Q[tail++] = x;

		int y, v;
		int cur;

		while(head < tail){
			x = Q[head++];

			decode(x, A);

			cur = map[x] + 1;

			for(int i=0; i<9; i+=3){
				y = A[i+2];
				A[i+2] = A[i+1];
				A[i+1] = A[i];
				A[i] = y;

				v = encode(A);

				if(map[v] == -1){
					map[v] = cur;
					Q[tail++] = v;
				}

                A[i] = A[i+1];
                A[i+1] = A[i+2];
                A[i+2] = y;
			}
			for(int i=0; i<3; i++){
				y = A[i+6];
                A[i+6] = A[i+3];
                A[i+3] = A[i];
                A[i] = y;

				v = encode(A);
				if(map[v] == -1){
					map[v] = cur;
					Q[tail++] = v;
				}

                A[i] = A[i+3];
                A[i+3] = A[i+6];
                A[i+6] = y;
			}
		}
	}

	static int encode(int A[]){
		int ret = 0;
		int c;

		for(int i=0; i<9; i++){
			c = 0;
			for(int j=i+1; j<9; j++){
				if(A[j] < A[i])	c++;
			}
			ret = ret + c * fac[8-i];
		}
		return ret + 1;
	}

	static void decode(int x, int ret[]){
		x--;
		int m = 8, L, k;
		for(int i=0; i<9; i++)	vis[i] = false;
		for(int i=0; i<9; i++){
			k = x / fac[m];

			for(L=0; L<=8; L++){
				if(!vis[L]){
					if(k == 0)	break;
					k--;
				}
			}
			ret[i] = L;
			vis[L] = true;	
			x = x % fac[m];
			m--;
		}
	}
}
