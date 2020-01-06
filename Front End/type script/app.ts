console.log('TypeScript code started');

let a = 100;//implicitly considered as let a:number 
a=null;
//a="string"; error cannot reassign type number to string

let b;//impliciltly considered as any type
b=100;
b="string";
console.log(b);

let marks: number[] = [1,2,33,44];//it will store only the array of numbers

let student:{name: string,age: number,pass: boolean};

student={
    name:'ramya',
    age:22,
    pass:true
}

class Sample {
    a=100;
    b='abc';
}
// console.log(sample1.a);
// console.log(sample1.b);

class Student {
    constructor(
       public  name: string,
        public age: number,
        public USN: string,
        public marks: number,
    ){}

    printDetails(): void {
        console.log(`
        Name is ${this.name},
        age is ${this.age},
        USN is ${this.USN}
        `
        );
    }
}

let student1 = new Student('bhavana',23,'bhavs123',123);
console.log('student name= ',student1.name);
console.log('student marks= ',student1.marks);
student1.printDetails(); 
console.log('TypeScript code ended');
 

