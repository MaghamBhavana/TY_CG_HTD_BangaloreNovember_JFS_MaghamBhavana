interface Trainee {
    name: string,
    age: number,
    printData(): void;
}

class Training implements Trainee {
    name = 'abc';
    age= 34;
    printData() {
        console.log('hiii');
    }
}
let tr = new Training();
tr.printData();

let trainee1: Training = {
    name:'bhav',
    age:45,
    printData: function() {
        console.log(this.name,this.age);
    }
}