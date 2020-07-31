### How Many Nines / 九的数量

If we represent a date in the format YYYY-MM-DD (for example, 2019-09-19), do you know how many 9s will appear in all the dates between $`Y_1`$-$`M_1`$-$`D_1`$ and $`Y_2`$-$`M_2`$-$`D_2`$ (both inclusive)?

Note that you should take leap years into consideration. A leap year is a year which can be divided by 400 or can be divided by 4 but can't be divided by 100.

若将日期表示为 YYYY-MM-DD 的形式（例如 2019-09-19），求 $`Y_1`$-$`M_1`$-$`D_1`$ 与 $`Y_2`$-$`M_2`$-$`D_2`$ 间（含两端）的所有日期中一共出现了多少个 9。

请注意，您需要考虑闰年的情况。闰年就是一个可以被 400 整除或可以被 4 整除但不能被 100 整除的年份。

#### Input / 输入格式

There are multiple test cases. The first line of the input contains an integer $`T`$ (about $`10^5`$) indicating the number of test cases, for each test case:

The first and only line contains six integers $`Y_1`$, $`M_1`$, $`D_1`$, $`Y_2`$, $`M_2`$ and $`D_2`$. Their meanings are described above.

It's guaranteed that $`Y_1`$-$`M_1`$-$`D_1`$ is not larger than $`Y_2`$-$`M_2`$-$`D_2`$. Both $`Y_1`$-$`M_1`$-$`D_1`$ and $`Y_2`$-$`M_2`$-$`D_2`$ are between 2000-01-01 and 9999-12-31, and both dates are valid.

有多组测试数据。第一行输入一个整数 $`T`$（约 $`10^5`$）表示测试数据组数，对于每组测试数据：

第一行输入六个整数 $`Y_1`$, $`M_1`$, $`D_1`$, $`Y_2`$, $`M_2`$ 与 $`D_2`$，含义如题中所述。

保证 $`Y_1`$-$`M_1`$-$`D_1`$ 不大于 $`Y_2`$-$`M_2`$-$`D_2`$ 且两个日期都在 2000-01-01 到 9999-12-31 之间，且都是合法的日期。

#### Output / 输出格式

For each test case output one line containing one integer, indicating the answer of this test case.

每组数据输出一行一个整数表示答案。

#### Sample Input / 样例输入
```in
4
2017 04 09 2017 05 09
2100 02 01 2100 03 01
9996 02 01 9996 03 01
2000 01 01 9999 12 31
```

#### Sample Output / 样例输出
```out
4
2
93
1763534
```

#### Hint / 样例解释

For the third test case, at least three 9s appear in each date between 9996-02-01 and 9996-03-01. Also, there are three additional nines, namely 9996-02-09 (one 9), 9996-02-19 (one 9) and 9996-02-29 (one 9). So the answer is 3 × 30 + 3 = 93.

对于第三组样例数据，9996-02-01 至 9996-03-01 之间的每个日期都至少含有三个 9。另外还有三个日期含有更多的 9，它们是 9996-02-09（多一个 9），9996-02-19（多一个 9）和 9996-02-29（多一个 9）。
