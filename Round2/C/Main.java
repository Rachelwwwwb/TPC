import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokenizer = null;
	static String[][] list;

	public static void main(String[] args){
		list = new String[][]{
			{"TP","C"},
			{"PT","C"},
			{"T","PC"},
			{"T","CP"}
		};

		int cases = nextInt();
		int n, ans;
		String s;

		for(int cas=0; cas<cases; cas++){
			n = nextInt();
			s = next();

			ans = solve(s);

			if(ans == -1){
				System.out.println("Impossible");
			} else {
				System.out.println(ans);
			}
		}
	}

	static int solve(String s){
		if(s.indexOf('T') == -1 || s.indexOf('P') == -1 || s.indexOf('C') == -1){
			return -1;
		}
		if(s.indexOf("TPC") != -1){
			return 0;
		}
		if(s.indexOf("CPT") != -1){
			return 1;
		}

		int p, q;

		for(int i=0; i<4; i++){
			p = s.indexOf(list[i][0]);
			q = s.lastIndexOf(list[i][1]);
			if(p != -1 && q != -1 && p < q)	return 1;
		}

		if(s.lastIndexOf('C')<s.indexOf('P')-1 && s.lastIndexOf('P')<s.indexOf('T')-1){
			return 3;
		}

		return 2;
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