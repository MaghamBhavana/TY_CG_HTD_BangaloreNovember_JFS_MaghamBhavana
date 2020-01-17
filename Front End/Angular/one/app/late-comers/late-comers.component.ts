import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-late-comers',
  templateUrl: './late-comers.component.html',
  styleUrls: ['./late-comers.component.css']
})
export class LateComersComponent implements OnInit {

  constructor() { }
  falg = true;
  message: string;

  person: 'balaram';

  lateComers: string[] = [
    'pavan',
    'Siva',
    'anish',
    'ram'
  ];
  ngOnInit() {
  }

  deleteLateComer(name: string) {
    this.lateComers.splice(this.lateComers.indexOf(name), 1);
    this.message = `${name} is deleted`;
    setTimeout(() => {
      this.message = null;
    }, 2000);
  }
}
