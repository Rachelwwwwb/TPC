#include<bits/stdc++.h>
using namespace std;

typedef long long LL;
typedef pair<int,int> pii;

#define pb push_back
#define mp make_pair

int main(){
    int T, n;
    scanf("%d", &T);
    while(T--){
        scanf("%d", &n);
        printf("%d\n", max(1, n >> 1));
    }
    return 0;
}