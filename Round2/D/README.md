### LIS / 最长上升子序列

Let $`f(a_1,a_2,\cdots,a_n)`$ be the length of the longest increasing subsequence of sequence $`a_1,a_2,\cdots,a_n`$.

Given two sequences $`l_1,l_2,\cdots,l_n`$ and $`r_1,r_2,\cdots,r_n`$, please calculate the maximum value of $`f(a_1,a_2,\cdots,a_n)`$ among all possible integer sequence $`a_1,a_2,\cdots,a_n`$ such that $`l_i \le a_i \le r_i`$.

Note that the longest increasing subsequence of the sequence $`a_1, a_2, \cdots, a_n`$ is the sequence of numbers $`a_{i_1}, \cdots, a_{i_m}`$, where $`i_1 < \cdots < i_m`$ and $`a_{i_1} < \cdots < a_{i_m}`$, and $`m`$ -- the length of the longest increasing subsequence -- is the greatest possible.

令 $`f(a_1,a_2,\cdots,a_n)`$ 为序列  $`a_1,a_2,\cdots,a_n`$ 的最长上升子序列的长度。

给定两个序列 $`l_1,l_2,\cdots,l_n`$ 和 $`r_1,r_2,\cdots,r_n`$，请计算出所有满足 $`1 \le i \le n`$，$`l_i \le a_i \le r_i`$ 的**整数**序列 $`a_1,a_2,\cdots,a_n`$ 中，$`f(a_1,a_2,\cdots,a_n)`$ 的最大值。

我们称序列 $`a_{i_1}, \cdots, a_{i_m}`$ 为序列 $`a_1, a_2, \cdots, a_n`$ 的最长上升子序列，若其满足 $`i_1 < \cdots < i_m`$，$`a_{i_1} < \cdots < a_{i_m}`$ 且子序列的长度 $`m`$ 尽可能大。

#### Input / 输入格式

There are multiple test cases. The first line of the input contains an integer $`T`$, indicating the number of test cases. For each test case:

The first line contains an integer $`n`$ ($`1 \le n \le 3 \times 10^5`$) -- the length of the sequence.

For the next $`n`$ lines, the $`i`$-th line contains two integers $`l_i`$ and $`r_i`$ ($`1 \le l_i \le r_i \le 10^9`$).

It's guaranteed that the sum of $`n`$ of all test cases will not exceed $`3 \times 10^5`$.

有多组测试数据。第一行输入一个整数 $`T`$ 代表测试数据组数。对于每组测试数据：

第一行输入一个整数 $`n`$ ($`1 \le n \le 3 \times 10^5`$)，代表给定序列的长度。

接下来 $`n`$ 行，第 $`i`$ 行输入两个整数 $`l_i`$ 与 $`r_i`$ ($`1 \le l_i \le r_i \le 10^9`$)。

保证所有数据中 $`n`$ 之和不超过 $`3 \times 10^5`$。

#### Output / 输出格式

For each test case output one line containing one integer denoting the answer.

每组数据输出一行一个整数代表答案。

#### Sample Input / 样例输入
```in
3
1
1 1000000000
5
1 2
2 3
3 5
1 3
4 7
2
1 3
3 5
```

#### Sample Output / 样例输出
```out
1
4
2
```

#### Hint / 样例说明

For the second sample test case, one of the desired sequence is $`\{1,2,3,1,4\}`$, whose longest increasing subsequence is $`\{1,2,3,4\}`$ and thus the answer is 4.

对于第二组样例数据，一个满足题目所求的序列可以是 $`\{1,2,3,1,4\}`$，它的最长上升子序列是 $`\{1,2,3,4\}`$，因此答案是 4。
