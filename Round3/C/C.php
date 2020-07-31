<?php

$s = trim(fgets(STDIN));

$arr = [];

$n = strlen($s);
$cnt = array_fill(0, 10, false);

for($i=0; $i<$n; $i++){
	$arr[$i] = intval($s[$i]);
	$cnt[$arr[$i]] = true;
}

$ans = -1;

for($i=0; $i<$n; $i++){
	if($arr[$i] % 2 == 0 || $arr[$i] == 5)	continue;
	for($j=1; $j<10 && $i+$j<$n; $j++){
		if($arr[$i+$j] % 2 == 0 || $arr[$i + $j] == 5)	break;
		$ans = max($ans, solve($i, $i+$j, $arr));
	}
}

$p = [2, 3, 5, 7];
foreach($p as $v){
	if($cnt[$v]){
		$ans = max($ans, $v);
	}
}

printf("%s\n", $ans);

function solve($L, $R, &$A){
	$ret = 0;
	$n = $R - $L + 1;
	for($i=0; $i<$n; $i++){
		$val = 0;
		for($j=0; $j<$n; $j++){
			$val = $val * 10 + $A[$L + ($i + $j) % $n];
		}

		if(!is_prime($val)){
			return -1;
		}

		$ret = $ret * 10 + $A[$i + $L];
	}
	return $ret;
}

function is_prime($n){
	for($i=3; $i*$i<=$n; $i+=2){
		if($n % $i == 0)	return false;
	}
	return true;
}
