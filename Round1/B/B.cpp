#include<bits/stdc++.h>
using namespace std;

const int N = 2e5 + 10;

int T, n;
char s[N], t[N];

int query(int a, int b){
    for(int i=a+1; i<=b; i++){
        if(t[i] != t[a])    return -1;
    }
    if(s[a] == s[a-1] || s[b] == s[b+1])    return -1;
    return 1;
}

int solve(){
    s[0] = t[0] = '*';
    s[n+1] = t[n+1] = '*';

    int pre = 0;
    int ret = 0;
    int tmp = 0;

    for(int i=1; i<=n+1; i++){
        if(s[i] == t[i]){
            if(pre != i-1){
                tmp = query(pre + 1, i - 1);
                if(tmp == -1)   return -1;
                ret += tmp;
            }
            pre = i;
        }
    }
    return ret;
}

int main(){
    scanf("%d", &T);
    while(T--){
        scanf("%d", &n);
        scanf("%s", s+1);
        scanf("%s", t+1);

        printf("%d\n", solve());
    }
    return 0;
}
