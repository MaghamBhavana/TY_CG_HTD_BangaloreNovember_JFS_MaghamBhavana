import { Component, OnInit, DoCheck } from '@angular/core';

@Component({
  selector: 'app-parent',
  templateUrl: './parent.component.html',
  styleUrls: ['./parent.component.css']
})
export class ParentComponent implements OnInit, DoCheck , AfterContentInit {

  dataFromChild;
  student = {
    name: 'Bhavana',
    age: 23,
    marks: 70
  };

  getChildData(data) {
    this.dataFromChild = data;
  }
  constructor() { 
    console.log('constructor calling');
  }

  ngOnInit() {
    console.log('Init is calling')
  }

  ngDoCheck() {
    console.log('Docheck is calling');
  }

  ngAfterContentInit() {
    console.log('AfterContentInit is calling');
  }

}
