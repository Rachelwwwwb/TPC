### Construct 7 / 劳动七号

<p><center>*Basic computation protocol loaded. Initiaing lesson. -- Construct 7*</center></p>

*Construct 7* is the third boss in the 24-man alliance raid *The Ridorana Lighthouse* of the famous MMORPG *Final Fantasy XIV*. During the fight, the boss will enter *Computation Mode* in which the health of the players will be reduced to a random number between 1 to 9 inclusive. Players have to step into, or keep away from, four circular areas representing 1, 2, 3 and 4 on the battle field to adjust their health according to the command of Construct 7 and survive the fight.

Each time Construct 7 will select one of the following four commands:
* Divide by Three: Adjust the value of health to be divisible by 3;
* Divide by Four: Adjust the value of health to be divisible by 4;
* Divide by Five: Adjust the value of health to be divisible by 5;
* Indivisible: Adjust the value of health to a prime.

<center>
![construct-7.png](~/6bb9ef72-7ff3-481e-b1f2-1b61a3919167.png)
<br><i>Construct 7 in the game</i></center>

If a player's health value is initially $`h`$, when he steps into a circular area representing $`c`$, his health will be adjusted to $`(h+c)`$. If he doesn't step into any circular area, his health will remain unchanged.

Given the health value of a player at the beginning of the computation mode and the command of the boss, which area should he step into? To make the problem a little harder, you should output the answer that makes the adjustment as small as possible.

<p><center>*读取完成…… 好了，各位同学！到该学习的时间了！  -- 劳动七号*</center></p>

劳动七号是人气 MMORPG《最终幻想 14》中 24 人团队任务“封闭圣塔黎铎拉纳大灯塔”的第三个 boss。在战斗过程中，boss 会进入“算术芯片”状态。玩家们的体力会被减少至 1 到 9 的随机数（含 1 和 9），此时需要依据劳动七号的指令，进入或远离场上四个代表 1，2，3 和 4 的圆形区域调整自己的体力，以躲避接下来的攻击。

劳动七号会使用以下四种指令中的一种：
* 算术 - 3 的倍数（Divide by Three）：需要调整自己的体力为 3 的倍数；
* 算术 - 4 的倍数（Divide by Four）：需要调整自己的体力为 4 的倍数；
* 算术 - 5 的倍数（Divide by Five）：需要调整自己的体力为 5 的倍数；
* 算术 - 质数（Indivisible）：需要调整自己的体力为质数。

<center>
![construct-7.png](~/6bb9ef72-7ff3-481e-b1f2-1b61a3919167.png)
<br><i>游戏中的劳动七号</i></center>

若玩家初始的体力值为 $`h`$，当他进入代表 $`c`$ 的圆形区域后，他的体力值会被调整为 $`(h+c)`$。如果他没有进入任何圆形区域，那么他的体力值不变。

给出玩家在算术芯片阶段开始时的体力值以及 boss 的指令，该玩家需要进入哪个圆形区域？为了增加一些难度，您需要输出让体力值调整量最小的答案。

#### Input / 输入格式

There are multiple test cases. The first line of the input contains an integer $`T`$ (about 40) indicating the number of test cases. For each test case:

The first and only line contains an integer $`h`$ ($`1 \le h \le 9`$) and a string $`s`$, indicating the initial health of the player and the command of the boss. String $`s`$ can only be "divide_by_three", "divide_by_four", "divide_by_five" or "indivisible".

有多组测试数据。第一行输入一个整数 $`T`$（约 40）代表测试数据组数。对于每组测试数据：

第一行输入一个整数 $`h`$ ($`1 \le h \le 9`$) 以及一个字符串 $`s`$，代表玩家的初始体力以及 boss 的指令。字符串 $`s`$ 只会是 "divide_by_three"，"divide_by_four"，"divide_by_five" 或 "indivisible" 中的一个。

#### Output / 输出格式

For each test case output one line containing one integer (between 1 and 4 inclusive), indicating the circular area the player should step into. If he should not step into any circular area, output 0. Note again that your answer should be as small as possible.

每组数据输出一行一个整数（1 至 4，包含 1 和 4），代表玩家需要进入的圆形区域。若玩家无需进入任何区域则输出 0。再次注意，您需要输出最小的答案。

#### Sample Input / 样例输入
```in
4
2 divide_by_three
8 divide_by_four
9 divide_by_five
9 indivisible
```

#### Sample Output / 样例输出
```out
1
0
1
2
```

#### Hint / 样例说明
For the first sample test case, although the player can also step into the circular area representing 4, but you should output the smallest possible answer which is 1.

For the second sample test case, as 8 is already divisible by 4, the player does not need to step into any circular area.

对于第一组样例数据，虽然玩家也可以进入代表 4 的圆形区域，但是您需要输出最小的答案，也就是 1。

对于第二组样例数据，由于 8 已经是 4 的倍数，所以玩家无需进入任何圆形区域。
