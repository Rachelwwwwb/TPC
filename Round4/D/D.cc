#include<bits/stdc++.h>
using namespace std;

typedef pair<int,int> pii;
const int N = 1e5 + 10;

int T, n, C[N];
int ch[N][2], val[N], dep[N];

void newnode(int o){
	ch[o][0] = ch[o][1] = 0;
	val[o] = 0;
	dep[o] = 0;
}

bool check(){
	for(int i=1; i<=n; i++){
		if(val[i] == 0)	return 0;
		if(!ch[i][0] && !ch[i][1])	continue;
		if(ch[i][0] && val[i] < val[ch[i][0]])	continue;
		if(ch[i][1] && val[i] > val[ch[i][1]])	continue;
		swap(ch[i][0], ch[i][1]);
		if(ch[i][0] && val[i] < val[ch[i][0]])	continue;
		if(ch[i][1] && val[i] > val[ch[i][1]])	continue;
		return 0;
	}
	return 1;
}

bool ok(){
	priority_queue<pii> heap;
	int mx = 1;
	for(int i=1; i<=n; i++){
		newnode(i);
		if(C[i] > 0){
			heap.emplace(C[i], i);
			if(C[i] > C[mx]){
				mx = i;
			}
		}
	}

	if((n - C[mx]) * 4 + 1 < n)	return 0;

	pii p, q;
	p = heap.top(); heap.pop();

	val[1] = p.second;
	if(--p.first){
		heap.emplace(p);
	}

	queue<int> Q;
	Q.emplace(1);

	int pt = 2;

	while(!heap.empty()){
		p = heap.top(); heap.pop();
		int x = Q.front(); Q.pop();

		if(p.first >= 2 && p.second != val[x]){
			ch[x][0] = pt;
			ch[x][1] = pt + 1;
			val[pt] = p.second;
			val[pt+1] = p.second;
			Q.emplace(pt);
			Q.emplace(pt + 1);
			pt += 2;
			p.first -= 2;
			if(p.first != 0)	heap.emplace(p);
		} else if(!heap.empty()){
			q = heap.top(); heap.pop();
			ch[x][0] = pt;
			ch[x][1] = pt + 1;
			val[pt] = p.second;
			val[pt+1] = q.second;
			Q.emplace(pt);
			Q.emplace(pt + 1);
			pt += 2;
			if(--p.first)	heap.emplace(p);
			if(--q.first)	heap.emplace(q);
		} else if(p.second != val[x]){
			ch[x][0] = pt;
			val[pt] = p.second;
			Q.emplace(pt);
			pt += 1;
			if(--p.first){
				heap.emplace(p);
			}
		} else {
			heap.push(p);
		}
	}

	return check();
}

int main(){
	int x;
	scanf("%d", &T);
	while(T--){
		scanf("%d", &n);
		for(int i=1; i<=n; i++)	C[i] = 0;
		for(int i=1; i<=n; i++){
			scanf("%d", &x);
			C[x]++;
		}

		if(ok()){
			puts("Yes");
			for(int i=1; i<=n; i++){
				printf("%d %d %d\n", val[i], ch[i][0], ch[i][1]);
			}
		} else {
			puts("No");
		}
	}
	return 0;
}

