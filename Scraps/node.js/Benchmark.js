const mergeModule = require('./MergeSort');

main();

function main() {
    const total = 201;
    var array = [];
    for (let i = total - 1; i >= 0; i--) {
        array[total - i - 1] = i;
    }

    console.log('Unsorted List - ' + array.toString());
    console.log('-----------------------------------');
    array = mergeModule.mergeSort(array);
    console.log('-----------------------------------');
    console.log('Sorted List - ' + array.toString());

}