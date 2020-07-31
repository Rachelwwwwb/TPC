### Recursive Flipping Game / 递归翻硬币游戏

There are $`n`$ coins arranged in a row on a table, numbered from 1 to $`n`$ from left to right. Some of them have their heads facing upward while the others have their tails facing upward. One can flip the coins by calling the `flip` procedure defined below:

```
procedure flip(
  i: the index of the coin to flip)
Flip the i-th coin
if i > 1
  check(i − 1, i)
if i < n
  check(i + 1, i)
	
procedure check(
  i: the index of the coin to check,
  p: the index of the previous flipped coin)
if the side of the i-th and p-th coins facing upward is different
  flip(i)
```

Given the initial and the desired state of each coin, what's the least number of times one needs to call the `flip` procedure to transform all the coins from the initial state to the desired state? Note that each time when the procedure is called, its argument can be different.

有 $`n`$ 枚硬币在桌子上排成一排，编号从左到右从 1 至 $`n`$。一些硬币正面朝上，其它硬币背面朝上。玩家可以按以下伪代码中的 `flip` 函数描述的规则翻转硬币：

```
procedure flip(
  i: the index of the coin to flip)
Flip the i-th coin
if i > 1
  check(i − 1, i)
if i < n
  check(i + 1, i)
	
procedure check(
  i: the index of the coin to check,
  p: the index of the previous flipped coin)
if the side of the i-th and p-th coins facing upward is different
  flip(i)
```

给出每枚硬币的初始状态和目标状态，求玩家最少需要调用几次 `flip` 函数才能将所有硬币从初始状态调整为目标状态。请注意，每次调用 `flip` 函数时，函数的参数可以不同。

#### Input / 输入格式
There are multiple test cases. The first line of the input contains an integer $`T`$ indicating the number of test cases. For each test case:

The first line contains an integer $`n`$ ($`1 \le n \le 10^5`$), indicating the number of coins.

The second line contains a string $`A = a_1a_2\cdots a_n`$ ($`a_i \in \{\text{`0'}, \text{`1'}\}`$) indicating the initial state of each coin. The $`i`$-th coin has its head facing upward in the initial state if $`a_i = \text{`0'}`$, and has its tail facing upward otherwise.

The third line contains a string $`B = b_1b_2\cdots b_n`$ ($`b_i \in \{\text{`0'}, \text{`1'}\}`$), indicating the desired state of each coin. The $`i`$-th coin has its head facing upward in the desired state if $`b_i = \text{`0'}`$, and has its tail facing upward otherwise.

It's guaranteed that the sum of $`n`$ of all test cases will not exceed $`5 \times 10^5`$.

有多组测试数据。第一行输入一个整数 $`T`$ 代表测试数据组数。对于每组测试数据：

第一行输入一个整数 $`n`$ ($`1 \le n \le 10^5`$)，代表硬币的数量。

第二行输入一个字符串 $`A = a_1a_2\cdots a_n`$ ($`a_i \in \{\text{`0'}, \text{`1'}\}`$) 代表每枚硬币的初始状态。若 $`a_i = \text{`0'}`$ 则第 $`i`$ 枚硬币一开始正面朝上，否则背面朝上。

第三行输入一个字符串 $`B = b_1b_2\cdots b_n`$ ($`b_i \in \{\text{`0'}, \text{`1'}\}`$) 代表每枚硬币的目标状态。若 $`b_i = \text{`0'}`$ 则第 $`i`$ 枚硬币的目标为正面朝上，否则为背面朝上。

保证所有数据的 $`n`$ 之和不超过 $`5 \times 10^5`$。

#### Output / 输出格式
For each test case output one line containing one integer, indicating the minimum number of times one needs to call the `flip` procedure to transform all the coins from the initial state to the desired state. In case that it's impossible to do so, output "-1" (without quotes) instead.

每组数据输出一行一个整数，代表将所有硬币从初始状态调整为目标状态最少需要调用多少次 `flip` 函数。若无论调用多少次都无法满足要求，则输出 "-1"（不输出引号）。

#### Sample Input / 样例输入
```in
2
12
110101110011
110111111111
3
101
010
```

#### Sample Output / 样例输出
```out
2
-1
```

#### Hint / 样例说明
For the first sample test case, one can first call `flip(7)` (so the status of the coins becomes 110100000011) then call `flip(5)`. So the answer is 2.

对于第一组样例数据，玩家可以先调用 `flip(7)`（硬币的状态将会变为 110100000011），然后再调用 `flip(5)`。所以答案是 2。
