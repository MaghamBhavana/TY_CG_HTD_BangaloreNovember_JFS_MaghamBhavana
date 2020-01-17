import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../authentication.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  message: string;

  constructor(private auth: AuthenticationService) { }

  ngOnInit() {
  }

  register(form: NgForm) {
    this.auth.registerUser(form.value).subscribe(data => {
      console.log(data);
      if (data.statusCode === 201) {
        this.message = data.message;
        form.reset();
        setTimeout(() => {
          this.message = null;
        }, 5000);
      } else {
        console.log('fail to register');
      }

    });
  }

}
