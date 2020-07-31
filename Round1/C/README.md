### Puzzle / 九宫谜题

A **3-order magic square** is a $`3 \times 3`$ matrix filled with distinct positive integers in the range $`\{1, 2, 3, 4, 5, 6, 7, 8, 9\}`$.

Now we can do the following operations on a 3-order magic square:

- select one row of the magic square, and then move the rightmost element in this row to the leftmost side.
- select one column of the magic square, and then move the bottommost element in this column to the topmost side.

Now you are given a 3-order magic square, find out the minimum number of operations needed to transform it into another given square.

一个**三阶幻方**就是一个由数字 1 至 9 组成的 $`3 \times 3`$ 的矩阵，矩阵内元素两两不相同。

允许对三阶幻方进行以下操作：

- 选择其中一行，并将该行最右边的元素移动到最左边。
- 选择其中一列，并将该列最下方的元素移动到最上方。

给出一个三阶幻方，求将其转换为另一个三阶幻方的最小操作数。

#### Input / 输入格式

There are multiple test cases. The first line of the input contains an integer $`T`$ ($`1 \le T \le 2 \times 10^4`$), indicating the number of test cases. For each test case:

For the first 3 lines, the $`i`$-th line contains a string $`s_i`$ ($`|s_i| = 3`$), where $`s_{i,j}`$ indicates the number on the $`i`$-th row and the $`j`$-th column of the initial magic square.

For the following 3 lines, the $`i`$-th line contains a string $`t_i`$ ($`|t_i| = 3`$), where $`t_{i,j}`$ indicates the number on the $`i`$-th row and the $`j`$-th column of the desired magic square.

有多组测试数据。第一行输入一个整数 $`T`$ ($`1 \le T \le 2 \times 10^4`$) 代表测试数据组数。对于每组测试数据：

前三行中第 $`i`$ 行输入一个字符串 $`s_i`$ ($`|s_i| = 3`$)，其中 $`s_{i,j}`$ 表示初始幻方中第 $`i`$ 行第 $`j`$ 列的数字。

接下来三行中第 $`i`$ 行输入一个字符串 $`t_i`$ ($`|t_i| = 3`$)，其中 $`t_{i,j}`$ 表示目标幻方中第 $`i`$ 行第 $`j`$ 列的数字。

#### Output / 输出格式

For each test case output one line containing one integer, indicating the minimum number of operations.

If it is impossible to transform the square from the initial state to the desired state, output "impossible" (without quotes) instead.

每组数据输出一行一个整数，代表所需的最少操作数。

若无法将幻方从初始状态转化为目标状态，则输出 "impossible"（不输出引号）。

#### Sample Input / 样例输入
```in
4
123
456
789
231
456
789
457
213
689
257
361
489
927
641
358
297
651
384
123
456
789
123
456
789
```

#### Sample Output / 样例输出
```out
2
3
impossible
0
```

#### Hint / 样例说明

For the 1st sample test case, we can select the 1st row and then move the rightmost element in this row to the leftmost side twice.

For the 2nd sample test case, we can first select the 1st column and then move the bottommost element in this column to the topmost side twice; then we can select the 2nd row and move the rightmost element in this row to the leftmost side.

对于第一组样例数据，可以选择第一行，并将该行最右边的元素移动到最左边两次。

对于第二组样例数据，可以选择第一列，并将该列最下方的元素移动到最上方两次；之后选择第二行，并将该行最右边的元素移动到最左边一次。
