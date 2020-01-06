// let msg = 'good mrng folks';

// console.log(msg.charCodeAt(3));
// console.log(msg.charAt(2));
// console.log(msg.split(' '));
// console.log(msg.split('').reverse().join(''));
// console.log(msg.includes('good'));
// console.log(msg.includes('morning'));
// console.log(msg.toUpperCase());
// console.log(msg.toLowerCase());
// console.log(msg.substr(0,10));
// console.log(msg.length);


// function add (...nums) {
//     let sum = 0;
//     for(let num of nums) {
//         sum = sum + num;
//     }
//     console.log('sum of the numbers is ',sum);
// }

// add(22,99,33,44,66);

let student = {
    id: 1234,
    name: 'bhavana',
    age: 23,
    degree: 'btech'
};

let {id,name,degree,...theRest } = student;

console.log(name);
console.log(id);
console.log(theRest);
console.log(degree);

let m1 = [20,12,45,60];

let[maths,science,socialScience,...rest] = m1;

console.log('maths marks', maths);
console.log('science',science);
console.log('socialScience',socialScience);
console.log('rest of the marks',rest);

