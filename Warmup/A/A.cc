#include <bits/stdc++.h>
 
using namespace std;

int main(){
    int cas;
    scanf("%d", &cas);
    while (cas--){
        int n;
        scanf("%d", &n);
        multiset<int> a;
        for (int i = 0; i < n; ++i){
            int x;
            scanf("%d", &x);
            a.insert(x);
        }
        while (*a.begin() != *a.rbegin()){
            auto p1 = a.begin();
            auto p2 = prev(a.end());
            a.erase(p1);
            a.erase(p2);
            int nval = *p2 - *p1;
            a.insert(nval);
            a.insert(nval);
        }
        printf("%d\n", *a.begin());
    }
    return 0;
}
