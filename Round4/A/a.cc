#include <bits/stdc++.h>
 
using namespace std;
 
using ll = long long;

const int N = 1E3 + 10;

int a[N][N];
vector<int> s[3];

int main(){
    int cas;
    scanf("%d", &cas); 
    while (cas--){
        int n;
        scanf("%d", &n);
        for (int i = 0; i < 3; ++i)
            s[i].clear();
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < n; ++j){
                scanf("%d", a[i] + j);
                int t = (i == j) + (i + j == n - 1);
                s[t].push_back(a[i][j]);
            }

        ll base = 0;
        for (int i = 0; i < 3; ++i)
            base += accumulate(s[i].begin(), s[i].end(), 0ll) * (i + 2);
        ll delta = 0;
        for (int i = 0; i < 3; ++i)
            for (int j = i + 1; j < 3; ++j)
                if (s[i].size() && s[j].size())
                    delta = max<ll>(delta, (j - i) * (*max_element(s[i].begin(), s[i].end()) - *min_element(s[j].begin(), s[j].end())));
        printf("%lld\n", base + delta);
    }
    return 0;
}
