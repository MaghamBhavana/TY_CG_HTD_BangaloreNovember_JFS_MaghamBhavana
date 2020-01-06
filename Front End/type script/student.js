var Students = /** @class */ (function () {
    function Students(name, age, USN, marks, adhar) {
        this.name = name;
        this.age = age;
        this.USN = USN;
        this.marks = marks;
        this.adhar = adhar;
    }
    return Students;
}());
var stud = {
    name: 'bhavana',
    age: 23,
    marks: 123,
    USN: '1234'
};
var student2 = new Students('bhavana', 23, '1234', 66, undefined);
var passedStudents = [
    new Students('bhavaanaa', 23, 'erthg', 70),
    new Students('ramya', 34, '234', 89)
];
console.log(passedStudents);
