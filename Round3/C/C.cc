#include <bits/stdc++.h>
 
using namespace std;
 
using ll = long long;

const int N = 1E5 + 10;

char s[N];

bool check(int num, int k){
    if (num == 1)
        return false;
    int K = 1;
    for (int i = k; i > 1; --i, K *= 10);
    for (int i = 0; i < k; ++i){
        for (int j = 3; j * j <= num; j += 2)
            if (num % j == 0)
                return false;
        num = num / K + num % K * 10;
    }
    return true;
}

int main(){
    scanf("%s", s);
    int n = strlen(s);
    for (int i = 0; i < n; ++i)
        s[i] -= '0';

    bool prime[10] = {0, 0, 1, 1, 0, 1, 0, 1, 0, 0};
    bool ignore[10] = {1, 0, 1, 0, 1, 1, 1, 0, 1, 0};
    int ans = -1;
    for (int i = 0; i < n; ++i)
        if (prime[s[i]])
            ans = max<int>(ans, s[i]);
    for (int i = 0; i < n; ++i){
        if (ignore[s[i]])
            continue;
        int j = i, num = 0;
        for (; j < n && !ignore[s[j]]; ++j){
            num = num * 10 + s[j];
            if (check(num, j - i + 1))
                ans = max(ans, num);
        }
    }
    printf("%d\n", ans);
    return 0;
}
