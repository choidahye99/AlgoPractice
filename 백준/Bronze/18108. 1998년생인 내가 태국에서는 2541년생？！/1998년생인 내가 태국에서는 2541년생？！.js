var fs = require('fs');
var inputData = fs.readFileSync('/dev/stdin').toString().trim();

console.log(inputData-543);