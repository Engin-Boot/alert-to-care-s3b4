import { Component, OnInit } from '@angular/core';
import { Icu } from '../icu' 
import { IcuService } from '../icu.service';

@Component({
  selector: 'app-icu-list',
  templateUrl: './icu-list.component.html',
  styleUrls: ['./icu-list.component.css']
})  
export class IcuListComponent implements OnInit {

  icus : Icu ;

  constructor( private icuService : IcuService ) { }

  ngOnInit(): void {
    this.getIcus() ;
  }

  getIcus() {
    this.icuService.getIcusList().subscribe(response => {
      this.icus = response.data ;
      console.log( this.icus ) ; 
    }) ;
  }

}
