import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-cars',
  templateUrl: './cars.component.html',
  styleUrls: ['./cars.component.css']
})
export class CarsComponent implements OnInit {

  selectedCar;
  cars = [
    {
      name: 'BMW',
      imageURL: 'https://cdn.pixabay.com/photo/2015/05/28/23/12/auto-788747__340.jpg',
      details: 'Find the all new BMW cars prices in India with all the latest offers & discounts on new and used BMW car models. '
    }, {
      name: 'benz',
      imageURL: 'https://cdn.pixabay.com/photo/2019/07/07/14/03/fiat-4322521__340.jpg',
      details: '7 Series Specs, Features and Price. The BMW 7 Series has 1 Diesel Engine and 2 Petrol Engine on offer.'
    }, {
      name: 'audi',
      imageURL: 'https://cdn.pixabay.com/photo/2016/04/01/12/16/car-1300629__340.png',
      details: 'Forget what you think you know about BMW being the "Ultimate Driving Machine" brand—those days are fading fast.'
    }, {
      name: 'maruthi',
      imageURL: 'https://cdn.pixabay.com/photo/2015/01/19/13/51/car-604019__340.jpg',
      details: '3 Series Specs, Features and Price. The BMW 3 Series has 1 Diesel Engine and 1 Petrol Engine on offer'
    }
  ];
  constructor() { }

  ngOnInit() {
  }
  selectCar(car) {
    this.selectedCar = car;
  }

}
