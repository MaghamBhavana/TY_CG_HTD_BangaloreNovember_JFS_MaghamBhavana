import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http: HttpClient) { }

  selectedProductToUpdate: Product;

  api = `http://localhost:8080`;


  postData(product): Observable<any> {
    return this.http.post<any>(`${this.api}/add-product`, product);
  }

  getData(): Observable<any> {
    return this.http.get<any>(`${this.api}/view-allproducts`);
  }

  deleteData(product: Product): Observable<any> {
    return this.http.delete<any>(`${this.api}/delete-product/${product.id}`);
  }

  updateData(product): Observable<any> {
    return this.http.put<any>(
      `${this.api}/modify-product`, product
    );
  }

}
