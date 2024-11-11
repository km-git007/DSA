/**
 * @param {number[]} nums
 * @param {Function} fn
 * @param {number} init
 * @return {number}
 */
var reduce = function(nums, fn, init) {
    let accumulator = init; // Start with the initial value
    for (let i = 0; i < nums.length; i++) {
        accumulator = fn(accumulator, nums[i]); // Apply fn to the accumulator and current element
    }
    return accumulator; // Return the final accumulated result
};