import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Monitor } from '../monitor';
import { MonitorService } from '../monitor.service';

@Component({
  selector: 'app-monitor-list',
  templateUrl: './monitor-list.component.html',
  styleUrls: ['./monitor-list.component.css']
})
export class MonitorListComponent implements OnInit {

  monitors : Monitor ;

  constructor( private monitorService : MonitorService,
    private router : Router ) { }



  ngOnInit(): void {
    this.getMonitors() ;
  }

  getMonitors() {
    this.monitorService.getMonitorList().subscribe(response=>{
      this.monitors = response.data ;
      console.log( this.monitors ) ;
    }) ;
  }

  updateVitals( id : number ) {
    this.router.navigate( ['updatevitals', id] ) ;
  }

}
