import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {RouterModule} from '@angular/router';

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { SectionComponent } from './section/section.component';
import { FooterComponent } from './footer/footer.component';
import { HomeComponent } from './home/home.component';
import { AboutComponent } from './about/about.component';
import { ContactusComponent } from './contactus/contactus.component';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { BhavanaComponent } from './bhavana/bhavana.component';
import { RamyaComponent } from './ramya/ramya.component';
import { BalaramComponent } from './balaram/balaram.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    SectionComponent,
    FooterComponent,
    HomeComponent,
    AboutComponent,
    ContactusComponent,
    RegisterComponent,
    LoginComponent,
    PageNotFoundComponent,
    BhavanaComponent,
    RamyaComponent,
    BalaramComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot([
      {path: '', component: HomeComponent},
      {path: 'about', component: AboutComponent , children: [
        {path: 'bhavana', component: BhavanaComponent},
        {path: 'ramya', component: RamyaComponent},
        {path: 'balaram', component: BalaramComponent}
      ]},
      {path: 'contact-us', component: ContactusComponent},
      {path: 'register', component: RegisterComponent},
      {path: 'login', component: LoginComponent},
      {path: '**', component: PageNotFoundComponent}
    ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
