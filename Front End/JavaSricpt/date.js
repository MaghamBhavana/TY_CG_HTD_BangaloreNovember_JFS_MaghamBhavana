var date = new Date();
console.log('date',date.getDate());
console.log('month',date.getMonth()+1);
console.log('year',date.getFullYear());
console.log('hrs',date.getHours());
console.log('mins',date.getMinutes());
console.log('millisec',date.getMilliseconds());

setInterval(() => {
    let date = new Date();
    document.getElementById('todaysDate').innerHTML = <h1>
   `Date ::: ${date.getDate()}-${date.getMonth()+1}-${date.getFullYear()}
   Time ::: ${date.getHours()}-${date.getMinutes()}-${date.getMilliseconds()}` 
   </h1>
},);