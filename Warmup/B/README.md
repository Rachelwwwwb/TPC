### Easy Number Game / 简单数字游戏

Given $`n`$ integers, each time one can take out two integers from the remaining ones and calculate the product of the two integers.

What's the minimum possible sum of all products calculated if this operation is performed $`m`$ times?

给定 $`n`$ 个整数，每次可以从剩下的整数中取走两个整数并计算这两个整数的积。

若该操作进行 $`m`$ 次，求每次计算的积之和的最小值。

#### Input / 输入格式

There are multiple test cases. The first line of the input contains an integer $`T`$ (about 30) indicating the number of test cases. For each test case:

The first line contains two integers $`n`$ and $`m`$ ($`1 \le n \le 10^5`$, $`0 \le m \le \frac{n}{2}`$). Their meanings are described above.

The second line contains $`n`$ integers $`a_1, a_2, \cdots, a_n`$ ($`0 \le a_i \le 10^4`$), indicating the numbers.

有多组测试数据。第一行输入一个整数 $`T`$（约 30）代表测试数据组数，对于每组数据：

第一行输入两个整数 $`n`$ 和 $`m`$（$`1 \le n \le 10^5`$, $`0 \le m \le \frac{n}{2}`$），它们的含义如题中所述。

第二行输入 $`n`$ 个整数 $`a_1, a_2, \cdots, a_n`$（$`0 \le a_i \le 10^4`$）表示给定的整数。

#### Output / 输出格式

For each test case output one line containing one integer, indicating the minimum possible sum of the products.

每组数据输出一行一个整数，表示积之和的最小值。

#### Sample Input / 样例输入
```in
3
4 2
1 3 2 4
3 1
2 3 1
4 0
1 3 2 4
```

#### Sample Output / 样例输出
```out
10
2
0
```

#### Hint / 样例说明

For the first sample test case, the answer is $`1 \times 4 + 3 \times 2 = 10`$.

For the second sample test case, the answer is $`2 \times 1 = 2`$.

对于第一组样例数据，答案是 $`1 \times 4 + 3 \times 2 = 10`$。

对于第二组样例数据，答案是 $`2 \times 1 = 2`$。
