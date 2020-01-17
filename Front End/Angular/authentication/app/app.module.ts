import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {RouterModule} from '@angular/router';
import {FormsModule} from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { AboutComponent } from './about/about.component';
import { AdminComponent } from './admin/admin.component';
import { UserComponent } from './user/user.component';
import { PagenotfoundComponent } from './pagenotfound/pagenotfound.component';
import { AuthGuard } from './register/auth.guard';
import { AppRoutingModule } from './app-routing.module';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomeComponent,
    LoginComponent,
    RegisterComponent,
    AboutComponent,
    AdminComponent,
    UserComponent,
    PagenotfoundComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule
    // RouterModule.forRoot([
    //   {path: '', component: HomeComponent},
    //   {path: 'login', component: LoginComponent},
    //   {path: 'register', component: RegisterComponent},
    //   {path: 'about', component:AboutComponent},
    //   {path: 'admin', component: AdminComponent,
    //   canActivate: [AuthGuard], data: {
    //     expectedRoles: ['admin']
    //   }
    // },
    //   {path: 'user', component: UserComponent,
    // canActivate: [AuthGuard], data: {
    //   expectedRoles: ['admin', 'user']
    // }
    // },
    //   {path: '**', component: PagenotfoundComponent}
    // ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
