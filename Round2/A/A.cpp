#include<bits/stdc++.h>
using namespace std;

int T, n;
char s[100];
int ans[10];

int decode(char ch){
	if('0' <= ch && ch<='9')	return ch - '0';
	return ch - 'a' + 10;
}

void solve1(int a, int b){
	int cur, m;
	for(int i=0; i<8; i++)	ans[i] = 0;
	m = 0;
	cur = 0;
	if(a != 0){
		for(int i=0; i<=a; i++){
			if(s[i] == ':'){
				ans[m++] = cur;
				cur = 0;
			} else {
				cur = cur << 4 | decode(s[i]);
			}
		}
	}

	m = 7;
	int p = 0;
	cur = 0;

	for(int i=n-1; i>=b; i--){
		if(s[i] == ':'){
			ans[m--] = cur;
			cur = 0;
			p = 0;
		} else {
			cur = decode(s[i]) << p | cur;
			p += 4;
		}
	}
}

void solve(){
	n = strlen(s);
	for(int i=1; i<n; i++){
		if(s[i] == ':' && s[i-1] == ':'){
			solve1(i-1, i);
			return;
		}
	}
	int m = 0, cur = 0;
	for(int i=0; i<n; i++){
		if(s[i] == ':'){
			ans[m++] = cur;
			cur = 0;
		} else {
			cur = cur << 4 | decode(s[i]);
		}
	}
	ans[m++] = cur;
}

int main(){
	scanf("%d", &T);
	while(T--){
		scanf("%s", s);
		solve();
		for(int i=0; i<8; i++){
			printf("%04x%c", ans[i], i==7?'\n':':');
		}
	}
	return 0;
}
