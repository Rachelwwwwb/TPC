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
		String s;
		int n, C0, C1;
		StringBuffer sb = new StringBuffer();
		for(int t=0; t<T; t++){
			sb.setLength(0);
			s = next();
			C0 = C1 = 0;
			n = s.length();
			for(int i=0; i<n; i++){
				if(s.charAt(i) == '0'){
					C0++;
				} else {
					C1++;
				}
			}

			if(C0 == 0){
				System.out.println(s);
				continue;
			}

			if(C0 > C1 * 2 + 2){
				System.out.println("Impossible");
				continue;
			}

			int p = (C0 - 1) / 2;

			for(int i=0; i<C1 - p; i++){
				sb.append("1");
			}
			for(int i=0; i<p; i++){
				sb.append("001");
			}
			for(int i=0; i<C0 - p * 2; i++){
				sb.append("0");
			}

			System.out.println(sb);
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