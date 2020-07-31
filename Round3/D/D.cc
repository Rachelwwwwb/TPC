#include <bits/stdc++.h>
 
using namespace std;

const int N = 1E5 + 10;

int n, m;
vector<int> E[N], F[N];
int vis[N];
vector<int> ans;

void DFS(int u){
    vis[u] = true;
    sort(E[u].begin(), E[u].end(), greater<int>());
    for (auto v: E[u]){
        if (vis[v])
            continue;
        F[u].push_back(v);
        DFS(v);
    }
}

void BFS(int u){
    priority_queue<int, vector<int>, greater<int>> Q;
    Q.push(u);
    ans.clear();
    while (!Q.empty()){
        int u = Q.top();
        Q.pop();
        ans.push_back(u);
        for (auto v: F[u])
            Q.push(v);
    }
}

int main(){
    int cas;
    scanf("%d", &cas);
    ans.reserve(N);
    while (cas--){
        scanf("%d%d", &n, &m);
        for (int i = 1; i <= n; ++i){
            E[i].clear();
            F[i].clear();
            vis[i] = false;
        }
        for (int i = 0; i < m; ++i){
            int u, v;
            scanf("%d%d", &u, &v);
            E[u].push_back(v);
            E[v].push_back(u);
        }
        DFS(1);
        BFS(1);
        for (int i = 0; i < n; ++i)
            printf("%d%c", ans[i], "\n "[i + 1 < n]);
    }
    return 0;
}
