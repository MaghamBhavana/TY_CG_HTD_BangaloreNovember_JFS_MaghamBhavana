class Students{
    constructor(
        public  name: string,
        public age: number,
        public USN: string,
        public marks: number,
        public adhar ?: number
    ){}
}

let stud: Students={
    name: 'bhavana',
    age: 23,
    marks: 123,
    USN: '1234'
}
let student2 = new Students(
    'bhavana',23,'1234',66,undefined
);


let passedStudents  = [
    new Students('bhavaanaa',23,'erthg',70),
    new Students('ramya',34,'234',89)

];
console.log(passedStudents);