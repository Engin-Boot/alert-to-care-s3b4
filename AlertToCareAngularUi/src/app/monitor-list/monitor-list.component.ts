import { Component, OnInit } from '@angular/core';
import { Monitor } from '../monitor';
import { MonitorService } from '../monitor.service';

@Component({
  selector: 'app-monitor-list',
  templateUrl: './monitor-list.component.html',
  styleUrls: ['./monitor-list.component.css']
})
export class MonitorListComponent implements OnInit {

  monitors : Monitor ;

  constructor( private monitorService : MonitorService ) { }

  ngOnInit(): void {
    this.getBeds() ;
  }

  getBeds() {
    this.monitorService.getMonitorList().subscribe(response=>{
      this.monitors = response.data ;
      console.log( this.monitors ) ;
    }) ;
  }

}
