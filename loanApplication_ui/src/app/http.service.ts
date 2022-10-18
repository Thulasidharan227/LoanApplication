import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Loan } from '../app/loan-history/loan-history.component';
import { ScheduleComponent } from '../app/schedule/schedule.component';

@Injectable({
  providedIn: 'root'
})
export class HttpService {

  constructor(public http:HttpClient) { }

  createLoan(value:any){
    return this.http.post("http://localhost:8080/createLoan",value,{responseType: 'text'});
  }

  loanHistory(){
    return this.http.get<Loan[]>("http://localhost:8080/loan");
  }

   scheduleHistory(id:number){
     return this.http.get<any>(`http://localhost:8080/schedule/${id}`);
   }

   PaidStatus(id:number){
    return this.http.get<any>(`http://localhost:8080/schedule/payment/${id}`);

   }

 
}

