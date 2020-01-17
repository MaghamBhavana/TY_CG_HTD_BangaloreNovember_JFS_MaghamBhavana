import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../authentication.service';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  message: string;
  error: any;
  constructor(private auth: AuthenticationService,
              private router: Router
    ) { }

  login(form: NgForm) {
    this.auth.loginUser(form.value).subscribe(data => {

      if (data.statusCode() === 201) {
        console.log(data);
        localStorage.setItem('userDetails', JSON.stringify(data));
        console.log('user details stored in local storage');
        this.router.navigateByUrl('/');
      } else {
        this.error = data.message;
      }
      form.reset();
    });
  }

  ngOnInit() {
  }

}
