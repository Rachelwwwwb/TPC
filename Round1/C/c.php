<?php

$A = '012345678';
$vis = [];

$Q = new SplQueue();

$vis[$A] = 0;

$Q->enqueue($A);

while(!$Q->isEmpty()){
	$A = $Q->dequeue();
	$cur = $vis[$A] + 1;

	$pt = 0;
	for($i=0; $i<3; $i++){
		$tmp = $A;
		$tmp[$pt+2] = $tmp[$pt+1];
		$tmp[$pt+1] = $tmp[$pt];
		$tmp[$pt] = $A[$pt+2];

		if(!isset($vis[$tmp])){
			$vis[$tmp] = $cur;
			$Q->enqueue($tmp);
		}

		$pt += 3;
	}

	$pt1 = 0;
	$pt2 = 3;
	$pt3 = 6;
	for($i=0; $i<3; $i++){
		$tmp = $A;
		$tmp[$pt3+$i] = $tmp[$pt2+$i];
		$tmp[$pt2+$i] = $tmp[$pt1+$i];
		$tmp[$pt1+$i] = $A[$pt3+$i];

		if(!isset($vis[$tmp])){
			$vis[$tmp] = $cur;
			$Q->enqueue($tmp);
		}
	}
}

$T = intval(fgets(STDIN));

$out = [];

while($T--){
	$s1 = trim(fgets(STDIN)) . trim(fgets(STDIN)) . trim(fgets(STDIN));
	$s2 = trim(fgets(STDIN)) . trim(fgets(STDIN)) . trim(fgets(STDIN));

	$mp = [];
	for($i=0; $i<9; $i++){
		$mp[$s1[$i]] = $i;
	}
	$s3 = '';
	for($i=0; $i<9; $i++){
		$s3 .= $mp[$s2[$i]];
	}

	if(isset($vis[$s3])){
		$out[] = $vis[$s3];
	} else {
		$out[] = 'impossible';
	}
}

printf("%s\n", implode("\n", $out));