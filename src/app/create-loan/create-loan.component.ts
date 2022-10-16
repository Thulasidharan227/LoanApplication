import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormGroup ,FormBuilder} from '@angular/forms';
import { HttpService } from '../http.service';

@Component({
  selector: 'app-create-loan',
  templateUrl: './create-loan.component.html',
  styleUrls: ['./create-loan.component.css']
})
export class CreateLoanComponent implements OnInit {

  public createLoan !: FormGroup;
  constructor(private formBuilder : FormBuilder,private http:HttpClient,
    private service:HttpService) { }

  ngOnInit(): void {
    this.createLoan = this.formBuilder.group({
      loanAmount:[''],
      loanStartDate:[''],
      paymentFrequency:[],
      interestRate:[''],
      payment:[''],
      totalMonth:[]
    })
  }
  createLoans(){
    
    console.log("success")
    console.log(this.createLoan.value)
    this.service.createLoan(this.createLoan.value).subscribe(
      Response=>{
        console.log(Response)
        alert('Loan is created successfully')
        window.location.reload()
    })
  }

}
