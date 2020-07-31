var fs = require('fs');
var buf = '';

process.stdin.on('readable', function() {
    var chunk = process.stdin.read();
    if (chunk) buf += chunk.toString();
});

process.stdin.on('end', function() {
    let data = buf.split('\n');
    let cas = parseInt(data[0]);
    for (var i = 1; i <= cas; ++i) {
        let num = parseInt(data[i]);
        console.log(num == 1 ? 1 : num / 2 | 0);
    }
});
