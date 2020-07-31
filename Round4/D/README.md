### Anti Binary Search Tree / 反二叉搜索树

For a binary tree, let $`\mathbb{V}`$ be the set of all its vertices and $`K(v)`$ be the key of a vertex $`v \in \mathbb{V}`$. We say this binary tree is an *anti binary search tree* if for all $`v \in \mathbb{V}`$, at least one of the following statement is true:
* Vertex $`v`$ is a leaf;
* Vertex $`v`$ has a left child $`l`$ and $`K(l) > K(v)`$;
* Vertex $`v`$ has a right child $`r`$ and $`K(r) < K(v)`$.

Given $`n`$ integers $`a_1, a_2, \cdots, a_n`$, please construct an anti binary search tree such that the multi-set of the keys of all vertices in the tree equals to the multi-set of these $`n`$ integers, and that the height of the tree does not exceed $`\lceil\log_2 n\rceil`$, where $`\lceil x \rceil`$ indicates the smallest integer that is not smaller than $`x`$.

Recall that the height of the tree is the maximum number of edges between the root of the tree and any vertex on the tree. That is to say, a tree with only one vertex has a height of 0, and a tree with two vertices has a height of 1.

对于一棵二叉树，令 $`\mathbb{V}`$ 为它的点集，$`K(v)`$ 为节点 $`v \in \mathbb{V}`$ 的键值。称该二叉树为“反二叉搜索树”，若对于所有 $`v \in \mathbb{V}`$ 至少满足以下一项条件：
* 节点 $`v`$ 是一个叶子节点；
* 节点 $`v`$ 有一个左子节点 $`l`$，且 $`K(l) > K(v)`$；
* 节点 $`v`$ 有一个右子节点 $`r`$，且 $`K(r) < K(v)`$。

给定 $`n`$ 个整数 $`a_1, a_2, \cdots, a_n`$，请构造一棵反二叉搜索树，使得该树所有节点的键值形成的可重集合与给定的 $`n`$ 个整数形成的可重集合相同，且该树的高度不超过 $`\lceil\log_2 n\rceil`$，其中 $`\lceil x \rceil`$ 表示不小于 $`x`$ 的最小整数。

请回忆：一棵树的高度指的是根节点与任意节点之间边的数量的最大值。也就是说，一棵只有一个节点的树，其高度为 0；一棵有两个节点的树，其高度为 1。

#### Input / 输入格式

There are multiple test cases. The first line of the input contains an integer $`T`$ indicating the number of test cases. For each test case:

The first line contains an integer $`n`$ ($`1 \le n \le 10^5`$) indicating the number of given integers.

The second line contains $`n`$ integers $`a_1, a_2, \cdots, a_n`$ ($`1 \le a_i \le n`$) indicating the given integers.

It's guaranteed that the sum of $`n`$ of all test cases will not exceed $`5 \times 10^5`$.

有多组测试数据。第一行输入一个整数 $`T`$ 代表测试数据组数。对于每组测试数据：

第一行输入一个整数 $`n`$ ($`1 \le n \le 10^5`$) 表示给定整数的数量。

第二行输入 $`n`$ 个整数 $`a_1, a_2, \cdots, a_n`$ ($`1 \le a_i \le n`$) 表示给定的整数。

保证所有数据的 $`n`$ 之和不超过 $`5 \times 10^5`$。

#### Output / 输出格式

For each test case, if such anti binary search tree exists, first output "Yes" (without quotes) in one line, then output $`n`$ lines indicating the constructed binary tree. For these $`n`$ lines, the $`i`$-th line contains 3 integers $`k_i`$, $`l_i`$ and $`r_i`$ separated by a space, indicating the key of the $`i`$-th vertex, the index of its left child and the index of its right child. $`l_i = 0`$ indicates that this vertex does not have a left child, while $`r_i = 0`$ indicates that this vertex does not have a right child. Vertex number 1 must be the root. If there are multiple valid answers, you can output any of them.

If no such anti binary search tree exists, just output "No" (without quotes) in one line.

对于每组数据，若存在符合要求的反二叉搜索树，首先输出一行 "Yes"（不输出括号），再输出 $`n`$ 行描述这棵树。这 $`n`$ 行中，第 $`i`$ 行输出三个由单个空格分隔的整数 $`k_i`$，$`l_i`$ 与 $`r_i`$，代表第 $`i`$ 个节点的键值，其左子节点的编号和其右子节点的编号。$`l_i = 0`$ 表示该节点没有左子节点，$`r_i = 0`$ 表示该节点没有右子节点。1 号节点必须是二叉树的根。如果有多种合理答案，您可以输出其中任何一种。

若不存在符合要求的反二叉搜索树，输出一行 "No"（不输出括号）即可。

#### Sample Input / 样例输入
```in
3
4
1 2 3 2
3
1 1 1
5
1 1 1 1 2
```

#### Sample Output / 样例输出
```out
Yes
3 2 3
2 0 0
1 4 0
2 0 0
No
Yes
1 2 5
2 3 4
1 0 0
1 0 0
1 0 0
```
