import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokenizer = null;
	static int mod = 1000000007;
	static int[][][] dp;

	public static void main(String[] args){
		dp = new int[2][5000 / 3 + 1][8];
		int T = nextInt();
		int n, k;
		String s;

		for(int t=1; t<=T; t++){
			n = nextInt();
			k = nextInt();
			s = next();

			System.out.println(solve(n, k, s));
		}
	}

	static int add(int a, int b){
		a += b;
		if(a >= mod)    a -= mod;
		return a;
	}

	static void clr(int f, int m){
		for(int i=0; i<=m; i++){
			for(int j=0; j<8; j++)	dp[f][i][j] = 0;
		}
	}

	static int solve(int n, int k, String s){
		if(k * 3 > n)	return 0;
		int m = n / 3;

		clr(0, m);

		dp[0][0][0] = 1;
		int v;
		int base = (int)'0';
		int f = 0;

		for(int i=1; i<=n; i++){
			clr(f^1, m);
			if(s.charAt(i-1) == '?'){
				v = 0;
			} else {
				v = 1 << ((int)s.charAt(i-1) - base);
			}

			for(int j=0; j<=m; j++){
				for(int l=0; l<8; l++){
					if(v == 0){
						dp[f^1][j][l|1] = add(dp[f^1][j][l|1], dp[f][j][l]);
						dp[f^1][j][l|2] = add(dp[f^1][j][l|2], dp[f][j][l]);
						dp[f^1][j][l|4] = add(dp[f^1][j][l|4], dp[f][j][l]);
					} else {
						dp[f^1][j][l|v] = add(dp[f^1][j][l|v], dp[f][j][l]);
					}
				}
			}

			for(int j=1; j<=m; j++){
				dp[f^1][j][0] = add(dp[f^1][j][0], dp[f^1][j-1][7]);
				dp[f^1][j-1][7] = 0;
			}

			f ^= 1;
		}

		int ret = 0;
		for(int i=k; i<=m; i++){
			for(int j=0; j<8; j++)  ret = add(ret, dp[f][i][j]);
		}

		return ret;
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