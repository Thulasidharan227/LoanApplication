import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateLoanComponent } from './create-loan/create-loan.component';
import { ExitComponent } from './exit/exit.component';
import { LandingPageComponent } from './landing-page/landing-page.component';
import { LoanHistoryComponent } from './loan-history/loan-history.component';
import { NotfoundComponent } from './notfound/notfound.component';
import { ScheduleComponent } from './schedule/schedule.component';

const routes: Routes = [
  {
  path:"", redirectTo:"/home", pathMatch: 'full'
  },

  {
    path:'home', component:LandingPageComponent
  },
  {
    path:'create',component:CreateLoanComponent
    
  },
  {
    path:'history',component:LoanHistoryComponent
  },
  {
    path:'exit',component:ExitComponent
  },
  {
path:'schedule/:id',component:ScheduleComponent
  },
 
{
    path:'**',component:NotfoundComponent
}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
