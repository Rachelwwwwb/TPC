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
		String[] s;
		String[] ans = new String[8];

		for(int t=1; t<=T; t++){
			s = next().split(":", -1);
			for(int i=0; i<8; i++)	ans[i] = "0000";
			n = s.length;
			for(int i=0; i<n; i++){
				if(s[i].equals("")){
					break;
				}
				ans[i] = String.format("%04x", Integer.parseInt(s[i], 16));
			}
			for(int i=7, j=n-1; i>=0 && j>=0; i--, j--){
				if(s[j].equals("")){
					break;
				}
				ans[i] = String.format("%04x", Integer.parseInt(s[j], 16));
			}

			System.out.println(String.join(":", ans));
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