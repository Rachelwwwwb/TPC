#include <bits/stdc++.h>
 
using namespace std;
 
using ll = long long;

unordered_map<ll, int> lst;

void prework(){
    ll S = 0;
    for (int i = 0; i < 9; ++i)
        S = S << 4 | i;

    queue<ll> Q;
    lst[S] = 0;
    Q.push(S);
    while (!Q.empty()){
        ll u = Q.front();
        Q.pop();
        int dis = lst[u];

        ll v[6] = {
            u & 0xffffff000ll | (u & 0x00000000fll) << 8 | (u & 0x000000ff0ll) >> 4,
            u & 0xfff000fffll | (u & 0x00000f000ll) << 8 | (u & 0x000ff0000ll) >> 4,
            u & 0x000ffffffll | (u & 0x00f000000ll) << 8 | (u & 0xff0000000ll) >> 4,
            u & 0xff0ff0ff0ll | (u & 0x00000000fll) << 24 | (u & 0x00f00f000ll) >> 12,
            u & 0xf0ff0ff0fll | (u & 0x0000000f0ll) << 24 | (u & 0x0f00f0000ll) >> 12,
            u & 0x0ff0ff0ffll | (u & 0x000000f00ll) << 24 | (u & 0xf00f00000ll) >> 12
        };
        for (int i = 0; i < 6; ++i){
            auto p = lst.find(v[i]);
            if (p == lst.end()){
                lst.emplace(v[i], dis + 1);
                Q.push(v[i]);
            }
        }
    }
}

inline vector<int> read_perm(){
    char s[10];
    vector<int> ret;
    for (int i = 0; i < 3; ++i){
        scanf("%s", s);
        for (int j = 0; j < 3; ++j)
            ret.push_back(s[j] - '1');
    }
    return ret;
}

int main(){
    lst.reserve(362880 * 5);
    prework();

    int cas;
    scanf("%d", &cas);
    while (cas--){
        auto a = read_perm();
        auto b = read_perm();
        auto c = a;

        for (size_t i = 0; i < a.size(); ++i)
            c[a[i]] = i;
        ll u = 0;
        for (auto x: b)
            u = u << 4 | c[x];

        auto p = lst.find(u);
        if (p == lst.end())
            puts("impossible");
        else
            printf("%d\n", p->second);
    }
	return 0;
}
