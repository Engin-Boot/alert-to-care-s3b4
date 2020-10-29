import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Monitor } from '../monitor';
import { MonitorService } from '../monitor.service';
import Swal from 'sweetalert2' ;

@Component({
  selector: 'app-check-vitals',
  templateUrl: './check-vitals.component.html',
  styleUrls: ['./check-vitals.component.css']
})
export class CheckVitalsComponent implements OnInit {

  monitors : Monitor ;

  constructor( private monitorService : MonitorService,
    private router : Router ) {

      

    }


  ngOnInit(): void {
    this.getMonitors() ;
  }

  getMonitors() {
    this.monitorService.getMonitorList().subscribe(response=>{
      this.monitors = response.data ;
      console.log( this.monitors ) ;
    }) ;
  }
  

}
