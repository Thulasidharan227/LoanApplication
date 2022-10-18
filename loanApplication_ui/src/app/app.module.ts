// import { NgModule } from '@angular/core';
// import { BrowserModule } from '@angular/platform-browser';
// import { NgxPaginationModule } from 'ngx-pagination';
// import { AppRoutingModule } from './app-routing.module';
// import { AppComponent } from './app.component';
// import {HttpClientModule}  from '@angular/common/http';
// import { CreateLoanComponent } from './create-loan/create-loan.component';
// import { DisplayLoanComponent } from './display-loan/display-loan.component'
// @NgModule({
//   declarations: [
//     AppComponent,
//     CreateLoanComponent,
//     DisplayLoanComponent
//   ],
//   imports: [
//     BrowserModule,
//     AppRoutingModule,
//     HttpClientModule,
//     NgxPaginationModule
//   ],
//   providers: [],
//   bootstrap: [AppComponent]
// })
// export class AppModule { }
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {FormsModule , ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { NgxPaginationModule } from 'ngx-pagination';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateLoanComponent } from './create-loan/create-loan.component';
import { LoanHistoryComponent } from './loan-history/loan-history.component';
import { ScheduleComponent } from './schedule/schedule.component';
import { LandingPageComponent } from './landing-page/landing-page.component';
import { NotfoundComponent } from './notfound/notfound.component';
import { ExitComponent } from './exit/exit.component';
//import { DisplayLoanComponent } from './display-loan/display-loan.component';


@NgModule({
  declarations: [
    AppComponent,
    CreateLoanComponent,
    LoanHistoryComponent,
    ScheduleComponent,
    LandingPageComponent,
    NotfoundComponent,
    ExitComponent,
  //  DisplayLoanComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    NgxPaginationModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
