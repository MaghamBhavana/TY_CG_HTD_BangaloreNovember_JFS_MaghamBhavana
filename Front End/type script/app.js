console.log('TypeScript code started');
var a = 100; //implicitly considered as let a:number 
a = null;
//a="string"; error cannot reassign type number to string
var b; //impliciltly considered as any type
b = 100;
b = "string";
console.log(b);
var marks = [1, 2, 33, 44]; //it will store only the array of numbers
var student;
student = {
    name: 'ramya',
    age: 22,
    pass: true
};
var Sample = /** @class */ (function () {
    function Sample() {
        this.a = 100;
        this.b = 'abc';
    }
    return Sample;
}());
// console.log(sample1.a);
// console.log(sample1.b);
var Student = /** @class */ (function () {
    function Student(name, age, USN, marks) {
        this.name = name;
        this.age = age;
        this.USN = USN;
        this.marks = marks;
    }
    Student.prototype.printDetails = function () {
        console.log("\n        Name is " + this.name + ",\n        age is " + this.age + ",\n        USN is " + this.USN + "\n        ");
    };
    return Student;
}());
var student1 = new Student('bhavana', 23, 'bhavs123', 123);
console.log('student name= ', student1.name);
console.log('student marks= ', student1.marks);
student1.printDetails();
console.log('TypeScript code ended');
