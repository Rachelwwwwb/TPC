import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokenizer = null;
	static int[] A;

	public static void main(String[] args){
		String s = next();

		int n = s.length();

		A = new int[n];

		for(int i=0; i<n; i++){
			A[i] = Character.getNumericValue(s.charAt(i));
		}

		long ans = -1;
		boolean[] vis = new boolean[10];

		for(int i=0; i<n; i++){
			vis[A[i]] = true;
			if(A[i] % 2 == 0 || A[i] == 5){
				continue;
			}
			for(int j=1; j<10 && i+j<n; j++){
				if(A[i+j] % 2 == 0)	break;
				if(A[i+j] == 5)	break;
				ans = Math.max(ans, solve(i, i+j));
			}
		}

		if(vis[2])	ans = Math.max(ans, 2);
		if(vis[3])	ans = Math.max(ans, 3);
		if(vis[5])	ans = Math.max(ans, 5);
		if(vis[7])	ans = Math.max(ans, 7);

		System.out.println(ans);
	}

	static long solve(int L, int R){
		int len = R - L + 1;
		long val;
		long ret = 0;
		for(int i=0; i<len; i++){
			val = 0;
			for(int j=0; j<len; j++){
				val = val * 10 + A[(i+j) % len + L];
			}
			if(!is_prime(val)){
				return -1;
			}
			ret = ret * 10 + A[L+i];
		}
		return ret;
	}

	static boolean is_prime(long x){
		for(long i=3; i*i<=x; i+=2){
			if(x % i == 0)	return false;
		}
		return true;
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