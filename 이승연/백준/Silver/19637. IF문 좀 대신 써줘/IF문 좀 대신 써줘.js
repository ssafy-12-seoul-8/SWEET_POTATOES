const input = require("fs").readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
.toString()
.trim()
.split("\n")
.map((item) => item.split(" "));

let N = 0;
let M = 0;

N = Number(input[0][0]);
M = Number(input[0][1]);

let names = [];
let nums = [];

for (let i = 1; i <= N; i++) {
  let name = String(input[i][0]);
  let num = Number(input[i][1]);

  names.push(name);
  nums.push(num);
}

let result = [];

for (let i = N + 1; i <= N + M; i++) {
  let num = Number(input[i][0]);
  
  let left = 0;
  let right = N - 1;

  while(left <= right) {
    let mid = Math.floor((left + right) / 2);

    if (left == right) {
      break;
    }

    if (num <= nums[mid]) {
      right = mid;
    } else {
      left = mid + 1;
    }
  }

  result.push(names[left]);
}

console.log(result.join("\n"));
