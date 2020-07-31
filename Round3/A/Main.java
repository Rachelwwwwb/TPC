import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokenizer = null;
	static int[] primes = new int[]{2, 3, 5, 7, 11};

	public static void main(String[] args){
		int T = nextInt();
		int ans = 0;
		for(int t=0; t<T; t++){
			int n = nextInt();
			String c = next();
			switch(c){
				case "divide_by_three":
					ans = div(n, 3);
					break;
				case "divide_by_four":
					ans = div(n, 4);
					break;
				case "divide_by_five":
					ans = div(n, 5);
					break;
				default:
					ans = prime(n);
					break;
			}
			System.out.println(ans);
		}
	}

	static int div(int n, int mod){
		if(n % mod == 0)	return 0;
		else	return mod - n % mod;
	}

	static int prime(int n){
		for(int i=0; i<5; i++){
			if(primes[i] >= n){
				return primes[i] - n;
			}
		}
		return 0;
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