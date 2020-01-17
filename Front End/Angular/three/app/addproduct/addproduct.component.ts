import { Component, OnInit } from '@angular/core';
import {NgForm} from '@angular/forms';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-addproduct',
  templateUrl: './addproduct.component.html',
  styleUrls: ['./addproduct.component.css']
})
export class AddproductComponent implements OnInit {
message: string;
  constructor(private productService: ProductService) { }

  ngOnInit() {
  }

  addProduct(form: NgForm) {
    this.productService.postData(form.value).subscribe(data => {
        console.log(data);
        this.message = data.message;
        setTimeout(() => {
          this.message = null;
        }, 2000);
        form.reset();
      }, err => {
        console.log(err);
      });

  }
}
