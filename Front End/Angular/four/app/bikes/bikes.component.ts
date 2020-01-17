import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-bikes',
  templateUrl: './bikes.component.html',
  styleUrls: ['./bikes.component.css']
})
export class BikesComponent implements OnInit {

  constructor() { }

  selectedBike;
  bikes = [
    {
      name: 'royal',
      imageURL: 'https://cdn.pixabay.com/photo/2016/04/07/06/53/bmw-1313343__340.jpg',
      details: 'Find the all new BMW cars prices in India with all the latest offers & discounts on new and used BMW car models. '
    }, {
      name: 'honda',
      imageURL: 'https://cdn.pixabay.com/photo/2014/07/04/19/15/biker-384178__340.jpg',
      details: '7 Series Specs, Features and Price. The BMW 7 Series has 1 Diesel Engine and 2 Petrol Engine on offer.'
    }, {
      name: 'bmw',
      imageURL: 'https://cdn.pixabay.com/photo/2016/09/23/21/08/motorcycle-1690452__340.jpg',
      details: 'Forget what you think you know about BMW being the "Ultimate Driving Machine" brand—those days are fading fast.'
    }, {
      name: 'TVS',
      imageURL: 'https://cdn.pixabay.com/photo/2014/07/05/16/44/biker-384921__340.jpg',
      details: '3 Series Specs, Features and Price. The BMW 3 Series has 1 Diesel Engine and 1 Petrol Engine on offer'
    }
  ];

  ngOnInit() {
  }
  selectBike(bike) {
    this.selectedBike = bike;
  }
}
