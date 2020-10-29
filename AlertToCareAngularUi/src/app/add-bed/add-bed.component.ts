import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Bed } from '../bed';
import { BedSub } from '../bed-sub';
import { BedService } from '../bed.service';

@Component({
  selector: 'app-add-bed',
  templateUrl: './add-bed.component.html',
  styleUrls: ['./add-bed.component.css']
})
export class AddBedComponent implements OnInit {

  bedsub : BedSub = new BedSub() ;
  bed : Bed ;

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

    error => {
      console.log( error ) ;
      if( isNaN(this.bedsub.icuId) ) {
        alert( "Please provide valid ICU ID, which should be a number)" ) ;
      } else {
        alert( error.error.message + ". Please choose another ICU to allocate this bed." ) ;
      }
    }) ;
  }

  goToBedList() {
    this.router.navigate(['/getbeds'])
  }

  onSubmit() {
    console.log( this.bedsub.icuId ) ;
    this.saveBed() ;
  }

}
