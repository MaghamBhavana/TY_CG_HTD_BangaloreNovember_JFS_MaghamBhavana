import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-movies',
  templateUrl: './movies.component.html',
  styleUrls: ['./movies.component.css']
})
export class MoviesComponent implements OnInit {

  constructor() { }

  selectedMovie;
  movies = [
    {
      name: 'Telugu',
      imageURL: 'https://cdn.pixabay.com/photo/2015/09/02/12/45/movie-918655__340.jpg',
      details: 'Find the all new BMW cars prices in India with all the latest offers & discounts on new and used BMW car models. '
    }, {
      name: 'Hindi',
      imageURL: 'https://cdn.pixabay.com/photo/2017/11/24/10/43/admission-2974645__340.jpg',
      details: '7 Series Specs, Features and Price. The BMW 7 Series has 1 Diesel Engine and 2 Petrol Engine on offer.'
    }, {
      name: 'English',
      imageURL: 'https://cdn.pixabay.com/photo/2013/09/29/12/21/camera-188083__340.jpg',
      details: 'Forget what you think you know about BMW being the "Ultimate Driving Machine" brand—those days are fading fast.'
    }, {
      name: 'Kanada',
      imageURL: 'https://cdn.pixabay.com/photo/2016/11/16/11/29/coupon-1828620__340.png',
      details: '3 Series Specs, Features and Price. The BMW 3 Series has 1 Diesel Engine and 1 Petrol Engine on offer'
    }
  ];

  ngOnInit() {
  }

  selectMovie(movie) {
    this.selectedMovie = movie;
  }

}
