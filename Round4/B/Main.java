import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokenizer = null;

	public static void main(String[] args){
		int T = nextInt();
		int offset = 20;
		int mask = (1 << offset) - 1;

		for(int t=1; t<=T; t++){
			int n = nextInt();
			int m = n >> 1;

			long[] A = new long[n];

			for(int i=0; i<n; i++){
				A[i] = (long)nextInt() << offset | i;
			}

			Arrays.sort(A);

			long ans = 0;
			for(int i=0; i<m; i++){
				long p = A[i] & mask;
				if(p >= m){
					ans += p;
				}
			}
			for(int i=m; i<n; i++){
				long p = A[i] & mask;
				if(p < m){
					ans -= p;
				}
			}
			System.out.println(ans);
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