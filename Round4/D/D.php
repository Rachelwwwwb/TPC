<?php

$T = intval(fgets(STDIN));

while($T--){
	$n = intval(fgets(STDIN));
	$arr = array_map('intval', explode(' ', fgets(STDIN)));
	$cnt = array_count_values($arr);

	$heap = new SplPriorityQueue();

	foreach($cnt as $key => $num){
		$heap->insert($key, $num);
	}

	$top1 = $heap->extract();

	if(($n - $cnt[$top1]) * 4 + 1 < $n){
		printf("No\n");
		continue;
	}

	$val = [
		1 => $top1
	];
	$ch = array_fill(1, $n, [0, 0]);

	if(--$cnt[$top1] > 0){
		$heap->insert($top1, $cnt[$top1]);
	}

	$queue = [];
	$head = $tail = 0;
	$queue[$tail++] = 1;

	$num = 2;

	while(!$heap->isEmpty()){
		$top1 = $heap->extract();
		$x = $queue[$head++];

		if($cnt[$top1] >= 2 && $top1 != $val[$x]){
			$ch[$x] = [$num, $num+1];
			$val[$num] = $val[$num+1] = $top1;
			$queue[$tail++] = $num;
			$queue[$tail++] = $num + 1;
			$num += 2;
			$cnt[$top1] -= 2;
			if($cnt[$top1] > 0)	$heap->insert($top1, $cnt[$top1]);
		} elseif(!$heap->isEmpty()){
			$top2 = $heap->extract();
			$ch[$x] = [$num, $num+1];
			if($top1 > $val[$x] || $top2 < $val[$x]){
				$val[$num] = $top1;
				$val[$num+1] = $top2;
			} else {
				$val[$num] = $top2;
				$val[$num+1] = $top1;
			}
			$queue[$tail++] = $num;
			$queue[$tail++] = $num + 1;
			$num += 2;
			if(--$cnt[$top1] > 0)	$heap->insert($top1, $cnt[$top1]);
			if(--$cnt[$top2] > 0)	$heap->insert($top2, $cnt[$top2]);
		} elseif($top1 != $val[$x]){
			$val[$num] = $top1;
			if($top1 > $val[$x]){
				$ch[$x] = [$num, 0];
			} else {
				$ch[$x] = [0, $num];
			}
			$queue[$tail++] = $num;
			$num += 1;
			if(--$cnt[$top1] > 0)	$heap->insert($top1, $cnt[$top1]);
		} else {
			$heap->insert($top1, $cnt[$top1]);
		}
	}

	printf("Yes\n");
	for($i=1; $i<=$n; $i++){
		printf("%d %d %d\n", $val[$i], $ch[$i][0], $ch[$i][1]);
	}
}