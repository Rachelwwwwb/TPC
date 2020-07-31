<?php

$T = intval(fgets(STDIN));

for($t=0; $t<$T; $t++){
	$n = intval(fgets(STDIN));
	printf("%d\n", max(1, $n>>1));
}

