import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(public data: DataService) {
    console.log(data.x);
    console.log(data.products);
    console.log(this.data.getProducts());
   }

  ngOnInit() {
  }

}
