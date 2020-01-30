import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-mobiles',
  templateUrl: './mobiles.component.html',
  styleUrls: ['./mobiles.component.css']
})
export class MobilesComponent implements OnInit {

  selectedMobile;
  mobiles = [
    {
      name: 'samsung',
      imageURL: 'https://cdn.pixabay.com/photo/2017/01/06/13/50/smartphone-1957740__340.jpg',
      details: 'Find the all new BMW cars prices in India with all the latest offers & discounts on new and used BMW car models. '
    }, {
      name: 'Iphone',
      imageURL: 'https://cdn.pixabay.com/photo/2014/08/05/10/27/iphone-410311__340.jpg',
      details: '7 Series Specs, Features and Price. The BMW 7 Series has 1 Diesel Engine and 2 Petrol Engine on offer.'
    }, {
      name: 'Nokia',
      imageURL: 'https://cdn.pixabay.com/photo/2016/12/19/08/39/mobile-phone-1917737__340.jpg',
      details: 'Forget what you think you know about BMW being the "Ultimate Driving Machine" brand—those days are fading fast.'
    }, {
      name: 'Note 4',
      imageURL: 'https://cdn.pixabay.com/photo/2017/10/12/22/17/business-2846221__340.jpg',
      details: '3 Series Specs, Features and Price. The BMW 3 Series has 1 Diesel Engine and 1 Petrol Engine on offer'
    }
  ];
  constructor() { }

  ngOnInit() {
  }

  selectMobile(mobile) {
    this.selectedMobile = mobile;
  }

}
