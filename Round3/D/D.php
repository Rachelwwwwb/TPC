<?php

$T = intval(fgets(STDIN));

GLOBAL $matrix, $vis, $tree;

while($T--){
	list($n, $m) = array_map('intval', explode(' ', fgets(STDIN)));

	$matrix = array_fill(1, $n, []);
	$vis = array_fill(1, $n, false);

	while($m--){
		list($x, $y) = array_map('intval', explode(' ', fgets(STDIN)));

		$matrix[$x][] = $y;
		$matrix[$y][] = $x;
	}

	dfs(1);

	$ans = [1];

	$heap = new SplMinHeap();
	foreach($tree[1] as $nxt){
		$heap->insert($nxt);
	}

	while(!$heap->isEmpty()){
		$x = $heap->extract();
		$ans[] = $x;
		foreach($tree[$x] as $nxt){
			$heap->insert($nxt);
		}
	}

	printf("%s\n", implode(' ', $ans));
}

function dfs($x){
	GLOBAL $vis, $matrix, $tree;
	$vis[$x] = true;

	rsort($matrix[$x], SORT_NUMERIC);

	$tree[$x] = [];

	foreach($matrix[$x] as $to){
		if($vis[$to]){
			continue;
		}
		$tree[$x][] = $to;
		dfs($to);
	}
}