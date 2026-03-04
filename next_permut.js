var nextPermutation = function(nums) {
  let i = nums.length - 1;
  let pi = -1;

  while (i > 0) {
    if (nums[i - 1] < nums[i]) {
      pi = i - 1;
      break;
    }
    i--;
  }
 
if(pi==-1){
  return nums.reverse()
}

let j =nums.length-1
while(nums[j]<=nums[pi]){
  j--
}

let temp = nums[j]
nums[j]=nums[pi]
nums[pi]=temp

let a = pi+1
let b =nums.length-1

while(a<b){
  let temp = nums[a]
  nums[a]=nums[b]
  nums[b]=temp
  a++
  b--
}
return nums
};