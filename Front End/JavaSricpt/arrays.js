var technologies = ["java","js","html","spring","angular",12,true];
console.log(technologies[2]);

for(let techonogy of technologies) {
    console.log(techonogy);
}

for(let index in technologies) {
    console.log(index);
}

technologies.forEach((value,index)=> {
    console.log(index);
    console.log(value);
});

console.log('index of ::'+technologies.indexOf(12));

console.log('Before pop::: '+technologies);
technologies.pop();
console.log('after pop::: '+technologies);

console.log('before push:: '+technologies);
technologies.push('jdbc','springboot');
console.log('after pop:: '+technologies);

console.log('before shift:: '+technologies);
technologies.shift();
console.log('after shift::'+technologies);

console.log('before unshift:: '+technologies);
technologies.unshift(12345);
console.log('after unshift::'+technologies);

technologies.splice(2,0,'git','hibernate');
console.log('splice method= '+technologies);

technologies.splice(technologies.indexOf(12345),2);

console.log('Array lenght= '+technologies.length);
technologies.reverse();
console.log('reverse:: '+technologies);

let marks=[12,89,34,22,33,11,23,67,84];
console.log(marks);

let filteredMarks = marks.filter((value,index,array) => {
    return value > 40;
});

console.log(filteredMarks.length);

let marks1 = [20,20,20,30,40,40,50,60,60,70];
console.log(marks1);

let filterMarks = marks1.filter((value,index,array) => {
        return array.indexOf(value) === index;
});

console.log(filterMarks);

let myArray = marks.map((value,index,array) => {

    return {ind:index,val:value};
});

console.log(myArray);

let arr = [30,13,67,44,63,56,22,81,20,21];

let ascending = arr.sort((x,y) => {
    return x-y;
});
console.log(ascending);

let decending = arr.sort((x,y) => {
    return y-x;
});
console.log(decending);