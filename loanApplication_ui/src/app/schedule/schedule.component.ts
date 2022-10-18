import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpService } from '../http.service';
@Component({
  selector: 'app-schedule',
  templateUrl: './schedule.component.html',
  styleUrls: ['./schedule.component.css']
})

    export class ScheduleComponent implements OnInit {
      page:number=1;
      count:number=0;
      tableSize:number=10;
      tableSizes:any=[5,10,15,20]
      schedules:any =[]
      id:number=0
      constructor(private service:HttpService,private route: ActivatedRoute) { }
    
      ngOnInit(): void {
        this.scheduleList()
      }
      scheduleList(){
        this.route.paramMap.subscribe((param:any)=>{
          this.service.scheduleHistory(param.get("id"))
          .subscribe((response)=>{
            console.log(response.schedule)
            console.log(param.get("id"))
            this.schedules=response.schedule;
          })
        })
      }
    
      onConfirm(){
        this.id =this.route.snapshot.params['id']
        
        this.service.PaidStatus(this.id)
        .subscribe((response)=>{
          this.schedules=response.schedule
          console.log(response)
          window.location.reload()
        })      
      }
    
    
      onTableDataChange(event:any){
        this.page=event;
        this.scheduleList();
      }
    
      onTableSizeChange(event:any):void{
        this.tableSize=event.target.value;
        this.page=1;
        this.scheduleList();
      }
    
    }
