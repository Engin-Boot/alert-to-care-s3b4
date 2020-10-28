import { Component, OnInit } from '@angular/core';
import { Bed } from '../bed';
import { BedService } from '../bed.service';

@Component({
  selector: 'app-bed-list',
  templateUrl: './bed-list.component.html',
  styleUrls: ['./bed-list.component.css']
})
export class BedListComponent implements OnInit {

  beds : Bed ;

  constructor( private bedService : BedService ) { }

  ngOnInit(): void {
    this.getBeds() ;
  }

  getBeds() {
    this.bedService.getBedList().subscribe(response=>{
      this.beds = response.data ;
      console.log( this.beds ) ;
    }) ;
  }

}
