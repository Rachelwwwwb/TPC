#include <bits/stdc++.h>
 
using namespace std;

const int N = 1E5 + 10;

char s[N];

int main(){
    int cas;
    scanf("%d", &cas);
    while (cas--){
        scanf("%s", s);
        int n = strlen(s);
        int a = count(s, s + n, '0');
        int b = n - a;

        if (b * 2 + 2 < a)
            puts("Impossible");
        else if (a == 0)
            puts(s);
        else{
            int tb = (a + 1) / 2 - 1;
            b -= tb;
            fputs(string(b, '1').c_str(), stdout);
            for (int i = 0; i < tb; ++i)
                fputs("001", stdout);
            puts(string(a - tb * 2, '0').c_str());
        }
    }
    return 0;
}
