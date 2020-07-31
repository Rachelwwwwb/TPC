### Number Partition / 数字分组

Given $`n`$ positive integers $`a_1, a_2, \cdots, a_n`$ such that $`\sum\limits_{i=1}^{n} a_i \le 2n-2`$, please find two non-empty sets $`A`$ and $`B`$ such that $`A \cup B = \{1, 2, \cdots, n\}`$, $`A \cap B = \emptyset`$ and $`|\sum\limits_{x \in A} a_x - \sum\limits_{y \in B} a_y|`$ is minimum.

给定 $`n`$ 个正整数 $`a_1, a_2, \cdots, a_n`$ 满足 $`\sum\limits_{i=1}^{n} a_i \le 2n-2`$，请构造两个非空集合 $`A`$ 与 $`B`$ 使得 $`A \cup B = \{1, 2, \cdots, n\}`$，$`A \cap B = \emptyset`$ 且 $`|\sum\limits_{x \in A} a_x - \sum\limits_{y \in B} a_y|`$ 的值最小。

#### Input / 输入格式

There are multiple test cases. The first line of the input contains an integer $`T`$, indicating the number of test cases. For each test case:

The first line contains an integer $`n`$ ($`2 \le n \le 2 \times 10^5`$) -- the number of integers.

The second line contains $`n`$ positive integers $`a_1, a_2, \cdots, a_n`$ ($`1 \le a_i, \sum a_i \le 2n-2`$).

It's guaranteed that the sum of $`n`$ of all test cases will not exceed $`2 \times 10^5`$.

有多组测试数据。第一行输入一个整数 $`T`$ 代表测试数据组数。对于每组测试数据：

第一行输入一个整数 $`n`$ ($`2 \le n \le 2 \times 10^5`$)，代表给定正整数的数量。

第二行输入 $`n`$ 个正整数 $`a_1, a_2, \cdots, a_n`$ ($`1 \le a_i, \sum a_i \le 2n-2`$)。

保证所有数据中 $`n`$ 之和不超过 $`2 \times 10^5`$。

#### Output / 输出格式

For each test case, output a string $`s`$ of length $`n`$ consisting only of 'a' and 'b', where $`s_i=a`$ indicates that $`i \in A`$,  and $`s_i=b`$ indicates that $`i \in B`$.

每组数据输出一个长度为 $`n`$ 的字符串 $`s`$，该字符串仅由字符 'a' 与 'b' 构成。若 $`s_i`$ 为 'a' 则 $`i \in A`$，若 $`s_i`$ 为 'b' 则 $`i \in B`$。答案可能不唯一，输出任意满足要求的字符串即可。

#### Sample Input / 样例输入
```in
3
2
1 1
3
1 2 1
3
1 1 1
```

#### Sample Output / 样例输出
```out
ba
aba
baa
```
