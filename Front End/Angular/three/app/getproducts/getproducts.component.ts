import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-getproducts',
  templateUrl: './getproducts.component.html',
  styleUrls: ['./getproducts.component.css']
})
export class GetproductsComponent implements OnInit {

  message: string;
  products: Product[];
  constructor(private productService: ProductService, private router: Router) {
    this.getProducts();
  }

  getProducts() {
    this.productService.getData().subscribe(response => {
      console.log(response);
      this.products = response.product;
    }, err => {
      console.log(err);
    });
  }
  deleteProduct(product: Product) {
    this.productService.deleteData(product).subscribe(response => {
      console.log(response);
      if (response.statusCode === 201) {
        this.products.splice(this.products.indexOf(product), 1);
      }
    });
  }

  deleteMessage() {
    this.message = null;
  }

  selectProduct(product) {
    this.productService.selectedProductToUpdate = product;
    this.router.navigateByUrl('/edit-product');
  }

  ngOnInit() {
  }

}
