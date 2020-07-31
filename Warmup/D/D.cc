#include <bits/stdc++.h>
 
using namespace std;

const int N = 2E5 + 10;
int n, m, sn;
int a[N], b[N];
char s[N];

bool checkb(int a){
    for (int k = 0, j = 0; j < m; ++j){
        int t = 0;
        if (s[k] == 0 || a <= s[k])
            t = s[k], ++k;
        else
            t = s[k] * 10 + s[k + 1], k += 2;
        if (k > sn)
            return false;
        b[j] = t / a;
        if (t != a * b[j])
            return false;
    }
    return b[0] != 0;
}

bool checka(){
    int k = 0;
    for (int i = 0; i < n; ++i)
        for (int j = 0; j < m; ++j){
            int t = 0;
            if (s[k] == 0 || b[j] <= s[k])
                t = s[k], ++k;
            else
                t = s[k] * 10 + s[k + 1], k += 2;
            if (k > sn)
                return false;
            
            if (j == 0)
                a[i] = t / b[0];
            if (t != a[i] * b[j])
                return false;
        }
    return k == sn && a[0] != 0;
}

int main(){
    int cas;
    scanf("%d", &cas);
    while (cas--){
        scanf("%d%d", &n, &m);
        scanf("%s", s);
        sn = strlen(s);
        for (int i = 0; i < sn; ++i)
            s[i] -= '0';
        bool flag = false;
        for (int i = 1; i < 10; ++i)
            if (checkb(i) && checka()){
                flag = true;
                break;
            }
        if (!flag)
            puts("Impossible");
        else{
            for (int i = 0; i < n; ++i)
                putchar('0' + a[i]);
            putchar(' ');
            for (int i = 0; i < m; ++i)
                putchar('0' + b[i]);
            putchar('\n');
        }
    }
    return 0;
}
