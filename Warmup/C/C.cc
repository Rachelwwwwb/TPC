#include <bits/stdc++.h>
 
using namespace std;

const int N = 1E4;
const int md[13] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

int cy[N];

int isleap(int y){
    return (y % 100 && y % 4 == 0) || y % 400 == 0;
}

int count9(int x){
    int ret = 0;
    for (; x; x /= 10)
        ret += x % 10 == 9;
    return ret;
}

void prework(){
    int yd = 0, y9 = 0;
    for (int i = 1; i <= 12; ++i){
        yd += md[i];
        y9 += (md[i] + 1) / 10 + (i == 9) * md[i];
    }
    for (int i = 0; i < N; ++i){
        int leap = isleap(i);
        cy[i] = count9(i) * (yd + leap) + (y9 + leap);
    }
    partial_sum(cy, cy + N, cy);
}

int getdays(bool open = false){
    int y, m, d;
    scanf("%d%d%d", &y, &m, &d);
    if (open){
        if (m == 1 && d == 1)
            --y, m = 12, d = 31;
        else if (d == 1)
            --m, d = md[m] + (m == 2 && isleap(y));
        else
            --d;
    }

    int ret = cy[y - 1];
    int leap = isleap(y);
    int yd = 0, y9 = 0;
    for (int i = 1; i <= m; ++i){
        int t = i == m ? d : md[i] + (leap && i == 2);
        yd += t;
        y9 += (t + 1) / 10 + (i == 9) * t;
    }
    ret += count9(y) * yd + y9;
    return ret;
}

int main(){
    prework();

    int cas;
    scanf("%d", &cas);
    while (cas--){
        int a = getdays(true);
        int b = getdays();
        printf("%d\n", b - a);
    }
    return 0;
}
