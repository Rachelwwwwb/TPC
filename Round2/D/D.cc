#include <bits/stdc++.h>

#define st first
#define nd second

using namespace std;

using ll = long long;
using pii = pair<int, int>;

const int N = 3E5 + 10;

struct node{
    int l, r;
    int rank;
    int key, add;

    void push();
}a[N];

int tot;

void node::push(){
    a[l].key += add;
    a[l].add += add;
    a[r].key += add;
    a[r].add += add;
    add = 0;
}

pii split(int u, int key){
    if (u == 0)
        return pii(0, 0);
    a[u].push();
    if (a[u].key < key){
        pii o = split(a[u].r, key);
        a[u].r = o.st;
        return pii(u, o.nd);
    }
    else{
        pii o = split(a[u].l, key);
        a[u].l = o.nd;
        return pii(o.st, u);
    }
}

pii split_left(int u){
    int* fa = &u;
    for (; a[*fa].l != 0; fa = &(a[*fa].l));
    int left = *fa;
    *fa = a[*fa].r;
    a[left].r = 0;
    return pii(left, u);
}

int merge(int u, int v){
    if (u == 0 || v == 0)
        return u | v;
    a[u].push();
    a[v].push();
    if (a[u].rank > a[v].rank)
        return a[u].push(), a[u].r = merge(a[u].r, v), u;
    else
        return a[v].push(), a[v].l = merge(u, a[v].l), v;
}

int msize(int u){
    return u == 0 ? 0 : msize(a[u].l) + 1 + msize(a[u].r);
}

int main(){
    mt19937 rnd(0);

    int cas;
    scanf("%d", &cas);
    while (cas--){
        int n;
        scanf("%d", &n);
        int rt = 0;
        tot = 1;
        while (n--){
            int l, r;
            scanf("%d%d", &l, &r);
            pii o1 = split(rt, l);
            pii o2 = split(o1.nd, r);
            pii o3 = split_left(o2.nd);
            a[o2.st].key += 1;
            a[o2.st].add += 1;
            a[tot] = node{0, 0, (int)rnd(), l, 0};
            rt = merge(o1.st, merge(tot, merge(o2.st, o3.nd)));
            ++tot;
        }
        printf("%d\n", msize(rt));
    }
    return 0;
}i
