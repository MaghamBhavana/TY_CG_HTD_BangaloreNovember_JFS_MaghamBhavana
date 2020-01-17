import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators, FormArray } from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  registerForm: FormGroup;
  constructor() { }

  ngOnInit() {
    this.registerForm = new FormGroup({
      name: new FormControl(null, [
        Validators.required,
        Validators.minLength(5)
      ]),
      email: new FormControl(null,
        [Validators.required,
        Validators.minLength(5),
        Validators.email
      ]),
      password: new FormControl(null,
        [
          Validators.required,
          Validators.maxLength(8),
          Validators.minLength(8)
        ]),
        age: new FormControl(null,
          [
            Validators.maxLength(3),
            Validators.required
          ]),
          skills: new FormArray([
           this.getSkill()

          ])
    });
  }

  // to have new FormControl Object (skill)
  getSkill() {
    return new FormControl(null,[
      Validators.required,
      Validators.minLength(3)
    ]);
  }
  // to access name field (FormControl)
  get name() {
    return this.registerForm.get('name');
  }
  // to access email field (FormControl)
  get email() {
    return this.registerForm.get('email');
  }
  // to access password field (FormControl)
  get password() {
    return this.registerForm.get('password');
  }
  // to access age field (FormControl)
  get age() {
    return this.registerForm.get('age');
  }
  // to access skills of (FormArray)
  get skills(): FormArray {
      return this.registerForm.get('skills') as FormArray;
  }
  submitForm() {
    console.log(this.registerForm.value);
    this.registerForm.reset();
  }
// to push FormControl (skill) to FormArray(skills)
  addSkill() {
    this.skills.push(this.getSkill());
  }

// delete each skill
  deleteSkill(i: number) {
    this.skills.removeAt(i);
  }
}
