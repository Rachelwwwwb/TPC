#include<bits/stdc++.h>
using namespace std;

const int N = 310;

int n, m, a[N];
char s[110], ans[2][10] = {"Alice", "Bob"};

int solve(){
	int cnt = 0;
	for(int i=1; i<=m; i++){
		if(a[i] == 1)   return 0;
		if(a[i] == 2)   cnt++;
	}
	if(cnt == 0)    return 1;
	if(cnt == 1){
	if(strcmp(s, ans[0]) == 0)  return 0;
		return 1;
	}
	return 0;
}

int main(){
	scanf("%d %s", &n, s);

	memset(a, 0, sizeof(a));
	m = 0;
	int x = 0;
	for(int i=0; i<n; i++){
		scanf("%d", &x);
		m = max(m, x);
		a[x]++;
	}

	puts(ans[solve()]);

	return 0;
}
