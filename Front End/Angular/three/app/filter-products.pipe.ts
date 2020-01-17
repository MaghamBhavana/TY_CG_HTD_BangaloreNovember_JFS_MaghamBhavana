import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'filterProducts'
})
export class FilterProductsPipe implements PipeTransform {

  transform(products: Product[], search: string): Product[] {
    if(search === undefined) {
      return products;
    } else {
      return products.filter((product, index) => {
        return product.name.toLowerCase().includes(search.toLowerCase());
      });
    }
  }

}
