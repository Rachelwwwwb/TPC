<?php

$T = intval(fgets(STDIN));
$offset = 20;
$mask = (1 << $offset) - 1;

while($T--){
	$n = intval(fgets(STDIN));
	$arr = explode(' ', fgets(STDIN));
	for($i=0; $i<$n; $i++){
		$arr[$i] = intval($arr[$i]) << $offset | $i;
	}
	sort($arr);
	$m = $n >> 1;
	$ans = 0;
	for($i=0; $i<$m; $i++){
		$p1 = $arr[$i] & $mask;
		$p2 = $arr[$i+$m] & $mask;
		if($p1 >= $m)	$ans += $p1;
		if($p2 < $m)	$ans -= $p2;
	}
	printf("%d\n", $ans);
}