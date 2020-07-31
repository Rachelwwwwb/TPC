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
	rsort($arr);
	$str = array_fill(0, $n, 'a');
	$diff = 0;

	for($i=0; $i<$n; $i++){
		$x = $arr[$i] >> $offset;
		$y = $arr[$i] & $mask;
		if($diff >= $x){
			$diff -= $x;
			$str[$y] = 'b';
		} else {
			$diff += $x;
		}
	}

	printf("%s\n", implode('', $str));
}