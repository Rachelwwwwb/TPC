<?php

define('MOD', 1000000007);

$dp = [];

$T = intval(fgets(STDIN));

$mp = ['?'=>0, '0'=>1, '1'=>2, '2'=>4];
$out = [];

while($T--){
	list($n, $k) = array_map('intval', explode(' ', fgets(STDIN)));
	$s = trim(fgets(STDIN));

	if($k * 3 > $n){
		$out[] = 0;
		continue;
	}
	
	for($i=0; $i<8; $i++){
		for($j=0; $j<=$k; $j++){
			$dp[0][$i][$j] = 0;
		}
	}

	$dp[0][0][0] = 1;

	for($i=0; $i<$n; $i++){
		$v = $mp[$s[$i]];
		$D = &$dp[1];
		
		for($j=0; $j<8; $j++){
			$E = &$D[$j];
			for($l=0; $l<=$k; $l++){
				$E[$l] = 0;
			}
		}

		if($v){
			for($j=0; $j<7; $j++){
				$E = &$dp[0][$j];
				$x = &$D[$j | $v];
				for($l=0; $l<=$k; $l++){
					$x[$l] += $E[$l] % MOD;
				}
			}
		} else {
			for($j=0; $j<7; $j++){
				$E = &$dp[0][$j];
				$x = &$D[$j | 1];
				$y = &$D[$j | 2];
				$z = &$D[$j | 4];
				for($l=0; $l<=$k; $l++){
					$cur = $E[$l] % MOD;
					if(!$cur)	continue;
					
					$x[$l] += $cur;
					$y[$l] += $cur;
					$z[$l] += $cur;
				}
			}
		}
		
		$dp = array_reverse($dp);

		$D = &$dp[0][7];
		$E = &$dp[0][0];

		for($j=0; $j<$k; $j++){
			$E[$j+1] += $D[$j];
		}
		$E[$k] += $D[$k];
	}

	$ans = 0;

	for($i=0; $i<7; $i++){
		$ans += $dp[0][$i][$k];
	}

	unset($dp);

	$out[] = $ans % MOD;
}

echo implode("\n", $out) . "\n";
