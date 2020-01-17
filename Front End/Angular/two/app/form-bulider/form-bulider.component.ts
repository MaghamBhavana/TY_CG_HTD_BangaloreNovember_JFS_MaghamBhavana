import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators, FormArray, FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-form-bulider',
  templateUrl: './form-bulider.component.html',
  styleUrls: ['./form-bulider.component.css']
})
export class FormBuliderComponent implements OnInit {

  registerForm: FormGroup;
  constructor(private fb: FormBuilder) { }

  ngOnInit() {
    this.registerForm = this.fb.group({
      name: this.fb.control(null, [
        Validators.required,
        Validators.minLength(5)
      ]),
      email: this.fb.control(null,
        [Validators.required,
        Validators.minLength(5),
        Validators.email
      ]),
      password: this.fb.control(null,
        [
          Validators.required,
          Validators.maxLength(8),
          Validators.minLength(8)
        ]),
        age: this.fb.control(null,
          [
            Validators.minLength(1),
            Validators.maxLength(3),
            Validators.required
          ]),
          skills: this.fb.array([
           this.getSkill()

          ])
    });
  }
  // to have new FormControl Object (skill)
  getSkill() {
    return this.fb.control(null,[
      Validators.required,
      Validators.minLength(3)
    ]);
  }
  // to access name field (FormControl)
  get name(): FormControl {
    return this.registerForm.get('name') as FormControl;
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
