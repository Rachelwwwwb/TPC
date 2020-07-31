import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokenizer = null;

	public static void main(String[] args){
		int n = nextInt();
		String name = next();
		int[] A = new int[301];

		for(int i=0; i<n; i++){
			int x = nextInt();
			A[x]++;
		}

		System.out.println(solve(A, name));
	}

	static String solve(int[] A, String name){
		int cnt = 0;
		for(int i=1; i<=300; i++){
			if(A[i] == 1)	return "Alice";
			if(A[i] == 2)	cnt++;
		}
		if(cnt == 0)	return "Bob";
		if(cnt == 1)	return name;
		return "Alice";
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