// //console.log('Welcome')

// //variable declaration
// var a;

// //variable intialization
// a=100;

// console.log('value of a is '+a);

// console.log(typeof a);

// var name = "bhavana";
// console.log(name);
// console.log(typeof name);


// var age = 23;

// //using template literals with embedded expressions
// var details = `The name is ${name} and age is ${age}`;
// console.log(details);

// console.log(`The sum of 10 and 11 is ${10+11}`);

// var sampleText = `bhavananajnajhahauhygggfgghhufdxfguytfd
// cghytytdsffghytrdsxcvhytresdxcghuytfgkiuygfyutrewazxfresdxghytrdfgt
// fytydrtgcghjhgjkuyghtrszxcghjkllkiuyftrewasdzxfghjkiuytrdfghjuytfghygf`;
// console.log(sampleText);

// var iscompassCleared = true;

// console.log(typeof iscompassCleared);

// var empty = null;
// console.log(typeof empty);

// if(null == undefined) {
//     console.log('true block')
// } else {
//     console.log('false block');
// }

// //o/p Methods...

// //alert Method
// alert('Are you fine?');

// //confirm method
// var userConfirm =confirm('are you sure you want to procced');
// console.log(userConfirm);
// if(userConfirm) {
//     console.log('Ok');
// } else {
//     console.log('cancel')
// }

// //prompt method
// var userInput =prompt('please enter ur name');
// console.log(userInput);

// //document method
// document.write('welcome');

// var a=100;//goble variable

// //Naming function
// function demo() {
//     var b=200;//local variable
//     console.log(a);
//     console.log('function calling');
// }
// demo();
// //console.log(b);As local we cant call outside the function

// function add(a, b) {
//     return a+b;
// }
// console.log(add(1,2));


// //Anonymous funtions
// var test = function() {
//     console.log('anonymous function assigned to variable test');
// }
// test();

// //IIFE

// (function demo1(a,b) {
//     var name ='bhavaan';
//     console.log(a+b);
//     console.log('inside funtion',name);
//     console.log('IIFE running');
// })(2,3);

// console.log('outside funtion',myname);

function fun(x) {
    console.log('sample start');
    x();
    console.log('sample end');
}
fun(function() {
    console.log('callback')
});