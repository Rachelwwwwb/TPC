#include<bits/stdc++.h>
using namespace std;

const int N = 1e5 + 10;
const int M = 256;

int T, n;
char s[N];
int fst[M], lst[M];

int solve(){
	memset(fst, 0x3f, sizeof(fst));
	memset(lst, -1, sizeof(lst));

	for(int i=0; i<n; i++){
		fst[s[i]] = min(fst[s[i]], i);
		lst[s[i]] = max(lst[s[i]], i);
	}

	if(lst['T']==-1 || lst['P']==-1 || lst['C']==-1){
		return -1;
	}

	for(int i=0; i+2<n; i++){
		if(s[i]=='T' && s[i+1]=='P' && s[i+2]=='C'){
			return 0;
		}
	}

	for(int i=0; i+2<n; i++){
		if(s[i]=='C' && s[i+1]=='P' && s[i+2]=='T'){
			return 1;
		}
	}

	for(int i=0; i<n-1; i++){
		if(s[i]=='T' && s[i+1]=='P' && lst['C']>i)	return 1;
		if(s[i]=='P' && s[i+1]=='T' && lst['C']>i)	return 1;
		if(fst['T']<i && s[i]=='P' && s[i+1]=='C')	return 1;
		if(fst['T']<i && s[i]=='C' && s[i+1]=='P')	return 1;
	}

	if(lst['C']<fst['P']-1 && lst['P']<fst['T']-1){
		return 3;
	}

	return 2;
}

int main(){
	scanf("%d", &T);
	while(T--){
		scanf("%d %s", &n, s);
		int ans = solve();
		if(ans == -1)	puts("Impossible");
		else	printf("%d\n", ans);
	}
	return 0;
}
