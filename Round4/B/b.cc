#include <bits/stdc++.h>

#define st first
#define nd second
 
using namespace std;
 
using ll = long long;
using pii = pair<int, int>;

const int N = 1E6 + 10;

pii a[N];

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
        int n1 = n / 2;
        nth_element(a, a + n1, a + n);
        ll ans = 0;
        for (int i = 0; i < n1; ++i)
            if (a[i].nd >= n1)
                ans += a[i].nd;
        for (int i = n1; i < n; ++i)
            if (a[i].nd < n1)
                ans -= a[i].nd;
        printf("%lld\n", ans);
    }
    return 0;
}
