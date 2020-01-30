import { BrowserModule } from '@angular/platform-browser';
import { NgModule, Component } from '@angular/core';
import {RouterModule} from '@angular/router';

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { CarsComponent } from './cars/cars.component';
import { BikesComponent } from './bikes/bikes.component';
import { MoviesComponent } from './movies/movies.component';
import { MobilesComponent } from './mobiles/mobiles.component';
import { CarchildComponent } from './carchild/carchild.component';
import { BikechildComponent } from './bikechild/bikechild.component';
import { MobilechildComponent } from './mobilechild/mobilechild.component';
import { MoviechildComponent } from './moviechild/moviechild.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomeComponent,
    CarsComponent,
    BikesComponent,
    MoviesComponent,
    MobilesComponent,
    CarchildComponent,
    BikechildComponent,
    MobilechildComponent,
    MoviechildComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot([
     
      {path: '', component: HomeComponent},
      {path: 'cars', component: CarsComponent},
      {path: 'bikes', component: BikesComponent},
      {path: 'movies', component: MoviesComponent},
      {path: 'mobiles', component: MobilesComponent}
    ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
