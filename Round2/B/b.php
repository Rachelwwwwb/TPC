<?php

list($n, $name) = explode(' ', fgets(STDIN));
$n = intval($n);
$name = trim($name);

$arr = explode(' ', fgets(STDIN));
$A = [];
foreach($arr as $v){
	$v = intval($v);
	if(!isset($A[$v])){
		$A[$v] = 0;
	}
	$A[$v]++;
}

function solve($A, $name){
	$cnt = 0;
	foreach($A as $v){
		if($v == 1)	return 'Alice';
		if($v == 2)	$cnt++;
	}
	if($cnt == 0)	return 'Bob';
	if($cnt == 1){
		return $name;
	}
	return 'Alice';
}

printf("%s\n", solve($A, $name));