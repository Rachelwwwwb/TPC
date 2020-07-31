#include <bits/stdc++.h>
 
using namespace std;

char s[20];

int main(){
    set<int> prime{2, 3, 5, 7, 11, 13};
    int cas;
    scanf("%d", &cas);
    while (cas--){
        int n;
        scanf("%d%s", &n, s);
        string t(s);
        int ans = n;
        if (s[0] == 'i'){
            for (int i = 0; i <= 4; ++i)
                if (prime.count(n + i) > 0){
                    ans = i;
                    break;
                }
        }
        else{
            int m = t == "divide_by_three" ? 3 :
                    t == "divide_by_four" ? 4 : 5;
            for (int i = 0; i <= 4; ++i)
                if ((n + i) % m == 0){
                    ans = i;
                    break;
                }
        }
        printf("%d\n", ans);
    }
    return 0;
}
