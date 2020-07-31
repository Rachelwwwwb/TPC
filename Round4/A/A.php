<?php

$T = intval(fgets(STDIN));

while($T--){
	$n = intval(fgets(STDIN));
	$sum = 0;
	$dia_min = PHP_INT_MAX;
	$dia_max = $other_max = 0;
	$mat = [];
	for($i=0; $i<$n; $i++){
		$arr = array_map('intval', explode(' ', fgets(STDIN)));
		for($j=0; $j<$n; $j++){
			$sum += $arr[$j] * 2;
			if($i == $j || $i + $j == $n - 1){
				$dia_min = min($dia_min, $arr[$j]);
				$dia_max = max($dia_max, $arr[$j]);
			} else {
				$other_max = max($other_max, $arr[$j]);
			}
		}
		$sum += $arr[$i] + $arr[$n-1-$i];
		$mat[$i] = $arr;
	}
	$diff = max(0, $other_max - $dia_min);
	if($n & 1){
		$v = $mat[$n>>1][$n>>1];
		$diff = max($diff, ($other_max - $v) * 2);
		$diff = max($diff, $dia_max - $v);
	}

	printf("%d\n", $sum + $diff);
}