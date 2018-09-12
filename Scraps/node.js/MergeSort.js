module.exports = {
    mergeSort: function (array) {
        return sort(array);
    }
}

//  main();

function main() {
    const total = 201;
    var array = [];
    for (let i = total - 1; i >= 0; i--) {
        array[total - i - 1] = i;
    }

    console.log('Unsorted List - ' + array.toString());
    console.log('-----------------------------------');
    array = sort(array);
    console.log('-----------------------------------');
    console.log('Sorted List - ' + array.toString());

}

function sort(array) {
    const counter = { count: 0 };
    var newArrays = [];

    for (let i = 0; i < array.length; i++) {
        var tempArray = [array[i]];
        newArrays.push(tempArray);
    }

    while (newArrays.length > 1) {
        console.log(newArrays.length);
        let length = newArrays.length;
        for (let i = 0; i < ((length) / 2); i++) {
            counter.count++;
            newArrays[i] = merge(newArrays[i], newArrays.pop(), counter);
        }
    }
    console.log('loops ran ' + counter.count + ' times');
    return newArrays;
}

function merge(arr1 = [], arr2 = [], counter) {
    let array = [];
    if (arr1[arr1.length - 1] < arr2[0]) {
        array = append(arr1, arr2);

    } else if (arr2[arr2.length - 1] < arr1[0]) {
        array = append(arr2, arr1);
    } else {
        array = interleave(arr1, arr2, counter);
    }
    return array;
}

function interleave(arr1, arr2, counter) {
    let array = [];
    let i = 0;
    let j = 0;
    let k = 0;
    while (i < arr1.length && j < arr2.length) {
        counter.count++;
        if (arr1[i] < arr2[j]) {
            array[k] = arr1[i];
            i++;
        } else {
            array[k] = arr2[j];
            j++;
        }
        k++;
    }
    while (i < arr1.length) {
        counter.count++;
        array.push(arr1[i]);
        i++
    }
    while (j < arr2.length) {
        counter.count++;
        array.push(arr2[j]);
        j++
    }
    return array;
}

function append(arr1, arr2, counter) {
    arr2.forEach(element => {
        arr1.push(element);
    });
    return arr1;
}