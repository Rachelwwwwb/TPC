import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Random;

public class Main {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokenizer = null;

	public static void main(String[] args){
		int T = nextInt();
		int n, l, r;
		for(int t=1; t<=T; t++){
			n = nextInt();
			Treap treap = new Treap();
			for(int i=0; i<n; i++){
				l = nextInt();
				r = nextInt();
				treap.add(l, r);
			}
			System.out.println(treap.sz());
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

class Treap{
	class TreapNode{
		int val, pri, lazy;
		TreapNode lson, rson;

		public TreapNode(){}
		public TreapNode(TreapNode lson, TreapNode rson, int val, int pri){
			this.lson = lson;
			this.rson = rson;
			this.val = val;
			this.pri = pri;
			this.lazy = 0;
		}

		public void pushdown(){
			if(this.lazy == 0)	return;
			this.lson.lazy += this.lazy;
			this.rson.lazy += this.lazy;
			this.lson.val += this.lazy;
			this.rson.val += this.lazy;
			this.lazy = 0;
		}
	}

	class MyPair{
		TreapNode x, y;
		public MyPair(){}
		public MyPair(TreapNode x, TreapNode y){
			this.x = x;
			this.y = y;
		}
	}

	TreapNode N;
	TreapNode root;
	Random r;

	public Treap(){
		this.N = new TreapNode(null, null, 0, 0);
		this.root = N;
		this.r = new Random(233);
	}

	MyPair split_smallest(TreapNode o){
		if(o == N){
			return new MyPair(N, N);
		}
		o.pushdown();
		if(o.lson == N){
			return new MyPair(N, o.rson);
		}
		MyPair ret = split_smallest(o.lson);
		o.lson = ret.y;
		ret.y = o;
		return ret;
	}
	
	private MyPair split_l(TreapNode o, int val){
		if(o == N){
			return new MyPair(N, N);
		}
		MyPair ret = new MyPair(N, N);
		o.pushdown();
		if(o.val <= val){
			ret = split_l(o.rson, val);
			o.rson = ret.x;
			ret.x = o;
		} else {
			ret = split_l(o.lson, val);
			o.lson = ret.y;
			ret.y = o;
		}
		return ret;
	}

	private MyPair split_r(TreapNode o, int val){
		if(o == N){
			return new MyPair(N, N);
		}
		o.pushdown();
		MyPair ret = new MyPair(N, N);
		if(o.val < val){
			ret = split_r(o.rson, val);
			o.rson = ret.x;
			ret.x = o;
		} else {
			ret = split_r(o.lson, val);
			o.lson = ret.y;
			ret.y = o;
		}
		return ret;
	}

	private TreapNode merge(TreapNode left, TreapNode right){
		if(left == N)	return right;
		if(right == N)	return left;
		left.pushdown();
		right.pushdown();
		if(left.pri < right.pri){
			left.rson = merge(left.rson, right);
			return left;
		} else {
			right.lson = merge(left, right.lson);
			return right;
		}
	}

	public void add(int l, int r){
		MyPair a = split_r(this.root, l);
		MyPair b = split_r(a.y, r);

		if(b.x != N){
			b.x.val++;
			b.x.lazy++;
		}

		MyPair c = split_smallest(b.y);

		TreapNode cur = new TreapNode(N, N, l, this.r.nextInt(1000000000) + 1);
		this.root = merge(a.x, merge(cur, merge(b.x, c.y)));
	}

	private int _sz(TreapNode o){
		if(o == N)	return 0;
		return 1 + _sz(o.lson) + _sz(o.rson);
	}

	public int sz(){
		return _sz(this.root);
	}
}