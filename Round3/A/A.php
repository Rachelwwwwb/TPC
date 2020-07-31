<?php

$T = intval(fgets(STDIN));

$mods = [
	'divide_by_three' => 3,
	'divide_by_four' => 4,
	'divide_by_five' => 5
];
$primes = [2,3,5,7,11];

while($T--){
	list($val, $cmd) = explode(' ', trim(fgets(STDIN)));
	$val = intval($val);
	if(isset($mods[$cmd])){
		$m = $mods[$cmd];
		$ans = ($m - $val % $m) % $m;
	} else {
		for($i=0; $i<5; $i++){
			if($primes[$i] >= $val){
				$ans = $primes[$i] - $val;
				break;
			}
		}
	}
	printf("%d\n", $ans);
}