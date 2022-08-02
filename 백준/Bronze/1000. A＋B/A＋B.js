const fs = require('fs');
const inputData = fs.readFileSync(0, 'utf8').toString().split(' ');
const a = parseInt(inputData[0]);
const b = parseInt(inputData[1]);
console.log(a+b);