import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Monitor } from '../monitor';
import { MonitorSub } from '../monitor-sub';
import { MonitorService } from '../monitor.service';
import { UpdateVitalsService } from '../update-vitals.service';

@Component({
  selector: 'app-update-vitals',
  templateUrl: './update-vitals.component.html',
  styleUrls: ['./update-vitals.component.css']
})
export class UpdateVitalsComponent implements OnInit {

  id : number ;
  monitorsub : MonitorSub = new MonitorSub() ;
  monitor : Monitor = new Monitor() ;

  constructor( private monitorService : MonitorService,
    private route : ActivatedRoute,
    private router : Router ) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'] ;

    this.monitorService.getMonitorById( this.id ).subscribe( data => {
      this.monitorsub = data ;
    }, error => console.log(error)) ;
  }

  onSubmit() {
    this.monitorService.updateMonitor( this.id, this.monitor ).subscribe( data => {
      this
    } ) ;
  }

  goToMonitorsList() {
    this.router.navigate(['/getmonitors']) ;
  }



}
