<?php

$T = intval(fgets(STDIN));

while($T--){
	$s = trim(fgets(STDIN));

	$ans = solve($s);

	if($ans === false){
		$ans = 'Impossible';
	}

	printf("%s\n", $ans);
}

function solve($s){
	$c = count_chars($s);
	$a = $c[ord('0')];
	$b = $c[ord('1')];

	if($a > $b * 2 + 2){
		return false;
	}

	if(!$a){
		return $s;
	}

	$p = ($a - 1) >> 1;

	$ret = array_fill(0, $b - $p, '1') + array_fill($b - $p, $p, '001') + array_fill($b + $p * 2, $a - $p * 2, '0');

	return implode('', $ret);
}