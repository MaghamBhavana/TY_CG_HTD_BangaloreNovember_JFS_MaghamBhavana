import { BrowserModule } from '@angular/platform-browser';
import { NgModule, Component } from '@angular/core';
import {FormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';

import { AppComponent } from './app.component';
import { DataBindingComponent } from './data-binding/data-binding.component';
import { LateComersComponent } from './late-comers/late-comers.component';
import { ProductsComponent } from './products/products.component';
import { HeaderComponent } from './header/header.component';
import { ImagesComponent } from './images/images.component';
import { ColorDirective } from './color.directive';
import { ParentComponent } from './parent/parent.component';
import { ChildComponent } from './child/child.component';



@NgModule({
  declarations: [
    AppComponent,
    DataBindingComponent,
    LateComersComponent,
    ProductsComponent,
    HeaderComponent,
    ImagesComponent,
    ColorDirective,
    ParentComponent,
    ChildComponent,


  ],
  imports: [
    BrowserModule,
    FormsModule,
    RouterModule.forRoot(
      [
        {path: '', component: HeaderComponent},
        {path: 'late-comers', component: LateComersComponent},
        {path: 'products' , component: ProductsComponent},
        {path: 'Images', component: ImagesComponent},
        {path: 'parent-child', component: ParentComponent}
      ]
    )
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
