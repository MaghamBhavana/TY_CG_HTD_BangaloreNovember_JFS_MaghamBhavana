import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-data-binding',
  templateUrl: './data-binding.component.html',
  styleUrls: ['./data-binding.component.css']
})
export class DataBindingComponent implements OnInit {
  twoWayData;
  flag = true;
  imgURL ="https://tse1.mm.bing.net/th?id=OIP._myrgkadY1QlQF1BQIWI3AHaE8&pid=Api&rs=1&c=1&qlt=95&w=136&h=91";
  constructor() { 
    // setInterval(() =>{
    //   this.flag = ! this.flag;
    // },1000)
  }

  clickMe(input) {
    console.log(input.value);
    //this.flag = ! this.flag;
  }

  printData() {
    console.log(this.twoWayData);
  }

  ngOnInit() {
  }

}
