/**
 * @param {Array} arr
 * @param {number} size
 * @return {Array}
 */
var chunk = function(arr, size) {
    const output = [];
    let temp = [];
    arr.forEach(num => {
        temp.push(num);
        if(temp.length === size){
            output.push(temp);
            temp = [];
        }
    });
    if(temp.length > 0)
    output.push(temp);
    return output;
};
