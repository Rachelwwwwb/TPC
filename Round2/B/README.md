### Candy / 糖果

Alice and Bob have bought some candies. Now they decide to play a game with these candies. The followings are the rules of this game:

- Alice and Bob take candies in turn.
- Alice will take **exact one candy** in her turn.
- Bob will take **at least two candies of the same favors** in his turn. 
- If, in Alice's turn, there is no candy left, she will lose the game.
- If, in Bob's turn, there are no two candies of the same favor, he will lose the game.

Alice and Bob both play optimally. Now, you are given the information of what kinds of candies they bought and who will take candies first, can you find out who the winner is?

Alice 和 Bob 买了一些糖果，他们准备用这些糖果玩一个游戏。游戏规则如下：

- Alice 和 Bob 轮流拿取糖果。
- 轮到 Alice 时，每次她必须拿走**恰好一颗糖果**。
- 轮到 Bob 时，每次他必须拿走**至少两颗口味相同的糖果**。
- 轮到 Alice 时，若没有剩余糖果可以拿取，则判 Alice 输。
- 轮到 Bob 时，若不存在两颗口味相同的糖果，则判 Bob 输。

Alice 和 Bob 都会采用最优策略进行游戏。给出他们购买的糖果的信息以及谁第一个拿取糖果，求最终的胜利者。

#### Input / 输入格式

There is only one test case.

The first line of the input contains an integer $`n`$ ($`1 \le n \le 300`$) and a string $`s`$ ($`s \in \{\text{``Alice''}, \text{``Bob''}\}`$), indicating the number of candies they bought and the player who go first.

The second line contains $`n`$ integers $`a_1, a_2, \cdots, a_n`$ ($`1 \le a_i \le 300`$) where $`a_i`$ indicates the flavor of the $`i`$-th candy. Candy $`i`$ and $`j`$ are of the same flavor if $`a_i = a_j`$.

只有一组测试数据。

第一行输入一个整数 $`n`$ ($`1 \le n \le 300`$) 和一个字符串 $`s`$ ($`s \in \{\text{``Alice''}, \text{``Bob''}\}`$)，代表两人购买的糖果数量以及先手玩家。

第二行输入 $`n`$ 个整数 $`a_1, a_2, \cdots, a_n`$ ($`1 \le a_i \le 300`$)，其中 $`a_i`$ 代表第 $`i`$ 颗糖果的口味。糖果 $`i`$ 和 $`j`$ 拥有相同口味若 $`a_i = a_j`$。

#### Output / 输出格式
Output one line containing the name of the winner of the game.

输出一行一个字符串代表胜利者的名字。

#### Sample Input / 样例输入
```in
4 Alice
1 2 3 1
```

#### Sample Output / 样例输出
```out
Alice
```

#### Hint / 样例说明

Alice can take the first candy and then Bob are left with 3 candies with different flavors. So Alice is the winner.

Alice 可以拿走第一颗糖果，这样 Bob 只剩下 3 颗口味不同的糖果。所以 Alice 是胜利者。
