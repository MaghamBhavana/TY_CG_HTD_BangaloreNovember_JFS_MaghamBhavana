var person={
    adharNo:123456787
}
var personPan= {
    pan:4567887
}

var student = {
    ...person,
    ...personPan,
    id:1234,
    name:"bhavana",
    degree:"B-tech pass",
    phone:74185278457,
    address:{
        city:'bang',
        state:'kar'
    }
}
console.log(student.name);
console.log(student['degree']);
console.log(student);
console.log(student.adharNo);
console.log(student)
console.log(student.address.city);

for(let key in student) {
    console.log(key+':::'+student[key]);
}

