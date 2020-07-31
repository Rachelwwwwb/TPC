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
		int[][] mat = new int[1000][1000];
		for(int t=0; t<T; t++){
			int n = nextInt();
			long sum = 0;
			long dia = 0;
			int other_max = 0;
			int dia_min = Integer.MAX_VALUE;
			int dia_max = 0;

			for(int i=0; i<n; i++){
				for(int j=0; j<n; j++){
					mat[i][j] = nextInt();
					sum += mat[i][j];

					if(i != j && i + j != n - 1){
						other_max = Math.max(other_max, mat[i][j]);
					} else {
						dia_min = Math.min(dia_min, mat[i][j]);
						dia_max = Math.max(dia_max, mat[i][j]);
					}
				}
				dia += mat[i][i] + mat[i][n-1-i];
			}

			long diff = Math.max(0, other_max - dia_min);

			if(n % 2 == 1){
				int m = n >> 1;
				diff = Math.max(diff, (other_max - mat[m][m]) * 2);
				diff = Math.max(diff, dia_max - mat[m][m]);
			}

			System.out.println(diff + dia + sum * 2);
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