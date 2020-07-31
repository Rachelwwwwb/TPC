#include <bits/stdc++.h>

using namespace std;

using ll = long long;

const int N = 5E3 + 10, K = N / 3 + 2;
const int M = 1E9 + 7;

ll dp[2][8][K];
char s[N];

inline void upd(ll &x, ll y){
	x += y;
	if (x >= M)
		x -= M;
}

int main(){
	int cas;
	scanf("%d", &cas);
	while (cas--){
		int n, m;
		scanf("%d%d", &n, &m);
		scanf("%s", s + 1);

		if (n / 3 < m){
			puts("0");
			continue;
		}

		for (int j = 0; j < 8; ++j)
			dp[0][j][0] = dp[0][j][1] = 0;
		dp[0][0][0] = 1;
		for (int i = 1; i <= n; ++i){
			auto (&f) = dp[i - 1 & 1], (&g) = dp[i & 1];

			int tm = i / 3;
			for (int j = 1; j < 8; ++j)
				fill_n(g[j], tm + 2, 0);
			for (int i_ = 0; i_ < 3; ++i_){
				if (!(s[i] == '0' + i_ || s[i] == '?'))
					continue;

				for (int j = 0; j < 7; ++j){
					int tj = j | 1 << i_;
					for (int k = 0; k <= tm; ++k)
						upd(g[tj][k], f[j][k]);
				}
			}
			g[0][0] = 0;
			copy_n(g[7], tm + 1, g[0] + 1);
		}
		ll ans = 0;
		for (int j = 0; j < 7; ++j)
			for (int k = n / 3; k >= m; --k)
				ans += dp[n & 1][j][k];
		ans %= M;
		printf("%lld\n", ans);
	}
	return 0;
}

