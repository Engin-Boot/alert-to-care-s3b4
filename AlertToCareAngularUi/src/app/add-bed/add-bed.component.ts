import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BedSub } from '../bed-sub';
import { BedService } from '../bed.service';

@Component({
  selector: 'app-add-bed',
  templateUrl: './add-bed.component.html',
  styleUrls: ['./add-bed.component.css']
})
export class AddBedComponent implements OnInit {

  bedsub : BedSub = new BedSub() ;

  constructor( private bedService : BedService,
    private router : Router ) {
  }

  ngOnInit() : void {
  }

  saveBed() {
    this.bedService.addBed( this.bedsub ).subscribe( data=> {
      console.log( data ) ;
      this.goToBedList() ;   
    },
    error => console.log( error )) ;
  }

  goToBedList() {
    this.router.navigate(['/getbeds'])
  }

  onSubmit() {
    console.log( this.bedsub ) ;
    this.saveBed() ;
  }

}
