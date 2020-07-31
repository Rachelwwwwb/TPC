<?php

$T = intval(fgets(STDIN));

function solve($n, $s){
	if(strpos($s, 'T')===false || strpos($s, 'P')===false || strpos($s, 'C')===false){
		return 'Impossible';
	}
	if(strpos($s, 'TPC') !== false){
		return 0;
	}
	if(strpos($s, 'CPT') !== false){
		return 1;
	}
	$check_list = [
		['TP', 'C'],
		['PT', 'C'],
		['T', 'PC'],
		['T', 'CP']
	];

	foreach($check_list as $v){
		$p = strpos($s, $v[0]);
		$q = strrpos($s, $v[1]);
		if($p !== FALSE && $q !== false && $p < $q){
			return 1;
		}
	}
	if(strrpos($s, 'C') < strpos($s, 'P')-1 && strrpos($s, 'P')<strpos($s, 'T')-1){
		return 3;
	}
	return 2;
}

$out = [];

while($T--){
	$n = intval(fgets(STDIN));
	$s = trim(fgets(STDIN));
	$out[] = solve($n, $s);
}

printf("%s\n", implode("\n", $out));