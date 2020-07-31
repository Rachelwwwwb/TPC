### Looping Prime / 循环质数

A *digit string* is a string consisting only of digits from '0' to '9' (both inclusive). Let $`s = s_1s_2\cdots s_n`$ be a digit string, define the following functions:

<center>
$`\begin{cases}r(s) = s_ns_1s_2\cdots s_{n-1} \\ R^0(s) = s \\ R^k(s) = r(R^{k-1}(s))\end{cases}`$
</center>

We say a digit string is a *prime string* if after parsing it to an integer, this integer is a prime. A digit string $`s = s_1s_2\cdots s_n`$ is called a *looping prime string* if for all $`0 \le k < n`$, $`R^k(s)`$ is a prime string.

Given a digit string $`s`$, please find a substring of $`s`$ such that the substring is a looping prime string and after parsing it to an integer the result is as large as possible.

Note that when parsing a digit string to an integer, its leading zeros will be discarded. For example, string "000123" will be parsed to integer 123. But this does not influence the string itself. For example, $`r(\text{``000123''}) = \text{``300012''}`$, not "312".

数字串指的是仅由数字 '0' 到 '9'（包括 '0' 和 '9'）组成的字符串。令 $`s = s_1s_2\cdots s_n`$ 为一个数字串，定义如下函数：

<center>
$`\begin{cases}r(s) = s_ns_1s_2\cdots s_{n-1} \\ R^0(s) = s \\ R^k(s) = r(R^{k-1}(s))\end{cases}`$
</center>

称一个数字串为一个质数串，若将该数字串转化为整数后，该整数是一个质数。称数字串 $`s = s_1s_2\cdots s_n`$ 为循环质数串，若对于所有 $`0 \le k < n`$ 都有  $`R^k(s)`$ 是质数串。

给出一个数字串 $`s`$，请找出它的一个子串，使得该子串不仅是循环质数串，且该子串转化为整数后尽可能大。

请注意，将数字串转为整数时，其前导 0 将被丢弃。例如，数字串 "000123" 将会被转化为 123。但是这并不影响字符串本身。例如，$`r(\text{``000123''}) = \text{``300012''}`$，而非 "312"。

#### Input / 输入格式

There is only one test case in a single test file, and there are 20 test files.

The first and only line contains a digit string $`s`$ ($`1 \le |s| \le 10^5`$), $`|s|`$ means the length of string $`s`$.

Please note that, although the length of $`s`$ is selected by hand, the content of $`s`$ is **randomly generated**. Each digit has equal probability to appear in each position of the string.

每个测试文件只有一组测试数据，共 20 个测试文件。

第一行输入一个数字串 $`s`$ ($`1 \le |s| \le 10^5`$)，其中 $`|s|`$ 是指字符串 $`s`$ 的长度。

请注意，虽然数据中数字串的长度是特意选择的，但数字串的内容是**随机生成**的。每种数字在字符串的每个位置都有相同的概率出现。

#### Output / 输出格式
Output one line containing one string, indicating the answer. If the answer does not exist, output "-1" (without quotes) instead.

输出一行一个字符串代表答案。若答案不存在则输出 "-1"（不输出引号）。

#### Sample Input 1 / 样例输入 1
```in
2971
```

#### Sample Output 1/ 样例输出 1
```out
971
```

#### Sample Input 2 / 样例输入 2
```in
88888
```

#### Sample Output 2 / 样例输出 2
```out
-1
```

#### Hint / 样例说明
For the first sample test case, as "971", "197" and "719" are prime strings, "971" is a looping prime string. While "2971" is a prime string, $`R^3(\text{``2971''}) = \text{``9712''}`$ is obviously not. So the answer is 971.

Also note that the second sample test case is (obviously) constructed by hand to illustrate the case when an answer does not exist. The contents of the digit strings in the real test cases will be randomly generated.

对于第一组样例数据，由于 "971", "197" 和 "719" 都是质数串，"971" 是一个循环质数串。虽然 "2971" 是质数串，然而 $`R^3(\text{``2971''}) = \text{``9712''}`$ 显然不是质数串。所以答案是 971。

另外也请注意，第二组样例数据（显然）是特意构造的，目的是为了展示无解时的情况。真正的测试数据中，数字串的内容是完全随机的。
