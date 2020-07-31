### Group the Integers / 整数分组

You need to divide all the integers ranging from 1 to $`n`$ (both inclusive) into some groups. The only constraint is that, the integers in the same group must be co-prime. Each integer must belong to exactly one group.

What's the smallest possible number of groups you can achieve?

请将从 1 至 $`n`$ （包括 1 与 $`n`$）的所有整数分成若干组，使得每一组内的整数互质。每个整数应恰好属于一个分组。

求最少的分组数。

#### Input / 输入格式

There are multiple test cases. The first line of the input is an integer $`T`$ (about $`10^5`$), indicating the number of test cases. For each test case:

The first and only line contains an integer $`n`$ ($`1 \le n \le 10^9`$).

有多组测试数据。第一行输入一个整数 $`T`$ （约 $`10^5`$）代表测试数据组数。对于每组测试数据：

第一行输入一个整数 $`n`$ （$`1 \le n \le 10^9`$）。

#### Output / 输出格式

For each test case output one line containing one integer, indicating the smallest possible number of groups one can achieve.

每组数据输出一行一个整数，代表最少分组数。

#### Sample Input / 样例输入
```in
2
2
5
```

#### Sample Output / 样例输出
```out
1
2
```

#### Hint / 样例说明

For the second sample test case, we can divide the integers into {1, 2, 3, 5} and {4}.

对于第二组样例数据，我们可以将整数划分为 {1, 2, 3, 5} 和 {4} 两组。
