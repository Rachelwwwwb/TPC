#include <bits/stdc++.h>

#define st first
#define nd second

using namespace std;

using ll = long long;
using pii = pair<int, int>;
const int N = 2E6 + 10;

pii a[N];
char s[N];

int main(){
	int cas;
	scanf("%d", &cas);
	while (cas--){
		int n;
		scanf("%d", &n);
		for (int i = 0; i < n; ++i){
			scanf("%d", &a[i].st);
			a[i].nd = i;
		}
		sort(a, a + n, greater<pii>());
		int diff = 0;
		for (int i = 0; i < n; ++i)
			if (diff > 0){
				s[a[i].nd] = 'b';
				diff -= a[i].st;
			}
			else{
				s[a[i].nd] = 'a';
				diff += a[i].st;
			}
		s[n] = '\0';
		puts(s);
	}
	return 0;
}
