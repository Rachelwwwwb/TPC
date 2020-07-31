### Not Fibonacci / 并非斐波那契

A binary string is a string consisting of only digits 0 and 1. Given a binary string $`s = s_1s_2\cdots s_n`$ ($`n \ge 3`$), your task is to rearrange the digits so that for all $`3 \le i \le n`$ we have $`s_{i-2} + s_{i-1} \ne s_i`$ after the rearrangement.

二进制字符串是由数字 0 和 1 组成的字符串。给定一个二进制字符串 $`s = s_1s_2\cdots s_n`$ ($`n \ge 3`$)，您需要将里面的数字重新排列，使得重新排列后的字符串对于所有 $`3 \le i \le n`$ 满足 $`s_{i-2} + s_{i-1} \ne s_i`$。

#### Input / 输入格式
There are multiple test cases. The first line of the input contains an integer $`T`$ indicating the number of test cases. For each test case:

The first and only line contains a binary string $`s`$ ($`3 \le |s| \le 10^5`$, $`s_i \in \{0, 1\}`$).

It's guaranteed that the sum of $`|s|`$ of all test cases will not exceed $`10^6`$.

有多组测试数据。第一行输入一个整数 $`T`$ 代表测试数据组数。对于每组测试数据：

第一行输入一个二进制字符串 $`s`$ ($`3 \le |s| \le 10^5`$, $`s_i \in \{0, 1\}`$)。

保证所有数据中 $`|s|`$ 之和不超过 $`10^6`$。

#### Output / 输出格式
For each test case, if there exists such valid rearrangement output the rearranged string in one line (if there are multiple valid answers you can output any of them), otherwise output "Impossible" (without quotes).

对于每组数据，若存在符合要求的重排列，输出一行重排列后的字符串（若有多种合理答案，您可以输出任意一种），否则输出 "Impossible"（不输出引号）。

#### Sample Input / 样例输入
```in
2
01110
000
```

#### Sample Output / 样例输出
```out
11100
Impossible
```
