import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {RouterModule} from '@angular/router';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule} from '@angular/forms';
 

import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { HeaderComponent } from './header/header.component';
import { AddproductComponent } from './addproduct/addproduct.component';
import { DatafromjsonComponent } from './datafromjson/datafromjson.component';
import { GetproductsComponent } from './getproducts/getproducts.component';
import { EditComponent } from './edit/edit.component';
import { UserComponent } from './user/user.component';
import { AuthGuard } from './auth.guard';
import { FilterProductsPipe } from './filter-products.pipe';



@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    HeaderComponent,
    AddproductComponent,
    DatafromjsonComponent,
    GetproductsComponent,
    EditComponent,
    UserComponent,
    FilterProductsPipe
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot([
      {path: '', component: HomeComponent},
      {path: 'add-product', component: AddproductComponent, canActivate: [AuthGuard], data: {name: 'bhavana'}},
      {path: 'data-from-JSON', component: DatafromjsonComponent},
      {path: 'getAllProducts', component: GetproductsComponent},
      {path: 'edit-product', component: EditComponent},
      {path: 'user/:id', component: UserComponent}
    ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
