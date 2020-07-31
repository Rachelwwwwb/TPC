### Easy Task / 简单题

Given $`n`$ integers, each time one can perform the following operation: select the maximum interger $`a`$ and the minimum integer $`b`$ among them, and then replace both $`a`$ and $`b`$ with $`(a - b)`$. 

Is it possible to make all integers equal after a finite number of operations? If yes, what's the final result?

给定 $`n`$ 个整数，每次可以进行如下操作：选择其中最大的整数 $`a`$ 与最小的整数 $`b`$，并将它们都替换为 $`(a - b)`$。

是否可以在有限次操作内使得所有整数都相等？如果是，最后的结果是什么？

#### Input / 输入格式

There are multiple test cases. The first line of the input contains an integer $`T`$ (about 20) indicating the number of test cases. For each test case:

The first line contains an integer $`n`$ ($`2 \le n \le 10`$) indicating the number of integers.

The second line contains $`n`$ integers $`a_1, a_2, \cdots, a_n`$ ($`-10^5 \le a_i \le 10^5`$) indicating the given integers.

有多组测试数据。第一行输入一个整数 $`T`$（约 20）代表测试数据组数。对于每组测试数据：

第一行输入一个整数 $`n`$（$`2 \le n \le 10`$）代表给定整数的数量。

第二行输入 $`n`$ 个整数 $`a_1, a_2, \cdots, a_n`$（$`-10^5 \le a_i \le 10^5`$）代表给定的整数。

#### Output / 输出格式

For each test case output one line. If it's possible to make all integers equal, output the integer they'll become; Otherwise output "Impossible" (without quotes).

每组数据输出一行。若可以将所有整数变为相等，输出最终产生的那个整数；否则输出 "Impossible"（不输出引号）。

#### Sample Input / 样例输入
```in
2
3
1 2 3
2
5 5
```

#### Sample Output / 样例输出
```out
2
5
```
