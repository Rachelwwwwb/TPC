### Magic Multiplication / 神秘的乘法

Define a new operation $`\otimes`$ between two positive integers $`A`$ and $`B`$ as follows:

let the first integer be $`A = a_1a_2 \cdots a_n`$, where $`a_i`$ indicates the $`i`$-th digit in $`A`$ from left to right, and the second integer be $`B = b_1b_2 \cdots b_m`$, where $`b_i`$ indicates the $`i`$-th digit in $`B`$ from left to right. We have

<center>
$`A \otimes B = \sum\limits_{i=1}^n\sum\limits_{j=1}^m a_ib_j = a_1b_1 + a_1b_2 + \cdots + a_1b_m + a_2b_a1 + \cdots + a_nb_m`$
</center>

Note that the result of $`a_ib_j`$ is considered to be a **string** (without leading zeros if $`a_ib_j > 0`$, or contains exactly one '0' if $`a_ib_j = 0`$), NOT a normal integer. Also, the sum here means **string concatenation**, NOT the normal addition operation.

For example, 23 $`\otimes`$ 45 = 8101215. Because $`8=2 \times 4`$, $`10=2 \times 5`$, $`12=3 \times 4`$ and $`15=3 \times 5`$.

Given an integer $`C = c_1c_2\cdots c_k`$, please find two positive integers $`A`$ and $`B`$ such that $`A \otimes B = C`$. We also require that the length of $`A`$ to be $`n`$ and the length of $`B`$ to be $`m`$.

定义两个正整数 $`A`$ 与 $`B`$ 间的一个新运算 $`\otimes`$ 如下：

令第一个整数为 $`A = a_1a_2 \cdots a_n`$，其中 $`a_i`$ 表示 $`A`$ 中从左到右第 $`i`$ 个数码；令第二个整数为 $`B = b_1b_2 \cdots b_m`$，其中 $`b_i`$ 表示 $`B`$ 中从左到右第 $`i`$ 个数码。我们有

<center>
$`A \otimes B = \sum\limits_{i=1}^n\sum\limits_{j=1}^m a_ib_j = a_1b_1 + a_1b_2 + \cdots + a_1b_m + a_2b_a1 + \cdots + a_nb_m`$
</center>

请注意，上述等式中 $`a_ib_j`$ 的计算结果将被看作一个**字符串**（若 $`a_ib_j > 0`$ 则该字符串没有前导零，若 $`a_ib_j = 0`$ 则该字符串恰好含有一个 '0'），而不是一个整数。同样地，上述等式中的和表示的是**字符串的连接**，而不是普通的加法。

例如，23 $`\otimes`$ 45 = 8101215，因为 $`8=2 \times 4`$，$`10=2 \times 5`$，$`12=3 \times 4`$ 以及 $`15=3 \times 5`$。

给定一个整数 $`C = c_1c_2\cdots c_k`$，请找到两个正整数 $`A`$ 与 $`B`$ 使得 $`A \otimes B = C`$。我们另外要求 $`A`$ 的长度为 $`n`$ 且 $`B`$ 的长度为 $`m`$。

#### Input / 输入格式

There are multiple test cases. The first line of the input contains an integer $`T`$, indicating the number of test cases. For each test case:

The first line contains two positive integers $`n`$ and $`m`$ ($`1 \le n, m \le 2 \times 10^5`$), where $`n`$ indicates the length of $`A`$ and $`m`$ indicates the length of $`B`$. Here length of an integer means the length of the string when writing the number in decimal notation without leading zeros.

The second line contains only one positive integer $`C`$ without leading zeros, indicating the result of $`A \otimes B`$. The length of $`C`$ is no more than $`2 \times 10^5`$.

It's guaranteed that the sum of lengths of $`C`$ over all test cases will not exceed $`2 \times 10^6`$.

有多组测试数据。第一行输入一个整数 $`T`$ 表示测试数据组数。对于每组数据：

第一行输入两个正整数 $`n`$ 与 $`m`$（$`1 \le n, m \le 2 \times 10^5`$），其中 $`n`$ 表示 $`A`$ 的长度，$`m`$ 表示 $`B`$ 的长度。一个整数的长度指的是它的十进制表示（不含前导零）中有多少个数码。

第二行输入一个不含前导零的正整数 $`C`$ 代表 $`A \otimes B`$ 的结果。$`C`$ 的长度不超过 $`2 \times 10^5`$。

保证所有数据 $`C`$ 的长度之和不超过 $`2 \times 10^6`$。

#### Output / 输出格式

For each test case output one line.

If there exist such $`A`$ and $`B`$ that $`A \otimes B = C`$, output one line containing two integers $`A`$ and $`B`$ separated by one space. Note that $`A`$ and $`B`$ should be positive integers without leading zeros, the length of $`A`$ should be exactly $`n`$, and the length of $`B`$ should be exactly $`m`$.

If there are multiple valid answers, output the answer with the smallest $`A`$; If there are still more than one answer, output one of them with the smallest $`B`$.

If such $`A`$ and $`B`$ do not exist, print "Impossible" (without quotes) on a single line.

每组数据输出一行。

如果存在 $`A`$ 和 $`B`$ 使得 $`A \otimes B = C`$，输出一行两个由单个空格分隔的整数 $`A`$ 和 $`B`$。请注意，$`A`$ 和 $`B`$ 必须都是没有前导零的正整数，且 $`A`$ 的长度必须恰好为 $`n`$，$`B`$ 的长度必须恰好为 $`m`$。

若有多种答案请输出 $`A`$ 最小的答案；若还是有多种答案请输出 $`B`$ 最小的答案。

如果不存在符合要求的 $`A`$ 与 $`B`$ 则输出一行 "Impossible"（不输出引号）。

#### Sample Input / 样例输入
```in
3
2 2
8101215
3 4
100000001000
2 2
80101215
```

#### Sample Output / 样例输出
```out
23 45
101 1000
Impossible
```
