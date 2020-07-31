### Almost Sorted Sequence / 几乎有序的序列

A sequence of even length $`n`$ is *almost sorted* if the maximum of the first $`\frac{n}{2}`$ values is less than or equal to the minimum of the last $`\frac{n}{2}`$ values.

Given an integer sequence of even length $`a_1, a_2, \cdots, a_n`$, one can perform the following operation on the sequence any number of times: choose two distinct indices $`i`$ and $`j`$ and swap $`a_i`$ and $`a_j`$. The cost for each operation is $`|i-j|`$.

What's the minimum cost needed to make the given sequence almost sorted?

若一个长度为 $`n`$（$`n`$ 为偶数）的序列中，前 $`\frac{n}{2}`$ 个元素里的最大值小于等于后 $`\frac{n}{2}`$ 个元素里的最小值，则称该序列“几乎有序”。

给定一个长度为偶数的序列 $`a_1, a_2, \cdots, a_n`$，可以对该序列进行以下操作任意多次：选择两个不同的序号 $`i`$ 和 $`j`$ 并交换 $`a_i`$ 与 $`a_j`$。每次操作的代价是 $`|i-j|`$。

求将给定序列转换为一个几乎有序的序列所需的最小代价。

#### Input / 输入格式
There are multiple test cases. The first line of the input contains an integer $`T`$, indicating the number of test cases. For each test case:

The first line contains an integer $`n`$ ($`2 \le n \le 10^5`$, $`n`$ is even), indicating the length of the sequence.

The second line contains $`n`$ positive integers $`a_1, a_2, \cdots, a_n`$ ($`1 \le a_i \le n`$).

It's guaranteed that the sum of $`n`$ of all test cases does not exceed $`10^5`$.

有多组测试数据。第一行输入一个整数 $`T`$ 代表测试数据组数。对于每组测试数据：

第一行输入一个整数 $`n`$（$`2 \le n \le 10^5`$, $`n`$ 是偶数）表示序列的长度。

第二行输入 $`n`$ 个正整数 $`a_1, a_2, \cdots, a_n`$ ($`1 \le a_i \le n`$)。

保证所有数据 $`n`$ 之和不超过 $`10^5`$。

#### Output / 输出格式
For each test case output one line containing one integer, indicating the minimum cost needed to make the sequence almost sorted.

每组数据输出一行一个整数，代表将给定序列转换为一个几乎有序的序列所需的最小代价。

#### Sample Input / 样例输入
```in
3
4
1 2 3 4
4
4 3 2 1
4
2 1 1 1
```

#### Sample Output / 样例输出
```out
0
4
2
```

#### Hint / 样例说明
For the first sample test case, as the given sequence is already almost sorted, no cost is needed.

For the second sample test case, we can swap the 1st and the 3rd integer, and the 2nd and the 4th integer. The cost is |1 - 3| + |2 - 4| = 4.

For the third sample test case, we can swap the 1st and the 3rd integer. The cost is |1 - 3| = 2.

对于第一组样例数据，由于给定的序列已经是几乎有序的，所以无需任何代价。

对于第二组样例数据，我们可以交换第 1、3 个整数以及第 2、4 个整数。代价是 |1 - 3| + |2 - 4| = 4。

对于第三组样例数据，我们可以交换第 1、3 个整数。代价是 |1 - 3| = 2。
