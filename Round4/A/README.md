### Lottery / 彩票

A type of lottery is a matrix of $`n`$ rows and $`n`$ columns. Let
* $`R_i`$ be the sum of all elements on the $`i`$-th row of the matrix;
* $`C_i`$ be the sum of all elements on the $`i`$-th column of the matrix;
* $`P`$ be the sum of all elements on the principle diagonal (main diagonal) of the matrix;
* $`A`$ be the sum of all elements on the antidiagonal (minor diagonal) of the matrix.

The player can swap at most one pair of elements in the matrix. After that he will earn

<center>$`\sum\limits_{i=1}^n R_i + \sum\limits_{i=1}^n C_i + P + A`$</center>

amount of money. Given a lottery, what's the maximum possible amount of money one can earn?

一种彩票的票面是一个 $`n`$ 行 $`n`$ 列的矩阵。令：
* $`R_i`$ 为矩阵第 $`i`$ 行的元素之和；
* $`C_i`$ 为矩阵第 $`i`$ 列的元素之和；
* $`P`$ 为矩阵主对角线的元素之和；
* $`A`$ 为矩阵反对角线（次对角线）的元素之和。

玩家可以交换矩阵中至多一对元素。操作完成后，玩家将会获得

<center>$`\sum\limits_{i=1}^n R_i + \sum\limits_{i=1}^n C_i + P + A`$</center>

的奖金。给出一张彩票票面，求玩家至多能获得多少奖金。

#### Input / 输入格式

There are multiple test cases. The first line of the input contains an integer $`T`$ indicating the number of test cases. For each test case:

The first line contains an integer $$`n`$ ($`1 \le n \le 10^3`$) indicating the size of the lottery.

For the following $`n`$ lines, the $`i`$-th line contains $`n`$ integers $`a_{i,1},a_{i,2},\cdots,a_{i,n}`$ ($`1 \le a_{i,j} \le 10^9`$) where $`a_{i,j}`$ indicates the element on the $`i`$-th row and $`j`$-th column of the matrix.

It's guaranteed that the sum of $`n`$ of all test cases will not exceed $`10^3`$.

有多组测试数据。第一行输入一个整数 $`T`$ 代表测试数据组数。对于每组测试数据：

第一行输入一个整数 $`n`$ ($`1 \le n \le 10^3`$) 代表彩票票面的大小。

对于接下来 $`n`$ 行，第 $`i`$ 行输入 $`n`$ 个整数 $`a_{i,1},a_{i,2},\cdots,a_{i,n}`$ ($`1 \le a_{i,j} \le 10^9`$)，其中  $`a_{i,j}`$ 代表矩阵第 $`i`$ 行第 $`j`$ 列的元素。

保证所有输入数据的 $`n`$ 之和不超过 $`10^3`$。

#### Output / 输出格式
For each test case output one line containing one integer indicating the maximum possible amount of money the player can earn by swapping at most one pair of elements in the matrix.

每组数据输出一行一个整数，代表玩家在至多交换矩阵的一对元素后最多能获得多少奖金。

#### Sample Input / 样例输入
```in
2
3
5 9 5
9 1 9
5 9 5
3
1 1 1
1 100 1
1 1 1
```

#### Sample Output / 输出格式
```out
152
420
```

#### Hint / 样例说明
For the first sample test case, the player should swap the 9 on the 1st line with the 1 on the 2nd line. After that the lottery becomes

<table>
	<tbody>
		<tr><td></td><td></td><td></td><td>19</td></tr>
		<tr><td>**5**</td><td>**1**</td><td>**5**</td><td>11</td></tr>
		<tr><td>**9**</td><td>**9**</td><td>**9**</td><td>27</td></tr>
		<tr><td>**5**</td><td>**9**</td><td>**5**</td><td>19</td></tr>
		<tr><td>19</td><td>19</td><td>19</td><td>19</td></tr>
	</tbody>
</table>

So the answer is 19 + 11 + 27 + 19 + 19 + 19 + 19 + 19 = 152.

For the second sample test case, it's obvious that the player should not perform any swapping.

对于第一组样例数据，玩家应该将第一行的 9 和第二行的 1 进行交换。交换后彩票票面变为

<table>
	<tbody>
		<tr><td></td><td></td><td></td><td>19</td></tr>
		<tr><td>**5**</td><td>**1**</td><td>**5**</td><td>11</td></tr>
		<tr><td>**9**</td><td>**9**</td><td>**9**</td><td>27</td></tr>
		<tr><td>**5**</td><td>**9**</td><td>**5**</td><td>19</td></tr>
		<tr><td>19</td><td>19</td><td>19</td><td>19</td></tr>
	</tbody>
</table>

所以答案是 19 + 11 + 27 + 19 + 19 + 19 + 19 + 19 = 152。

对于第二组样例数据，显然玩家不应该进行任何交换。
