### Ternary String Counting / 三进制字符串计数

We say a string is a *ternary string* if it only consists of characters '0', '1' and '2'. A ternary string $`s`$ is called $`m`$-supersequence if each ternary string of length $`m`$ is a subsequence of $`s`$.

Given a string $`s`$ of length $`n`$ consisting of '?', '0', '1' and '2', one can fill the '?' with '0', '1' or '2' to make $`s`$ become an $`m`$-supersequence. What's the number of different $`m`$-supersequences one can produce? As the answer may be very large, print it modulo $`10^9+7`$. Note that '?'s in different positions can be filled with different characters.

若一个字符串仅包含 '0', '1' 和 '2' 三种字符，我们就称其为“三进制字符串”。若所有长度为 $`m`$ 的三进制字符串均为另一三进制字符串 $`s`$ 的子序列，则称 $`s`$ 为一个“$`m`$ - 超序列”，$`m`$ 称为超序列的秩。

给定一个长度为 $`n`$ 的字符串 $`s`$，该字符串仅由字符 '?', '0', '1' 和 '2' 组成。我们可以将 '?' 换成 '0', '1' 或 '2' 以将 $`s`$ 转化为一个 $`m`$ - 超序列。求最终能产生多少种不同的 $`m`$ - 超序列。由于答案可能很大，请将答案对 $`10^9 + 7`$ 取模后输出。请注意，不同位置的 '?' 可以换成不同的字符。

#### Input / 输入格式
There are multiple test cases. The first line of the input contains an integer $`T`$, indicating the number of test cases. For each test case:

The first line contains two integers $`n`$ and $`m`$ ($`1 \le m \le n \le 5000`$) -- the length of the string and the order of supersequence.

The second line contains a string $`s`$ of length $`n`$ consisting of '?', '0', '1' and '2'.

It's guaranteed that the sum of $`n`$ of all test cases will not exceed 5000.

有多组测试数据。第一行输入一个整数 $`T`$ 代表测试数据组数。对于每组测试数据：

第一行输入两个整数 $`n`$ 与 $`m`$ ($`1 \le m \le n \le 5000`$)，代表字符串的长度与超序列的秩。

第二行输入一个长度为 $`n`$，仅包含字符 '?', '0', '1' 和 '2' 的字符串 $`s`$。

保证所有数据 $`n`$ 之和不超过 5000。

#### Output / 输出格式
For each test case, output one line containing one integer denoting the answer.

每组数据输出一行一个整数表示答案。

#### Sample Input / 样例输入
```in
2
3 1
???
9 2
???121???
```

#### Sample Output / 样例输出
```out
6
312
```

#### Hint / 样例说明
For the first sample, all $`1`$-supersequences are: $`012`$, $`021`$, $`102`$, $`120`$, $`201`$, $`210`$.

对于第一组样例数据，所有的 1 - 超序列为 $`012`$, $`021`$, $`102`$, $`120`$, $`201`$, $`210`$。
