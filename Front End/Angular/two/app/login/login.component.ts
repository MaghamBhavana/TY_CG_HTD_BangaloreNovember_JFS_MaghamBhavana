import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  todaysDate = Date.now();
  constructor() { }

  ngOnInit() {
    
  }

  submitForm(form: NgForm) {
    console.log(form.value);
    form.reset();
  }

}
