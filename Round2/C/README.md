### Lucky String / 幸运字符串

We define the strings containing "TPC" as a continuous substring as *lucky strings*. For example, "ABCTPCCBA" is a lucky string while "TTPPCC" is not.

You have just found a string $`s`$ on the table and you would like to make it a lucky string by reversing some of its continuous substrings. Formally, a reversing operation on the string $`s=s_{1}s_{2} \cdots s_{n}`$ is to choose two indices $`l`$ and $`r`$ ($`1 \le l \le r \le n`$) and to modify $`s`$ to $`s_1s_2 \cdots s_{l-1}s_rs_{r-1} \cdots s_{l+1}s_ls_{r+1} \cdots s_n`$. For example, if we reverse the string "ABCDE" by choosing $`l = 2`$ and $`r = 4`$, we get "ADCBE".

What's the minimum number of reversing operation needed to make $`s`$ a lucky string?

若字符串中含有连续子串 "TPC"，则我们称该字符串为“幸运字符串”。例如，"ABCTPCCBA" 是幸运字符串，而 "TTPPCC" 就不是。

你刚刚在桌子上找到了一个字符串 $`s`$，并且你打算通过倒转它的若干连续子串将其变为一个幸运字符串。正式地说，对字符串 $`s=s_{1}s_{2} \cdots s_{n}`$ 的一次倒转操作，就是选出两个下标 $`l`$ 与 $`r`$ ($`1 \le l \le r \le n`$) 并将字符串修改为 $`s_1s_2 \cdots s_{l-1}s_rs_{r-1} \cdots s_{l+1}s_ls_{r+1} \cdots s_n`$。例如，对于字符串 "ABCDE"，若我们选择 $`l = 2`$ 以及 $`r = 4`$，那么倒转操作的结果为 "ADCBE"。

求最少通过几次倒转操作可以将 $`s`$ 变为一个幸运字符串。

#### Input / 输入格式
There are multiple cases. The first line of the input contains a single integer $`T`$ ($`1 \le T \le 10^5`$) indicating the number of test cases. For each test case:

The first line contains an integer $`n`$ ($`1 \le n \le 10^5`$), indicating the length of the string $`s`$.

The second line contains the string $`s`$ ($`|s| = n`$) consisting only of upper-cased letters.

It's guaranteed that the sum of $`n`$ of all test cases does not exceed $`10^6`$.

有多组测试数据。第一行输入一个整数 $`T`$ 代表测试数据组数。对于每组测试数据：

第一行输入一个整数 $`n`$ ($`1 \le n \le 10^5`$)，代表字符串 $`s`$ 的长度。

第二行输入字符串 $`s`$ ($`|s| = n`$)，字符串仅包含大写字母。

保证所有数据的 $`n`$ 之和不超过 $`10^6`$。

#### Output / 输出格式
For each test case output one line containing one integer, indicating the minimum number of reversing operation needed to make $`s`$ a lucky string. In case that this is impossible, output "Impossible" (without quotes) instead.

每组数据输出一行一个整数，代表最少通过几次倒转操作可以将 $`s`$ 变为一个幸运字符串。若无法将 $`s`$ 变为幸运字符串则输出 "Impossible"（不输出引号）。

#### Sample Input / 样例输入
```in
4
3
TPC
6
TTPPCC
4
ABCD
5
TCIPT
```

#### Sample Output / 样例输出
```out
0
1
Impossible
2
```
