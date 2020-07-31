<?php

$T = intval(fgets(STDIN));

while($T--){
	$s = trim(fgets(STDIN));

	$ans = [0, 0, 0, 0, 0, 0, 0, 0];

	$arr = explode(':', $s);
	$n = count($arr);
	for($i=0; $i<$n; $i++){
		if($arr[$i] === ''){
			break;
		}
		sscanf($arr[$i], "%x", $ans[$i]);
	}
	for($i=7, $j=$n-1; $i>=0; $i--, $j--){
		if($arr[$j] === ''){
			break;
		}
		sscanf($arr[$j], "%x", $ans[$i]);
	}
	$output = [];
	foreach($ans as $v){
		$output[] = sprintf("%04x", $v);
	}
	printf("%s\n", implode(':', $output));
}