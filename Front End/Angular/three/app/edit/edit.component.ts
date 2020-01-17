import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';
import { Router } from '@angular/router';
import { NgForm, FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {

  constructor(public productService: ProductService,
              private router: Router) { }

  updateProduct(form: NgForm) {
    this.productService.updateData(form.value).subscribe(response => {
      console.log(response);
      if (response.statusCode === 201) {
        this.router.navigateByUrl('/getAllProducts');
      }
      form.reset();
    });
  }

  ngOnInit() {
  }

}
