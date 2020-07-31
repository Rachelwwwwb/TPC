<?php

function query($s, $t, $a, $b){
	for($i=$a+1; $i<=$b; $i++){
		if($t[$i] != $t[$a])	return -1;
	}
	if($s[$a] == $s[$a-1] || $s[$b] == $s[$b+1])	return -1;
	return 1;
}

function solve($n, $s, $t){
	$s = '*' . $s . '*';
	$t = '*' . $t . '*';
	$pre = $ret = $tmp = 0;
	for($i=1; $i<=$n+1; $i++){
		if($s[$i] == $t[$i]){
			if($pre != $i-1){
				$tmp = query($s, $t, $pre+1, $i-1);
				if($tmp == -1)	return -1;
				$ret += $tmp;
			}
			$pre = $i;
		}
	}
	return $ret;
}

$T = intval(fgets(STDIN));

while($T--){
	$n = intval(fgets(STDIN));
	$s = trim(fgets(STDIN));
	$t = trim(fgets(STDIN));

	printf("%d\n", solve($n, $s, $t));
}