var fs = require('fs');
var inputData = fs.readFileSync(0, 'utf8').toString().split(' ');
var a = parseInt(inputData[0]);
var b = parseInt(inputData[1]);
console.log(a/b);