#include <bits/stdc++.h>
 
using namespace std;
 
using ll = long long;

const int N = 1E5 + 10;

int a[N];

int main(){
    int cas;
    scanf("%d", &cas);
    while (cas--){
        int n, m;
        scanf("%d%d", &n, &m);
        for (int i = 0; i < n; ++i)
            scanf("%d", a + i);
        partial_sort(a, a + 2 * m, a + n);
        ll ans = 0;
        for (int l = 0, r = 2 * m - 1; l < r; ++l, --r)
            ans += 1ll * a[l] * a[r];
        printf("%lld\n", ans);
    }
    return 0;
}
