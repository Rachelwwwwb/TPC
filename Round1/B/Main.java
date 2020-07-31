import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokenizer = null;

	public static void main(String[] args){
		int T = nextInt();
		int n;
		String s1, s2;

		for(int t=1; t<=T; t++){
			n = nextInt();
			s1 = next();
			s2 = next();

			System.out.println(solve(n, s1, s2));
		}
	}

	static int solve(int n, String s1, String s2){
		s1 = "*" + s1 + "*";
		s2 = "*" + s2 + "*";
		int pre = 0, ret = 0, tmp = 0;
		for(int i=1; i<=n+1; i++){
			if(s1.charAt(i) == s2.charAt(i)){
				if(pre != i-1){
					tmp = query(s1, s2, pre+1, i-1);
					if(tmp == -1)	return -1;
					ret += tmp;
				}
				pre = i;
			}
		}
		return ret;
	}

	static int query(String s1, String s2, int a, int b){
		for(int i=a+1; i<=b; i++){
			if(s2.charAt(i) != s2.charAt(a))	return -1;
		}
		if(s1.charAt(a) == s1.charAt(a-1) || s1.charAt(b) == s1.charAt(b+1))	return -1;
		return 1;
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