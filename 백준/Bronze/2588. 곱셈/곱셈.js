const fs = require('fs');
const [A, B] = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
const [B0, B1, B2] = B.split('');

const temps1 = A * B2;
const temps2 = A * B1;
const temps3 = A * B0;
const sum = temps1 + Number(`${temps2}0`) + Number(`${temps3}00`);

console.log(`${temps1}\n${temps2}\n${temps3}\n${sum}`);