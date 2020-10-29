import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MonitorSub } from '../monitor-sub';
import { MonitorService } from '../monitor.service';

@Component({
  selector: 'app-add-monitor',
  templateUrl: './add-monitor.component.html',
  styleUrls: ['./add-monitor.component.css']
})
export class AddMonitorComponent implements OnInit {
  
  monitorsub : MonitorSub = new MonitorSub() ;

  constructor( private monitorService : MonitorService,
    private router : Router ) {
  }

  ngOnInit() : void {
  }

  saveMonitor() {
    this.monitorService.addMonitor( this.monitorsub ).subscribe( data=> {
      console.log( data ) ;
      this.goToMonitorList() ;  
    },
    error => console.log( error )) ;
  }

  goToMonitorList() {
    this.router.navigate(['/getmonitors'])
  }

  onSubmit() {
    console.log( this.monitorsub ) ;
    this.saveMonitor() ;
  }

}
