import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpService } from '../http.service';
@Component({
  selector: 'app-schedule',
  templateUrl: './schedule.component.html',
  styleUrls: ['./schedule.component.css']
})

    export class ScheduleComponent implements OnInit {
      id:number=0
      page:number=1;
      count:number=0;
      tableSize:number=10;
      tableSizes:any=[5,10,15,20]
      schedules:any =[]
      constructor(private service:HttpService,private route: ActivatedRoute) { }
    
      ngOnInit(): void {
        this.scheduleList()
      }
      scheduleList(){
        this.id=this.route.snapshot.params['id'];
        this.service.scheduleHistory(this.id).subscribe(
          (Response) => {
            console.log(Response.schedule)
            this.schedules = Response.schedule
          }
         )
      }
    
      onConfirm(){
        this.scheduleList();
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
